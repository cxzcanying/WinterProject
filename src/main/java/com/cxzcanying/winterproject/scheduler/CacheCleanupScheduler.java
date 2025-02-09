package com.cxzcanying.winterproject.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @author 21311
 */
@Component
public class CacheCleanupScheduler {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Scheduled(fixedRate = 1000000)
    public void cleanupExpiredCache() {
        System.out.println("清理过期缓存...");
        cleanupCache("users:*");
        cleanupCache("books:*");
    }

    @Scheduled(cron = "0 0 2 * * ?")
    public void cleanupExpiredCacheDaily() {
        System.out.println("每天凌晨2点清理过期缓存...");
        cleanupCache("user:*");
        cleanupCache("product:*");
    }

    private void cleanupCache(String keyPattern) {
        Set<String> keys = stringRedisTemplate.keys(keyPattern);
        if (keys != null && !keys.isEmpty()) {
            long deletedCount = stringRedisTemplate.delete(keys);
            System.out.printf("清理了 %d 个匹配 '%s' 模式的缓存 key%n", deletedCount, keyPattern);
        } else {
            System.out.printf("没有找到匹配 '%s' 模式的缓存 key，无需清理%n", keyPattern);
        }
    }

} 