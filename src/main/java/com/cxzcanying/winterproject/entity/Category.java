package com.cxzcanying.winterproject.entity;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 21311
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @NotNull(message = "ID不能为空")
    private Integer id;
    @NotEmpty(message = "分类名称不能为空")
    private String categoryName;

}
