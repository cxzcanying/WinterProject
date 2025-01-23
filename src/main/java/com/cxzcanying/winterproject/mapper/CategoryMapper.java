package com.cxzcanying.winterproject.mapper;

import com.cxzcanying.winterproject.entity.Book;
import com.cxzcanying.winterproject.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 21311
 */
@Mapper
public interface CategoryMapper {
    void addByName(Category category);

    List<Category> getAllCategory();

    Category getCategoryById(Integer id);

    void updateCategoryById(Category category);

    List<Book> getBooksByCategoryId(@Param("categoryId") int categoryId);

    void deleteCategoryById(Integer id);
}
