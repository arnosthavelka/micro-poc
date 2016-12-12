--liquibase formatted sql

--changeset nvoxland:1
create table canton (
    id int primary key,
    name varchar(50),
    csu_code varchar(6),
    district_code varchar(5)
);
--rollback drop table canton;

--changeset nvoxland:2
insert into canton(id, name, csu_code, district_code) values (0, 'Externí region', 'CZZZZZ', '');
insert into canton(id, name, csu_code, district_code) values (3100, 'Praha hlavní město', 'CZ0100', 'CZ010');
insert into canton(id, name, csu_code, district_code) values (3101, 'Praha 1', 'CZ0101', 'CZ010');
insert into canton(id, name, csu_code, district_code) values (3102, 'Praha 2', 'CZ0102', 'CZ010');
insert into canton(id, name, csu_code, district_code) values (3103, 'Praha 3', 'CZ0103', 'CZ010');
insert into canton(id, name, csu_code, district_code) values (3104, 'Praha 4', 'CZ0104', 'CZ010');
insert into canton(id, name, csu_code, district_code) values (3105, 'Praha 5', 'CZ0105', 'CZ010');
insert into canton(id, name, csu_code, district_code) values (3106, 'Praha 6', 'CZ0106', 'CZ010');
insert into canton(id, name, csu_code, district_code) values (3107, 'Praha 7', 'CZ0107', 'CZ010');
insert into canton(id, name, csu_code, district_code) values (3108, 'Praha 8', 'CZ0108', 'CZ010');
insert into canton(id, name, csu_code, district_code) values (3109, 'Praha 9', 'CZ0109', 'CZ010');
insert into canton(id, name, csu_code, district_code) values (3110, 'Praha 10', 'CZ010A', 'CZ010');
insert into canton(id, name, csu_code, district_code) values (3197, 'Správa hl.m.Prahy', '', 'CZ010');
insert into canton(id, name, csu_code, district_code) values (3199, 'Pp ČR ŘSSČP Praha', '', 'CZ010');
insert into canton(id, name, csu_code, district_code) values (3201, 'Benešov', 'CZ0201', 'CZ020');
insert into canton(id, name, csu_code, district_code) values (3202, 'Beroun', 'CZ0202', 'CZ020');
insert into canton(id, name, csu_code, district_code) values (3203, 'Kladno', 'CZ0203', 'CZ020');
insert into canton(id, name, csu_code, district_code) values (3204, 'Kolín', 'CZ0204', 'CZ020');
insert into canton(id, name, csu_code, district_code) values (3205, 'Kutná Hora', 'CZ0205', 'CZ020');
insert into canton(id, name, csu_code, district_code) values (3206, 'Mělník', 'CZ0206', 'CZ020');
insert into canton(id, name, csu_code, district_code) values (3207, 'Mladá Boleslav', 'CZ0207', 'CZ020');
insert into canton(id, name, csu_code, district_code) values (3208, 'Nymburk', 'CZ0208', 'CZ020');
insert into canton(id, name, csu_code, district_code) values (3209, 'Praha-východ', 'CZ0209', 'CZ020');
insert into canton(id, name, csu_code, district_code) values (3210, 'Praha-západ', 'CZ020A', 'CZ020');
insert into canton(id, name, csu_code, district_code) values (3211, 'Příbram', 'CZ020B', 'CZ020');
insert into canton(id, name, csu_code, district_code) values (3212, 'Rakovník', 'CZ020C', 'CZ020');
insert into canton(id, name, csu_code, district_code) values (3301, 'České Budějovice', 'CZ0311', 'CZ031');
insert into canton(id, name, csu_code, district_code) values (3302, 'Český Krumlov', 'CZ0312', 'CZ031');
insert into canton(id, name, csu_code, district_code) values (3303, 'Jindřichův Hradec', 'CZ0313', 'CZ031');
insert into canton(id, name, csu_code, district_code) values (3304, 'Pelhřimov', 'CZ0633', 'CZ063');
insert into canton(id, name, csu_code, district_code) values (3305, 'Písek', 'CZ0314', 'CZ031');
insert into canton(id, name, csu_code, district_code) values (3306, 'Prachatice', 'CZ0315', 'CZ031');
insert into canton(id, name, csu_code, district_code) values (3307, 'Strakonice', 'CZ0316', 'CZ031');
insert into canton(id, name, csu_code, district_code) values (3308, 'Tábor', 'CZ0317', 'CZ031');
insert into canton(id, name, csu_code, district_code) values (3401, 'Domažlice', 'CZ0321', 'CZ032');
insert into canton(id, name, csu_code, district_code) values (3402, 'Cheb', 'CZ0411', 'CZ041');
insert into canton(id, name, csu_code, district_code) values (3403, 'Karlovy Vary', 'CZ0412', 'CZ041');
insert into canton(id, name, csu_code, district_code) values (3404, 'Klatovy', 'CZ0322', 'CZ032');
insert into canton(id, name, csu_code, district_code) values (3405, 'Plzeň-město', 'CZ0323', 'CZ032');
insert into canton(id, name, csu_code, district_code) values (3406, 'Plzeň-jih', 'CZ0324', 'CZ032');
insert into canton(id, name, csu_code, district_code) values (3407, 'Plzeň-sever', 'CZ0325', 'CZ032');
insert into canton(id, name, csu_code, district_code) values (3408, 'Rokycany', 'CZ0326', 'CZ032');
insert into canton(id, name, csu_code, district_code) values (3409, 'Sokolov', 'CZ0413', 'CZ041');
insert into canton(id, name, csu_code, district_code) values (3410, 'Tachov', 'CZ0327', 'CZ032');
insert into canton(id, name, csu_code, district_code) values (3501, 'Česká Lípa', 'CZ0511', 'CZ051');
insert into canton(id, name, csu_code, district_code) values (3502, 'Děčín', 'CZ0421', 'CZ042');
insert into canton(id, name, csu_code, district_code) values (3503, 'Chomutov', 'CZ0422', 'CZ042');
insert into canton(id, name, csu_code, district_code) values (3504, 'Jablonec nad Nisou', 'CZ0512', 'CZ051');
insert into canton(id, name, csu_code, district_code) values (3505, 'Liberec', 'CZ0513', 'CZ051');
insert into canton(id, name, csu_code, district_code) values (3506, 'Litoměřice', 'CZ0423', 'CZ042');
insert into canton(id, name, csu_code, district_code) values (3507, 'Louny', 'CZ0424', 'CZ042');
insert into canton(id, name, csu_code, district_code) values (3508, 'Most', 'CZ0425', 'CZ042');
insert into canton(id, name, csu_code, district_code) values (3509, 'Teplice', 'CZ0426', 'CZ042');
insert into canton(id, name, csu_code, district_code) values (3510, 'Ústí nad Labem', 'CZ0427', 'CZ042');
insert into canton(id, name, csu_code, district_code) values (3601, 'Havlíčkův Brod', 'CZ0631', 'CZ063');
insert into canton(id, name, csu_code, district_code) values (3602, 'Hradec Králové', 'CZ0521', 'CZ052');
insert into canton(id, name, csu_code, district_code) values (3603, 'Chrudim', 'CZ0531', 'CZ053');
insert into canton(id, name, csu_code, district_code) values (3604, 'Jičín', 'CZ0522', 'CZ052');
insert into canton(id, name, csu_code, district_code) values (3605, 'Náchod', 'CZ0523', 'CZ052');
insert into canton(id, name, csu_code, district_code) values (3606, 'Pardubice', 'CZ0532', 'CZ053');
insert into canton(id, name, csu_code, district_code) values (3607, 'Rychnov nad Kněžnou', 'CZ0524', 'CZ052');
insert into canton(id, name, csu_code, district_code) values (3608, 'Semily', 'CZ0514', 'CZ051');
insert into canton(id, name, csu_code, district_code) values (3609, 'Svitavy', 'CZ0533', 'CZ053');
insert into canton(id, name, csu_code, district_code) values (3610, 'Trutnov', 'CZ0525', 'CZ052');
insert into canton(id, name, csu_code, district_code) values (3611, 'Ústí nad Orlicí', 'CZ0534', 'CZ053');
insert into canton(id, name, csu_code, district_code) values (3701, 'Blansko', 'CZ0641', 'CZ064');
insert into canton(id, name, csu_code, district_code) values (3702, 'Brno-město', 'CZ0642', 'CZ064');
insert into canton(id, name, csu_code, district_code) values (3703, 'Brno-venkov', 'CZ0643', 'CZ064');
insert into canton(id, name, csu_code, district_code) values (3704, 'Břeclav', 'CZ0644', 'CZ064');
insert into canton(id, name, csu_code, district_code) values (3705, 'Zlín', 'CZ0724', 'CZ072');
insert into canton(id, name, csu_code, district_code) values (3706, 'Hodonín', 'CZ0645', 'CZ064');
insert into canton(id, name, csu_code, district_code) values (3707, 'Jihlava', 'CZ0632', 'CZ063');
insert into canton(id, name, csu_code, district_code) values (3708, 'Kroměříž', 'CZ0721', 'CZ072');
insert into canton(id, name, csu_code, district_code) values (3709, 'Prostějov', 'CZ0713', 'CZ071');
insert into canton(id, name, csu_code, district_code) values (3710, 'Třebíč', 'CZ0634', 'CZ063');
insert into canton(id, name, csu_code, district_code) values (3711, 'Uherské Hradiště', 'CZ0722', 'CZ072');
insert into canton(id, name, csu_code, district_code) values (3712, 'Vyškov', 'CZ0646', 'CZ064');
insert into canton(id, name, csu_code, district_code) values (3713, 'Znojmo', 'CZ0647', 'CZ064');
insert into canton(id, name, csu_code, district_code) values (3714, 'Žďár nad Sázavou', 'CZ0635', 'CZ063');
insert into canton(id, name, csu_code, district_code) values (3801, 'Bruntál', 'CZ0801', 'CZ080');
insert into canton(id, name, csu_code, district_code) values (3802, 'Frýdek-Místek', 'CZ0802', 'CZ080');
insert into canton(id, name, csu_code, district_code) values (3803, 'Karviná', 'CZ0803', 'CZ080');
insert into canton(id, name, csu_code, district_code) values (3804, 'Nový Jičín', 'CZ0804', 'CZ080');
insert into canton(id, name, csu_code, district_code) values (3805, 'Olomouc', 'CZ0712', 'CZ071');
insert into canton(id, name, csu_code, district_code) values (3806, 'Opava', 'CZ0805', 'CZ080');
insert into canton(id, name, csu_code, district_code) values (3807, 'Ostrava-město', 'CZ0806', 'CZ080');
insert into canton(id, name, csu_code, district_code) values (3808, 'Přerov', 'CZ0714', 'CZ071');
insert into canton(id, name, csu_code, district_code) values (3809, 'Šumperk', 'CZ0715', 'CZ071');
insert into canton(id, name, csu_code, district_code) values (3810, 'Vsetín', 'CZ0723', 'CZ072');
insert into canton(id, name, csu_code, district_code) values (3811, 'Jeseník', 'CZ0711', 'CZ071');