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
@Table(name = "country")
public class CountryEntity {

    @Id
    @GeneratedValue
    private Integer id;

    @Version
    private Integer version;

    private String code;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "citizenship_code")
    private List<UserEntity> users;
}
