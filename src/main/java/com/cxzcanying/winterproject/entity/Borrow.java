package com.cxzcanying.winterproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author 21311
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Borrow {
    private Integer id;
    private String userId;
    private Integer bookId;
    private LocalDateTime borrowTime;
    private LocalDateTime returnTime;
    private LocalDateTime dueTime;

    // BORROWED, RETURNED, OVERDUE

    private String status;

}