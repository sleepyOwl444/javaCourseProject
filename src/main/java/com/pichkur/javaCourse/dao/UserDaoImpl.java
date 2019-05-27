package com.pichkur.javaCourse.dao;

import com.pichkur.javaCourse.dao.interfaces.UserDao;
import com.pichkur.javaCourse.model.OrganizationEntity;
import com.pichkur.javaCourse.model.UserEntity;
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
public class UserDaoImpl implements UserDao {

    private final EntityManager em;

    @Autowired
    public UserDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<UserEntity> getUsers(Long officeId, String firstName, String lastName,
                                     String middleName, String position, String docCode, String citizenshipCode){
        CriteriaQuery<UserEntity> criteria = getCriteriaQuery(officeId, firstName, lastName, middleName, position, docCode, citizenshipCode);
        TypedQuery<UserEntity> query = em.createQuery(criteria);
        return query.getResultList();
    }

    @Override
    public UserEntity getUserById(Long id) {
        return em.find(UserEntity.class, id);
    }



    private CriteriaQuery<UserEntity> getCriteriaQuery(Long officeId, String firstName, String secondName,
                                                               String middleName, String position, String docCode, String citizenshipCode) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<UserEntity> criteria = builder.createQuery(UserEntity.class);
        Root<UserEntity> root = criteria.from(UserEntity.class);
        List<Predicate> predicates = new ArrayList<>();

        predicates.add(builder.equal(root.get("offices").get("id"), officeId));
        if(firstName != null) {
            predicates.add(builder.like(root.get("firstName"), "%" + firstName + "%"));
        }
        if(secondName != null){
            predicates.add(builder.like(root.get("secondName"), "%" + secondName + "%"));
        }
        if(middleName != null) {
            predicates.add(builder.like(root.get("middleName"), "%" + middleName + "%"));
        }
        if(position != null) {
            predicates.add(builder.equal(root.get("position"), position));
        }
        if(docCode != null) {
            predicates.add(builder.equal(root.get("document").get("id"), docCode));
        }
        if(citizenshipCode != null) {
            predicates.add(builder.equal(root.get("country").get("code"), citizenshipCode));
        }
        criteria.select(builder.construct(
                UserEntity.class,
                root.get("id"),
                root.get("firstName"),
                root.get("secondName"),
                root.get("middleName"),
                root.get("position"))
        ).where(predicates.toArray(new Predicate[]{}));
        return criteria;
    }
}
