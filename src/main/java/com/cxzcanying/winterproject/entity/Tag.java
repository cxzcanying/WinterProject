package com.cxzcanying.winterproject.entity;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
public class Tag {
    @NotNull(message = "ID不能为空")
    private Integer id;
    @NotEmpty(message = "名称不能为空")
    private String name;
    @NotEmpty(message = "用户ID不能为空")
    private String userId;
    @NotNull(message = "图书ID不能为空")
    private Integer bookId;
    private LocalDateTime createTime;
}