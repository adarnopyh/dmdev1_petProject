DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE products
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    sku  VARCHAR(100) NOT NULL UNIQUE
);
insert into products (name, sku)
VALUES ('Super Cool Cleaner', 'SCL99337722'),
       ('Best Test', 'BST22553311'),
       ('Fancy Glider', 'FGL11223355');