package com.academia.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class AlunoCpf {
    @NotEmpty(message = "Campo cpf é obrigatório")
    @Pattern(regexp = "^[0-9]{10}$", message = "O campo cpf deve possuir 11 caracteres numéricos")
    private String cpf;
}
