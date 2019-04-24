package com.pichkur.javaCourse.interfaces;

import com.pichkur.javaCourse.model.OrganizationEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface OrganizationService {

    List<OrganizationEntity> getOrganizations();

    OrganizationEntity getOrganizationById(Long id);

    String updateOrganization(OrganizationEntity organization);

    String saveOrganization(OrganizationEntity organization);

}
