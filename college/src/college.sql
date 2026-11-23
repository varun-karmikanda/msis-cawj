add .jar 
file > project structure > module > + > JARs or Directories > select file > OK



CREATE USER 'nitr0x'@'localhost' IDENTIFIED BY '123';

GRANT ALL PRIVILEGES ON *.* TO 'nitr0x'@'localhost' IDENTIFIED BY '123';


CREATE TABLE student (
student_id INT NOT NULL,
student_name VARCHAR(30) NOT NULL,
program VARCHAR(30) NOT NULL,
semester INT NOT NULL,
email VARCHAR(30) NOT NULL UNIQUE,
PRIMARY KEY (student_id)
);

CREATE TABLE subject (
subject_id INT NOT NULL,
subject_name VARCHAR(30) NOT NULL,
credits INT NOT NULL,
semester INT NOT NULL,
PRIMARY KEY (subject_id)
);

CREATE TABLE examination (
exam_id INT NOT NULL,
subject_id INT NOT NULL,
exam_date DATE,
max_marks DECIMAL(5,2) NOT NULL,
PRIMARY KEY (exam_id),
FOREIGN KEY (subject_id) REFERENCES subject(subject_id)
);

CREATE TABLE result (
student_id INT NOT NULL,
subject_id INT NOT NULL,
marks_obtained DECIMAL(5,2) NOT NULL,
grade CHAR(1),
PRIMARY KEY (student_id, subject_id),
FOREIGN KEY (student_id) REFERENCES student(student_id),
FOREIGN KEY (subject_id) REFERENCES subject(subject_id)
);

DESC student;
DESC subject;
DESC examination;
DESC result;

INSERT INTO student
(student_id, student_name, program, semester, email)
VALUES 
(1, "Varun", "ME CSE", 1, "varun@gmail.com"),
(2, "Arun", "ME AIML", 1, "arun@gmail.com");

INSERT INTO subject
(subject_id, subject_name, credits, semester)
VALUES
(1, "Java", 10, 1),
(2, "Linear algebra", 10, 1);

INSERT INTO examination
(exam_id, subject_id, exam_date, max_marks)
VALUES
(1, 1, '2026-11-14', 100.0),
(2, 2, '2026-11-16', 100.0);

INSERT INTO result
(student_id, subject_id, marks_obtained, grade)
VALUES
(1, 1, 99.0, 'A'),
(1, 2, 99.0, 'A');

SELECT * FROM student;
SELECT * FROM subject;
SELECT * FROM examination;
SELECT * FROM result;

set up the properties file

create a db connection object
test

student dao