DROP TABLE IF EXISTS `MEMBER`;

CREATE TABLE `Member`
(
    `USER_ID`    VARCHAR(20) PRIMARY KEY COMMENT '회원 아이디',
    `PASSWORD`   VARCHAR(20) NOT NULL COMMENT '비밀번호',
    `USER_NAME`  VARCHAR(20) NULL COMMENT '이름',
    `ROLE`   VARCHAR(20) NOT NULL COMMENT '역할',
    `TEL`   VARCHAR(20)  NULL COMMENT '전화번호',
    `CREATED_AT`  timestamp NOT NULL COMMENT '생성일자'
);

DROP TABLE IF EXISTS `PRODUCT`;

CREATE TABLE `PRODUCT`
(
    `PRODUCT_ID`    BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '상품번호',
    `CATEGORY`      VARCHAR(20) NULL COMMENT '상품 카테고리',
    `PRODUCT_NAME`   VARCHAR(20) NULL NULL COMMENT '상품명',
    `PRICE`   INT NOT NULL COMMENT '가격',
    `STOCK`   INT NOT NULL COMMENT '재고',
    `INFO`    TEXT NULL COMMENT '상품 정보',
    `PRODUCT_IMG` VARCHAR(30) NULL COMMENT '상품 이미지'

);

ALTER TABLE `PRODUCT`
MODIFY COLUMN `PRODUCT_NAME` VARCHAR(50) NULL COMMENT '상품명';

DROP TABLE IF EXISTS `CART`;

CREATE TABLE `CART`
(
    `CART_ID`    BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '장바구니 번호',
    `USER_ID`      VARCHAR(20) NOT NULL COMMENT '회원 아이디',
    CONSTRAINT `fk_user` FOREIGN KEY (`USER_ID`) REFERENCES `Member`(`USER_ID`)
);

DROP TABLE IF EXISTS `CART_DETAILS`;

CREATE TABLE `CART_DETAILS`
(
    `BK_IDX`     int          NOT NULL auto_increment PRIMARY KEY COMMENT '도서번호',
    `CATEGORY`   CHAR(20)     NULL COMMENT '도서카테고리',
    `TITLE`      VARCHAR(255) NOT NULL COMMENT '도서명',
    `AUTHOR`     VARCHAR(36)  NOT NULL COMMENT '저자',
    `INFO`       VARCHAR(36)  NULL COMMENT '도서설명',
    `AMOUNT`     int          NULL     DEFAULT 0 COMMENT '도서재고',
    `CREATED_AT` timestamp    NULL     DEFAULT now() COMMENT '도서등록일자',
    `RENT_CNT`   int          NULL     DEFAULT 0 COMMENT '대출횟수',
    `ACTIVATED`  boolean      NOT NULL DEFAULT true
);

DROP TABLE IF EXISTS `RENT_BOOK`;

CREATE TABLE `RENT_BOOK`
(
    `RB_IDX`      int          NOT NULL auto_increment PRIMARY KEY COMMENT '대출도서번호',
    `RENT_ID`     int          NOT NULL COMMENT '대출번호',
    `BK_IDX`      int          NOT NULL COMMENT '도서번호',
    `BOOK_TITLE`  VARCHAR(255) NOT NULL COMMENT '도서명',
    `CREATED_AT`  timestamp    NULL     DEFAULT now() COMMENT '대출일자',
    `STATE`       VARCHAR(36)  NULL     DEFAULT 'RE00' COMMENT '대출도서상태',
    `RETURN_DATE` timestamp    NULL COMMENT '반납예정일자',
    `ACTIVATED`   boolean      NOT NULL DEFAULT true
);

DROP TABLE IF EXISTS `BOOK_IMG`;

CREATE TABLE `BOOK_IMG`
(
    `BI_IDX`           int          NOT NULL auto_increment PRIMARY KEY COMMENT '파일번호',
    `BK_IDX`           int          NOT NULL,
    `TYPE`             VARCHAR(36)  NOT NULL,
    `ORIGIN_FILE_NAME` VARCHAR(36)  NOT NULL COMMENT '원본파일명',
    `RENAME_FILE_NAME` VARCHAR(36)  NOT NULL COMMENT '저장파일명',
    `SAVE_PATH`        VARCHAR(255) NOT NULL COMMENT '저장경로',
    `CREATED_AT`       timestamp    NULL     DEFAULT now() COMMENT '파일등록일자',
    `ACTIVATED`        boolean      NOT NULL DEFAULT true
);

DROP TABLE IF EXISTS `RENT_HISTORY`;

