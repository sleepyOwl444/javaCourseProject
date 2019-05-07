package com.pichkur.javaCourse.dao;

import com.pichkur.javaCourse.dao.interfaces.OfficeDao;
import com.pichkur.javaCourse.model.OfficeEntity;
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
public class OfficeDaoImpl implements OfficeDao {

    private final EntityManager em;

    @Autowired
    public OfficeDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<OfficeEntity> getOffices(Long orgId, String name, String phone, Boolean isActive) {
        CriteriaQuery<OfficeEntity> criteria = getCriteriaQuery(orgId, name, phone, isActive);
        TypedQuery<OfficeEntity> query = em.createQuery(criteria);
        return query.getResultList();
    }

    @Override
    public OfficeEntity getOfficeById(Long id) {
        return em.find(OfficeEntity.class, id);
    }

    @Override
    public void saveOffice(OfficeEntity office) {
        em.persist(office);
    }



    private CriteriaQuery<OfficeEntity> getCriteriaQuery(Long orgId, String name, String phone, Boolean isActive) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<OfficeEntity> criteria = builder.createQuery(OfficeEntity.class);
        Root<OfficeEntity> root = criteria.from(OfficeEntity.class);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(builder.equal(root.get("organization").get("id"), orgId));
        if(name != null) {
            predicates.add(builder.like(root.get("name"), "%" + name + "%"));
        }
        if(phone != null) {
            predicates.add(builder.like(root.get("phone"), "%" + phone + "%"));
        }
        if(isActive != null){
            predicates.add(builder.equal(root.get("isActive"), isActive));
        }
        criteria.select(builder.construct(
                OfficeEntity.class,
                root.get("id"),
                root.get("name"),
                root.get("isActive"))
        ).where(predicates.toArray(new Predicate[]{}));
        return criteria;
    }
}
