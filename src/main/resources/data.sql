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

INSERT INTO courses (course_id, title, desc, img_url, status)
VALUES(
	'10001',
	'Java Spring & Spring Boot',
	'Spring Framework is the most demanded Java enterprise framework. Learn Spring Framework 5.0 with Spring Boot 2.0 now.',
     'spring.jpg',
     'running'
);

INSERT INTO courses (course_id, title, desc, img_url, status)
VALUES(
	'10002',
	'Python with Django',
	'Python is the number one programming language worldwide. From general programming to machine learning, anything you can do with Python.',
     'python.png',
     'running'
);

INSERT INTO courses (course_id, title, desc, img_url, status)
VALUES(
	'10003',
	'React Js & Styled Components',
	'React JS is the most loved JavaScript library around the world. It is popular because of its easy learning curve and scalability.',
     'react.jpg',
     'running'
);