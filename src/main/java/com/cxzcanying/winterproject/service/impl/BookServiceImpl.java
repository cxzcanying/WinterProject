package com.cxzcanying.winterproject.service.impl;

import com.cxzcanying.winterproject.entity.Book;
import com.cxzcanying.winterproject.entity.BookSearchRequest;
import com.cxzcanying.winterproject.entity.Borrow;
import com.cxzcanying.winterproject.exception.DuplicateISBNException;
import com.cxzcanying.winterproject.mapper.BookMapper;
import com.cxzcanying.winterproject.mapper.BorrowMapper;
import com.cxzcanying.winterproject.mapper.FavoriteMapper;
import com.cxzcanying.winterproject.service.BookService;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;


/**
 * @author 21311
 */
@Slf4j
@Service
public class BookServiceImpl implements BookService {
    //每一行都要注解

    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private BorrowMapper borrowMapper;
    @Autowired
    private FavoriteMapper favoriteMapper;

    @Override
    public void addBook(Book book) {
        Book bookCheck = bookMapper.getBookByIsbn(book.getIsbn());
        if(bookCheck != null){
            throw  new DuplicateISBNException(400,"ISBN已存在");
        }
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
    public List<Book> searchBook(@NotNull BookSearchRequest bookSearchRequest) {
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
        //基于用户借阅历史和收藏历史推荐
        List<Borrow> borrowHistory = borrowMapper.getBorrowHistory(userId);
        List<Book> favorites = favoriteMapper.getFavoritesByUserId(userId);

        //提取特征（分类、作者），与顺序无关，用Set集合表达键值对
        Set<String> categories = new HashSet<>();
        Set<String> authors = new HashSet<>();

        //用lambda表达式和foreach遍历set集合并把借阅历史和收藏历史的内容转移到特征集合中
        //borrow在遍历过程中被赋值，即每一次遍历得到的记录，从记录里面取到类别和作者
        borrowHistory.forEach(borrow -> {
            Book book = bookMapper.getBookById(borrow.getBookId());
            categories.add(book.getCategory());
            authors.add(book.getAuthor());
        });

        //在 favorites 集合中，每个元素本身就是 Book 对象，而不是 Borrow 对象
        //因此，不需要通过书籍 ID 查询书籍对象，可以直接从 Book 对象中获取类别和作者信息
        favorites.forEach(book -> {
            categories.add(book.getCategory());
            authors.add(book.getAuthor());
        });
        return bookMapper.getRecommendedBooks(categories, authors);
    }

    @Override
    public List<Book> advancedSearchBook(@NotNull BookSearchRequest bookSearchRequest) {
        return bookMapper.advancedSearchBook(bookSearchRequest.getTitle(),
                bookSearchRequest.getAuthor(),
                bookSearchRequest.getIsbn(),
                bookSearchRequest.getPublishedYear(),
                bookSearchRequest.getPriceMin(),
                bookSearchRequest.getPriceMax(),
                bookSearchRequest.getCategory());
    }
}




