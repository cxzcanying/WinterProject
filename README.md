# 蓝山工作室寒假考核之图书管理系统

## 项目简介
这是一个基于 `Spring Boot + MyBatis + MySQL` 的图书管理系统，拥有用户认证与授权、图书管理（增删改查、分页排序、搜索过滤、分类统计、高级搜索与智能推荐等）、异常处理、数据验证等功能。系统设计简洁高效，适合小型图书馆或个人图书管理。

## 项目架构
````
WinterProject
├── src/main/java/com/cxzcanying/winterproject
│   ├── annotation                               # 自定义注解
│   ├── aop                                      # 切面类
│   ├── controller                               # 控制器层，处理 HTTP 请求
│   ├── service                                  # 服务层，业务逻辑处理
│       └── impl                                 # 服务层实现类
│   ├── mapper                                   # MyBatis 映射层
│   ├── entity                                   # 实体类
│   ├── exception                                # 自定义异常类
│   ├── pojo                                     # 通用Java类
│   ├── scheduler                                # 日程类
│   ├── config                                   # 配置类
│   └── filter                                   # 过滤器
├── src/main/resources                           # 配置文件
│   ├── application.yml                          # Spring Boot 配置文件
│   ├── sql                                      # Sql语句
│   └── com/cxzcanying/winterproject/mapper      # MyBatis 映射文件
├── src/test                                     # 测试代码
├── docker-compose.yml                           # Docker-Compose配置文件
├── README.md                                    # 项目介绍
├── API文档.md                                    # API规范文档
└── pom.xml                                      # Maven 配置文件
````

## 技术栈
- **后端框架**：Spring Boot, MyBatis
- **数据库**：MySQL
- **缓存**：Redis
- **认证与授权**：JWT, Spring Security
- **日志**：Logback, Spring Boot Logging
- **AOP**：Spring AOP
- **定时任务**：Quartz
- **单元测试**：JUnit
- **参数验证**：Spring Boot Validation
- **分页**：PageHelper
- **其他工具**：Lombok,Aliyun OSS Utils
- **容器化工具**：Docker

## 项目功能

### 用户认证与授权
- 实现基本的身份验证机制，确保只有授权用户才能访问 API 端点。
- 未登录用户仅能访问注册和登录接口，已登录用户能访问部分CRUD接口，管理员仅能访问图书，分类，用户
- 实现角色管理，区分不同权限的用户（如管理员和普通用户）。

### 图书管理
- **添加图书**：管理员通过 `POST /api/books` 添加新图书，需验证参数合法性（如标题、作者必填）。
- **获取所有图书**：通过 `GET /api/books` 获取所有图书列表，支持基础分页和排序。
- **获取单本图书**：通过 `GET /api/books/{id}` 根据图书ID查询详细信息。
- **更新图书**：管理员通过 `PUT /api/books/{id}` 修改图书信息（如标题、分类）。
- **删除图书**：管理员通过 `DELETE /api/books/{id}` 删除指定图书。
- **分页与排序**：通过 `GET /api/books?page=1&size=10&sort=title,asc` 实现分页查询与排序。
- **图书搜索与过滤**：通过 `GET /api/books/search?title=Java&author=Author` 支持多条件组合查询。

### 图书分类管理
- **创建分类**：管理员通过 `POST /api/categories` 添加新分类（如“编程”、“文学”）。
- **获取所有分类**：通过 `GET /api/categories` 获取全部分类列表。
- **获取指定分类**：通过 `GET /api/categories/{id}` 查询分类详情。
- **更新分类**：管理员通过 `PUT /api/categories/{id}` 修改分类名称。
- **删除分类**：管理员通过 `DELETE /api/categories/{id}` 删除空分类（需校验是否关联图书）。
- **根据分类获取图书**：通过 `GET /api/books?categoryId=1` 筛选特定分类下的图书。
- **图书统计**：提供分类、年份、作者维度的统计接口（如 `GET /api/stats/by-category`）。

