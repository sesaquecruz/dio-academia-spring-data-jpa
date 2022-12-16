package com.academia.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "tb_alunos")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;
    @Column(nullable = false, unique = true)
    private String cpf;
    @Column(nullable = false)
    private LocalDate dataNascimento;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String telefone;
    private String email;
}
