//package com.cxzcanying.winterproject;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class XSSAttackTest {
//
//    @Autowired
//    private TestRestTemplate restTemplate;
//
//    @Test
//    public void testXSSAttackOnUsername() {
//        // 构造包含恶意脚本的用户名
//        String maliciousUsername = "<script>alert('XSS')</script>";
//        String requestBody = String.format("{ \"userName\": \"%s\", \"password\": \"123456789\", \"sex\": \"男\", \"birthDate\": \"1990-01-01\", \"avatarUrl\": \"\", \"isAdmin\": false}", maliciousUsername);
//
//        // 设置请求头
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Content-Type", "application/json");
//
//        // 发送注册请求
//        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);
//        ResponseEntity<String> response = restTemplate.exchange("/api/users/register", HttpMethod.POST, request, String.class);
//
//        // 验证响应
//        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
//        assertThat(response.getBody()).doesNotContain("<script>");
//    }
//
//    @Test
//    public void testXSSAttackOnCustomTag() {
//        // 构造包含恶意脚本的标签名
//        String maliciousTag = "<script>alert('XSS')</script>";
//        String requestBody = String.format("{\"id\": 0, \"name\": \"%s\", \"userId\": \"1\", \"bookId\": 1, \"createTime\": \"2024-01-01 12:00:00\"}", maliciousTag);
//
//        // 设置请求头
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Content-Type", "application/json");
//        headers.add("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsInJvbGUiOiJBRE1JTiIsImlhdCI6MTczOTI4MTM4MCwiZXhwIjoxNzM5MzY3NzgwfQ.f5M_GnQFXvFpaoVcCyRtGVH2YElKb-byC8Ciao3bvKI"); // 替换为有效的 JWT Token
//
//        // 发送添加标签请求
//        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);
//        ResponseEntity<String> response = restTemplate.exchange("/api/books/2/tags", HttpMethod.POST, request, String.class, 1);
//
//        // 验证响应
//        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
//        assertThat(response.getBody()).doesNotContain("<script>");
//    }
//}