### 图书统计
- **按分类统计图书数量**：返回各分类的图书总数，用于可视化展示。
- **按出版年份统计图书数量**：统计每年出版的图书数量。
- **按作者统计图书数量**：统计每位作者的著作数量，支持分页。

### 高级搜索与智能推荐
- **高级搜索**：支持多字段组合查询（如书名+作者+出版年份范围）。
- **智能推荐**：基于用户浏览/借阅历史，推荐相似图书。

### 图书收藏与书签功能
- **添加收藏**：用户通过 `POST /api/favorites` 收藏图书，避免重复添加。
- **获取收藏列表**：通过 `GET /api/favorites` 获取当前用户的收藏图书。
- **删除收藏**：通过 `DELETE /api/favorites/{bookId}` 移除指定收藏。

### 图书评论与评分
- **添加评论**：用户通过 `POST /api/comments` 对图书发表评论（含评分1-5星）。
- **获取评论列表**：通过 `GET /api/comments?bookId=1` 分页获取某图书的评论。
- **回复评论**：用户或管理员通过 `POST /api/comments/{parentId}/reply` 回复评论。
- **删除评论**：用户可删除自己的评论，管理员可删除任意评论。

### 图书标签与分类管理
- **添加标签**：管理员通过 `POST /api/tags` 为图书定义标签（如“畅销”、“经典”）。
- **获取标签列表**：通过 `GET /api/tags` 获取所有标签。
- **根据标签获取图书列表**：通过 `GET /api/books?tag=经典` 筛选标签关联的图书。
- **删除标签**：管理员通过 `DELETE /api/tags/{id}` 删除未使用的标签。

### 用户个人资料与社交功能
- **获取用户个人资料**：通过 `GET /api/users/{userId}/profile` 查看公开资料。
- **关注用户**：通过 `POST /api/follow/{targetUserId}` 关注其他用户。
- **取消关注用户**：通过 `DELETE /api/follow/{targetUserId}` 取消关注。
- **获取关注者列表**：通过 `GET /api/users/{userId}/followers` 查看粉丝列表。
- **获取关注的用户列表**：通过 `GET /api/users/{userId}/following` 查看关注列表。

### 图书借阅与归还功能
- **借阅图书**：用户通过 `POST /api/borrow/{bookId}` 借阅图书，校验库存余量。
- **归还图书**：通过 `POST /api/return/{bookId}` 归还图书，更新库存状态。
- **查看借阅历史**：通过 `GET /api/users/{userId}/borrow-history` 分页查询借阅记录。

### 文件上传
- **上传头像**：用户通过 `POST /api/users/avatar` 上传头像图片（限制格式为JPG/PNG）。

### 用户密码加盐加密
- 使用 Spring Security 的 `BCryptPasswordEncoder` 对用户密码进行加密。

### Redis 缓存
- 使用 Redis 缓存图书信息和个人资料，提高系统性能。

### AOP：操作日志写入与获取（管理员）
- 使用 Spring AOP 记录管理员的操作日志，并提供获取日志的功能。

### 添加 ApiFox API 文档
- 使用 ApiFox 创建详细的 API 文档，方便开发和测试。

### 实现文件上传功能（如用户头像）
- 支持用户上传头像，并存储在云存储中。

### 添加拦截器
- 添加自定义拦截器，用于身份验证和权限控制。

### 添加定时任务（如定期清理过期缓存）
- 使用 Spring Task 实现定时任务，定期清理 Redis 中的过期缓存。

### 实现 JWT 认证
- 使用 JWT 实现无状态的认证机制。

### 添加 XSS 防护
- 使用自定义过滤器防止 XSS 攻击。

## 快速启动
在项目根目录运行`mvn package`

调整docker-compose.yml参数后运行`docker-compose up`

本项目基于JDK18开发

## API 接口介绍

