package com.example.demo.api.exception;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // permite que essa classe intercepte alguns eventos de rest, inclusive as exceções

public class ExceptionConfig {

    @ExceptionHandler({
            EmptyResultDataAccessException.class // quando tenta cancelar um id inexistente
    })
    public ResponseEntity errorNotFound(Exception ex) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler({
            IllegalAccessException.class // quando tenta inserir um carro com o numero da id
    })
    public ResponseEntity errorBadRequest(Exception ex) {
        return ResponseEntity.badRequest().build();
    }
}
