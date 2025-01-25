package com.cxzcanying.winterproject.mapper;

import com.cxzcanying.winterproject.entity.Review;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 * @author 21311
 */
@Mapper
public interface ReviewMapper {
    /**
     * 添加评论
     * @param review
     */
    void addReview(Review review);

    /**
     * 获取指定图书的全部评论
     * @param bookId
     * @return List<Review>
     */
    List<Review> getReviewsByBookId(Integer bookId);

    /**
     * 删除评论
     * @param reviewId
     */
    void deleteReview(Integer reviewId);

    /**
     * 获取指定评论的全部回复
     * @param reviewId
     * @return List<Review>
     */
    List<Review> getRepliesByReviewId(Integer reviewId);
}
