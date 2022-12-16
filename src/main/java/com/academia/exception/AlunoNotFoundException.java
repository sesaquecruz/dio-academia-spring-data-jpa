package com.academia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class AlunoNotFoundException extends RuntimeException {
    public AlunoNotFoundException() {
        super("Aluno não encontrado");
    }
}
