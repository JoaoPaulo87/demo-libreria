CREATE DATABASE template_database;

use template_database;

CREATE TABLE users (
id int auto_increment primary key,
username varchar(56),
password varchar(256)
);

CREATE TABLE roles(
id int auto_increment primary key,
name varchar(56)
);

CREATE TABLE user_roles (
userid int,
roleid int,
PRIMARY KEY (userid,roleid)
);

insert into roles(name) values ('ROLE_USER'), ('ROLE_MODERATOR'), ('ROLE_ADMIN');

