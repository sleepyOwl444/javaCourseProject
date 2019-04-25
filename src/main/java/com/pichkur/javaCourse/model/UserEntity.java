package com.pichkur.javaCourse.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user")
public class UserEntity {

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
     * Имя сотрудника
     */
    private String firstName;

    /**
     * Фамилия сотрудника
     */
    private String secondName;

    /**
     * Отчество сотрудника
     */
    private String middleName;

    /**
     * Должность сотрудника
     */
    private String position;

    /**
     * Телефон сотрудника
     */
    private String phone;

    /**
     * Документ, выданный человеку
     */
    @OneToOne(
            mappedBy = "user",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            optional = false
    )
    private DocEntity document;

    /**
     * Список офисов, в которых работает человек
     */
    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinTable(
            name = "User_Office",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "office_id")
    )
    private Set<OfficeEntity> offices;

    public UserEntity(Long id, Long version) {
        this.id = id;
        this.version = version;
    }

    public void addOffice(OfficeEntity office) {
        offices.add(office);
        office.getUsers().add(this);
    }

    public void removeOffice(OfficeEntity office) {
        offices.remove(office);
        office.getUsers().remove(this);
    }
}
