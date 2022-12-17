package com.academia.repository;

import com.academia.model.Aluno;
import com.academia.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    List<Endereco> findByCep(String cep);

    List<Endereco> findByRua(String rua);

    List<Endereco> findByBairro(String bairro);

    List<Endereco> findByAluno(Aluno aluno);

    long deleteByAluno(Aluno aluno);
}
