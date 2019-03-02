CREATE SCHEMA IF NOT EXISTS application AUTHORIZATION postgres;

DROP TABLE IF EXISTS application.users;
 
CREATE TABLE application.users (
    id Bigserial PRIMARY KEY NOT NULL,
    firstName varchar(100) NOT NULL,
    lastName varchar(100) NOT NULL
);