INSERT INTO users (user_id, fullname, img_url, contact, email, password)
VALUES('101', 'Rezaur Rahman', 'https://devrezaur.com/File-Bucket/image/rezaur.png', '01839100546', 'rezaur@gmail.com', 'iamadmin');

INSERT INTO users (user_id, fullname, img_url, contact, email, password)
VALUES('102', 'Sanzida Sultana', 'https://devrezaur.com/File-Bucket/image/sanzida.png', '01839100546', 'sanzida@gmail.com', 'iamuser');

INSERT INTO roles
VALUES(1, 'ADMIN');

INSERT INTO roles
VALUES(2, 'USER');

INSERT INTO user_role
VALUES('101', 1);

INSERT INTO user_role
VALUES('102', 2);

INSERT INTO courses (course_id, title, desc, image, img_url, status, price)
VALUES(
	'10001',
	'Java Spring & Spring Boot',
	'Spring Framework is the most demanded Java enterprise framework. Learn Spring Framework 5.0 with Spring Boot 2.0 now.',
    'spring.jpg',
    'https://devrezaur.com/File-Bucket/image/spring.jpg',
    'running',
    10000
);

INSERT INTO courses (course_id, title, desc, image, img_url, status, price)
VALUES(
	'10002',
	'Python with Django',
	'Python is the number one programming language worldwide. From general programming to machine learning, anything you can do with Python.',
    'python.png',
    'https://devrezaur.com/File-Bucket/image/python.png',
    'running',
    8000
);

INSERT INTO courses (course_id, title, desc, image, img_url, status, price)
VALUES(
	'10003',
	'React JS & Styled Components',
	'React JS is the most loved JavaScript library around the world. It is popular because of its easy learning curve and scalability.',
    'react.jpg',
    'https://devrezaur.com/File-Bucket/image/react.jpg',
    'running',
    5000
);

INSERT INTO payments (user_id, Course_id, amount, trx_code, status)
VALUES(
	102,
	10001,
	10000,
	'1811510597',
	'Clear'
);

INSERT INTO course_enrolled (user_id, course_id)
VALUES(
	102,
	10001
);