package com.pichkur.javaCourse.country;


import com.pichkur.javaCourse.controller.CountryController;
import com.pichkur.javaCourse.interfaces.CountryService;
import com.pichkur.javaCourse.model.CountryEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CountryControllerTest {

    @Mock
    private CountryService countryService;

    @InjectMocks
    private CountryController countryController = new CountryController(countryService);

    @Test
    public void shouldCallGetCountriesMethod() {
        List<CountryEntity> countries = new ArrayList<>();
        countries.add(new CountryEntity(Long.valueOf(1), Long.valueOf(0)));
        when(countryService.getCountries()).thenReturn(countries);
        Assert.assertEquals(countryController.getCountries(), countries);
        verify(countryService).getCountries();
    }
}
