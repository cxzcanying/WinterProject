create table book
(
    id             mediumint unsigned auto_increment
        primary key,
    title          varchar(20)              not null comment '书名',
    isbn           varchar(13)              not null comment '书ISBN号',
    author         varchar(10)              not null comment '书作者',
    published_year char(4)   default '1000' null comment '出版年份',
    price          mediumint default 0      null comment '价格',
    category       int                      not null comment '类别',
    constraint book_pk
        unique (isbn)
)
    comment '图书表';

create index idx_category_id
    on book (category);

create table category
(
    id            int auto_increment comment '类别ID'
        primary key,
    category_name varchar(100) not null comment '类别名',
    constraint category_name
        unique (category_name),
    constraint category_category__fk
        foreign key (id) references book (category)
)
    comment '类别表';

create table operation_logs
(
    id             int auto_increment
        primary key,
    operation_name varchar(255) not null,
    start_time     datetime     not null,
    end_time       datetime     not null,
    duration       int          not null
);

create table tag
(
    id          int auto_increment
        primary key,
    name        varchar(50)                        not null,
    user_id     varchar(50)                        not null,
    create_time datetime default CURRENT_TIMESTAMP null
);

create table user
(
    user_id    int auto_increment comment '用户ID'
        primary key,
    user_name  varchar(50)               not null comment '用户名',
    password   varchar(255)              not null comment '用户密码',
    sex        varchar(2) default '保密' null comment '性别',
    birth_date date                      not null comment '出生日期',
    is_admin   tinyint(1) default 1      null comment '是否为管理员',
    avatar_url varchar(100)              null,
    constraint user_name
        unique (user_name)
)
    comment '用户表';

create table book_tag
(
    book_id     mediumint unsigned                 not null,
    tag_id      int                                not null,
    user_id     int                                not null,
    create_time datetime default CURRENT_TIMESTAMP null,
    primary key (book_id, tag_id),
    constraint book_tag_ibfk_1
        foreign key (book_id) references book (id)
            on delete cascade,
    constraint book_tag_ibfk_2
        foreign key (tag_id) references tag (id)
            on delete cascade,
    constraint book_tag_ibfk_3
        foreign key (user_id) references user (user_id)
            on delete cascade
)
    comment '图书标签关联表';

create index tag_id
    on book_tag (tag_id);

create index user_id
    on book_tag (user_id);

create table borrow
(
    id          int auto_increment
        primary key,
    user_id     int                                   not null,
    book_id     mediumint unsigned                    not null,
    borrow_time datetime    default CURRENT_TIMESTAMP null,
    due_time    datetime                              not null,
    return_time datetime                              null,
    status      varchar(20) default 'BORROWED'        null,
    constraint borrow_ibfk_1
        foreign key (user_id) references user (user_id)
            on delete cascade,
    constraint borrow_ibfk_2
        foreign key (book_id) references book (id)
            on delete cascade,
    check (`status` in (_utf8mb4\'BORROWED\',_utf8mb4\'RETURNED\',_utf8mb4\'OVERDUE\'))
)
comment '借阅表';

create index book_id
    on borrow (book_id);

create index user_id
    on borrow (user_id);

create table favorite
(
    favorite_id int auto_increment
        primary key,
    user_id     int                                null comment '用户ID',
    book_id     mediumint unsigned                 null comment '书ID',
    created_at  datetime default CURRENT_TIMESTAMP null,
    constraint favorite_constraint
        unique (user_id, book_id),
    constraint favorite_ibfk_1
        foreign key (book_id) references book (id)
            on delete cascade,
    constraint favorite_ibfk_2
        foreign key (user_id) references user (user_id)
            on delete cascade
)
    comment '收藏表';

create index book_id
    on favorite (book_id);

create table follow
(
    following_id int                      not null comment '关注者id',
    follower_id  int                      not null comment '粉丝id',
    follow_time  datetime default (now()) not null,
    constraint follow_follow__fk
        foreign key (follower_id) references user (user_id),
    constraint follow_follow__fk_2
        foreign key (following_id) references user (user_id)
);

create table review
(
    id          int auto_increment
        primary key,
    book_id     mediumint unsigned                 not null,
    user_id     int                                not null,
    content     text                               not null,
    rating      int                                null,
    parent_id   int                                null comment '父评论',
    create_time datetime default CURRENT_TIMESTAMP null,
    constraint review_ibfk_1
        foreign key (book_id) references book (id)
            on delete cascade,
    constraint review_ibfk_2
        foreign key (user_id) references user (user_id)
            on delete cascade,
    constraint review_ibfk_3
        foreign key (parent_id) references review (id)
            on delete cascade,
    constraint rating_check
        check (`rating` <= 5),
    constraint rating_check2
        check (`rating` >= 1),
    check ((`rating` >= 1) and (`rating` <= 5))
)
    comment '评论表';

create index book_id
    on review (book_id);

create index parent_id
    on review (parent_id);

create index user_id
    on review (user_id);

create table user_history
(
    id        int auto_increment
        primary key,
    user_id   int                                not null,
    book_id   mediumint unsigned                 not null,
    view_time datetime default CURRENT_TIMESTAMP null,
    constraint user_history_ibfk_1
        foreign key (user_id) references user (user_id)
            on delete cascade,
    constraint user_history_ibfk_2
        foreign key (book_id) references book (id)
            on delete cascade
)
    comment '用户浏览历史表';

create index book_id
    on user_history (book_id);

create index user_id
    on user_history (user_id);


