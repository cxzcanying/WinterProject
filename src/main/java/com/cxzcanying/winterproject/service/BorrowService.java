package com.cxzcanying.winterproject.service;

import com.cxzcanying.winterproject.entity.Borrow;

import java.util.List;

public interface BorrowService {
    /**
     * 借阅图书
     * @param borrow
     */
    void borrowBook(Borrow borrow);

    /**
     * 归还图书
     * @param bookId
     * @return
     */
    Borrow returnBook(Integer bookId);

    /**
     * 获取借阅历史
     * @param userId
     * @return
     */
    List<Borrow> getBorrowHistory(String userId);
}
