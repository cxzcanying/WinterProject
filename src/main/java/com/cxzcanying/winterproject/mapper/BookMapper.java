package com.cxzcanying.winterproject.mapper;

import com.cxzcanying.winterproject.entity.Book;
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
     *
     * @return
     */
    List<Book> getAllBooks(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 根据ID获取图书信息
     *
     * @param id
     * @return
     */
    Book getBookById(Integer id);

    /**
     * 根据ID更新图书信息
     *
     * @param book
     */
    void updateBookById(Book book);

    /**
     * 根据ID删除图书
     *
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
     * @return
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
     * @return
     */

    List<Book> getBooksByCategoryId(@Param("categoryId") int categoryId,
                                    @Param("offset") int offset,
                                    @Param("limit") int limit);

    Integer countBooksByAuthor(String author);

    Integer countBooksByPublishedYear(String publishedYear);

    Integer countBooksByCategory(String category);

    List<Book> getRecommendedBooks(Set<String> categories, Set<String> authors);


}
