package com.pichkur.javaCourse.service;

import com.pichkur.javaCourse.interfaces.OrganizationService;
import com.pichkur.javaCourse.model.OrganizationEntity;
import com.pichkur.javaCourse.model.UserEntity;
import com.pichkur.javaCourse.responce.SimpleResponce;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Override
    public List<OrganizationEntity> getOrganizations() {
        List<OrganizationEntity> organizations = new ArrayList<>();
        organizations.add(new OrganizationEntity());
        return organizations;
    }

    @Override
    public OrganizationEntity getOrganizationById(Long id) {

        return new OrganizationEntity();
    }


    @Override
    public SimpleResponce<String> updateOrganization() {

        return new SimpleResponce<>("success");
    }

    @Override
    public SimpleResponce<String> saveOrganization() {

        return new SimpleResponce<>("success");
    }
}
