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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Номер версии
     */
    @Version
    private Long version;

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
    private String inn;

    /**
     * КПП
     */
    private String kpp;

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
    @OneToMany(
            mappedBy = "organization",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<OfficeEntity> offices;

    public OrganizationEntity(Long id, Long version) {
        this.id = id;
        this.version = version;
    }
    public void addOffice(OfficeEntity office) {
        getOffices().add(office);
        office.setOrganization(this);
    }

    public void removeOffice(OfficeEntity office) {
        getOffices().remove(office);
        office.setOrganization(null);
    }
}
