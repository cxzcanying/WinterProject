package com.cxzcanying.winterproject.controller;

import com.cxzcanying.winterproject.entity.Book;
import com.cxzcanying.winterproject.entity.Favorite;
import com.cxzcanying.winterproject.pojo.Result;
import com.cxzcanying.winterproject.service.FavoriteService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author 21311
 */
@Slf4j
@RestController
@RequestMapping("/api/users/{userId}/favorites")
@Validated
public class FavoriteController {
    @Autowired
    private FavoriteService favoriteService;

    @PostMapping
    public Result<Favorite> addFavorite(@PathVariable String userId, @Valid @RequestBody Favorite favorite) {
        try {
            log.info("用户{}添加收藏图书", userId);
            favorite.setUserId(Integer.valueOf(userId));
            favorite.setCreateAt(String.valueOf(LocalDateTime.now()));
            favoriteService.addFavorite(favorite);
            return Result.success(favorite);
        } catch (Exception e) {
            log.error("添加收藏失败", e);
            return Result.fail("添加收藏失败: " + e.getMessage());
        }
    }

    @GetMapping
    public Result<List<Book>> getFavorites(@PathVariable String userId) {
        try {
            log.info("获取用户{}的收藏列表", userId);
            List<Book> favorites = favoriteService.getFavoritesByUserId(userId);
            return Result.success(favorites);
        } catch (Exception e) {
            log.error("获取收藏列表失败", e);
            return Result.fail("获取收藏列表失败: " + e.getMessage());
        }
    }

    @DeleteMapping("/{bookId}")
    public Result<?> deleteFavorite(@PathVariable String userId, @PathVariable Integer bookId) {
        try {
            log.info("用户{}删除收藏图书{}", userId, bookId);
            favoriteService.deleteFavorite(userId, bookId);
            return Result.success("删除收藏成功");
        } catch (Exception e) {
            log.error("删除收藏失败", e);
            return Result.fail("删除收藏失败: " + e.getMessage());
        }
    }
}
