package com.cxzcanying.winterproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author 21311
 */

@SpringBootApplication(exclude = LiquibaseAutoConfiguration.class)
@EnableCaching//启用Redis缓存
@EnableAspectJAutoProxy//启用切面编程AOP
@EnableScheduling//启用定时任务功能

public class WinterProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(WinterProjectApplication.class, args);
    }

}
