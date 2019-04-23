package com.pichkur.javaCourse.interfaces;

import com.pichkur.javaCourse.model.OrganizationEntity;
import com.pichkur.javaCourse.responce.SimpleResponce;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface OrganizationService {

    List<OrganizationEntity> getOrganizations();

    OrganizationEntity getOrganizationById(Long id);

    SimpleResponce<String> updateOrganization();

    SimpleResponce<String> saveOrganization();

}
