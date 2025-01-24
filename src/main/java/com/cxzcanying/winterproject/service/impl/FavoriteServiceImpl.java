package com.cxzcanying.winterproject.service.impl;

import com.cxzcanying.winterproject.entity.Book;
import com.cxzcanying.winterproject.entity.Favorite;
import com.cxzcanying.winterproject.entity.Follow;
import com.cxzcanying.winterproject.mapper.FavoriteMapper;
import com.cxzcanying.winterproject.service.FavoriteService;
import com.cxzcanying.winterproject.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 21311
 */
@Service
public class FavoriteServiceImpl implements FavoriteService {
    @Autowired
    private FavoriteMapper favoriteMapper;
    @Override
    public void addFavorite(Favorite favorite) {
        favoriteMapper.addFavorite(favorite);
    }

    @Override
    public List<Book> getFavoritesByUserId(String userId) {
        return favoriteMapper.getFavoritesByUserId(userId);
    }

    @Override
    public void deleteFavorite(String userId, Integer bookId) {
        favoriteMapper.deleteFavorite(userId,bookId);
    }
}
