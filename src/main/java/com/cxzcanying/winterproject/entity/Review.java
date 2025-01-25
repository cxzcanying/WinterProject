package com.cxzcanying.winterproject.entity;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author 21311
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class Review {
    @NotNull(message = "ID不能为空")
    private Integer id;
    
    @NotNull(message = "图书ID不能为空")
    private Integer bookId;
    
    @NotNull(message = "用户ID不能为空")
    private Integer userId;
    
    @NotEmpty(message = "评论内容不能为空")
    @Size(max = 500, message = "评论内容不能超过500个字符")
    private String content;
    
    @Min(value = 1, message = "评分最小为1")
    @Max(value = 5, message = "评分最大为5")
    private Integer rating;
    
    private LocalDateTime createTime;
    
    private Integer parentId;
    
    private List<Review> replies;
}

