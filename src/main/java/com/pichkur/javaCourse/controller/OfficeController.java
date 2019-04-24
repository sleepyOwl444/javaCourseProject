package com.pichkur.javaCourse.controller;

import com.pichkur.javaCourse.interfaces.OfficeSerice;

import com.pichkur.javaCourse.model.OfficeEntity;
import com.pichkur.javaCourse.responce.SimpleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/office")
public class OfficeController {

    @Autowired
    private OfficeSerice officeSerice;


    @GetMapping(value = "/list")
    public List<OfficeEntity> getOffices() {

        return officeSerice.getOffices();
    }

    @GetMapping(value = "/{id}")
    public OfficeEntity getOfficeById(@PathVariable("id") Long id) {

        return officeSerice.getOfficeById(id);
    }

    @PostMapping(value = "/update")
    public SimpleResponse<String> updateOffice() {

        return officeSerice.updateOffice();
    }

    @PostMapping(value = "/save")
    public SimpleResponse<String> saveOffice() {

        return officeSerice.saveOffice();
    }

}
