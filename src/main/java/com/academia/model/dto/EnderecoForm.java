package com.academia.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class EnderecoForm {
    @NotNull(message = "Os dados do aluno são obrigatórios")
    private AlunoCpf aluno;
    @NotEmpty(message = "O campo cep é obrigatório")
    @Pattern(regexp = "^[0-9]{8}$", message = "O campo cep deve possuir 8 caracteres numéricos")
    private String cep;
    @NotEmpty(message = "O campo rua é obrigatório")
    @Size(max = 50, message = "O campo rua deve possuir no máximo ${max} caracteres")
    private String rua;
    @NotNull(message = "O campo número é obrigatório")
    @Max(value = 999999, message =  "O valor máximo do campo número é ${value}")
    private Integer numero;
    private String complemento;
    @NotEmpty(message = "O campo bairro é obrigatório")
    @Size(max = 50, message = "O campo bairro deve possuir no máximo ${max} caracteres")
    private String bairro;
}
