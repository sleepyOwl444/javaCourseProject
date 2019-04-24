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

    private CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    /**
     * Получает список стран из справочника
     * @return список стран
     */
    @GetMapping
    public List<CountryEntity> getCountries(){

        return countryService.getCountries();
    }
}
