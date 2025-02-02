package com.cxzcanying.winterproject.service;
import com.cxzcanying.winterproject.entity.Book;
import com.cxzcanying.winterproject.entity.BookSearchRequest;
import jakarta.validation.Valid;

import java.util.List;

/**
 * @author 21311
 */
public interface BookService {
    /**
     * 新增图书
     * @param book
     */
    void addBook(Book book);

    /**
     * 根据ID查询图书信息
     * @param id
     * @return Book
     */
    Book getBookById(Integer id);

    /**
     * 根据ID更新图书信息
     * @param book
     */
    void updateBookById(@Valid Book book);

    /**
     * 根据id删除图书信息
     * @param id
     */
    void deleteBookById(Integer id);

    /**
     * 分页查询图书
     * @param page
     * @param pageSize
     * @param sortField
     * @param sortOrder
     * @return List<Book>
     */
    List<Book> getAllBooks(Integer page, Integer pageSize, String sortField, String sortOrder);

    /**
     * 图书搜索与过滤
     * @param bookSearchRequest
     * @return List<Book>
     */
    List<Book> searchBook(BookSearchRequest bookSearchRequest);

    /**
     * 获取指定分类图书
     * @param categoryId
     * @param page
     * @param size
     * @param sortField
     * @param sortOrder
     * @return List<Book>
     */
    List<Book> getBooksByCategoryId(Integer categoryId, Integer page, Integer size, String sortField, String sortOrder);

    /**
     * 按分类统计图书数量
     * @param author
     * @return Integer
     */
    Integer countBooksByAuthor(String author);

    /**
     * 按出版年份统计图书数量
     * @param publishedYear
     * @return Integer
     */
    Integer countBooksByPublishedYear(String publishedYear);

    /**
     * 按作者统计图书数量
     * @param category
     * @return Integer
     */
    Integer countBooksByCategory(String category);

    /**
     * 获取图书推荐
     * @param userId 用户ID
     * @return List<Book>
     */
    List<Book> getRecommendations(String userId);

    /**
     * 图书高级搜索
     * @param bookSearchRequest
     * @return List<Book>
     */
    List<Book> advancedSearchBook(BookSearchRequest bookSearchRequest);


}
