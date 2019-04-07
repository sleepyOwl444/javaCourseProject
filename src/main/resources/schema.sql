CREATE TABLE IF NOT EXISTS User (
    id    INTEGER NOT NULL    COMMENT 'Уникальный идентификатор'    PRIMARY KEY AUTO_INCREMENT ,
    office_id    INTEGER    COMMENT 'Внешний ключ для связи с таблицей Office' ,
    first_name VARCHAR(50)    COMMENT 'Первое имя',
    second_name VARCHAR(50)    COMMENT 'Фамилия',
    middle_name VARCHAR(50)    COMMENT 'Второе имя',
    position VARCHAR(50)    COMMENT 'Должность',
    phone VARCHAR(20)    COMMENT 'Телефон',
    doc_name VARCHAR(50)    COMMENT 'Название документа',
    doc_number INTEGER    COMMENT 'Номер документа',
    doc_date DATE   COMMENT 'Дата выдачи документа',
    citizenship_name VARCHAR(50)    COMMENT 'Название страны (гражданство)',
    citizenship_code INTEGER    COMMENT 'Код страны' ,
    is_identified    BOOLEAN    COMMENT ''
);
COMMENT ON TABLE User IS 'Человек';

CREATE TABLE IF NOT EXISTS Office (
    id    INTEGER NOT NULL    COMMENT 'Уникальный идентификатор'    PRIMARY KEY AUTO_INCREMENT ,
    organization_id    INTEGER    COMMENT 'Внешний ключ для связи с таблицей Organization' ,
    user_id    INTEGER    COMMENT 'Внешний ключ для связи с таблицей User' ,
    name    VARCHAR(50)    COMMENT 'Название офиса' ,
    address    VARCHAR(50)    COMMENT 'Адрес офиса' ,
    phone    VARCHAR(20)    COMMENT 'Телефон офиса' ,
    is_active BOOLEAN    COMMENT 'Активен офис или нет'
);
COMMENT ON TABLE Office IS 'Офис';

CREATE TABLE IF NOT EXISTS Organization (
    id    INTEGER NOT NULL    COMMENT 'Уникальный идентификатор'    PRIMARY KEY AUTO_INCREMENT ,
    office_id    INTEGER    COMMENT 'Внешний ключ для связи с таблицей Office' ,
    name    VARCHAR(50)    COMMENT 'Название организации' ,
    full_name VARCHAR(50)    COMMENT 'Полное название организации' ,
    inn    INTEGER    COMMENT 'ИНН' ,
    kpp    INTEGER    COMMENT 'КПП' ,
    address    VARCHAR(50)    COMMENT 'Адрес организации' ,
    phone    VARCHAR(20)    COMMENT 'Телефон организации' ,
    is_active    BOOLEAN    COMMENT 'Активна или нет'
);
COMMENT ON TABLE Organization IS 'Организация';


CREATE TABLE IF NOT EXISTS Doc (
    code    INTEGER NOT NULL    COMMENT 'Номер документа'    PRIMARY KEY ,
    name    VARCHAR(50)    COMMENT 'Название документа'
);
COMMENT ON TABLE Doc IS 'Документ';

CREATE TABLE IF NOT EXISTS Country (
    code    INTEGER NOT NULL    COMMENT 'Код страны'    PRIMARY KEY ,
    name    VARCHAR(50)    COMMENT 'Название страны'
);
COMMENT ON TABLE Country IS 'Страна';


CREATE INDEX IX_User_Id ON User (id);

CREATE INDEX IX_User_Office_Id ON User (office_id);
ALTER TABLE User ADD FOREIGN KEY (office_id) REFERENCES Office (id);

CREATE INDEX IX_User_Doc_Number ON User (doc_number);
ALTER TABLE User ADD FOREIGN KEY (doc_number) REFERENCES Doc (code);

CREATE INDEX IX_User_Citizenship_Code ON User (citizenship_code);
ALTER TABLE User ADD FOREIGN KEY (citizenship_code) REFERENCES Country (code);

CREATE INDEX IX_Office_Id ON Office (id);

CREATE INDEX IX_Office_Organization_Id ON Office (organization_id);
ALTER TABLE Office ADD FOREIGN KEY (organization_id) REFERENCES Organization (id);

CREATE INDEX IX_Office_User_Id ON Office (user_id);
ALTER TABLE Office ADD FOREIGN KEY (user_id) REFERENCES User (id);

CREATE INDEX IX_Organization_Id ON Organization (id);

CREATE INDEX IX_Organization_Office_Id ON Organization (office_id);
ALTER TABLE Organization ADD FOREIGN KEY (office_id) REFERENCES Office (id);

CREATE INDEX IX_Doc_Code ON Doc (code);

CREATE INDEX IX_Country_Code ON Country (code);