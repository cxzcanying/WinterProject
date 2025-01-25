package com.cxzcanying.winterproject.controller;

import com.cxzcanying.winterproject.entity.Book;
import com.cxzcanying.winterproject.entity.BookSearchRequest;
import com.cxzcanying.winterproject.exception.ResourceNotFoundException;
import com.cxzcanying.winterproject.pojo.Result;
import com.cxzcanying.winterproject.service.BookService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
    public Result<Book> addBook(@Valid @RequestBody Book book){
        log.info("新增:{}",book);
        bookService.addBook(book);
        return Result.success(book);

    }

    @GetMapping
    public Result<List<Book>> getAllBooks(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                          @RequestParam(value = "size", defaultValue = "10") Integer size,
                                          @RequestParam(value = "sort", defaultValue = "title,asc") String sort,
                                          @RequestParam(value = "categoryId", required = false) Integer categoryId) {
        log.info("分页排序查询，参数：page={}, size={}, sort={}, categoryId={}", page, size, sort, categoryId);
        //分割sort参数
        String[] sortParts = sort.split(",");
        String sortField = sortParts.length > 0 ? sortParts[0] : "title";
        String sortOrder = sortParts.length > 1 ? sortParts[1] : "asc";

        List<Book> books;
        if (categoryId != null) {
            // 根据分类 ID 获取图书
            books = bookService.getBooksByCategoryId(categoryId, page, size, sortField, sortOrder);
        } else {
            // 获取所有图书，支持分页和排序
            books = bookService.getAllBooks(page, size, sortField, sortOrder);
        }
        return Result.success(books);
    }


    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Integer id){
        log.info("查询id为{}的图书信息",id);
        Book book=bookService.getBookById(id);
        if (book == null){
            throw new ResourceNotFoundException(404,"Book not found with id: " + id);
        }
        return Result.success(book).getData();
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

    @GetMapping("/search")
    public Result<List<Book>> searchBook(@RequestParam(value = "title", defaultValue = "") String title,
                                         @RequestParam(value = "author", defaultValue = "") String author,
                                         @RequestParam(value = "isbn", defaultValue = "") String isbn,
                                         @RequestParam(value = "publishedDateStart", defaultValue = "") String publishedDateStart,
                                         @RequestParam(value = "publishedDateEnd", defaultValue = "") String publishedDateEnd,
                                         @RequestParam(value = "priceMin", defaultValue = "0") Integer priceMin,
                                         @RequestParam(value = "priceMax", defaultValue = "999999") Integer priceMax,
                                         @RequestParam(value = "category", defaultValue = "") String category){
        BookSearchRequest bookSearchRequest = new BookSearchRequest();
        bookSearchRequest.setTitle(title);
        bookSearchRequest.setAuthor(author);
        bookSearchRequest.setIsbn(isbn);
        bookSearchRequest.setPublishedDateStart(publishedDateStart);
        bookSearchRequest.setPublishedDateEnd(publishedDateEnd);
        bookSearchRequest.setPriceMin(priceMin);
        bookSearchRequest.setPriceMax(priceMax);
        bookSearchRequest.setCategory(category);
        log.info("图书搜索与过滤:书名{}，作者{}，ISBN{}，出版开始时间{}，出版结束时间{}，最低价格{}，最高价格{},分类{}",
                title,author,isbn,publishedDateStart,publishedDateEnd,priceMin,priceMax,category);
        List<Book> bookList=bookService.searchBook(bookSearchRequest);
        return Result.success(bookList);
    }

    @GetMapping("/stats/category/{category}")
    public Result<Integer> countBooksByCategory(@PathVariable String category){
        log.info("根据分类{}统计图书数量",category);
        Integer stats=bookService.countBooksByCategory(category);
        return Result.success(stats);
    }

    @GetMapping("/stats/publishedYear/{publishedYear}")
    public Result<Integer> countBooksByPublishedYear(@PathVariable String publishedYear){
        log.info("根据出版年份{}统计图书数量",publishedYear);
        Integer stats=bookService.countBooksByPublishedYear(publishedYear);
        return Result.success(stats);
    }

    @GetMapping("/stats/author/{author}")
    public Result<Integer> countBooksByAuthor(@PathVariable String author){
        log.info("根据作者{}统计图书数量",author);
        Integer stats=bookService.countBooksByAuthor(author);
        return Result.success(stats);
    }

    @GetMapping("/recommendations")
    public Result<List<Book>> getRecommendations(@RequestParam String userId) {
        log.info("为用户{}推荐图书", userId);
        List<Book> recommendations = bookService.getRecommendations(userId);
        return Result.success(recommendations);
    }

    @GetMapping("/advanced-search")
    public Result<List<Book>> advancedSearchBook(@RequestParam(value = "title", defaultValue = "") String title,
                                         @RequestParam(value = "author", defaultValue = "") String author,
                                         @RequestParam(value = "isbn", defaultValue = "") String isbn,
                                         @RequestParam(value = "publishedYear", defaultValue = "") String publishedYear,
                                         @RequestParam(value = "priceMin", defaultValue = "0") Integer priceMin,
                                         @RequestParam(value = "priceMax", defaultValue = "999999") Integer priceMax,
                                         @RequestParam(value = "category", defaultValue = "") String category){
        BookSearchRequest bookSearchRequest = new BookSearchRequest();
        bookSearchRequest.setTitle(title);
        bookSearchRequest.setAuthor(author);
        bookSearchRequest.setIsbn(isbn);
        bookSearchRequest.setPublishedYear(publishedYear);
        bookSearchRequest.setPriceMin(priceMin);
        bookSearchRequest.setPriceMax(priceMax);
        bookSearchRequest.setCategory(category);
        log.info("图书高级搜索:书名{}，作者{}，ISBN{}，出版时间{}，最低价格{}，最高价格{},分类{}",
                title,author,isbn,publishedYear,priceMin,priceMax,category);
        List<Book> bookList=bookService.advancedSearchBook(bookSearchRequest);
        return Result.success(bookList);
    }
}
