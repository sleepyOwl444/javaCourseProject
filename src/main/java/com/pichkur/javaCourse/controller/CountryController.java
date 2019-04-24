package com.pichkur.javaCourse.controller;

import com.pichkur.javaCourse.interfaces.CountryService;
import com.pichkur.javaCourse.model.CountryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping
    public List<CountryEntity> getCountries(){

        return countryService.getCountries();
    }
}
