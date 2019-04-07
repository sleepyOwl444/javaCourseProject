INSERT INTO Organization (id, name, inn, kpp, is_active) VALUES (1, 'Яндекс', 13243243, 1232433, true);

INSERT INTO Organization (id, name, inn, kpp, is_active) VALUES (2, 'Сбербанк', 3634643, 8523963, true);

INSERT INTO Office (id, organization_id, name, address, is_active) VALUES (1, 1, 'Какой-то офис', 'Ленинградский проспект, 17', true);

INSERT INTO Office (id,organization_id, name, address, is_active) VALUES (2, 2,  'Яндекс Главный офис', 'ул. Льва Толстого, 16', true);

INSERT INTO User (id, office_id, first_name, second_name, position) VALUES (1, 2, 'Иван', 'Симонов', 'Администратор');

INSERT INTO User (id, office_id, first_name, second_name, position) VALUES (2, 2, 'Олег', 'Петров', 'Старший тестировщик');

INSERT INTO Doc (code, name) VALUES (21, 'Паспорт гражданина РФ');

INSERT INTO Country (code, name) VALUES (643, 'Российская Федерация');