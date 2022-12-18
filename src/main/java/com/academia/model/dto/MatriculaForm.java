package com.academia.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class MatriculaForm {
    @NotNull(message = "Os dados do aluno são obrigatórios")
    private AlunoCpf aluno;
}
