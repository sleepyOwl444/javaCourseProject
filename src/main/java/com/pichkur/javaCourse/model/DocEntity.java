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

    @Id
    @GeneratedValue
    private Integer id;

    @Version
    private Integer version;

    private Date date;

    private Boolean isIdentified;

    private String code;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
