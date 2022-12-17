package com.academia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class AlunoAlreadyExistsException extends RuntimeException {
    public AlunoAlreadyExistsException() {
        super("Aluno já existe");
    }
}
