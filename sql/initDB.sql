CREATE DATABASE IF NOT EXISTS advertisepro;

USE advertisepro;

CREATE TABLE IF NOT EXISTS USERS
(
    ID INT PRIMARY KEY AUTO_INCREMENT,
    EMAIL VARCHAR(32) NOT NULL UNIQUE,
    PASSWORD VARCHAR(16) NOT NULL
);

CREATE TABLE IF NOT EXISTS CONTACTS
(
    ID INT PRIMARY KEY AUTO_INCREMENT,
    EMAIL VARCHAR(32) NOT NULL UNIQUE,
    PASSWORD VARCHAR(16) NOT NULL
);

CREATE TABLE IF NOT EXISTS CREDENTIALS
(
    LOGIN VARCHAR(32) PRIMARY KEY,
    PASSWORD VARCHAR(16) NOT NULL,

);