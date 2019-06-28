package com.pichkur.javaCourse.model.view.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserView {

    @NotNull
    private Long id;
    /**
     * Фамилия сотрудника
     */
    @Size(max = 50)
    private String secondName;

    /**
     * Имя сотрудника
     */
    @Size(max = 50)
    private String firstName;


    /**
     * Отчество сотрудника
     */
    @Size(max = 50)
    private String middleName;
    /**
     * Должность сотрудника
     */
    @Size(max = 50)
    private String position;

    /**
     * Телефон сотрудника
     */
    @Size(max = 20)
    private String phone;

   @Size(max = 50)
    private String docName;

    @Size(max = 50)
    private String docNumber;

    @Size(max = 50)
    private String docDate;

    @Size(max = 50)
    private String citizenshipCode;

    @Size(max = 50)
    private String citizenshipName;

    private Boolean isIdentifies;

}
