package com.cxzcanying.winterproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.util.Date;

/**
 * @author 21311
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Follow {
    private Integer followerId;
    private Integer followingId;
    private Date followTime;
}
