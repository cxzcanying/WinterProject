package com.cxzcanying.winterproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author 21311
 */
@SpringBootApplication
@EnableCaching//启用Redis缓存
@EnableAspectJAutoProxy//启用切面编程AOP
public class WinterProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(WinterProjectApplication.class, args);
    }
//TODO 加分项
//    用户密码加盐加密
//    Redis缓存：图书信息和个人资料
//    AOP:操作日志写入与获取（管理员）
//    添加ApiFox API文档
//    实现文件上传功能（如用户头像）

// TODO 未完成
//      添加定时任务（如定期清理过期缓存）
//      实现JWT认证
//      添加邮件通知功能（如借阅到期提醒）
//      添加数据库连接池配置
//      添加索引（如对常用查询字段）
//      实现WebSocket实时通知
//      实现数据库读写分离
//      添加数据库备份策略
//      实现CSRF防护
//      添加XSS防护
//      实现SQL注入防护
}
