package com.cxzcanying.winterproject.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author 21311
 */
@Component
public class CacheCleanupScheduler {

    @Scheduled(fixedRate = 300000)
    public void cleanupExpiredCache() {
        System.out.println("清理过期缓存...");
    }

    @Scheduled(cron = "0 0 2 * * ?")
    public void cleanupExpiredCacheDaily() {
        System.out.println("每天凌晨2点清理过期缓存...");
    }
    /*
     * @Scheduled 属性
     * 1. fixedRate
     * 作用：以固定的速率执行任务，单位是毫秒。
     * 特点：任务的上一次执行开始后，间隔指定时间后再次执行，无论上一次任务是否完成。
     * 2. fixedDelay
     * 作用：以固定的延迟执行任务，单位是毫秒。
     * 特点：任务的上一次执行结束后，间隔指定时间后再次执行。
     * 3. initialDelay
     * 作用：指定任务首次执行的延迟时间，单位是毫秒。
     * 特点：通常与 fixedRate 或 fixedDelay 一起使用，用于设置任务启动后的初始延迟。
     * 4. cron
     * 作用：使用 Cron 表达式定义任务的执行时间。
     * 特点：Cron 表达式非常灵活，可以精确到秒、分钟、小时、日期等。
     * Cron 表达式格式：
     * ┌─────────────> 秒 (0-59)
     * │ ┌─────────────> 分钟 (0-59)
     * │ │ ┌─────────────> 小时 (0-23)
     * │ │ │ ┌─────────────> 日 (1-31)
     * │ │ │ │ ┌─────────────> 月 (1-12 或 JAN-DEC)
     * │ │ │ │ │ ┌─────────────> 星期 (0-7 或 SUN-SAT, 0 和 7 都表示周日)
     * │ │ │ │ │ │
     * (? ? ? ? ? ?)
     * 5. zone
     * 作用：指定 Cron 表达式的时区。
     * 特点：默认使用服务器的时区，可以通过 zone 属性指定其他时区。
     * 6. fixedRateString、fixedDelayString、initialDelayString
     * 作用：与 fixedRate、fixedDelay、initialDelay 类似，但支持从配置文件中读取值。
     * 特点：适用于需要动态配置的场景。
     * 7. cron 表达式的特殊字符
     * *：匹配任意值。
     * ?：用于日期和星期字段，表示不指定值。
     * -：表示范围。
     * /：表示间隔。
     * ,：表示多个值。
     */
} 