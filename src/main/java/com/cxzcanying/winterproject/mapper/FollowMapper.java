package com.cxzcanying.winterproject.mapper;

import com.cxzcanying.winterproject.entity.Follow;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 21311
 */

@Mapper
public interface FollowMapper {
    public List<String> getFollowingById(String userId) ;

    public List<String> getFollowersById(String userId);

    public void followUser(Follow follow) ;
}
