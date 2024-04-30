create database asset_management;
use asset_management;

create table employees(
employee_id int,
name varchar(30),
department varchar(30),
email varchar(40),
password varchar(10),
primary key(employee_id));

drop table assets;
create table assets(
asset_id int,
name varchar(30),
type varchar(30),
serial_number int,
purchase_date date,
location varchar(30),
status varchar(30),
owner_id int,
primary key(asset_id),
foreign key(owner_id) references employees(employee_id));

create table maintenance_records(
maintenance_id int,
asset_id int,
maintenance_date date,
description varchar(100),
cost decimal(9,2),
primary key(maintenance_id),
foreign key(asset_id) references assets(asset_id));

create table asset_allocations(
allocation_id int,
asset_id int,
employee_id int,
allocation_date date,
return_date date,
primary key(allocation_id ),
foreign key(asset_id) references assets(asset_id),
foreign key(employee_id) references employees(employee_id));


create table reservations(
reservation_id int,
asset_id int,
employee_id int,
reservation_date date,
start_date date,
end_date date,
status varchar(30),
primary key(reservation_id),
foreign key(asset_id) references assets(asset_id),
foreign key(employee_id) references employees(employee_id)
);

