-- tạo cơ sở dữ liệu
create database ex03_mysql;
-- tạo bảng
create table ex03_mysql.Inventory(
	id int not null primary key,
    inventory_code varchar(10) not null,
    inventory_name varchar(100) not null,
    location varchar(1024) not null,
    created_at datetime,
    updated_at datetime
);
create table ex03_mysql.Category(
	id int not null primary key,
    category_code varchar(10) not null,
    category_name varchar(100) not null,
    description varchar(1024),
    created_at datetime,
    updated_at datetime
);
create table ex03_mysql.Product(
	id int not null primary key,
    product_code varchar(10) not null,
    category_id int not null,
    inventory_id int not null,
    product_name varchar(255) not null,
    description varchar(1024),
    image_path varchar(255),
    quantity int,
    sold int,
    price decimal,
    created_at datetime,
    updated_at datetime
);

-- thêm kho, danh mục sản phẩm, sản phẩm
insert into ex03_mysql.Inventory (id, inventory_code, inventory_name, location, created_at, updated_at) 
values (1, 'K001', 'inventory 1', 'location 1', now(), null);
insert into ex03_mysql.Inventory (id, inventory_code, inventory_name, location, created_at, updated_at) 
values (2, 'K002', 'inventory 2', 'location 2', now(), null);
insert into ex03_mysql.Inventory (id, inventory_code, inventory_name, location, created_at, updated_at) 
values (3, 'K003', 'inventory 3', 'location 3', now(), null);

insert into ex03_mysql.Category (id, category_code, category_name, description, created_at, updated_at) 
values (1, 'C001', 'category 1', 'description 1', now(), null);
insert into ex03_mysql.Category (id, category_code, category_name, description, created_at, updated_at) 
values (2, 'C002', 'category 2', 'description 2', now(), null);
insert into ex03_mysql.Category (id, category_code, category_name, description, created_at, updated_at) 
values (3, 'C003', 'category 3', 'description 3', now(), null);
insert into ex03_mysql.Category (id, category_code, category_name, description, created_at, updated_at) 
values (4, 'C004', 'category 4', 'description 4', now(), null);
insert into ex03_mysql.Category (id, category_code, category_name, description, created_at, updated_at) 
values (5, 'C005', 'category 5', 'description 5', now(), null);
insert into ex03_mysql.Category (id, category_code, category_name, description, created_at, updated_at) 
values (6, 'C006', 'category 6', 'description 6', now(), null);

insert into ex03_mysql.Product 
(id, product_code, category_id, inventory_id, product_name, description, image_path, quantity, sold, price, created_at, updated_at) 
values (1, 'P001', 1, 1, 'name 1', 'description 1', '', 10, 5, 2500000, now(), null);
insert into ex03_mysql.Product 
(id, product_code, category_id, inventory_id, product_name, description, image_path, quantity, sold, price, created_at, updated_at) 
values (2, 'P002', 2, 1, 'name 2', 'description 2', '', 11, 6, 3500000, now(), null);
insert into ex03_mysql.Product 
(id, product_code, category_id, inventory_id, product_name, description, image_path, quantity, sold, price, created_at, updated_at) 
values (3, 'P003', 3, 1, 'name 3', 'description 3', '', 12, 7, 4500000, now(), null);
insert into ex03_mysql.Product 
(id, product_code, category_id, inventory_id, product_name, description, image_path, quantity, sold, price, created_at, updated_at) 
values (4, 'P004', 4, 1, 'name 4', 'description 4', '', 13, 8, 5500000, now(), null);
insert into ex03_mysql.Product 
(id, product_code, category_id, inventory_id, product_name, description, image_path, quantity, sold, price, created_at, updated_at) 
values (5, 'P005', 5, 1, 'name 5', 'description 5', '', 14, 9, 6500000, now(), null);
insert into ex03_mysql.Product 
(id, product_code, category_id, inventory_id, product_name, description, image_path, quantity, sold, price, created_at, updated_at) 
values (6, 'P006', 1, 2, 'name 6', 'description 6', '', 15, 10, 7500000, now(), null);
insert into ex03_mysql.Product 
(id, product_code, category_id, inventory_id, product_name, description, image_path, quantity, sold, price, created_at, updated_at) 
values (7, 'P007', 2, 2, 'name 7', 'description 7', '', 16, 11, 8500000, now(), null);
insert into ex03_mysql.Product 
(id, product_code, category_id, inventory_id, product_name, description, image_path, quantity, sold, price, created_at, updated_at) 
values (8, 'P008', 3, 2, 'name 8', 'description 8', '', 17, 12, 9500000, now(), null);
insert into ex03_mysql.Product 
(id, product_code, category_id, inventory_id, product_name, description, image_path, quantity, sold, price, created_at, updated_at) 
values (9, 'P009', 4, 2, 'name 9', 'description 9', '', 18, 13, 10500000, now(), null);
insert into ex03_mysql.Product 
(id, product_code, category_id, inventory_id, product_name, description, image_path, quantity, sold, price, created_at, updated_at) 
values (10, 'P010', 5, 2, 'name 10', 'description 10', '', 19, 14, 11500000, now(), null);
insert into ex03_mysql.Product 
(id, product_code, category_id, inventory_id, product_name, description, image_path, quantity, sold, price, created_at, updated_at) 
values (11, 'P011', 5, 2, 'name 11', 'description 11', '', 19, 14, 11500000, now(), null);

-- sửa kho, danh mục sản phẩm, sản phẩm theo id
update ex03_mysql.Inventory set Inventory_name = 'inventory 1_u', updated_at = now() where id = 1;
update ex03_mysql.Category set category_name = 'Apple', updated_at = now() where id = 1;
update ex03_mysql.Product set product_name = 'dien thoai 1', updated_at = now()  where id = 1;
 
 -- xóa sản phẩm, kho, danh mục sản phẩm theo id
delete from ex03_mysql.Product where id = 11;
delete from ex03_mysql.Inventory where id = 3;
delete from ex03_mysql.Category where id = 6;

-- Lọc các sản phẩm có chứa từ 'Điện Thoại' và thuộc loại danh mục có tên là 'Apple'
select p.* from ex03_mysql.Product as p join ex03_mysql.Category as c on (p.category_id = c.id) 
where p.product_name LIKE '%dien thoai%' and c.category_name = 'Apple';

-- Đếm số lượng sản phẩm trong mỗi loại danh mục, sắp xếp theo thứ tự giảm dần
select c.category_name, count(p.id) as products, sum(p.quantity) as number_of_products 
from ex03_mysql.Product as p join ex03_mysql.Category as c 
on (p.category_id = c.id) 
group by c.category_name 
order by number_of_products desc;

-- Xóa danh mục đồng thời xóa luôn các sản phẩm thuộc danh mục đó (Có sử dụng transaction)
SET SQL_SAFE_UPDATES = 0; -- cho phép xóa hàng khi điều kiện không phải là khóa chính
SET autocommit = 0; -- tắt tự động commit

start transaction;
savepoint delete_start; -- tạo save point để có thể rollback
delete from ex03_mysql.Category where id = 5;
delete from ex03_mysql.Product where category_id = 5;
commit;

rollback to delete_start; -- quay trở lại savepoint

-- Procedure lấy 10 sản phẩm có số lượng bán nhiều nhất
delimiter //
create procedure ex03_mysql.get_max_sold_products()
begin
	select * from ex03_mysql.Product 
    order by sold desc
    limit 10 ;
end;
delimiter;

call ex03_mysql.get_max_sold_products();

 