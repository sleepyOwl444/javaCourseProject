package com.pichkur.javaCourse.service;

import com.pichkur.javaCourse.interfaces.UserService;
import com.pichkur.javaCourse.model.DocEntity;
import com.pichkur.javaCourse.model.OfficeEntity;
import com.pichkur.javaCourse.model.UserEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class UserServiceImpl implements UserService {

    /**
     * @return список сотрудников
     */
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

    /**
     * Получаем сотрудика по id
     * @param id сотрудника
     * @return запись о сотруднике
     */
    @Override
    public UserEntity getUserById(Long id) {
        Set<OfficeEntity> officeEntities = new HashSet<>();
        return new UserEntity(Long.valueOf(1), Long.valueOf(0), "Иван", "Соколов", "Владимирович",
                "администратор", "11111" ,new DocEntity(), officeEntities);
    }

    /**
     * Обновляем запись о сотруднике
     * @param user новые данные о сотруднике
     * @return сообщение об успехе или неудаче
     */
    @Override
    public String updateUser(UserEntity user) {
        return "success";
    }

    /**
     *Сохраняем новую запись о сотруднике
     * @param user новые данные о сотруднике
     * @return сообщение об успехе или неудаче
     */
    @Override
    public String saveUser(UserEntity user) {
        return "success";
    }
}
