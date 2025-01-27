package com.cxzcanying.winterproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author 21311
 */
@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        // 设置连接工厂
        template.setConnectionFactory(factory);
        // 设置键的序列化器
        template.setKeySerializer(new StringRedisSerializer());
        // 设置值的序列化器（使用 JSON 格式）
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        // 设置 Hash 键的序列化器
        template.setHashKeySerializer(new StringRedisSerializer());
        // 设置 Hash 值的序列化器（使用 JSON 格式）
        template.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
        return template;
    }
}