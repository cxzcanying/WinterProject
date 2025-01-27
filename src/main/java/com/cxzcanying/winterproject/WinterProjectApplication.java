package com.cxzcanying.winterproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author 21311
 */
@SpringBootApplication
@EnableCaching
public class WinterProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(WinterProjectApplication.class, args);
    }
//TODO 加分项
//    用户密码加盐加密
//    Redis缓存：图书信息和个人资料
}
