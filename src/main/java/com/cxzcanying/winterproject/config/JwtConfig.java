// package com.cxzcanying.winterproject.config;

// import com.cxzcanying.winterproject.security.JwtTokenUtil;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// /**
//  * @author 21311
//  */
// @Configuration
// public class JwtConfig {

//     @Value("${jwt.secret}")
//     private String secret;

//     @Value("${jwt.expiration}")
//     private int expiration;

//    @Bean
//   public JwtTokenUtil jwtTokenUtil() {
//        return new JwtTokenUtil(secret, expiration);
//    }
// } 