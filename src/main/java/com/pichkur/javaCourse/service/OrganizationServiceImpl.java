package com.pichkur.javaCourse.service;

import com.pichkur.javaCourse.interfaces.OrganizationService;
import com.pichkur.javaCourse.model.OfficeEntity;
import com.pichkur.javaCourse.model.OrganizationEntity;
import com.pichkur.javaCourse.responce.SimpleResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Override
    public List<OrganizationEntity> getOrganizations() {
        List<OrganizationEntity> organizations = new ArrayList<>();
        List<OfficeEntity> offices = new ArrayList<>();
        organizations.add(new OrganizationEntity(Long.valueOf(1), Long.valueOf(0), "Сбербанк", "ОАО Сбербанк",
                "4354", "354534", "адрес Сбербанка", "11111", true, offices));
        organizations.add(new OrganizationEntity(Long.valueOf(2), Long.valueOf(0), "Яндекс", "Яндекс",
                "2545", "2435", "адрес Яндекса", "22222", true, offices));
        organizations.add(new OrganizationEntity(Long.valueOf(3), Long.valueOf(0), "ВТБ", "ОАО Банк ВТБ",
                "2353", "45335", "адрес ВТБ", "33333", true, offices));
        return organizations;
    }

    @Override
    public OrganizationEntity getOrganizationById(Long id) {
        List<OfficeEntity> offices = new ArrayList<>();
        return new OrganizationEntity(Long.valueOf(2), Long.valueOf(0), "Яндекс", "Яндекс",
                "2545", "2435", "адрес Яндекса", "22222", true, offices);
    }


    @Override
    public String updateOrganization() {

        return "success";
    }

    @Override
    public String saveOrganization() {

        return "success";
    }
}
