package com.academia.repository;

import com.academia.model.Aluno;
import com.academia.model.AvaliacaoFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvaliacaoFisicaRepository extends JpaRepository<AvaliacaoFisica, Long> {
    List<AvaliacaoFisica> findByAluno(Aluno aluno);

    long deleteByAluno(Aluno aluno);
}
