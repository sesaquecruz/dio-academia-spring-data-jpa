package com.academia.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tb_enderecos")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;
    @Column(nullable = false)
    private String cep;
    @Column(nullable = false)
    private String rua;
    @Column(nullable = false)
    private Integer numero;
    private String complemento;
    @Column(nullable = false)
    private String bairro;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;
}
