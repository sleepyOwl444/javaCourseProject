package com.pichkur.javaCourse.controller;


import com.pichkur.javaCourse.interfaces.UserService;
import com.pichkur.javaCourse.model.UserEntity;
import com.pichkur.javaCourse.responce.SimpleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping(value = "/api/user", produces = APPLICATION_JSON_VALUE)
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
    public String updateUser() {

        return userService.updateUser();
    }

    @PostMapping(value = "/save")
    public String saveUser() {

        return userService.saveUser();
    }


}
