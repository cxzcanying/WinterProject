package com.cxzcanying.winterproject.service;

import com.cxzcanying.winterproject.entity.Book;
import com.cxzcanying.winterproject.entity.Favorite;

import java.util.List;

/**
 * @author 21311
 */
public interface FavoriteService {
    void addFavorite(Favorite favorite);

    List<Book> getFavoritesByUserId(String userId);

    void deleteFavorite(String userId, Integer bookId);
}
