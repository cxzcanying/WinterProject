package com.cxzcanying.winterproject.service.impl;

import com.cxzcanying.winterproject.entity.Review;
import com.cxzcanying.winterproject.exception.ResourceNotFoundException;
import com.cxzcanying.winterproject.mapper.ReviewMapper;
import com.cxzcanying.winterproject.service.ReviewService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author 21311
 */
@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewMapper reviewMapper;

    @Override
    public void addReview(Review review) {
        review.setCreateTime(LocalDateTime.now());
        if (review.getParentId() != null) {
            List<Review> parentReview = reviewMapper.getReviewsByBookId(review.getBookId());
            if (parentReview.isEmpty()) {
                throw new ResourceNotFoundException(404,"父评论不存在");
            }
        }
        reviewMapper.addReview(review);
    }

    @Override
    public List<Review> getReviewsByBookId(Integer bookId) {
        List<Review> reviews = reviewMapper.getReviewsByBookId(bookId);
        reviews.forEach(review -> {
            List<Review> replies = getRepliesRecursive(review.getId());
            review.setReplies(replies);
        });
        return reviews;
    }

    @Override
    public void deleteReview(Integer reviewId) {
        reviewMapper.deleteReview(reviewId);
    }

    @Override
    public List<Review> getRepliesByReviewId(Integer reviewId) {
        return reviewMapper.getRepliesByReviewId(reviewId);
    }

    private List<Review> getRepliesRecursive(Integer reviewId) {
        List<Review> replies = reviewMapper.getRepliesByReviewId(reviewId);
        // 递归获取每条回复的所有回复
        replies.forEach(reply -> {
            List<Review> nestedReplies = getRepliesRecursive(reply.getId());
            reply.setReplies(nestedReplies);
        });
        return replies;
    }
}
