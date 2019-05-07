package com.pichkur.javaCourse.service;


import com.pichkur.javaCourse.dao.interfaces.OfficeDao;
import com.pichkur.javaCourse.interfaces.OfficeService;
import com.pichkur.javaCourse.mapper.MapperFacade;
import com.pichkur.javaCourse.model.OfficeEntity;
import com.pichkur.javaCourse.model.OrganizationEntity;
import com.pichkur.javaCourse.model.UserEntity;
import com.pichkur.javaCourse.model.view.AnswerView;
import com.pichkur.javaCourse.model.view.OfficeView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class OfficeServiceImpl implements OfficeService {

    private final OfficeDao dao;

    private final MapperFacade mapper;

    @Autowired
    public OfficeServiceImpl(OfficeDao dao, MapperFacade mapper) {

        this.dao = dao;
        this.mapper = mapper;
    }

    /**
     * @return список офисов
     */
    @Override
    public List<OfficeView> getOffices(Long orgId, String name, String phone, Boolean isActive) {
        List<OfficeEntity> offices = dao.getOffices(orgId, name, phone, isActive);
//
        return mapper.mapAsList(offices, OfficeView.class);
    }


    /**
     * Получаем конкретный офис по его id
     * @param id офиса
     * @return запись об офисе
     */
    @Override
    public OfficeView getOfficeById(Long id) {
        OfficeEntity office = dao.getOfficeById(id);
        return mapper.map(office, OfficeView.class);
    }

    /**
     * Обновляем запись об офисе
     * @param office
     * @return сообщение об успехе или неудаче операции
     */
//    @Override
//    public String updateOffice(OfficeEntity office) {
//        return "success";
//    }

    /**
     * Сохраняем новую запись об офисе
     * @param office
     * @return сообщение об успехе или неудаче операции
     */
    @Override
    public AnswerView saveOffice(OfficeView office) {
        OfficeEntity entity = new OfficeEntity(office);
        dao.saveOffice(entity);
        return new AnswerView("success");
    }
}
