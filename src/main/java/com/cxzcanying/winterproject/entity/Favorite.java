package com.cxzcanying.winterproject.entity;

import lombok.Data;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

/**
 * @author 21311
 */
@Data
public class Favorite {
    private Integer id;
    private Integer userId;
    private Integer bookId;
    private String createAt;
}
