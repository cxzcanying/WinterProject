package com.cxzcanying.winterproject.filter;

import com.cxzcanying.winterproject.annotation.RequiresRole;
import com.cxzcanying.winterproject.pojo.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerMapping;

import java.io.IOException;

@Slf4j
@Component
public class AuthFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public void afterPropertiesSet() throws ServletException {
        super.afterPropertiesSet();
    }
    @Override
protected void doFilterInternal(HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull FilterChain filterChain)
        throws ServletException, IOException {

    // 放行注册和登录接口
    String requestURI = request.getRequestURI();
        log.info("Request URI: {}", requestURI);
    if ("/api/users/login".equals(requestURI) || "/api/users/register".equals(requestURI)) {
        filterChain.doFilter(request, response);
        return;
    }

    // 获取 Token
    String header = request.getHeader("Authorization");
    if (header == null || !header.startsWith("Bearer ")) {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write("Unauthorized: No token provided");
        return;
    }

    // 解析 Token
    String token = header.substring(7);
    if (!JwtUtil.isTokenValid(token)) {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write("Unauthorized: Invalid token");
        return;
    }

    // 获取角色
    String role = JwtUtil.getRoleFromToken(token);

    // 获取目标方法的注解
    RequiresRole requiresRole = getAnnotationFromRequest(request);
    if (requiresRole != null) {
        if (!role.equals(requiresRole.value())) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.getWriter().write("Forbidden: Insufficient permissions");
            return;
        }
    }

    // 放行
    filterChain.doFilter(request, response);
}

    private RequiresRole getAnnotationFromRequest(HttpServletRequest request) throws ServletException {
        try {
            HandlerMethod handlerMethod = (HandlerMethod) request.getAttribute(HandlerMapping.BEST_MATCHING_HANDLER_ATTRIBUTE);
            if (handlerMethod != null) {
                return handlerMethod.getMethodAnnotation(RequiresRole.class);
            }
        } catch (Exception e) {
            throw new ServletException("Error getting annotation", e);
        }
        return null;
    }

}