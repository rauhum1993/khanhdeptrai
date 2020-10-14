drop database if exists thi_module3;
create database thi_module3;
use thi_module3;
create table category (
		id_category int primary key,
		name_category varchar(255) 
       
    );
create table product (
		product_id varchar(45) primary key ,
        product_name varchar(45) not null,
        product_price varchar(45) not null,
        product_numbers varchar(45) not null,
        product_color varchar(45) not null,
        product_status varchar(45) not null,
        product_category varchar(45) not null
       

    );
insert into category(id_category,name_category ) 
	values 	('1','Phone'),
		('3','Tivi'),
		('4','Tủ lạnh'),
			('2','Máy Giặt');
            
			

insert into product (product_id,product_name,product_price,product_numbers,
product_color,product_status,product_category)
	values 	('1','Iphone 11','799.0','12','Black,yello,green','UsA','Phone'),
	 	('2','Iphone 11 pro','799.0','12','Black,yello,green','UsA','Phone' ),
	 	('3','Iphone 11 x','799.0','12','Black,yello,green','UsA','Phone' ),
	 	('4','Iphone 11','799.0','12','Black,yello,green','UsA','Phone' );
			
			
            