package com.cxzcanying.winterproject.service.impl;

import com.cxzcanying.winterproject.entity.Book;
import com.cxzcanying.winterproject.mapper.BookMapper;
import com.cxzcanying.winterproject.service.BookService;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 21311
 */
@Slf4j
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

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

        // 如果需要排序
        if (sortField != null && sortOrder != null) {
            PageHelper.orderBy(sortField + " " + sortOrder);
        }

        // 查询所有图书
        return bookMapper.getAllBooks();
    }
}



