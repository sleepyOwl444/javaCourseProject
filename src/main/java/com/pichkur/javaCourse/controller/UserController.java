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

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    /**
     * Получает список сотрудников
     * @return список сотрудников
     */
    @GetMapping(value = "/list")
    public List<UserEntity> getUsers() {

        return userService.getUsers();
    }

    /**
     * Получает запись о конкретном сотруднике по id
     * @param id сотрудника, которого хотим получить
     * @return запись об сотруднике
     */
    @GetMapping(value = "/{id}")
    public UserEntity getUserById(@PathVariable("id") Long id) {

        return userService.getUserById(id);
    }

    /**
     * Обновляет запись об сотруднике
     * @param user обновленный вариант сотрудника
     * @return сообщение об успехе или неуспехе обновления
     */
    @PostMapping(value = "/update")
    public String updateUser(@RequestBody UserEntity user) {

        return userService.updateUser(user);
    }

    /**
     * Сохраняет нового сотрудника
     * @param user, которого хотим сохранить
     * @return сообщение об успехе или неуспехе сохранения
     */
    @PostMapping(value = "/save")
    public String saveUser(@RequestBody UserEntity user) {

        return userService.saveUser(user);
    }


}
