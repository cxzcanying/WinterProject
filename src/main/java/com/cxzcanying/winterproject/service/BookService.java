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
     * @return
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
     * @return
     */
    public List<Book> getAllBooks(Integer page, Integer pageSize, String sortField, String sortOrder);

    /**
     * 图书搜索与过滤
     * @param bookSearchRequest
     * @return
     */
    List<Book> searchBook(BookSearchRequest bookSearchRequest);

    /**
     * 获取指定分类图书
     * @param categoryId
     * @param page
     * @param size
     * @param sortField
     * @param sortOrder
     * @return
     */
    List<Book> getBooksByCategoryId(Integer categoryId, Integer page, Integer size, String sortField, String sortOrder);

    /**
     * 按分类统计图书数量
     * @param author
     * @return
     */
    Integer countBooksByAuthor(String author);

    /**
     * 按出版年份统计图书数量
     * @param publishedYear
     * @return
     */
    Integer countBooksByPublishedYear(String publishedYear);

    /**
     * 按作者统计图书数量
     * @param category
     * @return
     */
    Integer countBooksByCategory(String category);

    /**
     * 获取图书推荐
     * @param userId 用户ID
     * @return 推荐图书列表
     */
    List<Book> getRecommendations(String userId);
}
