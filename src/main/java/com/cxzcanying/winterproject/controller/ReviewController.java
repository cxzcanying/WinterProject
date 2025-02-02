package com.cxzcanying.winterproject.controller;

import com.cxzcanying.winterproject.annotation.RequiresRole;
import com.cxzcanying.winterproject.entity.Review;
import com.cxzcanying.winterproject.entity.Roles;
import com.cxzcanying.winterproject.pojo.Result;
import com.cxzcanying.winterproject.service.ReviewService;
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
@RequestMapping("/api/books/{bookId}/reviews")
@Validated
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping
    @RequiresRole(Roles.ROLE_USER)
    public Result<Review> addReview(@PathVariable Integer bookId, @Valid @RequestBody Review review) {
        try {
            log.info("为图书{}添加评论{}", bookId, review);
            review.setBookId(bookId);
            reviewService.addReview(review);
            return Result.success(review);
        } catch (Exception e) {
            log.error("添加评论失败", e);
            return Result.fail("添加评论失败: " + e.getMessage());
        }
    }

    @GetMapping
    @RequiresRole(Roles.ROLE_USER)
    public Result<List<Review>> getBookReviews(@PathVariable Integer bookId) {
        try {
            log.info("获取图书{}的评论列表", bookId);
            List<Review> reviews = reviewService.getReviewsByBookId(bookId);
            return Result.success(reviews);
        } catch (Exception e) {
            log.error("获取评论列表失败", e);
            return Result.fail("获取评论列表失败: " + e.getMessage());
        }
    }

    @PostMapping("/{reviewId}/replies")
    @RequiresRole(Roles.ROLE_USER)
    public Result<Review> replyToReview(@PathVariable Integer bookId, 
                                      @PathVariable Integer reviewId, 
                                      @Valid @RequestBody Review reply) {
        try {
            log.info("用户ID:{}在图书ID:{}下的评论ID:{}回复评论:{}", reply.getUserId(), bookId, reviewId, reply);
            reply.setBookId(bookId);
            reply.setParentId(reviewId);
            reviewService.addReview(reply);
            return Result.success(reply);
        } catch (Exception e) {
            log.error("回复评论失败", e);
            return Result.fail("回复评论失败: " + e.getMessage());
        }
    }

    @DeleteMapping("/{reviewId}")
    @RequiresRole(Roles.ROLE_USER)
    public Result<?> deleteReview(@PathVariable Integer reviewId) {
        try {
            log.info("删除评论{}", reviewId);
            reviewService.deleteReview(reviewId);
            return Result.success("删除评论成功");
        } catch (Exception e) {
            log.error("删除评论失败", e);
            return Result.fail("删除评论失败: " + e.getMessage());
        }
    }
}
