package com.pichkur.javaCourse.interfaces;

import com.pichkur.javaCourse.model.OfficeEntity;
import com.pichkur.javaCourse.responce.SimpleResponce;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface OfficeSerice {

    List<OfficeEntity> getOffices();

    OfficeEntity getOfficeById(Long id);

    SimpleResponce<String> updateOffice();

    SimpleResponce<String> saveOffice();

}
