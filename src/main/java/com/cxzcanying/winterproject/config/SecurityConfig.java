package com.cxzcanying.winterproject.config;

import com.cxzcanying.winterproject.filter.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

/**
 * @author 21311
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
@Autowired
private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authorizeHttpRequests(auth -> auth
                        // 允许匿名访问的接口
                        .requestMatchers("/api/users/register", "/api/users/login").permitAll()

                        // USER 角色可以访问的接口
                        .requestMatchers(HttpMethod.GET,
                                "/api/users/{userId}/profile", // 获取用户个人资料
                                "/api/users/{userId}/favorites", // 获取收藏列表
                                "/api/users/{userId}/followers", // 获取关注者列表
                                "/api/users/{userId}/following", // 获取关注的用户列表
                                "/api/users/{userId}/borrow-history", // 查看借阅历史
                                "/api/tags/{tagId}/books", //查看标签下属图书
                                "/api/books/{bookId}/tags", //查看图书拥有的所有标签
                                "/api/books",//分页查询全部图书
                                "/api/books/{id}", //查询图书详情
                                "/api/books/search", //搜索筛选图书
                                "/api/books/recommendations", //获取推荐图书
                                "/api/books/advanced-search", //高级搜索
                                "/api/books/{bookId}/reviews", //查看图书评论评分
                                "/api/categories", //查询全部分类
                                "/api/categories/{id}" //查询分类详情
                        ).hasAnyRole("USER","ADMIN")
                        .requestMatchers(HttpMethod.PUT,
                                "/api/users/{userId}/update", // 更新用户资料 (自己的)
                                "/api/books/{bookId}/return"  // 归还图书
                        ).hasAnyRole("USER","ADMIN")
                        .requestMatchers(HttpMethod.POST,
                                "/api/users/{userId}/favorites", // 添加收藏
                                "/api/books/{bookId}/reviews", // 添加评论
                                "/api/books/{bookId}/reviews/{reviewId}/replies", // 回复评论
                                "/api/users/{userId}/follow", // 关注用户
                                "/api/books/{bookId}/borrow", // 借阅图书
                                "/api/users/{userId}/avatar",   // 上传头像
                                "/api/books/{bookId}/tags", //添加标签
                                "/api/books/{bookId}/return" //归还图书
                        ).hasAnyRole("USER","ADMIN")
                        .requestMatchers(HttpMethod.DELETE,
                                "/api/users/{userId}/favorites/{bookId}", // 删除收藏
                                "/api/users/{userId}/unfollow/{followingId}", // 取消关注用户
                                "/api/books/{bookId}/reviews/{reviewId}" // 删除评论
                        ).hasAnyRole("USER","ADMIN")
                        .requestMatchers(HttpMethod.GET,
                                "/api/books/stats/category", // 按分类统计图书数量
                                "/api/books/stats/year",     // 按出版年份统计图书数量
                                "/api/books/stats/author/{author}" // 按作者统计图书数量
                        ).hasAnyRole("USER","ADMIN")


                        // ADMIN 角色可以访问的接口
                        .requestMatchers(HttpMethod.POST,
                                "/api/books", // 添加图书
                                "/api/categories" // 创建分类
                        ).hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT,
                                "/api/books/{id}", // 更新图书
                                "/api/categories/{id}" // 更新分类
                        ).hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE,
                                "/api/books/{id}", // 删除图书
                                "/api/categories/{id}", // 删除分类
                                "/api/books/{bookId}/tags/{tagId}" // 删除标签
                        ).hasRole("ADMIN")
                        .requestMatchers("/api/books/logs" //查询日志
                         )
                        .hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();

    }
    @Bean
    public HttpFirewall httpFirewall() {
        StrictHttpFirewall firewall = new StrictHttpFirewall();
        firewall.setAllowUrlEncodedDoubleSlash(true);
        return firewall;
    }
}