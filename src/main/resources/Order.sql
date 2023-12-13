DROP DATABASE IF EXISTS springbootdb;
CREATE DATABASE springbootdb; 
USE springbootdb;

DROP TABLE IF EXISTS OrderDetails;

CREATE TABLE IF NOT EXISTS OrderDetails (
  orderId int(11) unsigned NOT NULL AUTO_INCREMENT,
  productName varchar(20) DEFAULT NULL,
  quantity int(5) DEFAULT NULL,
  status varchar(20) DEFAULT NULL,
  billAmount double DEFAULT NULL,
  PRIMARY KEY (orderId)
) ENGINE=InnoDB AUTO_INCREMENT=1006 DEFAULT CHARSET=utf8;

insert into OrderDetails (orderId, productName, quantity, billAmount, status) values (1001, 'HP-Laptop', 1, 82000.0, 'Confirmed');
insert into OrderDetails (orderId, productName, quantity, billAmount, status) values (1002, 'Boat-SmartWatch', 2, 32000.0, 'Intransit');
insert into OrderDetails (orderId, productName, quantity, billAmount, status) values (1003, 'Lenova-Tablet', 2, 55000.0, 'Delivered');
insert into OrderDetails (orderId, productName, quantity, billAmount, status) values (1004, 'Mac-Laptop', 1, 156000.0, 'Confirmed');
insert into OrderDetails (orderId, productName, quantity, billAmount, status) values (1005, 'HP-Printer', 1, 22000.0, 'OutForDelivery');
commit;
