package com.cxzcanying.winterproject.entity;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.springframework.validation.annotation.Validated;

/**
 * @author 21311
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class Favorite {
    private Integer id;
    @NotNull(message = "用户ID不能为空")
    private Integer userId;
    @NotNull(message = "图书ID不能为空")
    private Integer bookId;
    private String createAt;
}
