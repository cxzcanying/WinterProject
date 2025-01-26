package com.cxzcanying.winterproject.repository;

import com.cxzcanying.winterproject.entity.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author 21311
 */
public interface BookRepository extends ElasticsearchRepository<Book, String> {
    List<Book> findByTitleContaining(String title);
    List<Book> findByAuthor(String author);
} 