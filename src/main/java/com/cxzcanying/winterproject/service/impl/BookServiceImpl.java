package com.cxzcanying.winterproject.service.impl;

import com.cxzcanying.winterproject.entity.Book;
import com.cxzcanying.winterproject.entity.BookSearchRequest;
import com.cxzcanying.winterproject.entity.Borrow;
import com.cxzcanying.winterproject.mapper.BookMapper;
import com.cxzcanying.winterproject.mapper.BorrowMapper;
import com.cxzcanying.winterproject.mapper.FavoriteMapper;
import com.cxzcanying.winterproject.service.BookService;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


/**
 * @author 21311
 */
@Slf4j
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;
    private BorrowMapper borrowMapper;
    private FavoriteMapper favoriteMapper;

    @Override
    public void addBook(Book book) {
        bookMapper.addByName(book);
    }

    @Override
    public Book getBookById(Integer id) {
        return bookMapper.getBookById(id);
    }

    @Override
    public void updateBookById(Book book) {
        bookMapper.updateBookById(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookMapper.deleteBookById(id);
    }
    @Override
    public List<Book> getAllBooks(Integer page, Integer pageSize, String sortField, String sortOrder) {
        PageHelper.startPage(page, pageSize);
        if (sortField != null && sortOrder != null) {
            PageHelper.orderBy(sortField + " " + sortOrder);
        }
        return bookMapper.getAllBooks(page, pageSize);
    }

    @Override
    public List<Book> searchBook(BookSearchRequest bookSearchRequest) {
        return bookMapper.searchBook(bookSearchRequest.getTitle(),
                bookSearchRequest.getAuthor(),
                bookSearchRequest.getIsbn(),
                bookSearchRequest.getPublishedDateStart(),
                bookSearchRequest.getPublishedDateEnd(),
                bookSearchRequest.getPriceMin(),
                bookSearchRequest.getPriceMax(),
                bookSearchRequest.getCategory());
    }

    @Override
    public List<Book> getBooksByCategoryId(Integer categoryId, Integer page, Integer size, String sortField, String sortOrder) {
        int offset = (page - 1) * size;
        return bookMapper.getBooksByCategoryId(categoryId, offset, size);
    }

    @Override
    public Integer countBooksByAuthor(String author) {
        return bookMapper.countBooksByAuthor(author);
    }

    @Override
    public Integer countBooksByPublishedYear(String publishedYear) {
        return bookMapper.countBooksByPublishedYear(publishedYear);
    }

    @Override
    public Integer countBooksByCategory(String category) {
        return bookMapper.countBooksByCategory(category);
    }
    
    @Override
    public List<Book> getRecommendations(String userId) {
    // 1. 获取用户借阅历史
    List<Borrow> borrowHistory = borrowMapper.getBorrowHistory(userId);
    
    // 2. 获取用户收藏列表
    List<Book> favorites = favoriteMapper.getFavoritesByUserId(userId);
    
    // 3. 根据用户历史行为提取特征（分类、作者等）
    Set<String> categories = new HashSet<>();
    Set<String> authors = new HashSet<>();
    
    borrowHistory.forEach(borrow -> {
        Book book = bookMapper.getBookById(borrow.getBookId());
        categories.add(book.getCategory());
        authors.add(book.getAuthor());
    });
    
    favorites.forEach(book -> {
        categories.add(book.getCategory());
        authors.add(book.getAuthor());
    });
    
    // 4. 基于特征推荐相似图书
    return bookMapper.getRecommendedBooks(categories, authors);
}
}




