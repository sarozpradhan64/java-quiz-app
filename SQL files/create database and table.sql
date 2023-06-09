create database quiz;

use quiz;

create table questions(
	id int primary key not null auto_increment,
    question varchar(255) not null,
	opt1 varchar(255) not null,
    opt2 varchar(255) not null,
    opt3 varchar(255) not null,
    opt4 varchar(255) not null,
    correct varchar(255) not null
);