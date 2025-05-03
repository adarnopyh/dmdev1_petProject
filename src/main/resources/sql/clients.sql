DROP TABLE IF EXISTS clients CASCADE;
create table if not exists clients
(
    id              serial primary key,
    name            varchar(100) not null,
    is_legal        boolean      not null,
    is_vat_payer    boolean,
    address_id      integer REFERENCES addresses.client_addresses (id) ON DELETE CASCADE,
    reg_number      varchar(11)  not null unique,
    vat_number      varchar(13),
    bank_account_id integer REFERENCES bank_accounts (id) ON DELETE CASCADE,
    price_level_id  INTEGER not null REFERENCES price_levels (id) ON DELETE CASCADE

    CONSTRAINT vat_number_check CHECK (
    (is_legal = FALSE AND (vat_number IS NULL OR vat_number = '')) OR
(is_legal = TRUE AND is_vat_payer = FALSE AND (vat_number IS NULL OR vat_number = '')) OR
(is_legal = TRUE AND is_vat_payer = TRUE AND vat_number IS NOT NULL AND vat_number <> '')
    )
    );


INSERT INTO clients (name, is_legal, is_vat_payer, address_id, reg_number, vat_number, bank_account_id, price_level_id)
VALUES ('WoodZombie', true, true, 1, '40403000001', 'LV40403000001', 1, 1),
       ('WoodBarber', true, true, 1, '44223300002', 'LV44223300002', 2, 2),
       ('Cross Timber', true, true, 1, '41123300003', 'LV44223300003', 3, 1),
       ('Village Frames', true, false, 1, '44333300004', '', 4, 2),
       ('Go Cut', true, false, 1, '44223300005', '', 5, 2),
       ('James Fulfil', false, false, 1, '22039522346', '', 6, 1),
       ('Mary Puppins', false, false, 1, '01078744357', '', 7, 1),
       ('Gorge Washandgo', false, false, 1, '11119243123', '', 8, 1),
       ('Dry Heineken', false, false, 1, '21089823162', '', 9, 1),
       ('Ivan Palovik', false, false, 1, '22077846319', '', 10, 2);