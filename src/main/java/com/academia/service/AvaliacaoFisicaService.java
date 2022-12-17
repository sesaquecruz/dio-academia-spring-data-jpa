package com.academia.service;

import com.academia.exception.AlunoNotFoundException;
import com.academia.exception.MatriculaNotFoundException;
import com.academia.model.Aluno;
import com.academia.model.AvaliacaoFisica;
import com.academia.model.Matricula;
import com.academia.model.dto.AvaliacaoFisicaForm;
import com.academia.repository.AlunoRepository;
import com.academia.repository.AvaliacaoFisicaRepository;
import com.academia.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AvaliacaoFisicaService {
    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private MatriculaRepository matriculaRepository;
    @Autowired
    private AvaliacaoFisicaRepository avaliacaoFisicaRepository;

    public List<AvaliacaoFisica> findAll(String cpf) {
        if(cpf != null) {
            Optional<Aluno> alunoSaved = alunoRepository.findByCpf(cpf).stream().findFirst();

            if (alunoSaved.isEmpty())
                throw new AlunoNotFoundException();

            return avaliacaoFisicaRepository.findByAluno(alunoSaved.get());
        }

        return avaliacaoFisicaRepository.findAll();
    }

    @Transactional
    public AvaliacaoFisica save(AvaliacaoFisicaForm avaliacaoFisicaForm) {
        Optional<Aluno> alunoSaved = alunoRepository.findByCpf(avaliacaoFisicaForm.getAluno().getCpf()).stream().findFirst();

        if(alunoSaved.isEmpty())
            throw new AlunoNotFoundException();

        Optional<Matricula> matriculaSaved = matriculaRepository.findByAluno(alunoSaved.get()).stream().findFirst();

        if(matriculaSaved.isEmpty())
            throw new MatriculaNotFoundException();

        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
        avaliacaoFisica.setPeso(avaliacaoFisicaForm.getPeso());
        avaliacaoFisica.setAltura(avaliacaoFisicaForm.getAltura());
        avaliacaoFisica.setData(LocalDate.now());
        avaliacaoFisica.setAluno(alunoSaved.get());

        return avaliacaoFisicaRepository.save(avaliacaoFisica);
    }
}
