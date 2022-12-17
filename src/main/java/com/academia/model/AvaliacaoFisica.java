package com.academia.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "tb_avaliacoes_fisicas")
public class AvaliacaoFisica {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;
    @Column(nullable = false)
    private Double peso;
    @Column(nullable = false)
    private Double altura;
    @Column(nullable = false)
    private LocalDate data;
    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;
}
