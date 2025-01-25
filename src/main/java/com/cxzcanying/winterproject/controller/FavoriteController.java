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

import java.time.LocalDate;
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
        log.info("用户{}添加收藏图书", userId);
        favorite.setUserId(Integer.valueOf(userId));
        favorite.setCreateAt(String.valueOf(LocalDateTime.now()));
        favoriteService.addFavorite(favorite);
        return Result.success(favorite);
    }

    @GetMapping
    public Result<List<Book>> getFavorites(@PathVariable String userId) {
        log.info("获取用户{}的收藏列表", userId);
        List<Book> favorites = favoriteService.getFavoritesByUserId(userId);
        return Result.success(favorites);
    }

    @DeleteMapping("/{bookId}")
    public void deleteFavorite(@PathVariable String userId, @PathVariable Integer bookId) {
        log.info("用户{}删除收藏图书{}", userId, bookId);
        favoriteService.deleteFavorite(userId, bookId);
    }
}
