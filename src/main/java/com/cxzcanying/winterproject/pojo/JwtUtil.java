package com.cxzcanying.winterproject.pojo;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j; // 引入 slf4j 日志
import org.springframework.beans.factory.annotation.Value; // 引入 @Value 注解
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets; // 引入 StandardCharsets
import java.security.Key;
import java.util.Date;

/**
 * @author 21311
 */
@Slf4j
@Component
public class JwtUtil {

    private static Key SECRET_KEY;

    @Value("${jwt.secret-key}")
    private String secretKeyString;
    @PostConstruct
    public void init() {
        SECRET_KEY = Keys.hmacShaKeyFor(secretKeyString.getBytes(StandardCharsets.UTF_8));
        log.info("JWT Secret Key initialized from configuration.");
    }

    private static final long EXPIRATION_TIME = 86400000;

    public String generateToken(String username, String userRole) {

        return Jwts.builder()
                .setSubject(username)
                .claim("role", userRole)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SECRET_KEY)
                .compact();
    }

    public static boolean isTokenValid(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(SECRET_KEY).build().parseClaimsJws(token);
            log.debug("Token validation successful.");
            return true;
        } catch (io.jsonwebtoken.ExpiredJwtException e) {
            log.debug("Token expired: {}", e.getMessage());
            return false;
        } catch (io.jsonwebtoken.security.SignatureException e) {
            log.debug("Token signature invalid: {}", e.getMessage());
            return false;
        } catch (io.jsonwebtoken.MalformedJwtException e) {
            log.debug("Token malformed: {}", e.getMessage());
            return false;
        } catch (IllegalArgumentException e) {
            log.debug("Token validation error (IllegalArgumentException): {}", e.getMessage());
            return false;
        } catch (Exception e) {
            log.error("Unexpected error during token validation: {}", e.getMessage(), e);
            return false;
        }
    }

    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    public static String getRoleFromToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.get("role", String.class);
    }
}