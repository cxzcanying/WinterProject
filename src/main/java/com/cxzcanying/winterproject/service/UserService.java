package com.cxzcanying.winterproject.service;

import com.cxzcanying.winterproject.entity.User;
import com.cxzcanying.winterproject.pojo.Result;

import java.util.List;

/**
 * @author 21311
 */
public interface UserService {

    void updateProfile(String userId, User user);

    void registerUser(User user);

    User getProfileById(String userId);
}
