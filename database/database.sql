DROP TABLE IF EXISTS users;

CREATE TABLE users
(
    id          BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    username    varchar(30) NOT NULL,
    email       varchar(50) NOT NULL,
    password    varchar(70) NOT NULL,
    phone       varchar(20) NOT NULL,
    CONSTRAINT users_pk PRIMARY KEY (id)
);

INSERT INTO users (id,username,email,password,phone)
VALUES(1,'admin','admin@gmail.com','admin123','+37067777777');