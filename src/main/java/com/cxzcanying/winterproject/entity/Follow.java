package com.cxzcanying.winterproject.entity;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.springframework.validation.annotation.Validated;

import java.util.Date;

/**
 * @author 21311
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class Follow {
    @NotNull(message = "ID不能为空")
    private Integer followerId;
    @NotNull(message = "ID不能为空")
    private Integer followingId;
    private Date followTime;
}

