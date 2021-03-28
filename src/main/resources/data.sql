INSERT INTO users (user_id, fullname, email, password)
VALUES('101', 'Rezaur Rahman', 'rezaur@gmail.com', 'iamadmin');

INSERT INTO users (user_id, fullname, email, password)
VALUES('102', 'Sanzida Sultana', 'sanzida@gmail.com', 'iamuser');

INSERT INTO roles
VALUES(1, 'ADMIN');

INSERT INTO roles
VALUES(2, 'USER');

INSERT INTO user_role
VALUES('101', 1);

INSERT INTO user_role
VALUES('102', 2);

INSERT INTO courses (course_id, title, desc)
VALUES('10001', 'Java Spring & Spring Boot', 'This is a sample description');