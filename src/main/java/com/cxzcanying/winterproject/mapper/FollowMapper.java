package com.cxzcanying.winterproject.mapper;

import com.cxzcanying.winterproject.entity.Follow;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 21311
 */

@Mapper
public interface FollowMapper {
    /**
     * 获取指定用户的关注列表
     * @param userId
     * @return List<String>
     */
    List<String> getFollowingById(String userId) ;

    /**
     * 获取指定用户的粉丝列表
     * @param userId
     * @return List<String>
     */
    List<String> getFollowersById(String userId);

    /**
     * 关注用户
     * @param follow
     */
    void followUser(Follow follow) ;

    /**
     * 取消关注用户
     * @param followingId
     * @param userId
     */
    void unfollowUser(String followingId, String userId);
}
