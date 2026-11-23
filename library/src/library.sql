add .jar 
file > project structure > module > + > JARs or Directories > select file > OK

CREATE USER 'nitr0x'@'localhost' IDENTIFIED BY '123';

GRANT ALL PRIVILEGES ON *.* TO 'nitr0x'@'localhost' IDENTIFIED BY '123';

create table book (
book_id int not null,
isbn char(10) not null,
title varchar(30) not null,
author varchar(30) not null,
total_copies int not null,
copies_available int not null,
primary key(book_id)
);

create table member(
member_id int not null,
member_name varchar(30) not null,
email varchar(30) unique not null,
phone int unique not null,
primary key (member_id)
);

create table borrowing (
borrowing_id int not null,
book_id int not null,
member_id int not null,
issue_date date not null,
due_date date not null,
return_date date not null,
primary key (borrowing_id),
foreign key (book_id) references book(book_id),
foreign key (member_id) references member(member_id)
);


desc book;
desc member;
desc borrowing;


insert into book
(book_id, isbn, title, author, total_copies, copies_available)
values
(1, 'BOOK001', "Java basics", "John", 10, 10),
(2, 'BOOK002', "Python basics", "Jake", 15, 15);

insert into member
(member_id, member_name, email, phone)
values
(1, "Varun", "varun@gmail.com", "6767676767"),
(2, "Akil", "akil@gmail.com", "9988779988");


insert into borrowing
(borrowing_id, book_id, member_id, issue_date, due_date, return_date)
values
(1, 2, 1, "2026-11-23", "2026-11-29", null),
(1, 2, 1, "2026-11-24", "2026-11-30", null);

select * from book;
select * from member;
select * from borrowing;


insert into book (book_id, isbn, title, author, total_copies, copies_available) values (?, ?, ?, ?, ?, ?)