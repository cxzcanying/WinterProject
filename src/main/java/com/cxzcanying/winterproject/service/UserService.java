package com.cxzcanying.winterproject.service;

import com.cxzcanying.winterproject.entity.User;

/**
 * @author 21311
 */
public interface UserService {
    /**
     * 更新个人资料
     * @param userId
     * @param user
     */
    void updateProfile(String userId, User user);

    /**
     * 诸城用户
     * @param user
     */
    void registerUser(User user);

    /**
     * 获取个人资料
     * @param userId
     * @return
     */
    User getProfileById(String userId);

    /**
     * 更新用户头像URL
     * @param userId
     * @param avatarUrl
     */
    void updateAvatarUrl(String userId, String avatarUrl);

    /**
     * 登录
     * @param userName
     * @param password
     * @return User
     */
    User login(String userName, String password);
}
