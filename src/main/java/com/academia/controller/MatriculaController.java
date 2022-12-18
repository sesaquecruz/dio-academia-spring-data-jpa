package com.academia.controller;

import com.academia.model.Matricula;
import com.academia.model.dto.MatriculaForm;
import com.academia.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/matricula")
public class MatriculaController {
    @Autowired
    private MatriculaService matriculaService;

    @GetMapping
    public ResponseEntity<List<Matricula>> getAll(
            @RequestParam(value = "cpf", required = false) String cpf,

            @RequestParam(value = "data", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data
            ) {
        return ResponseEntity.status(HttpStatus.OK).body(matriculaService.findAll(cpf, data));
    }

    @PostMapping
    public ResponseEntity<Matricula> create(@Valid @RequestBody MatriculaForm matriculaForm) {
        return ResponseEntity.status(HttpStatus.CREATED).body(matriculaService.save(matriculaForm));
    }
}
