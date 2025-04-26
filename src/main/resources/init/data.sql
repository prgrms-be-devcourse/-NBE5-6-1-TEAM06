
insert into Member(user_id, password, user_name, role, tel, created_at) values ('admin@example.com', '9999','ADMIN', 'ADMIN' , '9999-9999', '2025-03-24 10:23:30');
insert into Member(user_id, password, user_name, role, tel, created_at) values ('kdu@example.com', '1111','김도윤', 'USER' , '1111-1111', '2025-03-25 10:23:30');
insert into Member(user_id, password, user_name, role, tel, created_at) values ('ash@example.com', '2222','안세희', 'USER' , '2222-2222', '2025-03-26 10:23:30');
insert into Member(user_id, password, user_name, role, tel, created_at) values ('lkh@example.com', '3333','이강현', 'USER' , '3333-3333', '2025-03-27 10:23:30');
insert into Member(user_id, password, user_name, role, tel, created_at) values ('lcr@example.com', '5555','이초롱', 'USER' , '5555-5555', '2025-03-28 10:23:30');
insert into Member(user_id, password, user_name, role, tel, created_at) values ('hyj@example.com', '6666','황영준', 'USER' , '6666-6666', '2025-03-29 10:23:30');

insert into product(CATEGORY, PRODUCT_NAME, PRICE, STOCK, INFO) VALUES ('COFFEE','Colombia Nariño',5000,100,'콜롬비아 남서부, 에콰도르와 인접한 고산 지대에 위치한 나리뇨는 해발 1,800m 이상의 고도에서 커피가 재배됩니다. 이 지역은 낮과 밤의 기온 차가 커 체리의 숙성이 천천히 이루어지며, 그 결과 복합적인 향미와 뛰어난 단맛, 밝은 산미를 지닌 커피가 생산됩니다. 나리뇨 커피는 꿀처럼 부드러운 단맛과 감귤류, 플로럴한 향이 어우러진 뛰어난 균형감을 자랑합니다. 카투라(Caturra), 카스티요(Castillo) 등의 품종이 주로 재배됩니다.');
insert into product(CATEGORY, PRODUCT_NAME, PRICE, STOCK, INFO) VALUES ('COFFEE','Brazil Serra do Caparaó',5000,100,'브라질 남동부, 에스피리투 산투(ES)와 미나스 제라이스(MG) 경계에 위치한 세하 도 카파라오는 브라질에서 보기 드문 고산지대 커피 생산지입니다. 1,000~1,400m의 고도에서 소규모 농장 중심으로 재배되며, 내추럴과 허니 프로세싱이 활발히 이루어지는 지역입니다. 이곳의 커피는 견과류와 초콜릿의 고소한 풍미, 붉은 과일의 단맛, 깔끔한 산미가 조화를 이루며, 브라질 커피 특유의 부드럽고 마일드한 매력을 지니고 있습니다.');
insert into product(CATEGORY, PRODUCT_NAME, PRICE, STOCK, INFO) VALUES ('COFFEE','Colombia Quindío',5000,100,'킨디오는 콜롬비아 커피 벨트의 중심에 위치한 전통적인 커피 생산지로, 수십 년간 축적된 노하우와 세심한 품질 관리로 잘 알려져 있습니다. 해발 1,200~1,800m의 고도에서 재배되는 킨디오 커피는 밝은 산미와 균형 잡힌 바디, 그리고 열대과일과 견과류, 카라멜의 단맛이 조화를 이루는 것이 특징입니다. 주로 티피카(Typica), 카투라(Caturra), 카스티요(Castillo) 품종이 재배되며, 품질이 안정적이고 대중적인 인기를 얻고 있습니다.');
insert into product(CATEGORY, PRODUCT_NAME, PRICE, STOCK, INFO) VALUES ('COFFEE','Ethiopia Sidamo',5000,100,'에티오피아 남부의 시다모 지역은 고도 1,500~2,200m의 이상적인 기후 조건을 갖춘 커피 명산지로, 에티오피아 고유의 유전자 풀을 지닌 토착 품종들이 자생합니다. 시다모 커피는 라벤더나 베르가못 같은 플로럴 향과 함께, 레몬, 라임 등 시트러스 계열의 생동감 있는 산미를 지닌 것이 특징입니다. 워시드(세척식), 내추럴(건식) 가공 방식 모두 활발히 이루어지며, 고유한 개성과 향미로 전 세계 커피 애호가들에게 사랑받고 있습니다.');

