package com.cxzcanying.winterproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 21311
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookSearchRequest {
    private String title;
    private String author;
    private String isbn;
    private String  publishedDateStart;
    private String publishedDateEnd;
    private Integer priceMin;
    private Integer priceMax;
    private String category;
}
