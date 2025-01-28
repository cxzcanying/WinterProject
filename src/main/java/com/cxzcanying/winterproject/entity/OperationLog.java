package com.cxzcanying.winterproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author 21311
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperationLog {
    private Integer id;
    private String operationName;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Integer duration;
} 