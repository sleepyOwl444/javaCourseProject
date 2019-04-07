package com.pichkur.javaCourse.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrganizationEntity {

    /**
     * Уникальный идентификатор
     */
    @Id
    @GeneratedValue
    private Integer id;

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
    @OneToMany(
            mappedBy = "organization",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<OfficeEntity> offices;

    /**
     * Добавляет офис в список офисов организации. Метод написан для синхронизации OrganizationEntity и OfficeEntity
     * @param office офис, который хотим добавить
     */
    public void addOffice(OfficeEntity office) {
        offices.add(office);
        office.setOrganization(this);
    }

    /**
     * Удаляет офис из списка офисов организации. Метод написан для синхронизации OrganizationEntity и OfficeEntity
     * @param office офис, который хотим удалить
     */
    public void removeOffice(OfficeEntity office) {
        offices.remove(office);
        office.setOrganization(null);
    }
}
