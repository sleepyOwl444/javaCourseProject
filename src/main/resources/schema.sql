CREATE TABLE IF NOT EXISTS User (
    id    INTEGER NOT NULL    COMMENT 'Уникальный идентификатор'    PRIMARY KEY AUTO_INCREMENT ,
    version    INTEGER NOT NULL     COMMENT 'Служебное поле hibernate',
    first_name VARCHAR(50)    COMMENT 'Первое имя',
    second_name VARCHAR(50)    COMMENT 'Фамилия',
    middle_name VARCHAR(50)    COMMENT 'Второе имя',
    position VARCHAR(50)    COMMENT 'Должность',
    phone VARCHAR(20)    COMMENT 'Телефон',
    citizenship_code VARCHAR(20)    COMMENT 'Код страны'
);
COMMENT ON TABLE User IS 'Человек';

CREATE TABLE IF NOT EXISTS Office (
    id    INTEGER NOT NULL    COMMENT 'Уникальный идентификатор'    PRIMARY KEY AUTO_INCREMENT ,
    version    INTEGER NOT NULL     COMMENT 'Служебное поле hibernate',
    org_id    INTEGER    COMMENT 'Внешний ключ для связи с таблицей Organization' ,
    name    VARCHAR(50)    COMMENT 'Название офиса' ,
    address    VARCHAR(50)    COMMENT 'Адрес офиса' ,
    phone    VARCHAR(20)    COMMENT 'Телефон офиса' ,
    is_active BOOLEAN    COMMENT 'Активен офис или нет'
);
COMMENT ON TABLE Office IS 'Офис';

CREATE TABLE IF NOT EXISTS User_Office (
    user_id    INTEGER    COMMENT 'Уникальный идентификатор Человека' ,
    office_id    INTEGER    COMMENT 'Уникальный идентификатор Офиса' ,
    PRIMARY KEY (user_id, office_id)
);
COMMENT ON TABLE User_Office IS 'join-таблица для связи человека и офиса';

CREATE TABLE IF NOT EXISTS Organization (
    id    INTEGER NOT NULL    COMMENT 'Уникальный идентификатор'    PRIMARY KEY AUTO_INCREMENT ,
    version    INTEGER NOT NULL     COMMENT 'Служебное поле hibernate',
    name    VARCHAR(50)    COMMENT 'Название организации' ,
    full_name VARCHAR(50)    COMMENT 'Полное название организации' ,
    inn    VARCHAR(20)    COMMENT 'ИНН' ,
    kpp    VARCHAR(20)    COMMENT 'КПП' ,
    address    VARCHAR(50)    COMMENT 'Адрес организации' ,
    phone    VARCHAR(20)    COMMENT 'Телефон организации' ,
    is_active    BOOLEAN    COMMENT 'Активна или нет'
);
COMMENT ON TABLE Organization IS 'Организация';

CREATE TABLE IF NOT EXISTS Doc_Type (
    code    VARCHAR(20) NOT NULL    COMMENT 'Номер документа, уникальный идентификатор'    PRIMARY KEY ,
    version    INTEGER NOT NULL     COMMENT 'Служебное поле hibernate',
    name    VARCHAR(50)    COMMENT 'Название документа'
);
COMMENT ON TABLE Doc_Type IS 'Справочник документов';

CREATE TABLE IF NOT EXISTS Doc (
    id    INTEGER NOT NULL    COMMENT 'Уникальный идентифкатор'    PRIMARY KEY AUTO_INCREMENT ,
    version    INTEGER NOT NULL     COMMENT 'Служебное поле hibernate',
    code    VARCHAR(20)    COMMENT 'Код документа' ,
    date    DATE    COMMENT 'Дата выдачи документа' ,
    is_identified    BOOLEAN    COMMENT 'Подтвержден документ или нет' ,
    user_id    INTEGER    COMMENT 'Внешний ключ для связи с таблицей User'
);
COMMENT ON TABLE Doc IS 'Информация по выданным документам';

CREATE TABLE IF NOT EXISTS Country (
    code    VARCHAR(20) NOT NULL    COMMENT 'Код страны, уникальный идентификатор'    PRIMARY KEY ,
    version    INTEGER NOT NULL     COMMENT 'Служебное поле hibernate',
    name    VARCHAR(50)    COMMENT 'Название страны'
);
COMMENT ON TABLE Country IS 'Страна';


CREATE INDEX IX_User_Id ON User (id);

CREATE INDEX IX_User_Citizenship_Code ON User (citizenship_code);
ALTER TABLE User ADD FOREIGN KEY (citizenship_code) REFERENCES Country (code);


CREATE INDEX IX_Office_Id ON Office (id);



CREATE INDEX IX_Office_Organization_Id ON Office (org_id);
ALTER TABLE Office ADD FOREIGN KEY (org_id) REFERENCES Organization (id);


CREATE INDEX IX_User_Office_Id ON User_Office (office_id);
ALTER TABLE User_Office ADD FOREIGN KEY (office_id) REFERENCES Office (id);

CREATE INDEX IX_Office_User_Id ON User_Office (user_id);
ALTER TABLE User_Office ADD FOREIGN KEY (user_id) REFERENCES User (id);



CREATE INDEX IX_Organization_Id ON Organization (id);


CREATE INDEX IX_Doc_Type_Id ON Doc_Type (code);


CREATE INDEX IX_Doc_Id On Doc (id);

CREATE INDEX IX_Doc_Code ON Doc (code);
ALTER TABLE Doc ADD FOREIGN KEY (code) REFERENCES Doc_Type (code);

CREATE INDEX IX_Doc_User_Id ON Doc (user_id);
ALTER TABLE Doc ADD FOREIGN KEY (user_id) REFERENCES User (id);

CREATE INDEX IX_Country_Code ON Country (code);