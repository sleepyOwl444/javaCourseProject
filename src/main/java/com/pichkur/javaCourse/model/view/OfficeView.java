package com.pichkur.javaCourse.model.view;

import com.fasterxml.jackson.annotation.JsonInclude;
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
public class OfficeView {

    @NotNull
    private Long id;

    @Size(max = 50)
    private String name;

    @Size(max = 50)
    private String address;

    @Size(max = 20)
    private String phone;

    private Boolean isActive;
}
