package com.pichkur.javaCourse.model.view.organization;


import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(description = "Организация")
public class OrganizationUpdateView {

    @NotNull
    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true)
    private Long id;

    @NotNull
    @Size(max = 50)
    @ApiModelProperty(value = "Название организации")
    private String name;

    @NotNull
    @Size(max = 50)
    @ApiModelProperty(value = "Полное название организации")
    private String fullName;

    @NotNull
    @Size(max = 20)
    @ApiModelProperty(value = "ИНН")
    private String inn;

    @NotNull
    @Size(max = 20)
    @ApiModelProperty(value = "КПП")
    private String kpp;

    @NotNull
    @Size(max = 50)
    @ApiModelProperty(value = "Адрес организации")
    private String address;

    @Size(max = 20)
    @ApiModelProperty(value = "Телефон организации")
    private String phone;

    @ApiModelProperty(value = "Работает организация или нет")
    private Boolean isActive;
}
