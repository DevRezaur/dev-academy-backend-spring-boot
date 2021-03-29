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
	'Spring Framework is the most demanded Java enterprise framework. 
     Learn Spring Framework 5.0 with Spring Boot 2.0 now. And fulfill your dream to become a 
     enterprise application developer.',
     'spring.jpg',
     'running'
);

INSERT INTO courses (course_id, title, desc, img_url, status)
VALUES(
	'10002',
	'Python with Django',
	'Python is growing so fast. Currently its the number one programming language. 
     From general programming to machine learning, anything you can do with Python. 
     So learn Python today with its amazing Django Framework.',
     'python.png',
     'running'
);

INSERT INTO courses (course_id, title, desc, img_url, status)
VALUES(
	'10003',
	'React Js & Styled Components',
	'React JS is the most loved JavaScript library around the world. It was 
     developed by Facebook Corporation. It is popular beacuse of its easy learning 
     curve. More and more reple are switching to React.',
     'react.jpg',
     'running'
);