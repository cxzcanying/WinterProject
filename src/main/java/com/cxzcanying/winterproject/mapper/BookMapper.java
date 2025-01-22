package com.cxzcanying.winterproject.mapper;

import com.cxzcanying.winterproject.entity.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 21311
 */
@Mapper
public interface BookMapper {
    /**
     * 根据名字添加图书
     * @param book
     */
    void addByName(Book book);

    /**
     * 分页查询图书信息
     * @return
     */
    List<Book> getAllBooks();

    /**
     * 根据ID获取图书信息
     * @param id
     * @return
     */
    Book getBookById(Integer id);

    /**
     * 根据ID更新图书信息
     * @param book
     */
    void updateBookById(Book book);

    /**
     * 根据ID删除图书
     * @param id
     */
    void deleteBookById(Integer id);


}
