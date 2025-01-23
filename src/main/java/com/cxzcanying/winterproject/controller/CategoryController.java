package com.cxzcanying.winterproject.controller;

import com.cxzcanying.winterproject.entity.Book;
import com.cxzcanying.winterproject.entity.Category;
import com.cxzcanying.winterproject.pojo.Result;
import com.cxzcanying.winterproject.service.CategoryService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author 21311
 */
@Slf4j
@RestController
@RequestMapping("/api/categories")
@Validated
public class CategoryController{
    @Autowired
    private CategoryService categoryService;


    @PostMapping
    public Result<Category> addCategory(@Valid @RequestBody Category category){
        log.info("创建新分类:{}",category);
        categoryService.addCategory(category);
        return Result.success(category);
    }
    @GetMapping
    public Result<List<Category>> getAllCategory(){
        log.info("获取全部分类信息");
        List<Category> categoryList=categoryService.getAllCategory();
        return Result.success(categoryList);
    }
    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Integer id){
        log.info("获取指定分类id为{}的信息",id);
        Category category=categoryService.getCategoryById(id);
        return Result.success(category).getData();
    }
    @PutMapping("/{id}")
    public Result<Category> updateCategoryById(@PathVariable Integer id,@RequestBody Category category){
        log.info("更新id为{}分类的信息",id);
        category.setId(id);
        categoryService.updateCategoryById(category);
        return Result.success(category);
    }
    @DeleteMapping("/{id}")
    public Result<Category> deleteCategoryById(@PathVariable Integer id){
        log.info("删除id为{}的分类",id);
        Category category = categoryService.getCategoryById(id);
        if (category == null) {
            return Result.fail("Category not found");
        }
        categoryService.deleteCategoryById(id);
        return Result.success(category);
    }
    @GetMapping("./books")
    public Result<List<Book>> getBookByCategory(@RequestParam(value = "categoryId",defaultValue = "")Integer id){
        log.info("获取分类id为{}的图书",id);
        List<Book> bookList=categoryService.getBooksByCategoryId(id);
        return Result.success(bookList);
    }
}
