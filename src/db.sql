drop table category;

create table category(
   cat_id              int not null auto_increment,
   cat_name            varchar(20),
   primary key (cat_id)
);

drop table product;

-- product cat_id:称为外键,它参照的是另外一张表的主键
create table product
(
   pro_id                  int not null auto_increment,
   pro_name                varchar(20),
   pro_price               decimal(8,2),
   pro_remark              longtext,
   pro_date                timestamp default CURRENT_TIMESTAMP,
   cat_id                  int,  
   primary key (pro_id)
);

insert into category (cat_name) values ('数码产品');
insert into category (cat_name) values ('服饰');
insert into category (cat_name) values ('儿童玩具');
insert into category (cat_name) values ('其它');

select * from category;

/* 数据入库测试*/
insert into product (pro_name,pro_price,pro_remark,cat_id) values ('computer',3000.00,'test....',1);
insert into product (pro_name,pro_price,pro_remark,cat_id) values ('computer2',4000.00,'test2....',1);
insert into product (pro_name,pro_price,pro_remark,cat_id) values ('Iphone6',6000.00,'test.....',2);
-- (page-1)*size =5
select * from product where name like '%xyz%' limit 5,5;