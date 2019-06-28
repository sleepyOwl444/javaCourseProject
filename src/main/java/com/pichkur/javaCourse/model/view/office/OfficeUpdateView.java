package com.pichkur.javaCourse.model.view.office;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.Api;
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
@ApiModel(description = "Офис")
public class OfficeUpdateView {

    @NotNull
    @ApiModelProperty(value = "Уникальный идентиикатор", hidden = true, example = "1")
    private Long id;

    @NotNull
    @Size(max = 50)
    @ApiModelProperty(value = "Название офиса")
    private String name;

    @NotNull
    @Size(max = 50)
    @ApiModelProperty(value = "Адрес офиса")
    private String address;

    @Size(max = 20)
    @ApiModelProperty(value = "Телефон офиса")
    private String phone;

    @ApiModelProperty(value = "Рабочий офис или нет")
    private Boolean isActive;
}
