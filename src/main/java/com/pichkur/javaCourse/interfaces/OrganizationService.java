package com.pichkur.javaCourse.interfaces;

import com.pichkur.javaCourse.model.OrganizationEntity;
import com.pichkur.javaCourse.responce.SimpleResponse;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface OrganizationService {

    List<OrganizationEntity> getOrganizations();

    OrganizationEntity getOrganizationById(Long id);

    SimpleResponse<String> updateOrganization();

    SimpleResponse<String> saveOrganization();

}
