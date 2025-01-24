package com.cxzcanying.winterproject.service;

import com.cxzcanying.winterproject.entity.Borrow;

import java.util.List;

public interface BorrowService {
    void borrowBook(Borrow borrow);

    Borrow returnBook(Integer bookId);

    List<Borrow> getBorrowHistory(String userId);
}
