package com.cxzcanying.winterproject.controller;

import com.cxzcanying.winterproject.annotation.RequiresRole;
import com.cxzcanying.winterproject.entity.Borrow;
import com.cxzcanying.winterproject.entity.Roles;
import com.cxzcanying.winterproject.pojo.Result;
import com.cxzcanying.winterproject.service.BorrowService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
        try {
            log.info("用户:{}借阅图书:{}", borrow.getUserId(), bookId);
            borrow.setBookId(bookId);
            borrowService.borrowBook(borrow);
            return Result.success(borrow);
        } catch (Exception e) {
            log.error("借阅图书失败", e);
            return Result.fail("借阅图书失败: " + e.getMessage());
        }
    }

    @PostMapping("/books/{bookId}/return")
    public Result<Borrow> returnBook(@PathVariable Integer bookId) {
        try {
            log.info("归还图书{}", bookId);
            Borrow borrow = borrowService.returnBook(bookId);
            return Result.success(borrow);
        } catch (Exception e) {
            log.error("归还图书失败", e);
            return Result.fail("归还图书失败: " + e.getMessage());
        }
    }

    @GetMapping("/users/{userId}/borrow-history")
    @RequiresRole(Roles.ROLE_USER)
    public Result<List<Borrow>> getBorrowHistory(@PathVariable String userId) {
        try {
            log.info("查询用户{}的借阅历史", userId);
            List<Borrow> history = borrowService.getBorrowHistory(userId);
            return Result.success(history);
        } catch (Exception e) {
            log.error("获取借阅历史失败", e);
            return Result.fail("获取借阅历史失败: " + e.getMessage());
        }
    }
}