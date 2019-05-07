package com.pichkur.javaCourse.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Country")
public class CountryEntity {

    /**
     * Уникальный идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Номер версии
     */
    @Version
    @Column(name = "version")
    private Long version;

    /**
     * Код страны
     */
    @Column(name = "code")
    private String code;

    /**
     * Название страны
     */
    @Column(name = "name")
    private String name;

    /**
     * Список граждан страны
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "citizenship_code")
    private List<UserEntity> users;

    public CountryEntity(Long id, Long version) {
        this.id = id;
        this.version = version;
    }
}
