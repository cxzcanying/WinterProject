package com.cxzcanying.winterproject.controller;

import com.cxzcanying.winterproject.entity.Borrow;
import com.cxzcanying.winterproject.pojo.Result;
import com.cxzcanying.winterproject.service.BorrowService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 21311
 */
@Slf4j
@RestController
@RequestMapping("/api/books/{bookId}/borrow")
public class BorrowController {
    @Autowired
    private BorrowService borrowService;

    @PostMapping
    public Result<Borrow> borrowBook(@PathVariable Integer bookId, @RequestBody Borrow borrow) {
        log.info("借阅图书{}", bookId);
        borrow.setBookId(bookId);
        borrowService.borrowBook(borrow);
        return Result.success(borrow);
    }

    @PostMapping("/return")
    public Result<Borrow> returnBook(@PathVariable Integer bookId) {
        log.info("归还图书{}", bookId);
        Borrow borrow = borrowService.returnBook(bookId);
        return Result.success(borrow);
    }

    @GetMapping("/history")
    public Result<List<Borrow>> getBorrowHistory(@RequestParam String userId) {
        log.info("查询用户{}的借阅历史", userId);
        List<Borrow> history = borrowService.getBorrowHistory(userId);
        return Result.success(history);
    }
}