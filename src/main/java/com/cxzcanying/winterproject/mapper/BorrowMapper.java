package com.cxzcanying.winterproject.mapper;

import com.cxzcanying.winterproject.entity.Borrow;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 * @author 21311
 */
@Mapper
public interface BorrowMapper {
    /**
     * 添加借阅记录
     * @param borrow
     */
    void addBorrow(Borrow borrow);

    /**
     * 更新借阅记录
     * @param borrow
     */
    void updateBorrow(Borrow borrow);

    /**
     * 获取借阅记录
     * @param userId
     * @return List<Borrow>
     */
    List<Borrow> getBorrowHistory(String userId);

    /**
     * 获取指定图书借阅记录
     * @param bookId
     * @return Borrow
     */
    Borrow getBorrowByBookId(Integer bookId);
}