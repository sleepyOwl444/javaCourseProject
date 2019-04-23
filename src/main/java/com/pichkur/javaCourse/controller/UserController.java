package com.pichkur.javaCourse.controller;


import com.pichkur.javaCourse.interfaces.UserService;
import com.pichkur.javaCourse.model.UserEntity;
import com.pichkur.javaCourse.responce.SimpleResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping(value = "/list")
    public List<UserEntity> getUsers() {
        return userService.getUsers();
    }

    @GetMapping(value = "/{id}")
    public UserEntity getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    @PostMapping(value = "/update")
    public SimpleResponce<String> updateUser() {
        return userService.updateUser();
    }

    @PostMapping(value = "/save")
    public SimpleResponce<String> saveUser() {
        return userService.saveUser();
    }


}
