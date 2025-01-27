package com.cxzcanying.winterproject.entity;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

/**
 * @author 21311
 */
@Data
public class LoginRequest {
    @NotEmpty(message = "用户名不能为空")
    private String userName;
    
    @NotEmpty(message = "密码不能为空")
    private String password;
} 