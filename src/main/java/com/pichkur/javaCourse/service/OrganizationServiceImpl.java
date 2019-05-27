package com.pichkur.javaCourse.service;

import com.pichkur.javaCourse.dao.interfaces.OrganizationDao;
import com.pichkur.javaCourse.interfaces.OrganizationService;
import com.pichkur.javaCourse.mapper.MapperFacade;
import com.pichkur.javaCourse.model.OfficeEntity;
import com.pichkur.javaCourse.model.OrganizationEntity;
import com.pichkur.javaCourse.model.view.OrganizationView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationDao dao;
    private final MapperFacade mapper;

    @Autowired
    public OrganizationServiceImpl(OrganizationDao dao, MapperFacade mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    /**
     * @return список организаций
     */
    @Override
    public List<OrganizationView> getOrganizations(String name, String phone, Boolean isActive) {
       List<OrganizationEntity> entities = dao.getOrganizations(name, phone, isActive);
       return mapper.mapAsList(entities, OrganizationView.class);
    }

    /**
     * Получаем организвацию по id
     * @param id организации
     * @return запись об организации
     */
    @Override
    public OrganizationView getOrganizationById(Long id) {
        OrganizationEntity entity = dao.getOrganizationById(id);
        return mapper.map(entity, OrganizationView.class);
    }

//    /**
//     * Обновляем запись об организации
//     * @param organization новые данные об организации
//     * @return сообщение об успехе или неудаче
//     */
//    @Override
//    public String updateOrganization(OrganizationEntity organization) {
//
//        return "success";
//    }
//
//    /**
//     * Сохраняем новую запись об организации
//     * @param organization новая организация
//     * @return сообщение об успехе или неудаче
//     */
//    @Override
//    public String saveOrganization(OrganizationEntity organization) {
//
//        return "success";
//    }
}
