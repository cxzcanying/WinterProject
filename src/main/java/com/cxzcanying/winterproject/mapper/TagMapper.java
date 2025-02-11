package com.cxzcanying.winterproject.mapper;

import com.cxzcanying.winterproject.entity.Book;
import com.cxzcanying.winterproject.entity.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 21311
 */
@Mapper
public interface TagMapper {
    /**
     * 添加标签
     * @param tag
     */
    void addTag(Tag tag);

    /**
     * 获取图书的标签列表
     * @param bookId
     * @return List<Tag>
     */
    List<Tag> getTagsByBookId(Integer bookId);

    /**
     * 删除标签
     * @param tagId
     */
    void deleteTag(Integer tagId);

    /**
     * 为指定图书添加标签
     * @param bookId
     * @param tagId
     * @param userId
     */
    void addBookTag(@Param("bookId") Integer bookId, @Param("tagId") Integer tagId, @Param("userId") String userId);

    /**
     * 获取指定ID的tag的图书列表
     * @param tagId
     * @return List<Book>
     */
    List<Book> getBooksByTagId(String tagId);

    /**
     * 删除图书标签
     * @param tagId
     */
    void deleteBookTagByTagId(Integer tagId);

    /**
     * 删除标签
     * @param tagId
     */
    void deleteTagById(Integer tagId);
}
