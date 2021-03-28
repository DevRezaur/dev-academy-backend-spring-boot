INSERT INTO users (user_id, email, password)
VALUES('101', 'rezaur@gmail.com', 'iamadmin');

INSERT INTO users (user_id, email, password)
VALUES('102', 'sanzida@gmail.com', 'iamuser');

INSERT INTO roles
VALUES(1, 'ADMIN');

INSERT INTO roles
VALUES(2, 'USER');

INSERT INTO user_role
VALUES('101', 1);

INSERT INTO user_role
VALUES('102', 2);