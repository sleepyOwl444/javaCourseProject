package com.pichkur.javaCourse.dao.interfaces;

import com.pichkur.javaCourse.model.UserEntity;

import java.util.List;

public interface UserDao {

    List<UserEntity> getUsers(Long officeId, String firstName, String secondName,
                              String middleName, String position, String docCode, String citizenshipCode);

    UserEntity getUserById(Long id);
}
