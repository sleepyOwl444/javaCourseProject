package com.pichkur.javaCourse.interfaces;

import com.pichkur.javaCourse.model.OfficeEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface OfficeService {

    List<OfficeEntity> getOffices();

    OfficeEntity getOfficeById(Long id);

    String updateOffice(OfficeEntity office);

    String saveOffice(OfficeEntity office);

}
