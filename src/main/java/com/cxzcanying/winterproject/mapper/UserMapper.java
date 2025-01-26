package com.cxzcanying.winterproject.mapper;

import com.cxzcanying.winterproject.entity.User;
import com.cxzcanying.winterproject.pojo.Result;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 21311
 */
@Mapper
public interface UserMapper {
    /**
     * 获取个人资料
     * @param userId
     * @return User
     */
    User getProfileById(String userId);

    /**
     * 更新资料
     * @param userId
     * @param user
     */
    void updateProfile(String userId, User user);

    /**
     * 注册用户
     * @param user
     */
    void registerUser(User user);

    /**
     * 更新用户头像URL
     * @param userId
     * @param avatarUrl
     */
    void updateAvatarUrl(String userId, String avatarUrl);

    /**
     * 登录
     * @param userName
     * @return User
     */
    User findByUserName(String userName);
}
