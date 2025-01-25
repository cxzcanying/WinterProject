package com.cxzcanying.winterproject.entity;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

/**
 * @author 21311
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class BookSearchRequest {
    @NotEmpty(message = "书名不能为空")
    private String title;
    @NotEmpty(message = "作者不能为空")
    private String author;
    @NotEmpty(message = "ISBN不能为空")
    private String isbn;
    private String  publishedDateStart;
    private String publishedDateEnd;
    private Integer priceMin;
    private Integer priceMax;
    private String category;
    private String publishedYear;
}
