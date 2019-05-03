package com.pichkur.javaCourse.model.view;

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
public class DocTypeView {

    @NotNull
    private Long id;

    @NotNull
    @Size(max = 50)
    private String code;

    @NotNull
    @Size(max = 50)
    private String name;

}
