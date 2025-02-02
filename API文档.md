# 寒假考核之图书管理系统

# TagController

## POST addTag

POST /api/books/{bookId}/tags

> Body 请求参数

```json
{
  "id": 0,
  "name": "string",
  "userId": "string",
  "bookId": 0,
  "createTime": "string"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|bookId|path|integer| 是 |none|
|body|body|[Tag](#schematag)| 否 |none|

> 返回示例

```json
{
  "code": 0,
  "message": "",
  "data": {
    "id": 0,
    "name": "",
    "userId": "",
    "bookId": 0,
    "createTime": ""
  }
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[ResultTag](#schemaresulttag)|

## GET getBookTags

GET /api/books/{bookId}/tags

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|bookId|path|integer| 是 |none|

> 返回示例

```json
{
  "code": 0,
  "message": "",
  "data": [
    {
      "id": 0,
      "name": "",
      "userId": "",
      "bookId": 0,
      "createTime": ""
    }
  ]
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[ResultListTag](#schemaresultlisttag)|

## GET getBooksByTagId

GET /api/tags/{tagId}/books

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|tagId|path|string| 是 |none|

> 返回示例

```json
{
  "code": 0,
  "message": "",
  "data": [
    {
      "id": 0,
      "title": "",
      "isbn": "",
      "author": "",
      "publishedYear": "",
      "price": 0,
      "category": ""
    }
  ]
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[ResultListBook](#schemaresultlistbook)|

## DELETE deleteTag

DELETE /api/books/{bookId}/tags/{tagId}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|bookId|path|integer| 是 |none|
|tagId|path|integer| 是 |none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 

# BookController

## POST addBook

POST /api/books

> Body 请求参数

```json
{
  "id": 0,
  "title": "string",
  "isbn": "string",
  "author": "string",
  "publishedYear": "string",
  "price": 999999,
  "category": "string"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[Book](#schemabook)| 否 |none|

> 返回示例

```json
{
  "code": 0,
  "message": "",
  "data": {
    "id": 0,
    "title": "",
    "isbn": "",
    "author": "",
    "publishedYear": "",
    "price": 0,
    "category": ""
  }
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[ResultBook](#schemaresultbook)|

## GET getAllBooks

GET /api/books

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|page|query|integer| 是 |none|
|size|query|integer| 是 |none|
|sort|query|string| 是 |none|
|categoryId|query|integer| 否 |none|

> 返回示例

```json
{
  "code": 0,
  "message": "",
  "data": [
    {
      "id": 0,
      "title": "",
      "isbn": "",
      "author": "",
      "publishedYear": "",
      "price": 0,
      "category": ""
    }
  ]
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[ResultListBook](#schemaresultlistbook)|

## GET getBookById

GET /api/books/{id}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|path|integer| 是 |none|

> 返回示例

```json
{
  "id": 0,
  "title": "",
  "isbn": "",
  "author": "",
  "publishedYear": "",
  "price": 0,
  "category": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[Book](#schemabook)|

## PUT updateBookById

PUT /api/books/{id}

> Body 请求参数

```json
{
  "id": 0,
  "title": "string",
  "isbn": "string",
  "author": "string",
  "publishedYear": "string",
  "price": 999999,
  "category": "string"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|path|integer| 是 |none|
|body|body|[Book](#schemabook)| 否 |none|

> 返回示例

```json
{
  "code": 0,
  "message": "",
  "data": {
    "id": 0,
    "title": "",
    "isbn": "",
    "author": "",
    "publishedYear": "",
    "price": 0,
    "category": ""
  }
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[ResultBook](#schemaresultbook)|

## DELETE deleteBookById

DELETE /api/books/{id}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|path|integer| 是 |none|

> 返回示例

```json
{
  "code": 0,
  "message": "",
  "data": {
    "id": 0,
    "title": "",
    "isbn": "",
    "author": "",
    "publishedYear": "",
    "price": 0,
    "category": ""
  }
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[ResultBook](#schemaresultbook)|

## GET searchBook

GET /api/books/search

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|title|query|string| 是 |none|
|author|query|string| 是 |none|
|isbn|query|string| 是 |none|
|publishedDateStart|query|string| 是 |none|
|publishedDateEnd|query|string| 是 |none|
|priceMin|query|integer| 是 |none|
|priceMax|query|integer| 是 |none|
|category|query|string| 是 |none|

> 返回示例

```json
{
  "code": 0,
  "message": "",
  "data": [
    {
      "id": 0,
      "title": "",
      "isbn": "",
      "author": "",
      "publishedYear": "",
      "price": 0,
      "category": ""
    }
  ]
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[ResultListBook](#schemaresultlistbook)|

## GET countBooksByCategory

GET /api/books/stats/category/{category}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|category|path|string| 是 |none|

> 返回示例

```json
{
  "code": 0,
  "message": "",
  "data": 0
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[ResultInteger](#schemaresultinteger)|

## GET countBooksByPublishedYear

GET /api/books/stats/publishedYear/{publishedYear}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|publishedYear|path|string| 是 |none|

> 返回示例

```json
{
  "code": 0,
  "message": "",
  "data": 0
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[ResultInteger](#schemaresultinteger)|

## GET countBooksByAuthor

GET /api/books/stats/author/{author}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|author|path|string| 是 |none|

> 返回示例

```json
{
  "code": 0,
  "message": "",
  "data": 0
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[ResultInteger](#schemaresultinteger)|

## GET getRecommendations

GET /api/books/recommendations

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|userId|query|string| 是 |none|

> 返回示例

```json
{
  "code": 0,
  "message": "",
  "data": [
    {
      "id": 0,
      "title": "",
      "isbn": "",
      "author": "",
      "publishedYear": "",
      "price": 0,
      "category": ""
    }
  ]
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[ResultListBook](#schemaresultlistbook)|

## GET advancedSearchBook

GET /api/books/advanced-search

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|title|query|string| 是 |none|
|author|query|string| 是 |none|
|isbn|query|string| 是 |none|
|publishedYear|query|string| 是 |none|
|priceMin|query|integer| 是 |none|
|priceMax|query|integer| 是 |none|
|category|query|string| 是 |none|

> 返回示例

```json
{
  "code": 0,
  "message": "",
  "data": [
    {
      "id": 0,
      "title": "",
      "isbn": "",
      "author": "",
      "publishedYear": "",
      "price": 0,
      "category": ""
    }
  ]
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[ResultListBook](#schemaresultlistbook)|

# UserController

## POST registerUser

POST /api/users/register

> Body 请求参数

```json
{
  "userId": 0,
  "userName": "string",
  "password": "string",
  "sex": "string",
  "birthDate": "string",
  "avatarUrl": "string",
  "isAdmin": true
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[User](#schemauser)| 否 |none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 

## GET getProfileById

GET /api/users/{userId}/profile

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|userId|path|string| 是 |none|

> 返回示例

```json
{
  "code": 0,
  "message": "",
  "data": {
    "userId": 0,
    "userName": "",
    "password": "",
    "sex": "",
    "birthDate": "",
    "avatarUrl": "",
    "isAdmin": false
  }
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[ResultUser](#schemaresultuser)|

## PUT updateProfile

PUT /api/users/{userId}/update

> Body 请求参数

```json
{
  "userId": 0,
  "userName": "string",
  "password": "string",
  "sex": "string",
  "birthDate": "string",
  "avatarUrl": "string",
  "isAdmin": true
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|userId|path|string| 是 |none|
|body|body|[User](#schemauser)| 否 |none|

> 返回示例

```json
{
  "code": 0,
  "message": "",
  "data": {
    "userId": 0,
    "userName": "",
    "password": "",
    "sex": "",
    "birthDate": "",
    "avatarUrl": "",
    "isAdmin": false
  }
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[ResultUser](#schemaresultuser)|

## POST login

POST /api/users/login

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|userName|query|string| 是 |none|
|password|query|string| 是 |none|

> 返回示例

```json
{
  "code": 0,
  "message": "",
  "data": {
    "userId": 0,
    "userName": "",
    "password": "",
    "sex": "",
    "birthDate": "",
    "avatarUrl": "",
    "isAdmin": false
  }
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[ResultUser](#schemaresultuser)|

# BorrowController

## POST borrowBook

POST /api/books/{bookId}/borrow

> Body 请求参数

```json
{
  "id": 0,
  "userId": "string",
  "bookId": 0,
  "borrowTime": "string",
  "dueTime": "string",
  "returnTime": "string",
  "status": "string"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|bookId|path|integer| 是 |none|
|body|body|[Borrow](#schemaborrow)| 否 |none|

> 返回示例

```json
{
  "code": 0,
  "message": "",
  "data": {
    "id": 0,
    "userId": "",
    "bookId": 0,
    "borrowTime": "",
    "dueTime": "",
    "returnTime": "",
    "status": ""
  }
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[ResultBorrow](#schemaresultborrow)|

## POST returnBook

POST /api/books/{bookId}/return

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|bookId|path|integer| 是 |none|

> 返回示例

```json
{
  "code": 0,
  "message": "",
  "data": {
    "id": 0,
    "userId": "",
    "bookId": 0,
    "borrowTime": "",
    "dueTime": "",
    "returnTime": "",
    "status": ""
  }
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[ResultBorrow](#schemaresultborrow)|

## GET getBorrowHistory

GET /api/users/{userId}/borrow-history

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|userId|path|string| 是 |none|

> 返回示例

```json
{
  "code": 0,
  "message": "",
  "data": [
    {
      "id": 0,
      "userId": "",
      "bookId": 0,
      "borrowTime": "",
      "dueTime": "",
      "returnTime": "",
      "status": ""
    }
  ]
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[ResultListBorrow](#schemaresultlistborrow)|

# FollowController

## POST followUser

POST /api/users/{userId}/follow

> Body 请求参数

```json
{
  "followerId": 0,
  "followingId": 0,
  "followTime": "string"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|userId|path|string| 是 |none|
|body|body|[Follow](#schemafollow)| 否 |none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 

## DELETE unfollowUser

DELETE /api/users/{userId}/unfollow/{followingId}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|followingId|path|string| 是 |none|
|userId|path|string| 是 |none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 

## GET getFollowersById

GET /api/users/{userId}/followers

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|userId|path|string| 是 |none|

> 返回示例

```json
{
  "code": 0,
  "message": "",
  "data": [
    ""
  ]
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[ResultListString](#schemaresultliststring)|

## GET getFollowingById

GET /api/users/{userId}/following

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|userId|path|string| 是 |none|

> 返回示例

```json
{
  "code": 0,
  "message": "",
  "data": [
    ""
  ]
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[ResultListString](#schemaresultliststring)|

# ReviewController

## POST addReview

POST /api/books/{bookId}/reviews

> Body 请求参数

```json
{
  "id": 0,
  "bookId": 0,
  "userId": 0,
  "content": "string",
  "rating": 1,
  "createTime": "string",
  "parentId": 0,
  "replies": [
    {
      "id": 0,
      "bookId": 0,
      "userId": 0,
      "content": "string",
      "rating": 1,
      "createTime": "string",
      "parentId": 0,
      "replies": [
        {
          "id": 0,
          "bookId": 0,
          "userId": 0,
          "content": "string",
          "rating": 1,
          "createTime": "string",
          "parentId": 0,
          "replies": [
            {}
          ]
        }
      ]
    }
  ]
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|bookId|path|integer| 是 |none|
|body|body|[Review](#schemareview)| 否 |none|

> 返回示例

```json
{
  "code": 0,
  "message": "",
  "data": {
    "id": 0,
    "bookId": 0,
    "userId": 0,
    "content": "",
    "rating": 0,
    "createTime": "",
    "parentId": 0,
    "replies": [
      {
        "id": 0,
        "bookId": 0,
        "userId": 0,
        "content": "",
        "rating": 0,
        "createTime": "",
        "parentId": 0,
        "replies": [
          {}
        ]
      }
    ]
  }
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[ResultReview](#schemaresultreview)|

## GET getBookReviews

GET /api/books/{bookId}/reviews

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|bookId|path|integer| 是 |none|

> 返回示例

```json
{
  "code": 0,
  "message": "",
  "data": [
    {
      "id": 0,
      "bookId": 0,
      "userId": 0,
      "content": "",
      "rating": 0,
      "createTime": "",
      "parentId": 0,
      "replies": [
        {
          "id": 0,
          "bookId": 0,
          "userId": 0,
          "content": "",
          "rating": 0,
          "createTime": "",
          "parentId": 0,
          "replies": []
        }
      ]
    }
  ]
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[ResultListReview](#schemaresultlistreview)|

## POST replyToReview

POST /api/books/{bookId}/reviews/{reviewId}/replies

> Body 请求参数

```json
{
  "id": 0,
  "bookId": 0,
  "userId": 0,
  "content": "string",
  "rating": 1,
  "createTime": "string",
  "parentId": 0,
  "replies": [
    {
      "id": 0,
      "bookId": 0,
      "userId": 0,
      "content": "string",
      "rating": 1,
      "createTime": "string",
      "parentId": 0,
      "replies": [
        {
          "id": 0,
          "bookId": 0,
          "userId": 0,
          "content": "string",
          "rating": 1,
          "createTime": "string",
          "parentId": 0,
          "replies": [
            {}
          ]
        }
      ]
    }
  ]
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|bookId|path|integer| 是 |none|
|reviewId|path|integer| 是 |none|
|body|body|[Review](#schemareview)| 否 |none|

> 返回示例

```json
{
  "code": 0,
  "message": "",
  "data": {
    "id": 0,
    "bookId": 0,
    "userId": 0,
    "content": "",
    "rating": 0,
    "createTime": "",
    "parentId": 0,
    "replies": [
      {
        "id": 0,
        "bookId": 0,
        "userId": 0,
        "content": "",
        "rating": 0,
        "createTime": "",
        "parentId": 0,
        "replies": [
          {}
        ]
      }
    ]
  }
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[ResultReview](#schemaresultreview)|

## DELETE deleteReview

DELETE /api/books/{bookId}/reviews/{reviewId}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|reviewId|path|integer| 是 |none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 

# UploadController

## POST uploadAvatar

POST /api/users/{userId}/update/upload

> Body 请求参数

```yaml
image: string

```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|userId|path|string| 是 |none|
|body|body|object| 否 |none|
|» image|body|string(binary)| 否 |none|

> 返回示例

```json
{
  "code": 0,
  "message": "",
  "data": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[ResultString](#schemaresultstring)|

# CategoryController

## POST addCategory

POST /api/categories

> Body 请求参数

```json
{
  "id": 0,
  "categoryName": "string"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[Category](#schemacategory)| 否 |none|

> 返回示例

```json
{
  "code": 0,
  "message": "",
  "data": {
    "id": 0,
    "categoryName": ""
  }
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[ResultCategory](#schemaresultcategory)|

## GET getAllCategory

GET /api/categories

> 返回示例

```json
{
  "code": 0,
  "message": "",
  "data": [
    {
      "id": 0,
      "categoryName": ""
    }
  ]
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[ResultListCategory](#schemaresultlistcategory)|

## GET getCategoryById

GET /api/categories/{id}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|path|integer| 是 |none|

> 返回示例

```json
{
  "id": 0,
  "categoryName": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[Category](#schemacategory)|

## PUT updateCategoryById

PUT /api/categories/{id}

> Body 请求参数

```json
{
  "id": 0,
  "categoryName": "string"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|path|integer| 是 |none|
|body|body|[Category](#schemacategory)| 否 |none|

> 返回示例

```json
{
  "code": 0,
  "message": "",
  "data": {
    "id": 0,
    "categoryName": ""
  }
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[ResultCategory](#schemaresultcategory)|

## DELETE deleteCategoryById

DELETE /api/categories/{id}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|path|integer| 是 |none|

> 返回示例

```json
{
  "code": 0,
  "message": "",
  "data": {
    "id": 0,
    "categoryName": ""
  }
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[ResultCategory](#schemaresultcategory)|

# FavoriteController

## POST addFavorite

POST /api/users/{userId}/favorites

> Body 请求参数

```json
{
  "id": 0,
  "userId": 0,
  "bookId": 0,
  "createAt": "string"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|userId|path|string| 是 |none|
|body|body|[Favorite](#schemafavorite)| 否 |none|

> 返回示例

```json
{
  "code": 0,
  "message": "",
  "data": {
    "id": 0,
    "userId": 0,
    "bookId": 0,
    "createAt": ""
  }
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[ResultFavorite](#schemaresultfavorite)|

## GET getFavorites

GET /api/users/{userId}/favorites

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|userId|path|string| 是 |none|

> 返回示例

```json
{
  "code": 0,
  "message": "",
  "data": [
    {
      "id": 0,
      "title": "",
      "isbn": "",
      "author": "",
      "publishedYear": "",
      "price": 0,
      "category": ""
    }
  ]
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[ResultListBook](#schemaresultlistbook)|

## DELETE deleteFavorite

DELETE /api/users/{userId}/favorites/{bookId}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|userId|path|string| 是 |none|
|bookId|path|integer| 是 |none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 

# 数据模型

<h2 id="tocS_Category">Category</h2>

<a id="schemacategory"></a>
<a id="schema_Category"></a>
<a id="tocScategory"></a>
<a id="tocscategory"></a>

```json
{
  "id": 0,
  "categoryName": "string"
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|id|integer|false|none||分组ID编号|
|categoryName|string|true|none||none|

<h2 id="tocS_ResultTag">ResultTag</h2>

<a id="schemaresulttag"></a>
<a id="schema_ResultTag"></a>
<a id="tocSresulttag"></a>
<a id="tocsresulttag"></a>

```json
{
  "code": 0,
  "message": "string",
  "data": {
    "id": 0,
    "name": "string",
    "userId": "string",
    "bookId": 0,
    "createTime": "string"
  }
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|code|integer|false|none||none|
|message|string|false|none||none|
|data|[Tag](#schematag)|false|none||none|

<h2 id="tocS_Tag">Tag</h2>

<a id="schematag"></a>
<a id="schema_Tag"></a>
<a id="tocStag"></a>
<a id="tocstag"></a>

```json
{
  "id": 0,
  "name": "string",
  "userId": "string",
  "bookId": 0,
  "createTime": "string"
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|id|integer|false|none||标签ID编号|
|name|string|true|none||标签名称|
|userId|string|true|none||none|
|bookId|integer|true|none||none|
|createTime|string|false|none||none|

<h2 id="tocS_ResultListTag">ResultListTag</h2>

<a id="schemaresultlisttag"></a>
<a id="schema_ResultListTag"></a>
<a id="tocSresultlisttag"></a>
<a id="tocsresultlisttag"></a>

```json
{
  "code": 0,
  "message": "string",
  "data": [
    {
      "id": 0,
      "name": "string",
      "userId": "string",
      "bookId": 0,
      "createTime": "string"
    }
  ]
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|code|integer|false|none||none|
|message|string|false|none||none|
|data|[[Tag](#schematag)]|false|none||none|

<h2 id="tocS_Book">Book</h2>

<a id="schemabook"></a>
<a id="schema_Book"></a>
<a id="tocSbook"></a>
<a id="tocsbook"></a>

```json
{
  "id": 0,
  "title": "string",
  "isbn": "string",
  "author": "string",
  "publishedYear": "string",
  "price": 999999,
  "category": "string"
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|id|integer|false|none||none|
|title|string|true|none||none|
|isbn|string|true|none||none|
|author|string|true|none||none|
|publishedYear|string|false|none||none|
|price|integer|false|none||none|
|category|string|true|none||none|

<h2 id="tocS_ResultListBook">ResultListBook</h2>

<a id="schemaresultlistbook"></a>
<a id="schema_ResultListBook"></a>
<a id="tocSresultlistbook"></a>
<a id="tocsresultlistbook"></a>

```json
{
  "code": 0,
  "message": "string",
  "data": [
    {
      "id": 0,
      "title": "string",
      "isbn": "string",
      "author": "string",
      "publishedYear": "string",
      "price": 999999,
      "category": "string"
    }
  ]
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|code|integer|false|none||none|
|message|string|false|none||none|
|data|[[Book](#schemabook)]|false|none||none|

<h2 id="tocS_ResultBook">ResultBook</h2>

<a id="schemaresultbook"></a>
<a id="schema_ResultBook"></a>
<a id="tocSresultbook"></a>
<a id="tocsresultbook"></a>

```json
{
  "code": 0,
  "message": "string",
  "data": {
    "id": 0,
    "title": "string",
    "isbn": "string",
    "author": "string",
    "publishedYear": "string",
    "price": 999999,
    "category": "string"
  }
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|code|integer|false|none||none|
|message|string|false|none||none|
|data|[Book](#schemabook)|false|none||none|

<h2 id="tocS_ResultInteger">ResultInteger</h2>

<a id="schemaresultinteger"></a>
<a id="schema_ResultInteger"></a>
<a id="tocSresultinteger"></a>
<a id="tocsresultinteger"></a>

```json
{
  "code": 0,
  "message": "string",
  "data": 0
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|code|integer|false|none||none|
|message|string|false|none||none|
|data|integer|false|none||none|

<h2 id="tocS_User">User</h2>

<a id="schemauser"></a>
<a id="schema_User"></a>
<a id="tocSuser"></a>
<a id="tocsuser"></a>

```json
{
  "userId": 0,
  "userName": "string",
  "password": "string",
  "sex": "string",
  "birthDate": "string",
  "avatarUrl": "string",
  "isAdmin": true
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|userId|integer|false|none||none|
|userName|string|true|none||none|
|password|string|true|none||none|
|sex|string|true|none||none|
|birthDate|string|true|none||none|
|avatarUrl|string|false|none||none|
|isAdmin|boolean|false|none||none|

<h2 id="tocS_ResultUser">ResultUser</h2>

<a id="schemaresultuser"></a>
<a id="schema_ResultUser"></a>
<a id="tocSresultuser"></a>
<a id="tocsresultuser"></a>

```json
{
  "code": 0,
  "message": "string",
  "data": {
    "userId": 0,
    "userName": "string",
    "password": "string",
    "sex": "string",
    "birthDate": "string",
    "avatarUrl": "string",
    "isAdmin": true
  }
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|code|integer|false|none||none|
|message|string|false|none||none|
|data|[User](#schemauser)|false|none||none|

<h2 id="tocS_Borrow">Borrow</h2>

<a id="schemaborrow"></a>
<a id="schema_Borrow"></a>
<a id="tocSborrow"></a>
<a id="tocsborrow"></a>

```json
{
  "id": 0,
  "userId": "string",
  "bookId": 0,
  "borrowTime": "string",
  "dueTime": "string",
  "returnTime": "string",
  "status": "string"
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|id|integer|false|none||none|
|userId|string|true|none||none|
|bookId|integer|true|none||none|
|borrowTime|string|false|none||none|
|dueTime|string|false|none||none|
|returnTime|string|false|none||none|
|status|string|false|none||none|

<h2 id="tocS_ResultBorrow">ResultBorrow</h2>

<a id="schemaresultborrow"></a>
<a id="schema_ResultBorrow"></a>
<a id="tocSresultborrow"></a>
<a id="tocsresultborrow"></a>

```json
{
  "code": 0,
  "message": "string",
  "data": {
    "id": 0,
    "userId": "string",
    "bookId": 0,
    "borrowTime": "string",
    "dueTime": "string",
    "returnTime": "string",
    "status": "string"
  }
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|code|integer|false|none||none|
|message|string|false|none||none|
|data|[Borrow](#schemaborrow)|false|none||none|

<h2 id="tocS_ResultListBorrow">ResultListBorrow</h2>

<a id="schemaresultlistborrow"></a>
<a id="schema_ResultListBorrow"></a>
<a id="tocSresultlistborrow"></a>
<a id="tocsresultlistborrow"></a>

```json
{
  "code": 0,
  "message": "string",
  "data": [
    {
      "id": 0,
      "userId": "string",
      "bookId": 0,
      "borrowTime": "string",
      "dueTime": "string",
      "returnTime": "string",
      "status": "string"
    }
  ]
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|code|integer|false|none||none|
|message|string|false|none||none|
|data|[[Borrow](#schemaborrow)]|false|none||none|

<h2 id="tocS_Follow">Follow</h2>

<a id="schemafollow"></a>
<a id="schema_Follow"></a>
<a id="tocSfollow"></a>
<a id="tocsfollow"></a>

```json
{
  "followerId": 0,
  "followingId": 0,
  "followTime": "string"
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|followerId|integer|true|none||none|
|followingId|integer|true|none||none|
|followTime|string|false|none||none|

<h2 id="tocS_ResultListString">ResultListString</h2>

<a id="schemaresultliststring"></a>
<a id="schema_ResultListString"></a>
<a id="tocSresultliststring"></a>
<a id="tocsresultliststring"></a>

```json
{
  "code": 0,
  "message": "string",
  "data": [
    "string"
  ]
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|code|integer|false|none||none|
|message|string|false|none||none|
|data|[string]|false|none||none|

<h2 id="tocS_Review">Review</h2>

<a id="schemareview"></a>
<a id="schema_Review"></a>
<a id="tocSreview"></a>
<a id="tocsreview"></a>

```json
{
  "id": 0,
  "bookId": 0,
  "userId": 0,
  "content": "string",
  "rating": 1,
  "createTime": "string",
  "parentId": 0,
  "replies": [
    {
      "id": 0,
      "bookId": 0,
      "userId": 0,
      "content": "string",
      "rating": 1,
      "createTime": "string",
      "parentId": 0,
      "replies": [
        {
          "id": 0,
          "bookId": 0,
          "userId": 0,
          "content": "string",
          "rating": 1,
          "createTime": "string",
          "parentId": 0,
          "replies": [
            {}
          ]
        }
      ]
    }
  ]
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|id|integer|false|none||none|
|bookId|integer|true|none||none|
|userId|integer|true|none||none|
|content|string|true|none||none|
|rating|integer|false|none||none|
|createTime|string|false|none||none|
|parentId|integer|false|none||none|
|replies|[[Review](#schemareview)]|false|none||none|

<h2 id="tocS_ResultReview">ResultReview</h2>

<a id="schemaresultreview"></a>
<a id="schema_ResultReview"></a>
<a id="tocSresultreview"></a>
<a id="tocsresultreview"></a>

```json
{
  "code": 0,
  "message": "string",
  "data": {
    "id": 0,
    "bookId": 0,
    "userId": 0,
    "content": "string",
    "rating": 1,
    "createTime": "string",
    "parentId": 0,
    "replies": [
      {
        "id": 0,
        "bookId": 0,
        "userId": 0,
        "content": "string",
        "rating": 1,
        "createTime": "string",
        "parentId": 0,
        "replies": [
          {
            "id": null,
            "bookId": null,
            "userId": null,
            "content": null,
            "rating": null,
            "createTime": null,
            "parentId": null,
            "replies": null
          }
        ]
      }
    ]
  }
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|code|integer|false|none||none|
|message|string|false|none||none|
|data|[Review](#schemareview)|false|none||none|

<h2 id="tocS_ResultListReview">ResultListReview</h2>

<a id="schemaresultlistreview"></a>
<a id="schema_ResultListReview"></a>
<a id="tocSresultlistreview"></a>
<a id="tocsresultlistreview"></a>

```json
{
  "code": 0,
  "message": "string",
  "data": [
    {
      "id": 0,
      "bookId": 0,
      "userId": 0,
      "content": "string",
      "rating": 1,
      "createTime": "string",
      "parentId": 0,
      "replies": [
        {
          "id": 0,
          "bookId": 0,
          "userId": 0,
          "content": "string",
          "rating": 1,
          "createTime": "string",
          "parentId": 0,
          "replies": [
            {}
          ]
        }
      ]
    }
  ]
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|code|integer|false|none||none|
|message|string|false|none||none|
|data|[[Review](#schemareview)]|false|none||none|

<h2 id="tocS_ResultString">ResultString</h2>

<a id="schemaresultstring"></a>
<a id="schema_ResultString"></a>
<a id="tocSresultstring"></a>
<a id="tocsresultstring"></a>

```json
{
  "code": 0,
  "message": "string",
  "data": "string"
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|code|integer|false|none||none|
|message|string|false|none||none|
|data|string|false|none||none|

<h2 id="tocS_ResultCategory">ResultCategory</h2>

<a id="schemaresultcategory"></a>
<a id="schema_ResultCategory"></a>
<a id="tocSresultcategory"></a>
<a id="tocsresultcategory"></a>

```json
{
  "code": 0,
  "message": "string",
  "data": {
    "id": 0,
    "categoryName": "string"
  }
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|code|integer|false|none||none|
|message|string|false|none||none|
|data|[Category](#schemacategory)|false|none||none|

<h2 id="tocS_ResultListCategory">ResultListCategory</h2>

<a id="schemaresultlistcategory"></a>
<a id="schema_ResultListCategory"></a>
<a id="tocSresultlistcategory"></a>
<a id="tocsresultlistcategory"></a>

```json
{
  "code": 0,
  "message": "string",
  "data": [
    {
      "id": 0,
      "categoryName": "string"
    }
  ]
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|code|integer|false|none||none|
|message|string|false|none||none|
|data|[[Category](#schemacategory)]|false|none||none|

<h2 id="tocS_Favorite">Favorite</h2>

<a id="schemafavorite"></a>
<a id="schema_Favorite"></a>
<a id="tocSfavorite"></a>
<a id="tocsfavorite"></a>

```json
{
  "id": 0,
  "userId": 0,
  "bookId": 0,
  "createAt": "string"
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|id|integer|false|none||none|
|userId|integer|true|none||none|
|bookId|integer|true|none||none|
|createAt|string|false|none||none|

<h2 id="tocS_ResultFavorite">ResultFavorite</h2>

<a id="schemaresultfavorite"></a>
<a id="schema_ResultFavorite"></a>
<a id="tocSresultfavorite"></a>
<a id="tocsresultfavorite"></a>

```json
{
  "code": 0,
  "message": "string",
  "data": {
    "id": 0,
    "userId": 0,
    "bookId": 0,
    "createAt": "string"
  }
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|code|integer|false|none||none|
|message|string|false|none||none|
|data|[Favorite](#schemafavorite)|false|none||none|

## GET getAllOperationLogs

GET /api/books/logs

> 返回示例

```json
{
  "code": 0,
  "message": "",
  "data": [
    {
      "id": 0,
      "operationName": "",
      "startTime": "",
      "endTime": "",
      "duration": 0
    }
  ]
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[ResultListOperationLog](#schemaresultlistoperationlog)|

# 数据模型

<h2 id="tocS_OperationLog">OperationLog</h2>

<a id="schemaoperationlog"></a>
<a id="schema_OperationLog"></a>
<a id="tocSoperationlog"></a>
<a id="tocsoperationlog"></a>

```json
{
  "id": 0,
  "operationName": "string",
  "startTime": "string",
  "endTime": "string",
  "duration": 0
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|id|integer|false|none||none|
|operationName|string|false|none||none|
|startTime|string|false|none||none|
|endTime|string|false|none||none|
|duration|integer|false|none||none|

<h2 id="tocS_ResultListOperationLog">ResultListOperationLog</h2>

<a id="schemaresultlistoperationlog"></a>
<a id="schema_ResultListOperationLog"></a>
<a id="tocSresultlistoperationlog"></a>
<a id="tocsresultlistoperationlog"></a>

```json
{
  "code": 0,
  "message": "string",
  "data": [
    {
      "id": 0,
      "operationName": "string",
      "startTime": "string",
      "endTime": "string",
      "duration": 0
    }
  ]
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|code|integer|false|none||none|
|message|string|false|none||none|
|data|[[OperationLog](#schemaoperationlog)]|false|none||none|


