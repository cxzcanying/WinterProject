package com.cxzcanying.winterproject.mapper;

import com.cxzcanying.winterproject.entity.Book;
import com.cxzcanying.winterproject.entity.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TagMapper {
    void addTag(Tag tag);

    List<Tag> getTagsByBookId(Integer bookId);

    void deleteTag(Integer tagId);

    void addBookTag(@Param("bookId") Integer bookId, @Param("tagId") Integer tagId, @Param("userId") String userId);

    List<Book> getBooksByTagName(String tagName);
}
