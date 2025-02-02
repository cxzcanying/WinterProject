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
        String operationName = joinPoint.getSignature().toShortString();
        LocalDateTime startTime = LocalDateTime.now();
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Exception e) {
            LocalDateTime endTime = LocalDateTime.now();
            long duration = ChronoUnit.MILLIS.between(startTime, endTime);

            //设置遇到异常则将所用时间设置为-1
            OperationLog operationLog = new OperationLog();
            operationLog.setOperationName(operationName);
            operationLog.setStartTime(startTime);
            operationLog.setEndTime(endTime);
            operationLog.setDuration(-1);

            operationLogMapper.insertOperationLog(operationLog);
            throw e;

        }
        return result;
    }
}