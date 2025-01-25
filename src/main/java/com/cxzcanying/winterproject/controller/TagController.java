package com.cxzcanying.winterproject.controller;

import com.cxzcanying.winterproject.entity.Book;
import com.cxzcanying.winterproject.entity.Tag;
import com.cxzcanying.winterproject.pojo.Result;
import com.cxzcanying.winterproject.service.TagService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 21311
 */
@Slf4j
@RestController
@RequestMapping("/api")
@Validated
public class TagController {
    @Autowired
    private TagService tagService;

    @PostMapping("/books/{bookId}/tags")
    public Result<Tag> addTag(@PathVariable Integer bookId, @Valid @RequestBody Tag tag) {
        log.info("为图书{}添加标签", bookId);
        tag.setBookId(bookId);
        tagService.addTag(tag);
        return Result.success(tag);
    }

    @GetMapping("/books/{bookId}/tags")
    public Result<List<Tag>> getBookTags(@PathVariable Integer bookId) {
        List<Tag> tags = tagService.getTagsByBookId(bookId);
        log.info("获取图书{}的标签列表tags{}", bookId,tags);
        return Result.success(tags);
    }

    @GetMapping("/tags/{tagId}/books")
    public Result<List<Book>> getBooksByTagId(@PathVariable String tagId){
        log.info("获取TagID为{}的图书列表",tagId);
        List<Book> books = tagService.getBooksByTagId(tagId);
        return Result.success(books);
    }

    @DeleteMapping("/books/{bookId}/tags/{tagId}")
    public void deleteTag(@PathVariable Integer bookId, @PathVariable Integer tagId) {
        log.info("删除图书{}的标签{}", bookId, tagId);
        tagService.deleteTag(tagId);
    }
}