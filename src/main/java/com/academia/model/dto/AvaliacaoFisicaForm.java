package com.academia.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AvaliacaoFisicaForm {
    private AlunoCpf aluno;
    private Double peso;
    private Double altura;
}
