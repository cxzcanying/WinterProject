package com.cxzcanying.winterproject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class WinterProjectApplicationTests {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;
@Test
    public void testConnection() {
        try {
            redisTemplate.opsForValue().set("test", "value");
            System.out.println("Redis connection is working!");
        } catch (Exception e) {
            System.err.println("Failed to connect to Redis: " + e.getMessage());
        }
    }

}
