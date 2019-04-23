package com.pichkur.javaCourse.service;

import com.pichkur.javaCourse.interfaces.UserService;
import com.pichkur.javaCourse.model.UserEntity;
import com.pichkur.javaCourse.responce.SimpleResponce;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Override
    public List<UserEntity> getUsers() {
        List<UserEntity> users = new ArrayList<>();
        users.add(new UserEntity());
        return users;
    }

    @Override
    public UserEntity getUserById(Long id) {
        return new UserEntity();
    }


    @Override
    public SimpleResponce<String> updateUser() {
        return new SimpleResponce<>("success");
    }

    @Override
    public SimpleResponce<String> saveUser() {
        return new SimpleResponce<>("success");
    }
}
