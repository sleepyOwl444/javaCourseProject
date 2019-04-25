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
     * Код документа
     */
    private String code;

    /**
     * Название документа (тип)
     */
    private String name;

    /**
     * Список выданных документов этого типа
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "code")
    private List<DocEntity> documents;

    public DocTypeEntity(Long id, Long version) {
        this.id = id;
        this.version = version;
    }
}
