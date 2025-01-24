package com.cxzcanying.winterproject.service;

import com.cxzcanying.winterproject.entity.Follow;

import java.util.List;

public interface FollowService {
    List<String> getFollowingById(String userId);

    List<String> getFollowersById(String userId);

    void followUser( Follow follow);
}
