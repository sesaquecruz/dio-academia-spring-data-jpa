package com.academia.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AvaliacaoFisicaForm {
    @NotNull(message = "Os dados do aluno são obrigatórios")
    private AlunoCpf aluno;
    @NotNull(message = "O campo peso é obrigatório")
    @Digits(integer = 3, fraction = 2, message = "O formato do campo peso é 999.99")
    private Double peso;
    @NotNull(message = "O campo altura é obrigatório")
    @Digits(integer = 1, fraction = 2, message = "O formato do campo altura é 9.99")
    private Double altura;
}
