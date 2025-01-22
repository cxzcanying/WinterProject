package com.cxzcanying.winterproject.controller;

import com.cxzcanying.winterproject.entity.Book;
import com.cxzcanying.winterproject.pojo.Result;
import com.cxzcanying.winterproject.service.BookService;

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
@RequestMapping("/api/books")
@Validated
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping(produces = "application/json")
    public Result<Book> add(@Valid @RequestBody Book book){
        log.info("新增:{}",book);
        bookService.addBook(book);
        return Result.success(book);
    }

    @GetMapping
    public Result<List<Book>> getAllBooks(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "sort", defaultValue = "title") String sort) {
        log.info("分页排序查询，参数{},{},{}",page,size,sort);
        //分割sort参数
        String[] sortParts = sort.split(",");
        String sortField = sortParts.length > 0 ? sortParts[0] : null;
        String sortOrder = sortParts.length > 1 ? sortParts[1] : null;

        List<Book> books = bookService.getAllBooks(page, size, sortField, sortOrder);
        return Result.success(books);
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Integer id){
        log.info("查询id为{}的图书信息",id);
        return bookService.getBookById(id);
    }

    @PutMapping("/{id}")
    public Result<Book> updateBookById(@PathVariable Integer id,@Valid @RequestBody Book book){
        log.info("更新id为{}的图书信息",id);
        book.setId(id);
        bookService.updateBookById(book);
        return Result.success(book);
    }

    @DeleteMapping("/{id}")
    public Result<Book> deleteBookById(@PathVariable Integer id){
        Book book = bookService.getBookById(id);
        if (book == null) {
            return Result.fail("Book not found");
        }
        log.info("删除id为{}的图书",id);
        bookService.deleteBookById(id);
        return Result.success(book);
    }

}
