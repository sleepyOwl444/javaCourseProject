package com.pichkur.javaCourse.dao.interfaces;

import com.pichkur.javaCourse.model.OfficeEntity;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface OfficeDao {

    List<OfficeEntity> getOffices(Long orgId, String name, String phone, Boolean isActive);

    OfficeEntity getOfficeById(Long id);
//
//    String updateOffice(OfficeEntity office);
//
    void saveOffice(OfficeEntity office);
}
