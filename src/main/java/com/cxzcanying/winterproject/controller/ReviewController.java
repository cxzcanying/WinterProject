package com.cxzcanying.winterproject.controller;

import com.cxzcanying.winterproject.entity.Review;
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
    public Result<Review> addReview(@PathVariable Integer bookId, @Valid @RequestBody Review review) {
        log.info("为图书{}添加评论{}", bookId,review);
        review.setBookId(bookId);
        reviewService.addReview(review);
        return Result.success(review);
    }

    @GetMapping
    public Result<List<Review>> getBookReviews(@PathVariable Integer bookId) {
        log.info("获取图书{}的评论列表", bookId);
        List<Review> reviews = reviewService.getReviewsByBookId(bookId);
        return Result.success(reviews);
    }

    @PostMapping("/{reviewId}/replies")
    public Result<Review> replyToReview(@PathVariable Integer bookId, 
                                      @PathVariable Integer reviewId, 
                                      @Valid @RequestBody Review reply) {
        log.info("用户ID:{}在图书ID:{}下的评论ID:{}回复评论:{}", reply.getUserId(),bookId,reviewId,reply);
        reply.setBookId(bookId);
        reply.setParentId(reviewId);
        reviewService.addReview(reply);
        return Result.success(reply);
    }

    @DeleteMapping("/{reviewId}")
    public void deleteReview(@PathVariable Integer reviewId) {
        log.info("删除评论{}", reviewId);
        reviewService.deleteReview(reviewId);
    }
}
