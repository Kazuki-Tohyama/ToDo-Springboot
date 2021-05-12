create database todotest;
CREATE TABLE todo (id INT AUTO_INCREMENT, name TEXT, isdone bool, userid INT, PRIMARY KEY (id));
CREATE TABLE user (userid INT AUTO_INCREMENT, username TEXT, password TEXT);
