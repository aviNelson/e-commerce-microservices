--liquibase formatted sql

--changeset avi_nelson:1
CREATE TABLE IF NOT EXISTS orders
(
    id           SERIAL PRIMARY KEY,
    order_number VARCHAR(256)
);

--changeset avi_nelson:2
CREATE TABLE IF NOT EXISTS orders_item
(
    id          SERIAL PRIMARY KEY,
    order_id INT REFERENCES orders(id),
    sku_code VARCHAR(256),
    quantity INT,
    price    DECIMAL
);