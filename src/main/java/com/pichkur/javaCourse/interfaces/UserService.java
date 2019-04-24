package com.pichkur.javaCourse.interfaces;

import com.pichkur.javaCourse.model.UserEntity;
import com.pichkur.javaCourse.responce.SimpleResponse;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UserService {

    List<UserEntity> getUsers();

    UserEntity getUserById(Long id);

    String updateUser();

    String saveUser();
}
