package com.academia.repository;

import com.academia.model.Aluno;
import com.academia.model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
    List<Matricula> findByData(LocalDate data);

    List<Matricula> findByAluno(Aluno aluno);

    long deleteByAluno(Aluno aluno);
}
