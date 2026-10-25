create table book (
    book_id int auto_increment,
    isbn varchar(17) not null unique,
    title varchar(100) not null,
    author varchar(30) not null,
    total_copies int not null,
    available_copies int not null,
    primary key (book_id)
);

create table member (
    member_id int auto_increment,
    member_name varchar(30) not null,
    email varchar(50) not null unique,
    phone varchar(20) not null unique,
    primary key (member_id)
);

create table borrowing (
    borrow_id int auto_increment,
    book_id int not null,
    member_id int not null,
    issue_date date not null,
    due_date date not null,
    return_date date null,
    primary key (borrow_id),
    foreign key (book_id) references book(book_id),
    foreign key (member_id) references member(member_id)
);