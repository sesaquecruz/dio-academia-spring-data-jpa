package com.academia.repository;

import com.academia.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    List<Aluno> findByCpf(String cpf);

    List<Aluno> findByDataNascimento(LocalDate dataNascimento);

    List<Aluno> findByNome(String nome);
}
