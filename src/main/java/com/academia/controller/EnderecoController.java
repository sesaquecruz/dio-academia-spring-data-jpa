package com.academia.controller;

import com.academia.model.Endereco;
import com.academia.model.dto.EnderecoForm;
import com.academia.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<List<Endereco>> getAll(
            @RequestParam(value = "cpf", required = false) String cpf,
            @RequestParam(value = "cep", required = false) String cep,
            @RequestParam(value = "rua", required = false) String rua,
            @RequestParam(value = "bairro", required = false) String bairro
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.findAll(cpf, cep, rua, bairro));
    }

    @PutMapping
    public ResponseEntity<Endereco> update(@RequestBody EnderecoForm enderecoForm) {
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.update(enderecoForm));
    }
}
