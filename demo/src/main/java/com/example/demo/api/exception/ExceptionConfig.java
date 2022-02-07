package com.example.demo.api.exception;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice // permite que essa classe intercepte alguns eventos  rest, inclusive as exceções

public class ExceptionConfig extends ResponseEntityExceptionHandler {
    // tratando as exception nesta classe, retira-se os try e catch da classe controller. Atribuindo aqui
    // a responsabilidade para o tratamento desses casos.

    @ExceptionHandler({
            EmptyResultDataAccessException.class // quando tenta cancelar um id inexistente
    })
    public ResponseEntity errorNotFound(Exception ex) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler({
            IllegalArgumentException.class // quando tenta inserir um carro com o numero da id
    })
    public ResponseEntity errorBadRequest(Exception ex) {
        return ResponseEntity.badRequest().build();
    }

}
