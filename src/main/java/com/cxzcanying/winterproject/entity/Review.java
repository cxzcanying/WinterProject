package com.cxzcanying.winterproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author 21311
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    private Integer id;
    private Integer bookId;
    private Integer userId;
    private String content;
    private Integer rating;
    private LocalDateTime createTime;
    // 改为 LocalDateTime 类型

    private Integer parentId;
    // 改为 Integer 类型

    private List<Review> replies;
    // 添加回复列表字段

}

