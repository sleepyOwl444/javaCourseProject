package com.pichkur.javaCourse.service;

import com.pichkur.javaCourse.interfaces.UserService;
import com.pichkur.javaCourse.model.DocEntity;
import com.pichkur.javaCourse.model.OfficeEntity;
import com.pichkur.javaCourse.model.UserEntity;
import com.pichkur.javaCourse.responce.SimpleResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class UserServiceImpl implements UserService {

    @Override
    public List<UserEntity> getUsers() {
        List<UserEntity> users = new ArrayList<>();
        Set<OfficeEntity> officeEntities = new HashSet<>();
        users.add(new UserEntity(Long.valueOf(1), Long.valueOf(0), "Иван", "Соколов", "Владимирович",
                "администратор", "11111" ,new DocEntity(), officeEntities));
        users.add(new UserEntity(Long.valueOf(2), Long.valueOf(0), "Петр", "Ивочкин", "Андреевич",
                "", "", new DocEntity(), officeEntities));
        return users;
    }

    @Override
    public UserEntity getUserById(Long id) {
        Set<OfficeEntity> officeEntities = new HashSet<>();
        return new UserEntity(Long.valueOf(1), Long.valueOf(0), "Иван", "Соколов", "Владимирович",
                "администратор", "11111" ,new DocEntity(), officeEntities);
    }


    @Override
    public String updateUser() {
        return "success";
    }

    @Override
    public String saveUser() {
        return "success";
    }
}
