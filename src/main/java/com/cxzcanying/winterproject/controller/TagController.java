package com.cxzcanying.winterproject.controller;

import com.cxzcanying.winterproject.annotation.RequiresRole;
import com.cxzcanying.winterproject.entity.Book;
import com.cxzcanying.winterproject.entity.Roles;
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
    @RequiresRole(Roles.ROLE_USER)
    public Result<Tag> addTag(@PathVariable Integer bookId, @Valid @RequestBody Tag tag) {
        try {
            log.info("为图书{}添加标签", bookId);
            tag.setBookId(bookId);
            tagService.addTag(tag);
            return Result.success(tag);
        } catch (Exception e) {
            log.error("添加标签失败", e);
            return Result.fail("添加标签失败: " + e.getMessage());
        }
    }

    @GetMapping("/books/{bookId}/tags")
    @RequiresRole(Roles.ROLE_USER)
    public Result<List<Tag>> getBookTags(@PathVariable Integer bookId) {
        try {
            List<Tag> tags = tagService.getTagsByBookId(bookId);
            log.info("获取图书{}的标签列表tags{}", bookId, tags);
            return Result.success(tags);
        } catch (Exception e) {
            log.error("获取标签列表失败", e);
            return Result.fail("获取标签列表失败: " + e.getMessage());
        }
    }

    @GetMapping("/tags/{tagId}/books")
    @RequiresRole(Roles.ROLE_USER)
    public Result<List<Book>> getBooksByTagId(@PathVariable String tagId) {
        try {
            log.info("获取TagID为{}的图书列表", tagId);
            List<Book> books = tagService.getBooksByTagId(tagId);
            return Result.success(books);
        } catch (Exception e) {
            log.error("获取图书列表失败", e);
            return Result.fail("获取图书列表失败: " + e.getMessage());
        }
    }

    @DeleteMapping("/books/{bookId}/tags/{tagId}")
    @RequiresRole(Roles.ROLE_USER)
    public Result<?> deleteTag(@PathVariable Integer bookId, @PathVariable Integer tagId) {
        try {
            log.info("删除图书{}的标签{}", bookId, tagId);
            tagService.deleteTag(tagId);
            return Result.success("删除标签成功");
        } catch (Exception e) {
            log.error("删除标签失败", e);
            return Result.fail("删除标签失败: " + e.getMessage());
        }
    }
}