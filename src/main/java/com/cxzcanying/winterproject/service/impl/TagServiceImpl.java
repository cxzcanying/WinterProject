package com.cxzcanying.winterproject.service.impl;

import com.cxzcanying.winterproject.entity.Book;
import com.cxzcanying.winterproject.entity.Tag;
import com.cxzcanying.winterproject.mapper.TagMapper;
import com.cxzcanying.winterproject.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author 21311
 */
@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagMapper tagMapper;

    @Override
    public void addTag(Tag tag) {
        tag.setCreateTime(LocalDateTime.now());
        tagMapper.addTag(tag);
        tagMapper.addBookTag(tag.getBookId(),tag.getId(),tag.getUserId());
    }

    @Override
    public List<Tag> getTagsByBookId(Integer bookId) {
        return tagMapper.getTagsByBookId(bookId);
    }

    @Override
    public void deleteTag(Integer tagId) {
        tagMapper.deleteTag(tagId);
    }


    @Override
    public List<Book> getBooksByTagId(String tagId) {
        return tagMapper.getBooksByTagId(tagId);
    }
}