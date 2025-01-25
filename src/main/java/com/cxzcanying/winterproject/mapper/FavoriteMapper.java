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
    /**
     * 删除收藏
     * @param userId
     * @param bookId
     */
    void deleteFavorite(String userId, Integer bookId);

    /**
     * 添加收藏
     * @param favorite
     */
    void addFavorite(Favorite favorite);

    /**
     * 获取指定用户的收藏列表
     * @param userId
     * @return List<Book>
     */
    List<Book> getFavoritesByUserId(String userId);
}
