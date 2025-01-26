package com.cxzcanying.winterproject.filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 所有接口
                .allowedOrigins("http://localhost:8081") // 允许前端端口
                .allowedMethods("GET", "POST", "PUT", "DELETE") // 允许的请求方法
                .allowCredentials(true); // 允许携带凭证（如 Cookie）
    }
}
