package com.cxzcanying.winterproject.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    private Integer id;
    @NotEmpty(message = "名称不能为空")
    private String name;
    @NotEmpty(message = "用户ID不能为空")
    private String userId;
    private Integer bookId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
}