### 用户认证与授权
- **用户注册**：`POST /api/users/register`
- **用户登录**：`POST /api/users/login`
- **获取用户信息**：`GET /api/users/{userId}/profile`
- **更新用户资料**：`PUT /api/users/{userId}/update`


### 图书管理
- **添加图书**：`POST /api/books`
- **获取所有图书**：`GET /api/books`
- **获取单本图书**：`GET /api/books/{id}`
- **更新图书**：`PUT /api/books/{id}`
- **删除图书**：`DELETE /api/books/{id}`
- **分页与排序**：`GET /api/books?page=1&size=10&sort=title,asc`
- **图书搜索与过滤**：`GET /api/books/search?title=Java&author=AuthorName`

### 图书分类管理
- **创建分类**：`POST /api/categories`
- **获取所有分类**：`GET /api/categories`
- **获取指定分类**：`GET /api/categories/{id}`
- **更新分类**：`PUT /api/categories/{id}`
- **删除分类**：`DELETE /api/categories/{id}`
- **根据分类获取图书**：`GET /api/books?categoryId=1`

### 图书统计
- **按分类统计图书数量**：`GET /api/books/stats/category`
- **按出版年份统计图书数量**：`GET /api/books/stats/year`
- **按作者统计图书数量**：`GET /api/books/stats/author/{author}`

### 高级搜索与智能推荐
- **高级搜索**：`GET /api/books/advanced-search?title=Java&author=AuthorName`
- **智能推荐**：`GET /api/books/recommendations?userId=123`

### 图书收藏与书签功能
- **添加收藏**：`POST /api/users/{userId}/favorites`
- **获取收藏列表**：`GET /api/users/{userId}/favorites`
- **删除收藏**：`DELETE /api/users/{userId}/favorites/{bookId}`

### 图书评论与评分
- **添加评论**：`POST /api/books/{bookId}/reviews`
- **获取评论列表**：`GET /api/books/{bookId}/reviews`
- **回复评论**：`POST /api/books/{bookId}/reviews/{reviewId}/replies`
- **删除评论**：`DELETE /api/books/{bookId}/reviews/{reviewId}`

### 图书标签与分类管理
- **添加标签**：`POST /api/books/{bookId}/tags`
- **获取标签列表**：`GET /api/books/{bookId}/tags`
- **根据标签获取图书列表**：`GET /api/tags/{tagId}/books`
- **删除标签**：`DELETE /api/books/{bookId}/tags/{tagId}`

### 用户个人资料与社交功能
- **获取用户个人资料**：`GET /api/users/{userId}/profile`
- **关注用户**：`POST /api/users/{userId}/follow`
- **取消关注用户**：`DELETE /api/users/{userId}/unfollow/{followingId}`
- **获取关注者列表**：`GET /api/users/{userId}/followers`
- **获取关注的用户列表**：`GET /api/users/{userId}/following`

### 图书借阅与归还功能
- **借阅图书**：`POST /api/books/{bookId}/borrow`
- **归还图书**：`POST /api/books/{bookId}/return`
- **查看借阅历史**：`GET /api/users/{userId}/borrow-history`

### 文件上传
- **上传头像**：`POST /api/users/{userId}/avatar`

### 查看日志
- **获取全部日志**`GET /api/books/logs`

## 异常处理
- **资源未找到**：返回 `404 Not Found`
- **重复 ISBN**：返回 `400 Bad Request`
- **数据验证失败**：返回 `400 Bad Request`，并提供详细的错误信息

## 数据验证
- **书名和作者不能为空**
- **ISBN 格式正确且唯一**
- **出版日期和价格格式正确**

## 项目作者
- **开发者**：21311
- **博客**：[https://cxzcanying.github.io/](https://cxzcanying.github.io/)
- **GitHub**：[https://github.com/gsjbbd](https://github.com/gsjbbd)

## 支持
如果这个项目帮助了你，请给我们一个 ⭐️！
