create user 'varun'@'localhost' identified by '123';
grant all privileges on *.* to 'varun'@'localhost' identified by '123';


create database college;
use college;


create table student(
student_id int not null,
student_name varchar(30) not null,
program varchar(30) not null,
semester int not null,
email varchar(30) not null unique,
primary key(student_id)
);

create table subject(
subject_id int not null,
subject_name varchar(30) not null,
credits int not null,
semester int not null,
primary key(subject_id)
);

create table examination(
exam_id int not null,
subject_id int not null,
exam_date date,
max_marks decimal(5,2) not null,
primary key(exam_id),
foreign key(subject_id) references subject(subject_id)
);

create table result(
student_id int not null,
exam_id int not null,
marks_obtained decimal(5,2) not null,
grade char(1) not null,
primary key(student_id, exam_id),
foreign key(student_id) references student(student_id),
foreign key(exam_id) references examination(exam_id)
);

desc student;
desc subject;
desc examination;
desc result;

insert into student(student_id, student_name, program, semester, email) values
(1, "Varun", "ME CSE", 1, "varun@gmail.com"),
(2, "Arun", "ME AIML", 1, "arun@gmail.com");

insert into subject(subject_id, subject_name, credits, semester) values
(1, "Java", 10, 1),
(2, "Linear algebra", 10, 1);

insert into examination(exam_id, subject_id, exam_date, max_marks) values
(1, 1, CURDATE(), 100.0),
(2, 2, CURDATE(), 100.0);

insert into result(student_id, exam_id, marks_obtained, grade) values
(1, 1, 99.0, 'A'),
(1, 2, 99.0, 'A');

select * from student;
select * from subject;
select * from examination;
select * from result;

