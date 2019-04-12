CREATE SEQUENCE user_id;
CREATE SEQUENCE org_id;
CREATE SEQUENCE office_id;
CREATE SEQUENCE doc_id;


INSERT INTO Organization (id, version, name, inn, kpp, is_active) VALUES (org_id.nextval, 0, 'Яндекс', 13243243, 1232433, true);

INSERT INTO Organization (id, version, name, inn, kpp, is_active) VALUES (org_id.nextval, 0, 'Сбербанк', 16346123, 73471247, true);

INSERT INTO Office (id, version, org_id, name, address, is_active) VALUES (office_id.nextval, 0, org_id.currval,  'Яндекс Главный офис', 'ул. Льва Толстого, 16', true);

INSERT INTO User (id, version, first_name, second_name, position) VALUES (user_id.nextval, 0, 'Олег', 'Петров', 'Старший тестировщик');

INSERT INTO User_Office (user_id, office_id) VALUES (user_id.currval, office_id.currval);

INSERT INTO Doc_Type (code, version, name) VALUES (21, 0, 'Паспорт гражданина РФ');

INSERT INTO Doc (id, version, code, user_id) VALUES (doc_id.nextval, 0, 21, user_id.currval);

INSERT INTO Country (code, version, name) VALUES (643, 0, 'Российская Федерация');