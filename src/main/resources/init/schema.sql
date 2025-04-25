DROP TABLE IF EXISTS `Member`;

CREATE TABLE `Member` (
                          `user_id`	varchar(20)	NOT NULL	COMMENT '이메일',
                          `password`	varchar(20)	NOT NULL,
                          `user_name`	varchar(20)	NULL,
                          `role`	varchar(20)	NOT NULL	DEFAULT 'ROLE_USER',
                          `tel`	varchar(20)	NULL,
                          `created_at`	Date	NOT NULL
);

DROP TABLE IF EXISTS `order_details`;

CREATE TABLE `order_details` (
                                 `order_details_id`	Bigint	NOT NULL	COMMENT 'orderDetailsId',
                                 `order_id`	varchar(20)	NOT NULL	COMMENT 'orderId',
                                 `product_id`	Bigint	NOT NULL	COMMENT 'productId',
                                 `order_cnt`	int	NOT NULL	COMMENT 'orderCnt',
                                 `product_price`	int	NOT NULL	COMMENT 'productPrice'
);

DROP TABLE IF EXISTS `order`;

CREATE TABLE `order` (
                         `order_id`	Bigint	NOT NULL	COMMENT 'orderId',
                         `user_id`	varchar(20)	NOT NULL	COMMENT 'userId',
                         `order_date`	Date	NOT NULL	COMMENT 'orderDate',
                         `expect_delivery_date`	Date	NOT NULL	COMMENT 'expectDeliveryDate',
                         `address`	varchar(20)	NOT NULL	COMMENT 'address',
                         `post_number`	varchar(20)	NOT NULL	COMMENT 'postNumber',
                         `total_price`	int	NOT NULL	COMMENT 'totalPrice',
                         `order_items`	int	NOT NULL	COMMENT 'orderItems',
                         `activated`	Boolean	NOT NULL	COMMENT 'activated'
);

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
                           `product_id`	Bigint	NOT NULL,
                           `category`	varchar(20)	NULL,
                           `product_name`	varchar(20)	NOT NULL,
                           `price`	int	NOT NULL,
                           `stock`	int	NOT NULL,
                           `info`	text	NULL,
                           `product_img`	varchar(30)	NULL
);

DROP TABLE IF EXISTS `cart`;

CREATE TABLE `cart` (
                        `cart_id`	Bigint	NOT NULL,
                        `user_id`	varchar(20)	NOT NULL	COMMENT '이메일'
);

DROP TABLE IF EXISTS `cart_details`;

CREATE TABLE `cart_details` (
                                `cart_details_id`	Bigint	NOT NULL,
                                `cart_id`	Bigint	NOT NULL,
                                `product_id`	Bigint	NOT NULL,
                                `product_cnt`	int	NOT NULL,
                                `created_at`	Date	NOT NULL
);

ALTER TABLE `Member` ADD CONSTRAINT `PK_MEMBER` PRIMARY KEY (
                                                             `user_id`
    );

ALTER TABLE `order_details` ADD CONSTRAINT `PK_ORDER_DETAILS` PRIMARY KEY (
                                                                           `order_details_id`
    );

ALTER TABLE `order` ADD CONSTRAINT `PK_ORDER` PRIMARY KEY (
                                                           `order_id`
    );

ALTER TABLE `product` ADD CONSTRAINT `PK_PRODUCT` PRIMARY KEY (
                                                               `product_id`
    );

ALTER TABLE `cart` ADD CONSTRAINT `PK_CART` PRIMARY KEY (
                                                         `cart_id`
    );

ALTER TABLE `cart_details` ADD CONSTRAINT `PK_CART_DETAILS` PRIMARY KEY (
                                                                         `cart_details_id`
    );