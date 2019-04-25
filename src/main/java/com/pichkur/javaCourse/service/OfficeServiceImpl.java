package com.pichkur.javaCourse.service;


import com.pichkur.javaCourse.interfaces.OfficeService;
import com.pichkur.javaCourse.model.OfficeEntity;
import com.pichkur.javaCourse.model.UserEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class OfficeServiceImpl implements OfficeService {

    /**
     * @return список офисов
     */
    @Override
    public List<OfficeEntity> getOffices() {
        List<OfficeEntity> offices = new ArrayList<>();
        List<UserEntity> users = new ArrayList<>();
        offices.add(new OfficeEntity(Long.valueOf(1), Long.valueOf(0), "Сбербанк Главный офис", "ул. Вавилова, д. 19",
                "11111", true, users));
        offices.add(new OfficeEntity(Long.valueOf(2), Long.valueOf(0), "Яндекс Главный офис", "ул. Льва Толстого, 16",
                "2222", true, users));
        return offices;
    }


    /**
     * Получаем конкретный офис по его id
     * @param id офиса
     * @return запись об офисе
     */
    @Override
    public OfficeEntity getOfficeById(Long id) {
        List<UserEntity> users = new ArrayList<>();
        return new OfficeEntity(Long.valueOf(1), Long.valueOf(0), "Сбербанк Главный офис", "ул. Вавилова, д. 19",
                "11111", true, users);
    }

    /**
     * Обновляем запись об офисе
     * @param office
     * @return сообщение об успехе или неудаче операции
     */
    @Override
    public String updateOffice(OfficeEntity office) {
        return "success";
    }

    /**
     * Сохраняем новую запись об офисе
     * @param office
     * @return сообщение об успехе или неудаче операции
     */
    @Override
    public String saveOffice(OfficeEntity office) {
        return "success";
    }
}
