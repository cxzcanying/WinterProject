package com.cxzcanying.winterproject.controller;

import com.cxzcanying.winterproject.entity.Follow;
import com.cxzcanying.winterproject.pojo.Result;
import com.cxzcanying.winterproject.service.FollowService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 21311
 */
@Slf4j
@RestController
@RequestMapping("/api/users/{userId}")
public class FollowController {
    @Autowired
    private FollowService followService;

    //关注用户

    @PostMapping("/follow")
    public void followUser(@PathVariable String userId, @RequestBody Follow follow){
        followService.followUser(follow);
    }

    //用户的粉丝

    @GetMapping("/followers")
    public Result<List<String>> getFollowersById(@PathVariable String userId){
        List<String> followers=followService.getFollowersById(userId);
        return Result.success(followers);
    }

    //用户的关注

    @GetMapping("/following")
    public Result<List<String>> getFollowingById(@PathVariable String userId){
        List<String> following=followService.getFollowingById(userId);
        return Result.success(following);
    }
}
