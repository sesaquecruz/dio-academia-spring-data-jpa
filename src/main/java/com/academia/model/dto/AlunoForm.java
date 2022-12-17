package com.academia.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AlunoForm {
    private String cpf;
    private LocalDate dataNascimento;
    private String nome;
    private String telefone;
    private String email;
    private AlunoFormEndereco endereco;

    @Getter
    @Setter
    public static class AlunoFormEndereco {
        private String cep;
        private String rua;
        private Integer numero;
        private String complemento;
        private String bairro;
    }
}
