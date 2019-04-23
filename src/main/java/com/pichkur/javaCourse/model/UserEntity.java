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

    @Id
    @GeneratedValue
    private Integer id;

    @Version
    private Integer version;

    private String first_name;

    private String second_name;

    private String middle_name;

    private String position;

    private String phone;

    @OneToOne(
            mappedBy = "user",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            optional = false
    )
    private DocEntity document;

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

    public void addOffice(OfficeEntity office) {
        offices.add(office);
        office.getUsers().add(this);
    }

    public void removeOffice(OfficeEntity office) {
        offices.remove(office);
        office.getUsers().remove(this);
    }
}
