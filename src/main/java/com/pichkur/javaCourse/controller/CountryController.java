package com.pichkur.javaCourse.controller;

import com.pichkur.javaCourse.interfaces.CountryService;
import com.pichkur.javaCourse.model.view.CountryView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/countries", produces = APPLICATION_JSON_VALUE)
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
    public List<CountryView> getCountries(){
        return countryService.getCountries();
    }
}
