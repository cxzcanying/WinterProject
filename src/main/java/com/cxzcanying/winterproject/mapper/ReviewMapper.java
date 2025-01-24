package com.cxzcanying.winterproject.mapper;

import com.cxzcanying.winterproject.entity.Review;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 * @author 21311
 */
@Mapper
public interface ReviewMapper {
    void addReview(Review review);

    List<Review> getReviewsByBookId(Integer bookId);

    void deleteReview(Integer reviewId);

    List<Review> getRepliesByReviewId(Integer reviewId);
}