CREATE TABLE `RENT_HISTORY`
(
    `RH_IDX`     int       NOT NULL auto_increment PRIMARY KEY COMMENT '대출이력번호',
    `RENT_ID`    int       NOT NULL COMMENT '대출번호',
    `RB_IDX`     int       NOT NULL COMMENT '대출도서번호',
    `BK_IDX`     int       NULL COMMENT '도서번호',
    `CREATED_AT` timestamp NULL DEFAULT now() COMMENT '이력등록일자',
    `STATE`      CHAR(20)  NULL COMMENT '대출상태'
);

# DROP TABLE IF EXISTS `MEMBER_INFO`;
#
# CREATE TABLE `MEMBER_INFO`
# (
#     `USER_ID`       VARCHAR(36) PRIMARY KEY COMMENT '회원 아이디',
#     `CREATED_AT`    timestamp NULL DEFAULT now() COMMENT '가입일자',
#     `LOGIN_DATE`    timestamp NULL COMMENT '마지막로그인일자',
#     `MODIFY_DATE`   timestamp NULL COMMENT '마지막수정일자',
#     `LEAVE_DATE`    timestamp NULL COMMENT '탈퇴일자',
#     `RENTABLE_DATE` timestamp NULL DEFAULT now() COMMENT '대출가능일자'
# );

DROP TABLE IF EXISTS `RENT`;

CREATE TABLE `RENT`
(
    `RENT_ID`    int         NOT NULL auto_increment PRIMARY KEY COMMENT '대출번호',
    `USER_ID`    VARCHAR(36) NOT NULL COMMENT '회원 아이디',
    `CREATED_AT` timestamp   NULL     DEFAULT now() COMMENT '대출일자',
    `IS_RETURN`  bool        NULL     DEFAULT 0 COMMENT '반납여부',
    `TITLE`      VARCHAR(50) NOT NULL COMMENT '대출건제목',
    `ACTIVATED`  boolean     NOT NULL DEFAULT true
);

# 여기서부터 삽입
DROP TABLE IF EXISTS `Member`;

CREATE TABLE `Member` (
                          `user_id` varchar(20) NOT NULL COMMENT '유저 아이디 (PK)',
                          `password` varchar(20) NOT NULL,
                          `user_name` varchar(20) NOT NULL,
                          `role` varchar(20) NOT NULL DEFAULT 'ROLE_USER',
                          `tel` varchar(20) NOT NULL,
                          `created_at` DATE NOT NULL,
                          PRIMARY KEY (`user_id`)
);

DROP TABLE IF EXISTS `order_details`;

CREATE TABLE `order_details` (
                                 `order_details_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT 'orderDetailsId',
                                 `order_id` varchar(20) NOT NULL COMMENT 'orderId',
                                 `product_id` BIGINT NOT NULL COMMENT 'productId',
                                 `order_cnt` INT NOT NULL COMMENT 'orderCnt',
                                 `product_price` INT NOT NULL COMMENT 'productPrice',
                                 PRIMARY KEY (`order_details_id`)
);

DROP TABLE IF EXISTS `order`;

CREATE TABLE `order` (
                         `order_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT 'orderId',
                         `user_id` varchar(20) NOT NULL COMMENT 'userId',
                         `order_date` DATE NOT NULL COMMENT 'orderDate',
                         `expect_delivery_date` DATE NOT NULL COMMENT 'expectDeliveryDate',
                         `address` varchar(20) NOT NULL COMMENT 'address',
                         `post_number` varchar(20) NOT NULL COMMENT 'postNumber',
                         `total_price` INT NOT NULL COMMENT 'totalPrice',
                         `order_items` INT NOT NULL COMMENT 'orderItems',
                         `activated` BOOLEAN NOT NULL COMMENT 'activated',
                         PRIMARY KEY (`order_id`)
);

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
                           `product_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT 'productId',
                           `category` varchar(20) NULL,
                           `product_name` varchar(50) NOT NULL,
                           `price` INT NOT NULL,
                           `stock` INT NOT NULL,
                           `info` TEXT NULL,
                           `product_img` varchar(30) NULL,
                           PRIMARY KEY (`product_id`)
);

DROP TABLE IF EXISTS `cart`;

CREATE TABLE `cart` (
                        `cart_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT 'cartId',
                        `user_id` varchar(20) NOT NULL COMMENT '이메일',
                        PRIMARY KEY (`cart_id`)
);

DROP TABLE IF EXISTS `cart_details`;

CREATE TABLE `cart_details` (
                                `cart_details_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT 'cartDetailsId',
                                `cart_id` BIGINT NOT NULL,
                                `product_id` BIGINT NOT NULL,
                                `product_cnt` INT NOT NULL,
                                `created_at` DATE NOT NULL,
                                PRIMARY KEY (`cart_details_id`)
);