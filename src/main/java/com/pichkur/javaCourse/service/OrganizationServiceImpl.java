package com.pichkur.javaCourse.service;

import com.pichkur.javaCourse.interfaces.OrganizationService;
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
        organizations.add(new OrganizationEntity());
        return organizations;
    }

    @Override
    public OrganizationEntity getOrganizationById(Long id) {

        return new OrganizationEntity();
    }


    @Override
    public SimpleResponse<String> updateOrganization() {

        return new SimpleResponse<>("success");
    }

    @Override
    public SimpleResponse<String> saveOrganization() {

        return new SimpleResponse<>("success");
    }
}
