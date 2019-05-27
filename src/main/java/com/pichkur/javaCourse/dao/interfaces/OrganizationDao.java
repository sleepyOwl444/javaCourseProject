package com.pichkur.javaCourse.dao.interfaces;


import com.pichkur.javaCourse.model.OrganizationEntity;

import java.util.List;

public interface OrganizationDao {

    List<OrganizationEntity> getOrganizations(String name, String phone, Boolean isActive);

    OrganizationEntity getOrganizationById(Long id);
}
