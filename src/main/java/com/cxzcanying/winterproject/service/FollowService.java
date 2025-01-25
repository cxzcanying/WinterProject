package com.cxzcanying.winterproject.service;

import com.cxzcanying.winterproject.entity.Follow;

import java.util.List;

public interface FollowService {
    /**
     * 获取指定用户关注列表
     * @param userId
     * @return List<String>
     */
    List<String> getFollowingById(String userId);

    /**
     * 获取指定用户粉丝列表
     * @param userId
     * @return List<String>
     */
    List<String> getFollowersById(String userId);

    /**
     * 关注用户
     * @param follow
     */
    void followUser( Follow follow);

    /**
     * 取消关注用户
     * @param followingId
     * @param userId
     */
    void unfollowUser(String followingId, String userId);
}
