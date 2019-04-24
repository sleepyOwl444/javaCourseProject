package com.pichkur.javaCourse.service;

import com.pichkur.javaCourse.interfaces.CountryService;
import com.pichkur.javaCourse.model.CountryEntity;
import com.pichkur.javaCourse.model.UserEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Override
    public List<CountryEntity> getCountries() {
        List<CountryEntity> countries = new ArrayList<>();
        List<UserEntity> users = new ArrayList<>();
        countries.add(new CountryEntity(Long.valueOf(1), Long.valueOf(0)));
        countries.add(new CountryEntity(Long.valueOf(2), Long.valueOf(0), "643", "Российская Федерация", users));
        return countries;
    }
}
