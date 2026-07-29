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
    product_name varchar(40) not null,
    product_description text,
    product_price int not null,
    product_image_url varchar(255),
    amount int,
    created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp on update current_timestamp,

    constraint FK_ODETAIL_ORDERID foreign key (orders_id)
        references orders(id) on update cascade on delete cascade
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
INSERT INTO product(name, description, price, image_url, color, delete_flg)
VALUES
('ロマンティックローズブーケ', '赤・ピンク・ホワイトのバラを贅沢に束ねた華やかなブーケ。誕生日や記念日、大切な人への贈り物にぴったりです。', 6980, '/images/product1.png', 1, 0),

('ピーチガーベラアレンジ', '優しいピーチカラーのバラとピンクのガーベラを組み合わせた可愛らしいアレンジメント。感謝やお祝いの気持ちを優しく伝えます。', 4980, '/images/product2.png', 4, 0),

('エレガントリリーブーケ', '大輪のユリを中心に、バラやガーベラを美しくまとめた上品な花束。華やかさと気品を兼ね備えた特別な一品です。', 7980, '/images/product3.png', 6, 0),

('ピンクローズブーケ', '鮮やかなピンクのバラだけを束ねたシンプルで愛らしいブーケ。プロポーズや記念日、特別な想いを伝える贈り物におすすめです。', 4280, '/images/product4.png', 4, 0),

('プレミアムレッドローズ', '深紅のバラを贅沢に使用した高級感あふれるブーケ。愛情や情熱を象徴する特別なフラワーギフトです。', 9980, '/images/product5.png', 1, 0),

('ナチュラルガーデンブーケ', 'くすみピンクのバラとユーカリを組み合わせたナチュラルテイストのブーケ。落ち着いた雰囲気で大人の贈り物に最適です。', 5480, '/images/product6.png', 8, 0),

('フェミニンフラワーブーケ', 'ピンクやホワイトの花々をバランスよく束ねたエレガントなブーケ。優雅で華やかな印象を演出し、様々なお祝いのシーンにおすすめです。', 10980, '/images/product7.png', 5, 0),
('商品8', 'ドライフラワーセット', 2200, '/images/product8.png', 1, 0),
('商品9', '花瓶付きフラワーセット', 3500, '/images/product9.png', 1, 0),
('商品10', 'アロマフラワーキャンドル', 900, '/images/product10.png', 1, 0),
('商品11', 'ラベンダーブーケ', 1300, '/images/product11.png', 1, 0),
('商品12', '多肉植物アソート', 1600, '/images/product12.png', 1, 0),
('商品13', 'ひまわりギフトセット', 2800, '/images/product13.png', 1, 0),
('商品14', '季節限定フラワーボックス', 4200, '/images/product14.png', 1, 0),
('商品15', 'プリザーブドフラワー（ピンク）', 3000, '/images/product15.png', 1, 0);

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
 