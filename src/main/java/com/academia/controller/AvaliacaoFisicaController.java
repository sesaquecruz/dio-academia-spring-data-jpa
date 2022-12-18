package com.academia.controller;

import com.academia.model.AvaliacaoFisica;
import com.academia.model.dto.AvaliacaoFisicaForm;
import com.academia.service.AvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/avaliacao-fisica")
public class AvaliacaoFisicaController {
    @Autowired
    private AvaliacaoFisicaService avaliacaoFisicaService;

    @GetMapping
    public ResponseEntity<List<AvaliacaoFisica>> getAll(
            @RequestParam(value = "cpf", required = false) String cpf
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(avaliacaoFisicaService.findAll(cpf));
    }

    @PostMapping
    public ResponseEntity<AvaliacaoFisica> create(@Valid @RequestBody AvaliacaoFisicaForm avaliacaoFisicaForm) {
        return ResponseEntity.status(HttpStatus.CREATED).body(avaliacaoFisicaService.save(avaliacaoFisicaForm));
    }
}
