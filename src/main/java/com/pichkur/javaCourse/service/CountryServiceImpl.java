package com.pichkur.javaCourse.service;

import com.pichkur.javaCourse.dao.interfaces.CountryDao;
import com.pichkur.javaCourse.interfaces.CountryService;
import com.pichkur.javaCourse.mapper.MapperFacade;
import com.pichkur.javaCourse.model.CountryEntity;
import com.pichkur.javaCourse.model.view.CountryView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {


    private final CountryDao dao;
    private final MapperFacade mapperFacade;

    @Autowired
    public CountryServiceImpl(CountryDao dao, MapperFacade mapperFacade) {
        this.dao = dao;
        this.mapperFacade = mapperFacade;
    }
    /**
     * Получаем список стран из справочника
     * @return список стран
     */
    @Override
    @Transactional(readOnly = true)
    public List<CountryView> getCountries() {
        List<CountryEntity> list = dao.getAll();
        return mapperFacade.mapAsList(list, CountryView.class);
    }
}
