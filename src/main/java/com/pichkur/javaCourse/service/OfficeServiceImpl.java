package com.pichkur.javaCourse.service;


import com.pichkur.javaCourse.interfaces.OfficeSerice;
import com.pichkur.javaCourse.model.OfficeEntity;
import com.pichkur.javaCourse.responce.SimpleResponce;
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
    public SimpleResponce<String> updateOffice() {
        return new SimpleResponce<>("success");
    }

    @Override
    public SimpleResponce<String> saveOffice() {
        return new SimpleResponce<>("success");
    }
}
