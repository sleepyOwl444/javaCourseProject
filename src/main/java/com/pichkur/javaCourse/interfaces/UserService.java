package com.pichkur.javaCourse.interfaces;

import com.pichkur.javaCourse.model.view.UserView;
import org.springframework.validation.annotation.Validated;

import java.util.List;


@Validated
public interface UserService {

    List<UserView> getUsers(Long officeId, String firstName, String lastName,
                            String middleName, String position, String docCode, String citizenshipCode);

    UserView getUserById(Long id);

//    String updateUser(UserEntity user);
//
//    String saveUser(UserEntity user);
}
