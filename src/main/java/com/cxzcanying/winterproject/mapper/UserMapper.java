package com.cxzcanying.winterproject.mapper;

import com.cxzcanying.winterproject.entity.User;
import com.cxzcanying.winterproject.pojo.Result;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 21311
 */
@Mapper
public interface UserMapper {
    User getProfileById(String userId);

    void updateProfile(String userId, User user);

    void registerUser(User user);
}