insert into cart(user_id)  values ('kdu@example.com');
insert into cart(user_id)  values ('ash@example.com');
insert into cart(user_id)  values ('lkh@example.com');
insert into cart(user_id)  values ('lcr@example.com');
insert into cart(user_id)  values ('hyj@example.com');
insert into cart(user_id)  values ('test@email.com' );
insert into cart(user_id)  values ('test2@email.com');

insert into cart_details(cart_id, product_id, product_cnt, CREATED_AT) values (7,3,10,'2025-04-01 10:23:30');
insert into cart_details(cart_id, product_id, product_cnt, CREATED_AT) values (7,4,20,'2025-04-01 10:23:30');

insert into cart_details(cart_id, product_id, product_cnt, CREATED_AT) values (6,1,50,'2025-04-01 10:23:30');
insert into cart_details(cart_id, product_id, product_cnt, CREATED_AT) values (6,2,30,'2025-04-01 10:23:30');

insert into cart_details(cart_id, product_id, product_cnt, CREATED_AT) values (1,1,1,'2025-04-01 10:23:30');
insert into cart_details(cart_id, product_id, product_cnt, CREATED_AT) values (1,2,1,'2025-04-01 10:23:30');
insert into cart_details(cart_id, product_id, product_cnt, CREATED_AT) values (1,3,1,'2025-04-01 10:23:30');
insert into cart_details(cart_id, product_id, product_cnt, CREATED_AT) values (1,4,1,'2025-04-01 10:23:30');

insert into cart_details(cart_id, product_id, product_cnt, CREATED_AT) values (2,1,2,'2025-04-02 10:23:30');
insert into cart_details(cart_id, product_id, product_cnt, CREATED_AT) values (2,2,2,'2025-04-02 10:23:30');
insert into cart_details(cart_id, product_id, product_cnt, CREATED_AT) values (2,3,2,'2025-04-02 10:23:30');
insert into cart_details(cart_id, product_id, product_cnt, CREATED_AT) values (2,4,2,'2025-04-02 10:23:30');

insert into cart_details(cart_id, product_id, product_cnt, CREATED_AT) values (3,1,3,'2025-04-03 10:23:30');
insert into cart_details(cart_id, product_id, product_cnt, CREATED_AT) values (3,2,3,'2025-04-03 10:23:30');
insert into cart_details(cart_id, product_id, product_cnt, CREATED_AT) values (3,3,3,'2025-04-03 10:23:30');
insert into cart_details(cart_id, product_id, product_cnt, CREATED_AT) values (3,4,3,'2025-04-03 10:23:30');

insert into cart_details(cart_id, product_id, product_cnt, CREATED_AT) values (4,1,4,'2025-04-05 10:23:30');
insert into cart_details(cart_id, product_id, product_cnt, CREATED_AT) values (4,2,4,'2025-04-05 10:23:30');
insert into cart_details(cart_id, product_id, product_cnt, CREATED_AT) values (4,3,4,'2025-04-05 10:23:30');
insert into cart_details(cart_id, product_id, product_cnt, CREATED_AT) values (4,4,4,'2025-04-05 10:23:30');

INSERT INTO `order`(order_id, user_id, ordered_at, expect_deliveried_at, address, post_number, total_price, order_items, activated)
VALUES
    (1, 'kdu@example.com', '2025-04-01', '2025-04-03', '서울 강남구', '12345', 10000, 2, true),
    (2, 'ash@example.com', '2025-04-02', '2025-04-04', '서울 마포구', '23456', 15000, 3, true),
    (3, 'lkh@example.com', '2025-04-03', '2025-04-05', '서울 성동구', '34567', 20000, 4, true),
    (4, 'lcr@example.com', '2025-04-04', '2025-04-06', '서울 영등포구', '45678', 5000, 1, true),
    (5, 'hyj@example.com', '2025-04-05', '2025-04-07', '서울 종로구', '56789', 10000, 2, true),
    (6, 'admin@example.com', '2025-04-06', '2025-04-08', '서울 중구', '67890', 15000, 3, true);

INSERT INTO order_details(order_details_id, order_id, product_id, order_cnt, product_price)
VALUES
    (1, 1, 1, 1, 5000),
    (2, 1, 2, 1, 5000),
    (3, 2, 2, 2, 5000),
    (4, 2, 3, 1, 5000),
    (5, 3, 1, 1, 5000),
    (6, 3, 2, 1, 5000),
    (7, 3, 3, 1, 5000),
    (8, 3, 4, 1, 5000),
    (9, 4, 4, 1, 5000),
    (10, 5, 2, 2, 5000),
    (11, 6, 1, 3, 5000);
