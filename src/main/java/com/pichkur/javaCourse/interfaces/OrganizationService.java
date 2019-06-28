package com.pichkur.javaCourse.interfaces;

import com.pichkur.javaCourse.model.view.organization.OrganizationView;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface OrganizationService {

    List<OrganizationView> getOrganizations(String name, String inn, Boolean isActive);

    OrganizationView getOrganizationById(Long id);

//    String updateOrganization(OrganizationEntity organization);
//
//    String saveOrganization(OrganizationEntity organization);

}
