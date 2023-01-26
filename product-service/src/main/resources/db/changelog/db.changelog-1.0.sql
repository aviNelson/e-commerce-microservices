--liquibase formatted sql

--changeset avi_nelson:1
CREATE TABLE IF NOT EXISTS product
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(255),
    description VARCHAR(255),
    price       DECIMAL
    );