package com.academia.controller;

import com.academia.model.Aluno;
import com.academia.model.dto.AlunoCpf;
import com.academia.model.dto.AlunoForm;
import com.academia.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<Aluno>> getAll(
            @RequestParam(value = "cpf", required = false) String cpf,
            @RequestParam(value = "nome", required = false) String nome,

            @RequestParam(value = "dataNascimento", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataNascimento
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.findAll(cpf, nome, dataNascimento));
    }

    @PostMapping
    public ResponseEntity<Aluno> create(@Valid @RequestBody AlunoForm alunoForm) {
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.save(alunoForm));
    }

    @PutMapping
    public ResponseEntity<Aluno> update(@Valid @RequestBody AlunoForm alunoForm) {
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.update(alunoForm));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@Valid @RequestBody AlunoCpf alunoCpf) {
        alunoService.delete(alunoCpf);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
