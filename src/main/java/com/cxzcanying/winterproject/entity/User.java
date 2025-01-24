package com.cxzcanying.winterproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 21311
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String userName;
    private String password;
    private String sex;
    private String birthDate;
    private String avatarUrl;
    private Boolean isAdmin;
}
