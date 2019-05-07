package com.pichkur.javaCourse.model;


import com.pichkur.javaCourse.model.view.OfficeView;
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
@Table(name = "Office")
public class OfficeEntity {

    /**
     * Уникальный идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Номер версии
     */
    @Version
    private Long version;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "org_id")
    private OrganizationEntity organization;

    /**
     * Список сотрудников в офисе
     */
    @ManyToMany(mappedBy = "offices")
    private List<UserEntity> users;

    public OfficeEntity(Long id, Long version) {
        this.id = id;
        this.version = version;
    }

    public OfficeEntity(Long id, String name, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
    }

    public OfficeEntity(OfficeView view) {
        this.id = view.getId();
        this.name = view.getName();
        this.address = view.getAddress();
        this.phone = view.getPhone();
        this.isActive = view.getIsActive();
    }

    public List<UserEntity> getUsers() {
        if(users == null) {
            users = new ArrayList<>();
        }
        return users;
    }
}
