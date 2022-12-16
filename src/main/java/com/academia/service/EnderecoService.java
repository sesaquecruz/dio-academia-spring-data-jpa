package com.academia.service;

import com.academia.exception.AlunoNotFoundException;
import com.academia.model.Aluno;
import com.academia.model.Endereco;
import com.academia.model.dto.EnderecoForm;
import com.academia.repository.AlunoRepository;
import com.academia.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {
    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Endereco> findAll(String cpf, String cep, String rua, String bairro) {
        if(cpf != null) {
            Optional<Aluno> alunoSaved = alunoRepository.findByCpf(cpf).stream().findFirst();

            if(alunoSaved.isEmpty())
                throw new AlunoNotFoundException();

            return enderecoRepository.findByAluno(alunoSaved.get());
        } if(cep != null)
            return enderecoRepository.findByCep(cep);
        if(rua != null)
            return enderecoRepository.findByRua(rua);
        if(bairro != null)
            return enderecoRepository.findByBairro(bairro);

        return enderecoRepository.findAll();
    }

    public Endereco update(EnderecoForm enderecoForm) {
        Optional<Aluno> alunoSaved = alunoRepository.findByCpf(enderecoForm.getAluno().getCpf()).stream().findFirst();

        if(alunoSaved.isEmpty())
            throw new AlunoNotFoundException();

        Optional<Endereco> enderecoSaved = enderecoRepository.findByAluno(alunoSaved.get()).stream().findFirst();

        Endereco endereco = enderecoSaved.orElseGet(Endereco::new);
        endereco.setCep(enderecoForm.getCep());
        endereco.setRua(enderecoForm.getRua());
        endereco.setNumero(enderecoForm.getNumero());
        endereco.setComplemento(enderecoForm.getComplemento());
        endereco.setBairro(enderecoForm.getBairro());

        return enderecoRepository.save(endereco);
    }
}
