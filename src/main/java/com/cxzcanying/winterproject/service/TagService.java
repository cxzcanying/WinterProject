package com.cxzcanying.winterproject.service;

import com.cxzcanying.winterproject.entity.Book;
import com.cxzcanying.winterproject.entity.Tag;

import java.util.List;

public interface TagService {
    void addTag(Tag tag);

    List<Tag> getTagsByBookId(Integer bookId);

    void deleteTag(Integer tagId);

    List<Book> getBooksByTagName(String tagName);
}
