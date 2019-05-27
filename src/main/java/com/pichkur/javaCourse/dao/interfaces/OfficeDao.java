package com.pichkur.javaCourse.dao.interfaces;

import com.pichkur.javaCourse.model.OfficeEntity;

import java.util.List;


public interface OfficeDao {

    List<OfficeEntity> getOffices(Long orgId, String name, String phone, Boolean isActive);

    OfficeEntity getOfficeById(Long id);
//
//    String updateOffice(OfficeEntity office);
//
    void saveOffice(OfficeEntity office);
}
