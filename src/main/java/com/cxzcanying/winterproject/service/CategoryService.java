package com.cxzcanying.winterproject.service;

import com.cxzcanying.winterproject.entity.Book;
import com.cxzcanying.winterproject.entity.Category;

import java.util.List;

/**
 * @author 21311
 */
public interface CategoryService {
    /**
     * 添加分类
     * @param category
     */
    void addCategory(Category category);

    /**
     * 获取全部分类
     * @return
     */
    List<Category> getAllCategory();

    /**
     * 获取指定id分类
     * @param id
     * @return
     */
    Category getCategoryById(Integer id);

    /**
     * 更新指定id分类信息
     * @param category
     */
    void updateCategoryById(Category category);

    /**
     * 删除指定id分类
     * @param id
     */
    void deleteCategoryById(Integer id);


}
