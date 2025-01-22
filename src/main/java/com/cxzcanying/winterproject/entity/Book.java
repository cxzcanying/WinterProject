package com.cxzcanying.winterproject.entity;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
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
    private String title;
    @Pattern(regexp = "^[0-9]{13}$", message = "ISBN 格式不正确")
    private String isbn;
    @NotEmpty(message = "作者不能为空")
    private String author;
    private Integer publishedYear;
    private Integer price;
    private String category;

}
