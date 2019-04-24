package com.pichkur.javaCourse.service;


import com.pichkur.javaCourse.interfaces.OfficeSerice;
import com.pichkur.javaCourse.model.OfficeEntity;
import com.pichkur.javaCourse.responce.SimpleResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class OfficeServiceImpl implements OfficeSerice {


    @Override
    public List<OfficeEntity> getOffices() {
        List<OfficeEntity> offices = new ArrayList<>();
        offices.add(new OfficeEntity());
        return offices;
    }


    @Override
    public OfficeEntity getOfficeById(Long id) {
        return new OfficeEntity();
    }


    @Override
    public SimpleResponse<String> updateOffice() {
        return new SimpleResponse<>("success");
    }

    @Override
    public SimpleResponse<String> saveOffice() {
        return new SimpleResponse<>("success");
    }
}
