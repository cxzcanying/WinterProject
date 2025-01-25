package com.cxzcanying.winterproject.service.impl;

import com.cxzcanying.winterproject.entity.Borrow;
import com.cxzcanying.winterproject.exception.ResourceNotFoundException;
import com.cxzcanying.winterproject.mapper.BookMapper;
import com.cxzcanying.winterproject.mapper.BorrowMapper;
import com.cxzcanying.winterproject.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author 21311
 */
@Service
public class BorrowServiceImpl implements BorrowService {
    @Autowired
    private BorrowMapper borrowMapper;

    @Autowired
    private BookMapper bookMapper;

    @Override
    public void borrowBook(Borrow borrow) {
        Borrow existingBorrow = borrowMapper.getBorrowByBookId(borrow.getBookId());
        if (existingBorrow != null) {
            throw new IllegalStateException("该图书已被借出");
        }
        borrow.setBorrowTime(LocalDateTime.now());
        // 默认借阅30天
        borrow.setDueTime(LocalDateTime.now().plusDays(30));
        borrow.setStatus("BORROWED");
        borrowMapper.addBorrow(borrow);
    }

    @Override
    public Borrow returnBook(Integer bookId) {
        Borrow borrow = borrowMapper.getBorrowByBookId(bookId);
        if (borrow == null) {
            throw new ResourceNotFoundException(404,"未找到该借阅记录");
        }
        borrow.setReturnTime(LocalDateTime.now());
        borrow.setStatus("RETURNED");
        // 如果超期，更新状态为OVERDUE
        if (LocalDateTime.now().isAfter(borrow.getDueTime())) {
            borrow.setStatus("OVERDUE");
        }
        borrowMapper.updateBorrow(borrow);
        return borrow;
    }

    @Override
    public List<Borrow> getBorrowHistory(String userId) {
        return borrowMapper.getBorrowHistory(userId);
    }
}
