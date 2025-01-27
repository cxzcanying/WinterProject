package com.cxzcanying.winterproject.controller;

import com.cxzcanying.winterproject.entity.LoginRequest;
import com.cxzcanying.winterproject.entity.User;
import com.cxzcanying.winterproject.pojo.Result;
import com.cxzcanying.winterproject.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author 21311
 */
@Slf4j
@RestController
@RequestMapping("/api/users")
@Validated
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public Result<?> registerUser(@Valid @RequestBody User user) {
        try {
            log.info("新增用户{}", user);
            userService.registerUser(user);
            return Result.success("用户注册成功");
        } catch (Exception e) {
            log.error("用户注册失败", e);
            return Result.fail("用户注册失败: " + e.getMessage());
        }
    }

    @GetMapping("/{userId}/profile")
    public Result<User> getProfileById(@PathVariable String userId){
        try {
            log.info("获取用户ID为{}的个人资料",userId);
            User user=userService.getProfileById(userId);
            return Result.success(user);
        } catch (Exception e) {
            log.error("获取个人资料失败", e);
            return Result.fail("获取个人资料失败: " + e.getMessage());
        }
    }

    @PutMapping("/{userId}/update")
    public Result<User> updateProfile(@PathVariable String userId,@Valid @RequestBody User user){
        try {
            log.info("ID为{}的用户更新了个人资料{}",userId,user);
            userService.updateProfile(userId,user);
            return Result.success(user);
        } catch (Exception e) {
            log.error("更新个人资料失败", e);
            return Result.fail("更新个人资料失败: " + e.getMessage());
        }
    }

    @PostMapping("/login")
    public Result<User> login(@Valid @RequestBody LoginRequest loginRequest) {
        try {
            log.info("用户{}尝试登录", loginRequest.getUserName());
            User user = userService.login(loginRequest.getUserName(), loginRequest.getPassword());
            if (user != null) {
                return Result.success(user);
            } else {
                return Result.fail("用户名或密码错误");
            }
        } catch (Exception e) {
            log.error("登录失败", e);
            return Result.fail("登录失败: " + e.getMessage());
        }
    }
}
