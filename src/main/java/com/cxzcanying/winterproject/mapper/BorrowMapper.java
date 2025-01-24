package com.cxzcanying.winterproject.mapper;

import com.cxzcanying.winterproject.entity.Borrow;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface BorrowMapper {
    void addBorrow(Borrow borrow);
    void updateBorrow(Borrow borrow);
    List<Borrow> getBorrowHistory(String userId);
    Borrow getBorrowByBookId(Integer bookId);
}