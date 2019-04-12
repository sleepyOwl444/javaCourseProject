package com.pichkur.javaCourse.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "office")
public class OfficeEntity {

    /**
     * Уникальный идентификатор
     */
    @Id
    @GeneratedValue
    private Integer id;

    @Version
    private Integer version;

    /**
     *Название офиса
     */
    private String name;

    /**
     * Адрес офиса
     */
    private String address;

    /**
     * Телефон офиса
     */
    private String phone;

    /**
     * Активен офис или нет
     */
    private Boolean isActive;

    @ManyToMany(mappedBy = "offices")
    private List<UserEntity> users;

    public List<UserEntity> getUsers() {
        if(users == null) {
            users = new ArrayList<>();
        }
        return users;
    }
}