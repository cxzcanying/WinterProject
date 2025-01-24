package com.cxzcanying.winterproject.service;

import com.cxzcanying.winterproject.entity.Review;

import java.util.List;

/**
 * @author 21311
 */
public interface ReviewService {
    void addReview(Review review);
    List<Review> getReviewsByBookId(Integer bookId);
    void deleteReview(Integer reviewId);
    List<Review> getRepliesByReviewId(Integer reviewId);
}