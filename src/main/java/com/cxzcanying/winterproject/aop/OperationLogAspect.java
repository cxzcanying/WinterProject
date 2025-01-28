package com.cxzcanying.winterproject.aop;

import com.cxzcanying.winterproject.entity.OperationLog;
import com.cxzcanying.winterproject.mapper.OperationLogMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * @author 21311
 */
@Aspect
@Component
public class OperationLogAspect {

    @Autowired
    private OperationLogMapper operationLogMapper;

    @Around("execution(* com.cxzcanying.winterproject.service.impl.*.*(..))")
    public Object logOperation(ProceedingJoinPoint joinPoint) throws Throwable {
        // 获取操作名称
        String operationName = joinPoint.getSignature().toShortString();

        // 记录开始时间
        LocalDateTime startTime = LocalDateTime.now();

        // 执行目标方法
        Object result = joinPoint.proceed();

        // 记录结束时间
        LocalDateTime endTime = LocalDateTime.now();

        // 计算持续时间（秒）
        long duration = ChronoUnit.MILLIS.between(startTime, endTime);

        // 创建日志对象
        OperationLog operationLog = new OperationLog();
        operationLog.setOperationName(operationName);
        operationLog.setStartTime(startTime);
        operationLog.setEndTime(endTime);
        operationLog.setDuration((int) duration);

        // 插入日志到数据库
        operationLogMapper.insertOperationLog(operationLog);

        return result;
    }

} 