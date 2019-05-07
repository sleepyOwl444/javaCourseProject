package com.pichkur.javaCourse.interfaces;

import com.pichkur.javaCourse.model.view.CountryView;
import org.springframework.validation.annotation.Validated;

import java.util.List;


@Validated
public interface CountryService {

    List<CountryView> getCountries();
}
