package com.cxzcanying.winterproject.mapper;

import com.cxzcanying.winterproject.entity.Book;
import com.cxzcanying.winterproject.entity.Favorite;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 21311
 */
@Mapper
public interface FavoriteMapper {
    void deleteFavorite(String userId, Integer bookId);

    void addFavorite(Favorite favorite);

    List<Book> getFavoritesByUserId(String userId);
}
