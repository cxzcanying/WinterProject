package com.cxzcanying.winterproject.controller;

import com.cxzcanying.winterproject.entity.Book;
import com.cxzcanying.winterproject.entity.Tag;
import com.cxzcanying.winterproject.pojo.Result;
import com.cxzcanying.winterproject.service.TagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 21311
 */
@Slf4j
@RestController
@RequestMapping("/api/books/{bookId}/tags")
public class TagController {
    @Autowired
    private TagService tagService;

    @PostMapping
    public Result<Tag> addTag(@PathVariable Integer bookId, @RequestBody Tag tag) {
        log.info("为图书{}添加标签", bookId);
        tag.setBookId(bookId);
        tagService.addTag(tag);
        return Result.success(tag);
    }

    @GetMapping
    public Result<List<Tag>> getBookTags(@PathVariable Integer bookId) {
        log.info("获取图书{}的标签列表", bookId);
        List<Tag> tags = tagService.getTagsByBookId(bookId);
        return Result.success(tags);
    }

    @DeleteMapping("/{tagId}")
    public void deleteTag(@PathVariable Integer bookId, @PathVariable Integer tagId) {
        log.info("删除图书{}的标签{}", bookId, tagId);
        tagService.deleteTag(tagId);
    }

    @GetMapping("/search")
    public Result<List<Book>> getBooksByTag(@RequestParam String tagName) {
        log.info("搜索标签{}相关的图书", tagName);
        List<Book> books = tagService.getBooksByTagName(tagName);
        return Result.success(books);
    }
}