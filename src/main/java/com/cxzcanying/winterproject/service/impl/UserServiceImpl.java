package com.cxzcanying.winterproject.service.impl;

import com.cxzcanying.winterproject.entity.User;
import com.cxzcanying.winterproject.mapper.UserMapper;
import com.cxzcanying.winterproject.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

/**
 * @author 21311
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getProfileById(String userId) {
        return userMapper.getProfileById(userId);
    }

    @Override
    public void updateAvatarUrl(String userId, String avatarUrl) {
        userMapper.updateAvatarUrl(userId,avatarUrl);
    }

    @Override
    public User login(String userName, String password) {
        User user = userMapper.findByUsername(userName);
        if (user != null && BCrypt.checkpw(password, user.getPassword())) {
            return user;
        }
        return null;
    }

    @Override
    public void updateProfile(String userId, User user) {
        userMapper.updateProfile(userId,user);
    }

    @Override
    public void registerUser(User user) {
        // Generate salt
        String salt = BCrypt.gensalt();
        // Hash password with salt
        String hashedPassword = BCrypt.hashpw(user.getPassword(), salt);
        user.setPassword(hashedPassword);
        user.setSalt(salt);
        userMapper.insertUser(user);
    }
}
