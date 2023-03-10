DROP TABLE IF EXISTS products;
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
VALUES(1,'admin','admin@gmail.com','bf6b5bdb74c79ece9fc0ad0ac9fb0359f9555d4f35a83b2e6ec69ae99e09603d','+37067777777');
INSERT INTO users (id,username,email,password,phone)
VALUES(2,'user','user@gmail.com','bf6b5bdb74c79ece9fc0ad0ac9fb0359f9555d4f35a83b2e6ec69ae99e09603d','+37067111177');

CREATE TABLE products
(
    id                          BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name                        varchar(30) NOT NULL,
    description                 text NOT NULL,
    price                       float NOT NULL,
    user_id                     BIGINT NOT NULL,
    CONSTRAINT products_pk      PRIMARY KEY (id),
    FOREIGN KEY(user_id) 
      REFERENCES users(id)
);

INSERT INTO products (id,name,description,price,user_id)
VALUES(1,'telefonas','naudotas',150,1);
INSERT INTO products (id,name,description,price,user_id)
VALUES(2,'kompiuteris','naujas',1000,1);
INSERT INTO products (id,name,description,price,user_id)
VALUES(3,'vaizdo plokste','pusiau nauja',800,2);