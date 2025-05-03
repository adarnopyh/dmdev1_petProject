DROP TABLE IF EXISTS product_prices CASCADE;
CREATE TABLE product_prices
(
    id             SERIAL PRIMARY KEY,
    product_id     INT            NOT NULL REFERENCES products (id) ON DELETE CASCADE,
    price_level_id INTEGER        NOT NULL REFERENCES price_levels (id),
    price          DECIMAL(10, 2) NOT NULL,
    UNIQUE (product_id, price_level_id)
);

insert into product_prices (product_id, price_level_id, price)
VALUES (1, 2, 19.99),
       (2, 1, 39.78),
       (3, 3, 48.55);