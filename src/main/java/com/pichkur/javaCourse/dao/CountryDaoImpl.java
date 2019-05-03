package com.pichkur.javaCourse.dao;

import com.pichkur.javaCourse.dao.interfaces.CountryDao;
import com.pichkur.javaCourse.model.CountryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CountryDaoImpl implements CountryDao {

    private final EntityManager em;

    @Autowired
    public CountryDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<CountryEntity> getAll() {
        TypedQuery<CountryEntity> query = em.createQuery("SELECT c FROM CountryEntity c", CountryEntity.class);
        return query.getResultList();
    }

    @Override
    public CountryEntity getCountryById(Long id) {
        return em.find(CountryEntity.class, id);
    }
}
