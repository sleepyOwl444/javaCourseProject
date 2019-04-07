package com.pichkur.javaCourse.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OfficeEntity {

    /**
     * Уникальный идентификатор
     */
    @Id
    @GeneratedValue
    private Integer id;

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

    /**
     * Организация, которой принадлежит офис
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id")
    private OrganizationEntity organization;
}
