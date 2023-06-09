

use quiz;


create table admin(
	id int primary key not null auto_increment,
    email varchar(255) not null,
	password varchar(255) not null);
    

insert into admin(email, password)values("sarozpradhan64@gmail.com", "kingsrz");