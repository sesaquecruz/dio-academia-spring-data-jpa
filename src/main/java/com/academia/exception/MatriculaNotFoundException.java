package com.academia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class MatriculaNotFoundException extends RuntimeException {
    public MatriculaNotFoundException() {
        super("Matrícula não encontrada");
    }
}
