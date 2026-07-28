set names utf8mb4;

drop database if exists shopping;
create database shopping;

use shopping;

-- テーブル作成

-- お花の色
create table color(
    id int auto_increment primary key,
    name varchar(40) not null
);

-- ユーザー
create table user(
    id int auto_increment primary key,
    email varchar(100) unique not null,
    password varchar(100) not null,
    role tinyint not null,
    last_name varchar(100) not null,
    first_name varchar(100) not null,
    post_number varchar(10),
    address varchar(255),
    tel_number varchar(30),
    created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp on update current_timestamp
);

-- 商品（お花）
create table product(
    id int auto_increment primary key,
    name varchar(40) not null,
    description text,
    price int not null,
    image_url varchar(255),
    color int not null,
    delete_flg tinyint default 0,
    created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp on update current_timestamp,

    constraint FK_PRODUCT_COLOR foreign key (color)
        references color(id) on update cascade on delete cascade
);

-- カート
create table cart(
	id int auto_increment primary key,
	user_id int not null,
	product_id int not null,
	amount int not null default 1,
    created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp on update current_timestamp,
    
    constraint FK_CART_USERID foreign key(user_id)
    	references user(id) on update cascade on delete cascade,
    
    constraint FK_CART_PID foreign key(product_id)
    	references product(id) on update cascade on delete cascade,
    	
    constraint UNQ_USER_PRODUCT unique (user_id, product_id)
);

-- 注文
create table orders(
    id int auto_increment primary key,
    user_id int not null,
    credit_number varchar(30),
    last_name varchar(100) not null,
    first_name varchar(100) not null,
    post_number varchar(10) not null,
    address varchar(255) not null,
    tel_number varchar(30) not null,
    sum_price int not null,
    created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp on update current_timestamp,

    constraint FK_ORDERS_USERID foreign key (user_id)
        references user(id) on update cascade on delete cascade
);

-- 注文詳細
create table orders_detail(
    id int auto_increment primary key,
    orders_id int not null,
    product_id int not null,
    amount int,
    created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp on update current_timestamp,

    constraint FK_ODETAIL_ORDERID foreign key (orders_id)
        references orders(id) on update cascade on delete cascade,
    
    constraint FK_ODETAIL_PRODUCTID foreign key (product_id)
        references product(id) on update cascade on delete cascade
);

-- お知らせ
create table notice(
    id int auto_increment primary key,
    title varchar(50) not null,
    body varchar(500) not null,
    visibility_flag tinyint not null,
    delete_flg tinyint default 0,
    created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp on update current_timestamp
);

-- お知らせ既読
create table notice_read(
    id int auto_increment primary key,
    notice_id int not null,
    user_id int not null,
    created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp on update current_timestamp,

    constraint FK_NOTICER_NOTICEID foreign key(notice_id)
        references notice(id) on update cascade on delete cascade,
        
    constraint FK_NOTICER_USERID foreign key(user_id)
        references user(id) on update cascade on delete cascade
);


-- データ投入

-- color
insert into color(name)
values
('赤'),
('黄色'),
('青'),
('ピンク'),
('紫'),
('白'),
('オレンジ'),
('緑'),
('黒');

-- product
insert into product(name, description, price, image_url, color, delete_flg)
values
('商品1', '商品説明1', 1000, '/img/product1.jpg', 1, 0),
('商品2', '商品説明2', 2000, '/img/product2.jpg', 1, 0),
('商品3', '商品説明3', 3000, '/img/product3.jpg', 1, 0),
('商品4', '季節の花を使ったミニブーケ', 1500, '/img/product4.jpg', 1, 0),
('商品5', '人気のバラアレンジメント', 2500, '/img/product5.jpg', 1, 0),
('商品6', '観葉植物（小サイズ）', 1800, '/img/product6.jpg', 1, 0),
('商品7', '胡蝶蘭（ギフト用）', 12000, '/img/product7.jpg', 1, 0),
('商品8', 'ドライフラワーセット', 2200, '/img/product8.jpg', 1, 0),
('商品9', '花瓶付きフラワーセット', 3500, '/img/product9.jpg', 1, 0),
('商品10', 'アロマフラワーキャンドル', 900, '/img/product10.jpg', 1, 0),
('商品11', 'ラベンダーブーケ', 1300, '/img/product11.jpg', 1, 0),
('商品12', '多肉植物アソート', 1600, '/img/product12.jpg', 1, 0),
('商品13', 'ひまわりギフトセット', 2800, '/img/product13.jpg', 1, 0),
('商品14', '季節限定フラワーボックス', 4200, '/img/product14.jpg', 1, 0),
('商品15', 'プリザーブドフラワー（ピンク）', 3000, '/img/product15.jpg', 1, 0);

-- user
insert into user(email, password, role, last_name, first_name, post_number, address, tel_number) 
values
('sample1@kronos.jp', SHA2('pass01', 256), 2, '山田', '太郎', '5470033', '大阪市平野区平野西4丁目', '09033332222'),
('sample2@kronos.jp', SHA2('pass02', 256), 2, '井上', '次郎', '5470025', '大阪市阿倍野区阿倍野西4丁目', '09044442232'),
('sample3@kronos.jp', SHA2('pass03', 256), 1, '二宮', '秀雄', null, null, null);

-- notice
INSERT INTO notice (title, body, visibility_flag, delete_flg)
VALUES
('新作ブーケ入荷のお知らせ',
 '季節の花を使った新作ブーケが入荷しました。店頭にてご覧いただけます。',
 1, 0),
 ('臨時休業のお知らせ',
 'スタッフ研修のため、来週火曜日は臨時休業とさせていただきます。',
 1, 0),
 ('母の日ギフト予約開始',
 '母の日向けの特別ギフトセットの予約受付を開始しました。数量限定です。',
 1, 0),
 ('会員限定セールのご案内',
 '会員様限定で、観葉植物の10％オフセールを実施いたします。',
 0, 0),
 ('販売終了商品のお知らせ',
 '一部の花材は仕入れ終了のため、販売を終了いたしました。',
 1, 1),
 ('花の水やり講座開催',
 '初心者向けの花の水やり講座を開催します。参加希望の方は店頭でお申し込みください。',
 1, 0);
 