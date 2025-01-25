package com.cxzcanying.winterproject.controller;

import com.cxzcanying.winterproject.entity.Borrow;
import com.cxzcanying.winterproject.pojo.Result;
import com.cxzcanying.winterproject.service.BorrowService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author 21311
 */
@Slf4j
@RestController
@RequestMapping("/api")
@Validated
public class BorrowController {
    @Autowired
    private BorrowService borrowService;

    @PostMapping("/books/{bookId}/borrow")
    public Result<Borrow> borrowBook(@PathVariable Integer bookId, @Valid @RequestBody Borrow borrow) {
        log.info("用户:{}借阅图书:{}",borrow.getUserId(), bookId);
        borrow.setBookId(bookId);
        borrowService.borrowBook(borrow);
        return Result.success(borrow);
    }

    @PostMapping("/books/{bookId}/return")
    public Result<Borrow> returnBook(@PathVariable Integer bookId) {
        log.info("归还图书{}", bookId);
        Borrow borrow = borrowService.returnBook(bookId);
        return Result.success(borrow);
    }

    @GetMapping("/users/{userId}/borrow-history")
    public Result<List<Borrow>> getBorrowHistory(@PathVariable String userId) {
        log.info("查询用户{}的借阅历史", userId);
        List<Borrow> history = borrowService.getBorrowHistory(userId);
        return Result.success(history);
    }
}