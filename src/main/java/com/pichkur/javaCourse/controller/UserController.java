package com.pichkur.javaCourse.controller;


import com.pichkur.javaCourse.interfaces.UserService;
import com.pichkur.javaCourse.model.UserEntity;
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
    public String updateUser(@RequestBody UserEntity user) {

        return userService.updateUser(user);
    }

    @PostMapping(value = "/save")
    public String saveUser(@RequestBody UserEntity user) {

        return userService.saveUser(user);
    }


}
