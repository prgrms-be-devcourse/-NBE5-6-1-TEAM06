insert into team(TEAM_ID, NAME) values (1000, 'grepp');
insert into team(TEAM_ID, NAME) values (1001, 'programmers');

insert into team_member(TEAM_ID, USER_ID, ROLE)
values(1000, 'super', 'LEADER');
insert into team_member(TEAM_ID, USER_ID, ROLE)
values(1000, 'test', 'MEMBER');

insert into team_member(TEAM_ID, USER_ID, ROLE)
values(1001, 'super', 'MEMBER');
insert into team_member(TEAM_ID, USER_ID, ROLE)
values(1001, 'test', 'LEADER');

insert into book(bk_idx, author, amount, category, title, created_at)
values (1000, '김애란', '3', 'NOVEL', '비행운', '2023-03-06 3:02:40');
insert into book(bk_idx, author, amount, category, title, created_at)
values (1001, '조앤롤링', '4', 'NOVEL', '해리포터', '2023-04-06 3:02:40');
insert into book(bk_idx, author, amount, category, title, created_at)
values (1002, '에리히프롬', '5', 'HUMANITY', '사랑의기술', '2023-03-06 3:02:40');
insert into book(bk_idx, author, amount, category, title, created_at)
values (1003, '비트겐슈타인', '6', 'HUMANITY', '논리철학논고', '2025-04-06 3:02:40');
insert into book(bk_idx, author, amount, category, title, created_at)
values (1004, '황정은', '7', 'NOVEL', '디디의우산', '2025-04-06 3:02:40');

insert into rent(rent_id, title, user_id, created_at)
values (100001, '비행운 외 1권', 'test', '2023-03-06 3:02:40');
insert into rent(rent_id, title, user_id, created_at)
values (100002, '비행운 외 1권', 'jpa', '2023-04-06 3:02:40');
insert into rent(rent_id, title, user_id, created_at)
values (100003, '비행운 외 1권', 'security', '2023-03-06 3:02:40');
insert into rent(rent_id, title, user_id, created_at)
values (100004, '디디의 우산 외 1권', 'test', '2025-04-06 3:02:40');
insert into rent(rent_id, title, user_id, created_at)
values (100005, '논리철학논고 외 1권', 'test', '2025-04-06 3:02:40');

insert into rent_book(rb_idx, rent_id, bk_idx, book_title, state, return_date, created_at)
values (200001, 100001, 1000, '비행운', 'RENT', '2023-03-13 3:02:40', '2023-03-06 3:02:40');
insert into rent_book(rb_idx, rent_id, bk_idx, book_title, state, return_date, created_at)
values (200002, 100001, 1001, '해리포터', 'RENT', '2023-04-13 3:02:40', '2023-04-06 3:02:40');
insert into rent_book(rb_idx, rent_id, bk_idx, book_title, state, return_date, created_at)
values (200003, 100002, 1000, '비행운','RENT', '2023-03-13 3:02:40', '2023-03-06 3:02:40');
insert into rent_book(rb_idx, rent_id, bk_idx, book_title, state, return_date, created_at)
values (200004, 100002, 1001, '해리포터', 'RENT', '2025-04-13 3:02:40', '2025-03-06 3:02:40');
insert into rent_book(rb_idx, rent_id, bk_idx, book_title, state, return_date, created_at)
values (200005, 100003, 1000, '비행운', 'RENT', '2025-04-13 3:02:40', '2025-03-06 3:02:40');
insert into rent_book(rb_idx, rent_id, bk_idx, book_title, state, return_date, created_at)
values (200006, 100003, 1001, '해리포터', 'RENT', '2023-03-13 3:02:40', '2023-03-06 3:02:40');
insert into rent_book(rb_idx, rent_id, bk_idx, book_title, state, return_date, created_at)
values (200007, 100004, 1004, '디디의우산', 'RENT', '2023-04-13 3:02:40', '2023-04-06 3:02:40');
insert into rent_book(rb_idx, rent_id, bk_idx, book_title, state, return_date, created_at)
values (200008, 100004, 1003, '논리철학논고','RENT', '2023-03-13 3:02:40', '2023-03-06 3:02:40');
insert into rent_book(rb_idx, rent_id, bk_idx, book_title, state, return_date, created_at)
values (200009, 100005, 1004, '디디의우산', 'RENT', '2025-04-13 3:02:40', '2025-03-06 3:02:40');
insert into rent_book(rb_idx, rent_id, bk_idx, book_title, state, return_date, created_at)
values (200010, 100005, 1003, '논리철학논고', 'RENT', '2025-04-13 3:02:40', '2025-03-06 3:02:40');

insert into rent_history(rh_idx, rb_idx, rent_id, bk_idx, state, created_at)
values (300001, 200001, 100001, '1000', 'RENT', '2023-03-06 3:02:40');
insert into rent_history(rh_idx, rb_idx, rent_id, bk_idx, state, created_at)
values (300002, 200002, 100001, '1001', 'RENT', '2023-04-06 3:02:40');
insert into rent_history(rh_idx, rb_idx, rent_id, bk_idx, state, created_at)
values (300003, 200003, 100002, '1000', 'RENT', '2023-03-06 3:02:40');
insert into rent_history(rh_idx, rb_idx, rent_id, bk_idx, state, created_at)
values (300004, 200004, 100002, '1001', 'RENT', '2025-04-06 3:02:40');
insert into rent_history(rh_idx, rb_idx, rent_id, bk_idx, state, created_at)
values (300005, 200005, 100003, '1000', 'RENT', '2025-04-06 3:02:40');
insert into rent_history(rh_idx, rb_idx, rent_id, bk_idx, state, created_at)
values (300006, 200006, 100003, '1001', 'RENT', '2023-03-06 3:02:40');
insert into rent_history(rh_idx, rb_idx, rent_id, bk_idx, state, created_at)
values (300007, 200007, 100004, '1004', 'RENT', '2023-04-06 3:02:40');
insert into rent_history(rh_idx, rb_idx, rent_id, bk_idx, state, created_at)
values (300008, 200008, 100004, '1003', 'RENT', '2023-03-06 3:02:40');
insert into rent_history(rh_idx, rb_idx, rent_id, bk_idx, state, created_at)
values (300009, 200009, 100005, '1004', 'RENT', '2025-04-06 3:02:40');
insert into rent_history(rh_idx, rb_idx, rent_id, bk_idx, state, created_at)
values (300010, 200010, 100005, '1003', 'RENT', '2025-04-06 3:02:40');
