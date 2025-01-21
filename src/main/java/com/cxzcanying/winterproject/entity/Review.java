package com.cxzcanying.winterproject.entity;

import lombok.Data;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

/**
 * @author 21311
 */
@Data
public class Review {
    private Integer id;
    private Integer bookId;
    private Integer userId;
    private String content;
    private Integer rating;
    private String createAt;
}
