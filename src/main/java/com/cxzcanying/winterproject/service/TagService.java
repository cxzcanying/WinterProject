package com.cxzcanying.winterproject.service;

import com.cxzcanying.winterproject.entity.Book;
import com.cxzcanying.winterproject.entity.Tag;

import java.util.List;

/**
 * @author 21311
 */
public interface TagService {
    /**
     * 添加标签
     * @param tag
     */
    void addTag(Tag tag);

    /**
     * 获取指定图书的标签
     * @param bookId
     * @return
     */
    List<Tag> getTagsByBookId(Integer bookId);

    /**
     * 删除标签
     * @param tagId
     */
    void deleteTag(Integer tagId);

    /**
     * 获取指定ID的tag的图书
     * @param tagId
     * @return List<Book>
     */
    List<Book> getBooksByTagId(String tagId);
}
