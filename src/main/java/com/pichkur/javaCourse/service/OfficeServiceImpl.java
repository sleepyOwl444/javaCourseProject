package com.pichkur.javaCourse.service;


import com.pichkur.javaCourse.interfaces.OfficeSerice;
import com.pichkur.javaCourse.model.OfficeEntity;
import com.pichkur.javaCourse.model.UserEntity;
import com.pichkur.javaCourse.responce.SimpleResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class OfficeServiceImpl implements OfficeSerice {


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


    @Override
    public OfficeEntity getOfficeById(Long id) {
        List<UserEntity> users = new ArrayList<>();
        return new OfficeEntity(Long.valueOf(1), Long.valueOf(0), "Сбербанк Главный офис", "ул. Вавилова, д. 19",
                "11111", true, users);
    }


    @Override
    public String updateOffice() {
        return "success";
    }

    @Override
    public String saveOffice() {
        return "success";
    }
}
