package com.cxzcanying.winterproject.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CacheCleanupScheduler {

    @Scheduled(fixedRate = 3600000) // Every hour
    public void cleanExpiredCache() {
        // Cache cleanup logic
    }
} 