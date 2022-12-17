package com.academia.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoForm {
    private AlunoCpf aluno;
    private String cep;
    private String rua;
    private Integer numero;
    private String complemento;
    private String bairro;
}
