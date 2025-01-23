package com.cxzcanying.winterproject.service.impl;

import com.cxzcanying.winterproject.entity.Book;
import com.cxzcanying.winterproject.entity.Category;
import com.cxzcanying.winterproject.mapper.CategoryMapper;
import com.cxzcanying.winterproject.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 21311
 */
@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public void addCategory(Category category) {
        categoryMapper.addByName(category);
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryMapper.getAllCategory();
    }

    @Override
    public Category getCategoryById(Integer id) {
        return categoryMapper.getCategoryById(id);
    }

    @Override
    public void updateCategoryById(Category category) {
        categoryMapper.updateCategoryById(category);
    }

    @Override
    public void deleteCategoryById(Integer id) {
        categoryMapper.deleteCategoryById(id);
    }

    @Override
    public List<Book> getBooksByCategoryId(Integer categoryId) {
        return categoryMapper.getBooksByCategoryId(categoryId);
    }

}
