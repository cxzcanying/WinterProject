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
    /**
     * 添加分类
     * @param category
     */
    void addByName(Category category);

    /**
     * 获取全部分类
     * @return List<Category>
     */
    List<Category> getAllCategory();

    /**
     * 获取指定ID的分类
     * @param id
     * @return Category
     */
    Category getCategoryById(Integer id);

    /**
     * 更新指定ID的分类
     * @param category
     */
    void updateCategoryById(Category category);

    /**
     * 删除分类
     * @param id
     */
    void deleteCategoryById(Integer id);
}
