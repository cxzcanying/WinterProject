package com.cxzcanying.winterproject.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;

/**
 * @author 21311
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class Borrow {
    private Integer id;
    
    @NotEmpty(message = "用户ID不能为空")
    private String userId;

    private Integer bookId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime borrowTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dueTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime returnTime;
    
    @Pattern(regexp = "^(BORROWED|RETURNED|OVERDUE)$", message = "状态值不正确")
    private String status;
}