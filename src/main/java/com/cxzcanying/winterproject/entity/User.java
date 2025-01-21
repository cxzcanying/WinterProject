package com.cxzcanying.winterproject.entity;

import lombok.Data;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

/**
 * @author 21311
 */
@Data
public class User {
    private Integer id;
    private String userName;
    private String password;
    private String sex;
    private String birthDate;
    private boolean isAdmin;
}
