package com.cxzcanying.winterproject.controller;

import com.cxzcanying.winterproject.entity.Follow;
import com.cxzcanying.winterproject.entity.User;
import com.cxzcanying.winterproject.pojo.Result;
import com.cxzcanying.winterproject.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.print.DocFlavor;
import java.util.List;
import java.util.Map;

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

    @PostMapping("/register")
    public void registerUser(@Valid @RequestBody User user){
        log.info("新增用户{}",user);
        userService.registerUser(user);
    }

    @GetMapping("/{userId}/profile")
    public Result<User> getProfileById(@PathVariable String userId){
        log.info("获取用户ID为{}的个人资料",userId);
        User user=userService.getProfileById(userId);
        return Result.success(user);
    }

    @PutMapping("/{userId}/update")
    public Result<User> updateProfile(@PathVariable String userId,@Valid @RequestBody User user){
        log.info("ID为{}的用户更新了个人资料{}",userId,user);
        userService.updateProfile(userId,user);
        return Result.success(user);
    }

    @PostMapping("/login")
    public Result<User> login(@RequestParam String userName, @RequestParam String password) {
        log.info("用户{}尝试登录", userName);
        User user = userService.login(userName, password);
        if (user != null) {
            return Result.success(user);
        } else {
            return Result.fail("用户名或密码错误");
        }
    }
}
