drop database if exists shopping;
create database shopping;

connect shopping;

-- テーブル作成

-- ユーザー
create table user(
    id int(11) auto_increment primary key,
    email varchar(100) unique not null,
    password varchar(100) not null,
    role tinyint(5) not null,
    last_name varchar(100) not null,
    first_name varchar(100) not null,
    post_number varchar(10) not null,
    address varchar(255) not null,
    tel_number varchar(30) not null,
    created_at datetime,
    updated_at datetime
);

-- お花の色
create table color(
    id Integer auto_increment primary key,
    name varchar(40) not null
)

-- 商品（お花）
create table product(
    id Integer auto_increment primary key,
    name varchar(40) not null,
    description text,
    price Integer not null,
    image_url varchar(255),
    color Integer not null,
    delete_flg tinyint,
    created_at datetime,
    updated_at datetime,

    constraint FK_PRODUCT_COLOR foreign key (color)
        references color(id) on update cascade on delete cascade
);

-- 注文
create table orders(
    id Integer auto_increment primary key,
    user_id Integer not null,
    credit_number varchar(30),
    post_number varchar(10) not null,
    address varchar(255) not null,
    tel_number varchar(30) not null,
    created_at datetime,
    updated_at datetime,

    constraint FK_ORDERS_USERID foreign key (user_id)
        references user(id) on update cascade on delete cascade
);

-- 注文詳細
create table orders_detail(
    id Integer auto_increment primary key,
    orders_id Integer not null,
    product_id Integer not null,
    amount Integer,
    created_at datetime,
    updated_at datetime

    constraint FK_ODETAIL_ORDERID foreign key (orders_id)
        references orders(id) on update cascade on delete cascade,
    
    constraint FK_ODETAIL_PRODUCTID foreign key (product_id)
        references (id) on update cascade on delete cascade
);

-- お知らせ
create table notice(
    id Integer auto_increment primary key,
    title varchar(50) not null,
    body varchar(500) not null,
    visibility_flag tinyint not null,
    delete_flg tinyint,
    created_at datetime,
    updated_at datetime
);

-- お知らせ既読
create table notice_read(
    id Integer auto_increment primary key,
    notice_id Integer not null,
    user_id Integer not null,
    created_at datetime,
    updated_at datetime

    constraint FK_NOTICER_NOTICEID foreign key(notice_id)
        references (notice) on update cascade on delete cascade
);


-- データ投入

-- 
insert into product(name, description, price, image_url, color, delete_flg, created_at, updated_at)
values
('商品1', '商品説明1', 1000, '/img/product1.jpg', 1, 0, now(), now()),
('商品2', '商品説明2', 2000, '/img/product2.jpg', 1, 0, now(), now()),
('商品3', '商品説明3', 3000, '/img/product3.jpg', 1, 0, now(), now());

insert into user(email, password, role, last_name, first_name, post_number, address, tel_number, created_at, updated_at) 
values
('sample1@kronos.jp','pass01', 2, '山田', '太郎', '5470033', '大阪市平野区平野西4丁目', '09033332222', now(), now()),
('sample2@kronos.jp','pass02', 2, '井上', '次郎', '5470025', '大阪市阿倍野区阿倍野西4丁目', '09044442232', now(), now()),
('sample3@kronos.jp','pass03', 1, '二宮', '秀雄', '0690831', '北海道江別市野幌若葉町', '09077776666', now(), now());

insert into color(name)
values
(赤);