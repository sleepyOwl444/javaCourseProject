package com.pichkur.javaCourse.model.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ApiModel(description = "Страна")
public class CountryView {

    @NotNull
    @ApiModelProperty(hidden = true)
    private Long id;


    @NotNull
    @Size(max = 50)
    private String code;

    @NotNull
    @Size(max = 50)
    private String name;

    @Override
    public String toString() {
        return "{ id: " + this.id + "; code; " + this.code + "; name: " + this.code + "}";
    }
}
