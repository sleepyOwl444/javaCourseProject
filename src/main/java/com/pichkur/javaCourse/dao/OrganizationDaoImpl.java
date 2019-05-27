package com.pichkur.javaCourse.dao;

import com.pichkur.javaCourse.dao.interfaces.OrganizationDao;
import com.pichkur.javaCourse.model.OfficeEntity;
import com.pichkur.javaCourse.model.OrganizationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrganizationDaoImpl implements OrganizationDao {

    private final EntityManager em;

    @Autowired
    public OrganizationDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<OrganizationEntity> getOrganizations(String name, String phone, Boolean isActive) {
        CriteriaQuery<OrganizationEntity> criteria = getCriteriaQuery(name, phone, isActive);
        TypedQuery<OrganizationEntity> query = em.createQuery(criteria);
        return query.getResultList();
    }

    @Override
    public OrganizationEntity getOrganizationById(Long id) {
        return em.find(OrganizationEntity.class, id);
    }


    private CriteriaQuery<OrganizationEntity> getCriteriaQuery(String name, String phone, Boolean isActive) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<OrganizationEntity> criteria = builder.createQuery(OrganizationEntity.class);
        Root<OrganizationEntity> root = criteria.from(OrganizationEntity.class);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(builder.like(root.get("name"), "%" + name + "%"));
        if(phone != null) {
            predicates.add(builder.like(root.get("phone"), "%" + phone + "%"));
        }
        if(isActive != null){
            predicates.add(builder.equal(root.get("isActive"), isActive));
        }
        criteria.select(builder.construct(
                OrganizationEntity.class,
                root.get("id"),
                root.get("name"),
                root.get("isActive"))
        ).where(predicates.toArray(new Predicate[]{}));
        return criteria;
    }
}
