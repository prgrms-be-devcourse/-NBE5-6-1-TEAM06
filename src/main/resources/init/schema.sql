DROP TABLE IF EXISTS `Member`;

CREATE TABLE `Member` (
                          `user_id` varchar(20) NOT NULL COMMENT '유저 아이디 (PK)',
                          `password` varchar(70) NOT NULL,
                          `user_name` varchar(20) NOT NULL,
                          `role` varchar(20) NOT NULL DEFAULT 'ROLE_USER',
                          `tel` varchar(20) NOT NULL,
                          `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ,
                          PRIMARY KEY (`user_id`)
);

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
                           `product_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT 'productId',
                           `category` varchar(20) NULL,
                           `product_name` varchar(50) NOT NULL,
                           `price` INT NOT NULL,
                           `stock` INT NOT NULL,
                           `info` TEXT NULL,
                           `product_img_url` varchar(30) NULL,
                           PRIMARY KEY (`product_id`)
);

DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
                         `order_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT 'orderId',
                         `user_id` varchar(20) NOT NULL COMMENT 'userId',
                         `ordered_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         `expect_deliveried_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         `address` varchar(20) NOT NULL COMMENT 'address',
                         `post_number` varchar(20) NOT NULL COMMENT 'postNumber',
                         `total_price` INT NOT NULL COMMENT 'totalPrice',
#                          `order_items` INT NOT NULL COMMENT 'orderItems',
                         `activated` BOOLEAN NOT NULL COMMENT 'activated',
                         PRIMARY KEY (`order_id`)
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
                                `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                PRIMARY KEY (`cart_details_id`)
);