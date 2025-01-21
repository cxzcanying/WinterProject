package com.cxzcanying.winterproject.entity;

import lombok.Data;

/**
 * @author 21311
 */
@Data
public class Book {
    private Integer id;
    private String title;
    private String author;
    private String isbn;
    private String publishedDate;
    private String category;
    private Double price;
    private String review;
}
