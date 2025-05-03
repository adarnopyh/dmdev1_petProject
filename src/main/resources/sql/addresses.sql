-- CREATE SCHEMA company_storage;
-- DROP SCHEMA company_storage;


CREATE SCHEMA IF NOT EXISTS addresses;

DROP TABLE IF EXISTS addresses.no_county_cities CASCADE;
CREATE TABLE IF NOT EXISTS addresses.no_county_cities
(
    id   serial PRIMARY KEY,
    name varchar(100) UNIQUE NOT NULL
    );
INSERT INTO addresses.no_county_cities (name)
VALUES ('Ainaži'),
       ('Daugavpils'),
       ('Jelgava'),
       ('Jūrmala'),
       ('Liepāja'),
       ('Rēzekne'),
       ('Rīga'),
       ('Ventspils');

DROP TABLE IF EXISTS addresses.counties CASCADE;
CREATE TABLE IF NOT EXISTS addresses.counties
(
    id   serial PRIMARY KEY,
    name varchar(100) UNIQUE NOT NULL
    );
INSERT INTO addresses.counties (name)
VALUES ('Ādažu nov.'),
       ('Aglonas nov.'),
       ('Aizkraukles nov.'),
       ('Aizputes nov.'),
       ('Aknīstes nov.'),
       ('Alojas nov.'),
       ('Alsungas nov.'),
       ('Talsu nov.,'),
       ('Preiļu nov.'),
       ('Limbažu nov.'),
       ('Jēkabpils nov.'),
       ('Rēzeknes nov.'),
       ('Dobeles nov.'),
       ('Krāslavas nov.'),
       ('Mārupes nov.'),
       ('Ķekavas nov.'),
       ('Beverīnas nov.'),
       ('Dienvidkurzemes nov.'),
       ('Valmieras nov.'),
       ('Balvu nov.'),
       ('Ogres nov.'),
       ('Ludzas nov.');



DROP TABLE IF EXISTS addresses.parishes CASCADE;
CREATE TABLE IF NOT EXISTS addresses.parishes
(
    id        serial PRIMARY KEY,
    county_id integer      NOT NULL REFERENCES addresses.counties (id) ON DELETE CASCADE,
    name      varchar(100) NOT NULL UNIQUE
    );
INSERT INTO addresses.parishes (county_id, name)
VALUES (8, 'Abavas pag.'),
       (9, 'Aglonas pag.'),
       (10, 'Ainažu pag.'),
       (3, 'Aiviekstes pag.'),
       (9, 'Aizkalnes pag.'),
       (3, 'Aizkraukles pag.'),
       (11, 'Atašienes pag.'),
       (12, 'Audriņu pag.'),
       (13, 'Augstkalnes pag.'),
       (14, 'Aulejas pag.'),
       (13, 'Auru pag.'),
       (15, 'Babītes pag.'),
       (16, 'Baldones pag.'),
       (12, 'Kaunatas pag.');

DROP TABLE IF EXISTS addresses.cities CASCADE;
CREATE TABLE IF NOT EXISTS addresses.cities
(
    id        serial PRIMARY KEY,
    county_id integer             NOT NULL REFERENCES addresses.counties (id) ON DELETE CASCADE,
    name      varchar(100) UNIQUE NOT NULL
    );
INSERT INTO addresses.cities (county_id, name)
VALUES (10, 'Ainaži'),
       (3, 'Aizkraukle'),
       (18, 'Aizpute'),
       (11, 'Aknīste'),
       (10, 'Aloja'),
       (19, 'Mazsalaca'),
       (11, 'Viesīte'),
       (20, 'Viļaka'),
       (12, 'Viļāni'),
       (11, 'Jēkabpils'),
       (21, 'Ogre'),
       (19, 'Valmiera'),
       (22, 'Zilupe');

DROP TABLE IF EXISTS addresses.villages CASCADE;
CREATE TABLE IF NOT EXISTS addresses.villages
(
    id        serial PRIMARY KEY,
    parish_id integer      NOT NULL REFERENCES addresses.parishes (id) ON DELETE CASCADE,
    name      varchar(100) NOT NULL
    );

INSERT INTO addresses.villages (parish_id, name)
VALUES (14, 'Ababļeva'),
       (2, 'Aglona'),
       (2, 'Aļhovka');

DROP TABLE IF EXISTS addresses.streets CASCADE;
CREATE TABLE IF NOT EXISTS addresses.streets
(
    id                serial PRIMARY KEY,
    city_id           integer REFERENCES addresses.cities (id) ON DELETE CASCADE,
    no_county_city_id integer REFERENCES addresses.no_county_cities (id) ON DELETE CASCADE,
    village_id        integer REFERENCES addresses.villages (id) ON DELETE CASCADE,
    parish_id         integer REFERENCES addresses.parishes (id) ON DELETE CASCADE,
    street_name       varchar(255) NOT NULL
    );

