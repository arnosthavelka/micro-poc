--liquibase formatted sql

--changeset nvoxland:1
create table district (
    id int primary key,
    name varchar(50),
    csu_code varchar(5),
    plate_code varchar(1)
);
--rollback drop table district;

--changeset nvoxland:2
insert into district(id, name, csu_code, plate_code) values (0, 'Externí region', 'CZZZZ', 'X');
insert into district(id, name, csu_code, plate_code) values (14, 'Hlavní město Praha', 'CZ010', 'A');
insert into district(id, name, csu_code, plate_code) values (1, 'Jihočeský', 'CZ031', 'C');
insert into district(id, name, csu_code, plate_code) values (2, 'Jihomoravský', 'CZ062', 'B');
insert into district(id, name, csu_code, plate_code) values (3, 'Karlovarský', 'CZ041', 'K');
insert into district(id, name, csu_code, plate_code) values (4, 'Královéhradecký', 'CZ052', 'H');
insert into district(id, name, csu_code, plate_code) values (5, 'Liberecký', 'CZ051', 'L');
insert into district(id, name, csu_code, plate_code) values (6, 'Moravskoslezský', 'CZ080', 'T');
insert into district(id, name, csu_code, plate_code) values (7, 'Olomoucký', 'CZ071', 'M');
insert into district(id, name, csu_code, plate_code) values (8, 'Pardubický', 'CZ053', 'E');
insert into district(id, name, csu_code, plate_code) values (9, 'Plzeňský', 'CZ032', 'P');
insert into district(id, name, csu_code, plate_code) values (10, 'Středočeský', 'CZ020', 'S');
insert into district(id, name, csu_code, plate_code) values (11, 'Ústecký', 'CZ042', 'U');
insert into district(id, name, csu_code, plate_code) values (12, 'Vysočina', 'CZ061', 'J');
insert into district(id, name, csu_code, plate_code) values (13, 'Zlínský', 'CZ072', 'Z');