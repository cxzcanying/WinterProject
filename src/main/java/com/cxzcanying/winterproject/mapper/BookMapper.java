package com.cxzcanying.winterproject.mapper;

import com.cxzcanying.winterproject.entity.Book;
import jakarta.validation.constraints.Pattern;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;
import java.util.Set;

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
     * @param offset
     * @param limit
     * @return List<Book>
     */
    List<Book> getAllBooks(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 根据ID获取图书信息
     * @param id
     * @return Book
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

    /**
     * 图书搜索与过滤
     *
     * @param title
     * @param author
     * @param isbn
     * @param publishedDateStart
     * @param publishedDateEnd
     * @param priceMin
     * @param priceMax
     * @param category
     * @return List<Book>
     */
    List<Book> searchBook(@Param("title") String title,
                          @Param("author") String author,
                          @Param("isbn") String isbn,
                          @Param("publishedDateStart") String publishedDateStart,
                          @Param("publishedDateEnd") String publishedDateEnd,
                          @Param("priceMin") Integer priceMin,
                          @Param("priceMax") Integer priceMax,
                          @Param("category") String category);

    /**
     * 获取指定分类图书
     * @param categoryId
     * @param offset
     * @param limit
     * @return List<Book>
     */
    List<Book> getBooksByCategoryId(@Param("categoryId") int categoryId,
                                    @Param("offset") int offset,
                                    @Param("limit") int limit);

    /**
     * 统计指定作者的图书数量
     * @param author
     * @return Integer
     */
    Integer countBooksByAuthor(String author);

    /**
     * 统计指定出版年份的图书数量
     * @param publishedYear
     * @return Integer
     */
    Integer countBooksByPublishedYear(String publishedYear);

    /**
     * 统计指定分类的图书数量
     * @param category
     * @return Integer
     */
    Integer countBooksByCategory(String category);

    /**
     * 获取推荐图书
     * @param categories
     * @param authors
     * @return List<Book>
     */
    List<Book> getRecommendedBooks(Set<String> categories, Set<String> authors);

    /**
     * 高级搜素图书
     * @param title
     * @param author
     * @param isbn
     * @param publishedYear
     * @param priceMin
     * @param priceMax
     * @param category
     * @return List<Book>
     */
    List<Book> advancedSearchBook(String title, String author, String isbn, String publishedYear, Integer priceMin, Integer priceMax, String category);

    /**
     * 测试ISBN是否重复
     * @param isbn
     * @return Book
     */
    Book getBookByIsbn(@Pattern(regexp = "^[0-9]{13}$", message = "ISBN 格式不正确") String isbn);
}
