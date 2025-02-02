package com.cxzcanying.winterproject.controller;

import com.cxzcanying.winterproject.annotation.RequiresRole;
import com.cxzcanying.winterproject.entity.Follow;
import com.cxzcanying.winterproject.entity.Roles;
import com.cxzcanying.winterproject.pojo.Result;
import com.cxzcanying.winterproject.service.FollowService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 21311
 */
@Slf4j
@RestController
@RequestMapping("/api/users/{userId}")
@Validated
public class FollowController {
    @Autowired
    private FollowService followService;

    //关注用户

    @PostMapping("/follow")
    @RequiresRole(Roles.ROLE_USER)
    public Result<?> followUser(@PathVariable String userId, @Valid @RequestBody Follow follow) {
        try {
            log.info("用户{}关注用户", userId);
            followService.followUser(follow);
            return Result.success("关注成功");
        } catch (Exception e) {
            log.error("关注失败", e);
            return Result.fail("关注失败: " + e.getMessage());
        }
    }

    //取消关注

    @DeleteMapping("/unfollow/{followingId}")
    @RequiresRole(Roles.ROLE_USER)
    public Result<?> unfollowUser(@PathVariable String followingId, @PathVariable String userId) {
        try {
            log.info("用户{}取消关注用户{}", userId, followingId);
            followService.unfollowUser(followingId, userId);
            return Result.success("取消关注成功");
        } catch (Exception e) {
            log.error("取消关注失败", e);
            return Result.fail("取消关注失败: " + e.getMessage());
        }
    }

    //用户的粉丝

    @GetMapping("/followers")
    public Result<List<String>> getFollowersById(@PathVariable String userId) {
        try {
            log.info("获取用户{}的粉丝列表", userId);
            List<String> followers = followService.getFollowersById(userId);
            return Result.success(followers);
        } catch (Exception e) {
            log.error("获取粉丝列表失败", e);
            return Result.fail("获取粉丝列表失败: " + e.getMessage());
        }
    }

    //用户的关注

    @GetMapping("/following")
    public Result<List<String>> getFollowingById(@PathVariable String userId) {
        try {
            log.info("获取用户{}的关注列表", userId);
            List<String> following = followService.getFollowingById(userId);
            return Result.success(following);
        } catch (Exception e) {
            log.error("获取关注列表失败", e);
            return Result.fail("获取关注列表失败: " + e.getMessage());
        }
    }
}
