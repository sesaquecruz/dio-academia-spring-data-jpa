package com.academia.service;

import com.academia.exception.AlunoAlreadyExistsException;
import com.academia.exception.AlunoNotFoundException;
import com.academia.model.Aluno;
import com.academia.model.Endereco;
import com.academia.model.dto.AlunoCpf;
import com.academia.model.dto.AlunoForm;
import com.academia.repository.AlunoRepository;
import com.academia.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Aluno> findAll(String cpf, String nome, LocalDate dataNascimento) {
        if(cpf != null)
            return alunoRepository.findByCpf(cpf);
        if(nome != null)
            return alunoRepository.findByNome(nome);
        if(dataNascimento != null)
            return alunoRepository.findByDataNascimento(dataNascimento);

        return alunoRepository.findAll();
    }

    public Aluno save(AlunoForm alunoForm) {
        Optional<Aluno> alunoSaved = alunoRepository.findByCpf(alunoForm.getCpf()).stream().findFirst();

        if(!alunoSaved.isEmpty())
            throw new AlunoAlreadyExistsException();

        Aluno aluno = new Aluno();
        aluno.setCpf(alunoForm.getCpf());
        aluno.setDataNascimento(alunoForm.getDataNascimento());
        aluno.setNome(alunoForm.getNome());
        aluno.setTelefone(alunoForm.getTelefone());
        aluno.setEmail(alunoForm.getEmail());

        Endereco endereco = new Endereco();
        endereco.setCep(alunoForm.getEndereco().getCep());
        endereco.setRua(alunoForm.getEndereco().getRua());
        endereco.setNumero(alunoForm.getEndereco().getNumero());
        endereco.setComplemento(alunoForm.getEndereco().getComplemento());
        endereco.setBairro(alunoForm.getEndereco().getBairro());

        aluno = alunoRepository.save(aluno);
        endereco.setAluno(aluno);
        enderecoRepository.save(endereco);

        return aluno;
    }

    public Aluno update(AlunoForm alunoForm) {
        Optional<Aluno> alunoSaved = alunoRepository.findByCpf(alunoForm.getCpf()).stream().findFirst();

        if(alunoSaved.isEmpty())
            throw new AlunoNotFoundException();

        Optional<Endereco> enderecoSaved = enderecoRepository.findByAluno(alunoSaved.get()).stream().findFirst();

        if(enderecoSaved.isEmpty())
            throw new AlunoNotFoundException();

        Aluno aluno = alunoSaved.get();
        aluno.setCpf(alunoForm.getCpf());
        aluno.setDataNascimento(alunoForm.getDataNascimento());
        aluno.setNome(alunoForm.getNome());
        aluno.setTelefone(alunoForm.getTelefone());
        aluno.setEmail(alunoForm.getEmail());

        Endereco endereco = enderecoSaved.get();
        endereco.setCep(alunoForm.getEndereco().getCep());
        endereco.setRua(alunoForm.getEndereco().getRua());
        endereco.setNumero(alunoForm.getEndereco().getNumero());
        endereco.setComplemento(alunoForm.getEndereco().getComplemento());
        endereco.setBairro(alunoForm.getEndereco().getBairro());

        aluno = alunoRepository.save(aluno);
        enderecoRepository.save(endereco);

        return aluno;
    }

    public void delete(AlunoCpf alunoCpf) {
        Optional<Aluno> alunoSaved = alunoRepository.findByCpf(alunoCpf.getCpf()).stream().findFirst();

        if(alunoSaved.isEmpty())
            throw new AlunoNotFoundException();

        Optional<Endereco> enderecoSaved = enderecoRepository.findByAluno(alunoSaved.get()).stream().findFirst();

        if(enderecoSaved.isEmpty())
            throw new AlunoNotFoundException();

        enderecoRepository.delete(enderecoSaved.get());
        alunoRepository.delete(alunoSaved.get());
    }
}
