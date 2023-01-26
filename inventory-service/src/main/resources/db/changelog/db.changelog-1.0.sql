--liquibase formatted sql

--changeset avi_nelson:1
CREATE TABLE IF NOT EXISTS inventory
(
    id       SERIAL PRIMARY KEY ,
    sku_code VARCHAR(255),
    quantity INT
);
