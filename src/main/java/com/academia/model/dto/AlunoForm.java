package com.academia.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
public class AlunoForm {
    @NotEmpty(message = "Campo cpf é obrigatório")
    @Pattern(regexp = "^[0-9]{10}$", message = "O campo cpf deve possuir 11 caracteres numéricos")
    private String cpf;
    @NotNull(message = "Campo data de nascimento é obrigatório")
    private LocalDate dataNascimento;
    @NotEmpty(message = "Campo nome é obrigatório")
    @Size(max = 50, message = "O campo nome deve possuir no máximo ${max} caracteres")
    private String nome;
    @NotEmpty(message = "Campo telefone é obrigatório")
    @Pattern(regexp = "^[0-9]{10}$", message = "O campo telefone deve possuir 10 caracteres numéricos")
    private String telefone;
    @Size(max = 50, message = "O campo email deve possuir no máximo ${max} caracteres")
    @Email(message = "O email digitado não é válido")
    private String email;
    @NotNull(message = "Os dados do endereço são obrigatórios")
    private AlunoFormEndereco endereco;

    @Getter
    @Setter
    public static class AlunoFormEndereco {
        @NotEmpty(message = "O campo cep é obrigatório")
        @Pattern(regexp = "^[0-9]{8}$", message = "O campo cep deve possuir 8 caracteres numéricos")
        private String cep;
        @NotEmpty(message = "O campo rua é obrigatório")
        @Size(max = 50, message = "O campo rua deve possuir no máximo ${max} caracteres")
        private String rua;
        @NotNull(message = "O campo número é obrigatório")
        @Pattern(regexp = "^[0-9]+$", message = "O campo número deve possuir apenas caracteres numéricos")
        @Max(value = 999999, message =  "O valor máximo do campo número é ${value}")
        private Integer numero;
        private String complemento;
        @NotEmpty(message = "O campo bairro é obrigatório")
        @Size(max = 50, message = "O campo bairro deve possuir no máximo ${max} caracteres")
        private String bairro;
    }
}
