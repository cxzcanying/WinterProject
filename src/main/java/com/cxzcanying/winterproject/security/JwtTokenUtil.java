package com.cxzcanying.winterproject.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

//@Component
//public class JwtTokenUtil {
//
//    @Value("${jwt.secret}")
//    private String secret;
//
//    @Value("${jwt.expiration}")
//    private int expiration;
//
////    public String generateToken(UserDetails userDetails) {
////        Map<String, Object> claims = new HashMap<>();
////        return doGenerateToken(claims, userDetails.getUsername());
////    }
//
////    private String doGenerateToken(Map<String, Object> claims, String subject) {
////        return Jwts.builder()
////                .setClaims(claims)
////                .setSubject(subject)
////                .setIssuedAt(new Date(System.currentTimeMillis()))
////                .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000L))
////                .signWith(SignatureAlgorithm.HS512, secret)
////                .compact();
////    }
//}