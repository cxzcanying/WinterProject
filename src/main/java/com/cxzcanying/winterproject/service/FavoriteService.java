package com.cxzcanying.winterproject.service;

import com.cxzcanying.winterproject.entity.Book;
import com.cxzcanying.winterproject.entity.Favorite;

import java.util.List;

/**
 * @author 21311
 */
public interface FavoriteService {
    /**
     * 添加收藏
     * @param favorite
     */
    void addFavorite(Favorite favorite);

    /**
     * 获取用户收藏列表
     * @param userId
     * @return List<Book>
     */
    List<Book> getFavoritesByUserId(String userId);

    /**
     * 删除收藏
     * @param userId
     * @param bookId
     */
    void deleteFavorite(String userId, Integer bookId);
}
