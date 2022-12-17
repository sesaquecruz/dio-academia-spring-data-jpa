package com.academia.service;

import com.academia.exception.AlunoNotFoundException;
import com.academia.exception.MatriculaAlreadyExistsException;
import com.academia.model.Aluno;
import com.academia.model.Matricula;
import com.academia.model.dto.MatriculaForm;
import com.academia.repository.AlunoRepository;
import com.academia.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class MatriculaService {
    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private MatriculaRepository matriculaRepository;

    public List<Matricula> findAll(String cpf, LocalDate data) {
        if(cpf != null) {
            Optional<Aluno> alunoSaved = alunoRepository.findByCpf(cpf).stream().findFirst();

            if (alunoSaved.isEmpty())
                throw new AlunoNotFoundException();

            return matriculaRepository.findByAluno(alunoSaved.get());
        } if(data != null)
            return matriculaRepository.findByData(data);

        return matriculaRepository.findAll();
    }

    public Matricula save(MatriculaForm matriculaForm) {
        Optional<Aluno> alunoSaved = alunoRepository.findByCpf(matriculaForm.getAluno().getCpf()).stream().findFirst();

        if(alunoSaved.isEmpty())
            throw new AlunoNotFoundException();

        Optional<Matricula> matriculaSaved = matriculaRepository.findByAluno(alunoSaved.get()).stream().findFirst();

        if(!matriculaSaved.isEmpty())
            throw new MatriculaAlreadyExistsException();

        Matricula matricula = new Matricula();
        matricula.setData(LocalDate.now());
        matricula.setAluno(alunoSaved.get());

        return matriculaRepository.save(matricula);
    }
}
