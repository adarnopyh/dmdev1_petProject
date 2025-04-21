DROP TABLE IF EXISTS bank_accounts CASCADE;
CREATE TABLE IF NOT EXISTS bank_accounts
(
    id         serial primary key,
    iban       VARCHAR(34),
    bank_name  VARCHAR(50),
    swift_code VARCHAR(8)
    );


INSERT INTO bank_accounts(iban, bank_name, swift_code)
VALUES ('LV37HABA0550000000001', 'Swedbank, AS', 'HABALV22'),
       ('LV80RIKO0000000000002', 'Luminor Bank AS Latvijas filiāle', 'RIKOLV2X'),
       ('LV15UNLA0000000000003', 'SEB banka, AS', 'UNLALV2X'),
       ('LV15UNLA0000000000099', 'SEB banka, AS', 'UNLALV2X'),
       ('LV03PARX0000000000004', 'Citadele banka, AS', 'PARXLV22'),
       ('LV03RTMB0000000000006', 'Rietumu Banka, AS', 'RTMBLV2X'),
       ('LV03RTMB0000000000010', 'Rietumu Banka, AS', 'RTMBLV2X'),
       ('LT343500000000000007', 'Paysera LT, UAB', 'EVIULT2V'),
       ('LT343500000000000008', 'Revolut Bank, UAB', 'RVUALT2V'),
       ('LV91CBBR0000000000005', 'BluOr Bank, AS', 'CBBRLV22');