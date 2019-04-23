package com.pichkur.javaCourse.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "organization")
public class OrganizationEntity {

    /**
     * Уникальный идентификатор
     */
    @Id
    @GeneratedValue
    private Integer id;

    @Version
    private Integer version;

    /**
     * Название организации
     */
    private String name;

    /**
     * Полное название организации
     */
    private String fullName;

    /**
     * ИНН
     */
    private Integer inn;

    /**
     * КПП
     */
    private Integer kpp;

    /**
     * Адрес организации
     */
    private String address;

    /**
     * Телефон организации
     */
    private String phone;

    /**
     * Активна организация или нет
     */
    private Boolean isActive;

    /**
     * Список офисов, принадлежащих организации
     */
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "org_id")
    private List<OfficeEntity> offices;
}
