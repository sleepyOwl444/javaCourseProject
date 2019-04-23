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
@Table(name = "doc_type")
public class DocTypeEntity {

    @Id
    @GeneratedValue
    private Integer id;

    @Version
    private Integer version;

    private String code;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "code")
    private List<DocEntity> documents;
}
