DROP SCHEMA IF EXISTS cupcakes;
CREATE SCHEMA cupcakes;
USE cupcakes;

CREATE TABLE user(
username VARCHAR(40) PRIMARY KEY, 
password VARCHAR(40),
balance DOUBLE(5,2)
);

CREATE TABLE toppings(
topping VARCHAR(40) PRIMARY KEY,
price DOUBLE(3,2)
);

CREATE TABLE bottoms(
bottom VARCHAR(40) PRIMARY KEY,
price DOUBLE(3,2)
);

CREATE TABLE ordre(
FK_user VARCHAR(40),
FOREIGN KEY (FK_user) REFERENCES user (username),
FK_bottoms VARCHAR(40),
FOREIGN KEY (FK_bottoms) REFERENCES bottoms (bottom),
FK_toppings VARCHAR(40),
FOREIGN KEY (FK_toppings) REFERENCES toppings (topping)
);

INSERT INTO bottoms(bottom, price) VALUES('Chocolate', 5.00);
INSERT INTO bottoms(bottom, price) VALUES('Vanilla', 5.00);
INSERT INTO bottoms(bottom, price) VALUES('Nutmeg', 5.00);
INSERT INTO bottoms(bottom, price) VALUES('Pistacio', 6.00);
INSERT INTO bottoms(bottom, price) VALUES('Almond', 7.00);

INSERT INTO toppings(topping, price) VALUES('Chocolate', 5.00);
INSERT INTO toppings(topping, price) VALUES('Blueberry', 5.00);
INSERT INTO toppings(topping, price) VALUES('Rasberry', 5.00);
INSERT INTO toppings(topping, price) VALUES('Crispy', 6.00);
INSERT INTO toppings(topping, price) VALUES('Strawberry', 6.00);
INSERT INTO toppings(topping, price) VALUES('Rum/Raisin', 7.00);
INSERT INTO toppings(topping, price) VALUES('Orange', 8.00);
INSERT INTO toppings(topping, price) VALUES('Lemon', 8.00);
INSERT INTO toppings(topping, price) VALUES('Blue cheese', 9.00);
