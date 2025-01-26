package com.cxzcanying.winterproject.entity;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

/**
 * @author 21311
 */
@Validated
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private Integer id;
    
    @NotEmpty(message = "书名不能为空")
    @Size(max = 100, message = "书名长度不能超过100个字符")
    private String title;
    
    @NotEmpty(message = "ISBN不能为空")
    @Pattern(regexp = "^[0-9]{13}$", message = "ISBN必须是13位数字")
    private String isbn;
    
    @NotEmpty(message = "作者不能为空")
    @Size(max = 50, message = "作者名长度不能超过50个字符")
    private String author;
    
    @Pattern(regexp = "^(19|20)\\d{2}$", message = "出版年份格式不正确")
    private String publishedYear;
    
    @Min(value = 0, message = "价格不能为负数")
    @Max(value = 999999, message = "价格不能超过999999")
    private Integer price;
    
    @NotEmpty(message = "分类不能为空")
    private String category;

}
