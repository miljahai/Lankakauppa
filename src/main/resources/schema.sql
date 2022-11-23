SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS yarn;
DROP TABLE IF EXISTS pattern;
DROP TABLE IF EXISTS application_user;
SET FOREIGN_KEY_CHECKS=1;

CREATE TABLE yarn
(id BIGINT NOT NULL AUTO_INCREMENT,
brand VARCHAR(50) NOT NULL, 
name VARCHAR(50) NOT NULL, 
description VARCHAR (50),
price DOUBLE,
PRIMARY KEY (id)
);

INSERT INTO yarn (brand, name, description, price)
VALUES ("Novita", "7-veljestä", "75%villa 25%polyamidi", 2.7),
("DROPS", "Karisma", "100%villa", 2.7), ("Novita", "Hygge Wool", "100%villa", 5.9);

CREATE TABLE pattern 
(id BIGINT NOT NULL AUTO_INCREMENT,
name VARCHAR(50) NOT NULL,
content VARCHAR(1000),
yarnid BIGINT,
PRIMARY KEY (id),
FOREIGN KEY (yarnid) REFERENCES yarn(id));

INSERT INTO pattern (name, content, yarnid)
VALUES ("Lapaset", "Neulo joustinneuleella resorit, sitten sileää, kavenna, päättele ja tee peukalot", 1),
("Paita", "Neulo hieno paita", 2);

CREATE TABLE application_user
(id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY
, firstname VARCHAR(100) NOT NULL
, lastname VARCHAR(100) NOT NULL
, role VARCHAR(100) NOT NULL
, username VARCHAR(250) NOT NULL
, password_hash VARCHAR(250) NOT NULL);

INSERT INTO application_user (firstname, lastname, username, role, password_hash)
VALUES ("Milja", "Haiko", "USER", "user", "$2a$10$GL7Mjm745jTV5KXEzC3nI.7OC3wBluMPmvHqYnZDJ1hIR/lGSStHu"),
("Milja", "Haiko", "ADMIN", "admin", "$2a$10$yKd/VEAj6KdYyAhR14Xx1.W/xS1sixv0SnUD.4m/pGRNdp/a0Y1O6");

SELECT * FROM yarn;
SELECT * FROM pattern;
SELECT * FROM application_user;