INSERT INTO addresses.streets (city_id, street_name)
VALUES (2, 'Aglonas iela'),
       (2, 'Misiņa iela'),
       (5, 'Mičurina iela'),
       (9, 'Miķeļa iela');
INSERT INTO addresses.streets (village_id, parish_id, street_name)
VALUES (1, 2, 'Rīgas iela'),
       (1, 6, 'Miķelsonu iela'),
       (1, 2, 'Miķelīšu iela'),
       (1, 6, 'Miķeļa Valtera iela'),
       (1, 7, 'Miera iela');

DROP TABLE IF EXISTS addresses.buildings CASCADE;
CREATE TABLE IF NOT EXISTS addresses.buildings
(
    id              serial PRIMARY KEY,
    street_id       integer REFERENCES addresses.streets (id) ON DELETE CASCADE,
    building_number varchar(5) NOT NULL
    );

INSERT INTO addresses.buildings (street_id, building_number)
VALUES (1, '1'),
       (1, '1b'),
       (1, '2'),
       (1, '2a/k1'),
       (2, '3'),
       (3, '4'),
       (4, '5'),
       (5, '6');

DROP TABLE IF EXISTS addresses.apartments CASCADE;
CREATE TABLE IF NOT EXISTS addresses.apartments
(
    id               serial PRIMARY KEY,
    building_id      integer REFERENCES addresses.buildings (id) ON DELETE CASCADE,
    apartment_number varchar(50)
    );

INSERT INTO addresses.apartments (building_id, apartment_number)
VALUES (1, '1'),
       (2, '2'),
       (3, '3'),
       (2, '4'),
       (2, '5'),
       (3, '6');

DROP TABLE IF EXISTS addresses.postal_code CASCADE;
CREATE TABLE IF NOT EXISTS addresses.postal_code
(
    id   serial PRIMARY KEY,
    code integer NOT NULL UNIQUE CHECK (code BETWEEN 1000 AND 999999)
    );
INSERT INTO addresses.postal_code (code)
VALUES ('3752'),
       ('2121'),
       ('1010'),
       ('1050'),
       ('2120');

DROP TABLE IF EXISTS addresses.steadings CASCADE;
CREATE TABLE IF NOT EXISTS addresses.steadings
(
    id             serial PRIMARY KEY,
    name           varchar(255) NOT NULL,
    postal_code_id integer REFERENCES addresses.postal_code (id) ON DELETE CASCADE,
    parish_id      integer REFERENCES addresses.parishes (id) ON DELETE CASCADE,
    county_id      integer REFERENCES addresses.counties (id) ON DELETE CASCADE
    );

INSERT INTO addresses.steadings (postal_code_id, name)
VALUES (1, 'Riņņi'),
       (2, 'Šķetras'),
       (3, 'Naukšēnu muiža'),
       (5, 'Abullejas'),
       (2, 'Aivari'),
       (1, 'Aizmeži'),
       (5, 'Aizpurvi'),
       (3, 'Aizupes'),
       (2, 'Alejas'),
       (4, 'Alkšņi'),
       (4, 'Allikas'),
       (2, 'Mazantiņi');


DROP TABLE IF EXISTS addresses.client_addresses CASCADE;
CREATE TABLE IF NOT EXISTS addresses.client_addresses
(
    id     serial PRIMARY KEY,
    postal_code_id integer REFERENCES addresses.postal_code (id) ON DELETE CASCADE,
    city_id        integer REFERENCES addresses.cities (id) ON DELETE CASCADE,
    county_id      integer REFERENCES addresses.counties (id) ON DELETE CASCADE,
    parish_id      integer REFERENCES addresses.parishes (id) ON DELETE CASCADE,
    village_id     integer REFERENCES addresses.villages (id) ON DELETE CASCADE,
    street_id      integer REFERENCES addresses.streets (id) ON DELETE CASCADE,
    building_id    integer REFERENCES addresses.buildings (id) ON DELETE CASCADE,
    apartment_id   integer REFERENCES addresses.apartments (id) ON DELETE CASCADE,
    steading_id    integer REFERENCES addresses.steadings (id) ON DELETE CASCADE
    );

INSERT INTO addresses.client_addresses (postal_code_id, city_id, county_id, parish_id, village_id, street_id,
                                        building_id)
VALUES (1, 1, 1, 1, 1, 1, 1);