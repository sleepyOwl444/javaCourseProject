package com.pichkur.javaCourse.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "doc")
public class DocEntity {

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
     * Дата выдачи документа
     */
    private Date date;

    /**
     * Метка, подтвержден документ или нет
     */
    private Boolean isIdentified;

    /**
     * Код документа
     */
    private String code;

    /**
     * Владелец документа
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public DocEntity(Long id, Long version) {
        this.id = id;
        this.version = version;
    }
}
