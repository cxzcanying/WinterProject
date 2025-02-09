package com.cxzcanying.winterproject.service.impl;

import com.cxzcanying.winterproject.entity.User;
import com.cxzcanying.winterproject.mapper.UserMapper;
import com.cxzcanying.winterproject.pojo.XSSUtils;
import com.cxzcanying.winterproject.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author 21311
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Cacheable(value = "users",key = "#userId")
    @Override
    public User getProfileById(String userId) {
        return userMapper.getProfileById(userId);
    }


    @CacheEvict(value = "users", key = "#userId")
    @Override
    public void updateAvatarUrl(String userId, String avatarUrl) {
        userMapper.updateAvatarUrl(userId, avatarUrl);
    }

    @Override
    public User login(String userName, String password) {
        User user = userMapper.findByUserName(userName);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return user;
        }
        return null;
    }
    @CacheEvict(value = "users" ,key = "#userId")
    @Override
    public void updateProfile(String userId, User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userMapper.updateProfile(userId,user);
    }

    @Override
    public void registerUser(User user) {
        String safeName = XSSUtils.escapeHtml(user.getUserName());
        user.setUserName(safeName);
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        userMapper.registerUser(user);
    }
}
