package com.cxzcanying.winterproject.service.impl;

import com.cxzcanying.winterproject.entity.Follow;
import com.cxzcanying.winterproject.mapper.FollowMapper;
import com.cxzcanying.winterproject.service.FollowService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 21311
 */
@Slf4j
@Service
public class FollowServiceImpl implements FollowService {
    @Autowired
    private FollowMapper followMapper;

    @Override
    public List<String> getFollowingById(String userId) {
        return followMapper.getFollowingById(userId);
    }

    @Override
    public List<String> getFollowersById(String userId) {
        return followMapper.getFollowersById(userId);
    }

    @Override
    public void followUser(Follow follow) {
        followMapper.followUser(follow);
    }
}
