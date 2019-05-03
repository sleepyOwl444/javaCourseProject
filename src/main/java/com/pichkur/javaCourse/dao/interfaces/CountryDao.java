package com.pichkur.javaCourse.dao.interfaces;

import com.pichkur.javaCourse.model.CountryEntity;

import java.util.List;

public interface CountryDao {

    /**
     * Получить список всех стран
     * @return
     */
    List<CountryEntity> getAll();

    /**
     * Получить страну по id
     * @param id
     * @return
     */
    CountryEntity getCountryById(Long id);

//    /**
//     * Получить страну по коду
//     * @param code
//     * @return
//     */
//    CountryEntity getCountryByCode(String code);
}
