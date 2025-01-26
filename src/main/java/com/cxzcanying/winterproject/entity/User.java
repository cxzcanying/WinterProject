package com.cxzcanying.winterproject.entity;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

/**
 * @author 21311
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class User {

    private Integer userId;
    @NotEmpty(message = "用户名不能为空")
    private String userName;
    @NotEmpty(message = "密码不能为空")
    private String password;
    @NotEmpty(message = "性别不能为空")
    private String sex;
    @NotEmpty(message = "出生日期不能为空")
    private String birthDate;
    private String avatarUrl;
    private Boolean isAdmin;
}
