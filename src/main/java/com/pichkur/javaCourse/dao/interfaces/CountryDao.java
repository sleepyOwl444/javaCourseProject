package com.pichkur.javaCourse.dao.interfaces;

import com.pichkur.javaCourse.model.CountryEntity;

import java.util.List;

public interface CountryDao {

    /**
     * Получить список всех стран
     * @return
     */
    List<CountryEntity> getAll();
}
