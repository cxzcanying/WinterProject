# 蓝山工作室寒假考核之图书管理系统

## 项目简介
这是一个基于 `Spring Boot + MyBatis + MySQL` 的图书管理系统，拥有用户认证与授权、图书管理（增删改查、分页排序、搜索过滤、分类统计、高级搜索与智能推荐等）、异常处理、数据验证等功能。系统设计简洁高效，适合小型图书馆或个人图书管理。

## 项目架构
````
WinterProject
├── src/main/java/com/cxzcanying/winterproject
│   ├── controller         # 控制器层，处理 HTTP 请求
│   ├── service            # 服务层，业务逻辑处理
│   ├── mapper             # MyBatis 映射层
│   ├── model              # 数据模型
│   ├── config             # 配置类
│   └── filter             # 过滤器
├── src/main/resources     # 配置文件
│   ├── application.yml    # Spring Boot 配置文件
│   ├── mybatis-config.xml # MyBatis 配置文件
│   └── mapper             # MyBatis 映射文件
├── src/test               # 测试代码
└── pom.xml                # Maven 配置文件
````

## 技术栈
- **后端框架**：Spring Boot, MyBatis
- **数据库**：MySQL, Druid
- **缓存**：Redis
- **认证与授权**：JWT, Spring Security
- **日志**：Logback, Spring Boot Logging
- **AOP**：Spring AOP
- **定时任务**：Quartz
- **JSON 处理**：FastJSON
- **单元测试**：JUnit, TestNG
- **参数验证**：Spring Boot Validation
- **分页**：PageHelper
- **其他工具**：Lombok, JAXB, Spring Boot Actuator

## 项目功能

### 基础功能

#### 用户认证与授权
- 实现基本的身份验证机制，确保只有授权用户才能访问 API 端点。
- 实现角色管理，区分不同权限的用户（如管理员和普通用户）。

#### 图书管理
- **添加图书**：`POST /api/books`
- **获取所有图书**：`GET /api/books`
- **获取单本图书**：`GET /api/books/{id}`
- **更新图书**：`PUT /api/books/{id}`
- **删除图书**：`DELETE /api/books/{id}`
- **分页与排序**：`GET /api/books?page=1&size=10&sort=title,asc`
- **图书搜索与过滤**：`GET /api/books/search?title=Java&author=AuthorName`
- **图书分类管理**：
    - `POST /api/categories`
    - `GET /api/categories`
    - `GET /api/categories/{id}`
    - `PUT /api/categories/{id}`
    - `DELETE /api/categories/{id}`
    - `GET /api/books?categoryId=1`
- **图书统计**：提供按分类统计图书数量、按出版年份统计图书数量等。

### 加分项

#### 用户密码加盐加密
- 使用 Spring Security 的 `BCryptPasswordEncoder` 对用户密码进行加密。

#### Redis 缓存
- 使用 Redis 缓存图书信息和个人资料，提高系统性能。

#### AOP：操作日志写入与获取（管理员）
- 使用 Spring AOP 记录管理员的操作日志，并提供获取日志的功能。

#### 添加 ApiFox API 文档
- 使用 ApiFox 创建详细的 API 文档，方便开发和测试。

#### 实现文件上传功能（如用户头像）
- 支持用户上传头像，并存储在服务器或云存储中。

#### 添加拦截器
- 添加自定义拦截器，用于身份验证和权限控制。

#### 添加定时任务（如定期清理过期缓存）
- 使用 Spring Task 实现定时任务，定期清理 Redis 中的过期缓存。

#### 实现 JWT 认证
- 使用 JWT 实现无状态的认证机制。

#### 添加数据库连接池 Druid 配置用来防御 SQL 注入
- 配置 Druid 数据库连接池，并使用其防 SQL 注入功能。

#### 添加 XSS 防护
- 使用自定义过滤器防止 XSS 攻击。

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
- **上传头像**：`POST /api/users/{userId}/update/upload`

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
