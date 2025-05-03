DROP TABLE IF EXISTS price_levels CASCADE;
CREATE TABLE price_levels
(
    id   SERIAL PRIMARY KEY,
    code VARCHAR(20) UNIQUE NOT NULL
);

insert into price_levels (code)
VALUES ('last'),
       ('last10'),
       ('last15');