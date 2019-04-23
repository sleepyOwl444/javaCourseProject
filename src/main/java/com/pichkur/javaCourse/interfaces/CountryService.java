package com.pichkur.javaCourse.interfaces;

import com.pichkur.javaCourse.model.CountryEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface CountryService {

    List<CountryEntity> getCountries();
}
