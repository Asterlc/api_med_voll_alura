package com.example.alura.medvolli.sapi.infra.httpExceptionHandler;

import com.example.alura.medvolli.sapi.infra.httpExceptionHandler.dto.ConstraintExceptionDTO;
import com.example.alura.medvolli.sapi.infra.httpExceptionHandler.dto.NotValidExceptionDTO;
import com.example.alura.medvolli.sapi.infra.httpExceptionHandler.dto.NotReadableExceptionDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class HttpExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handlerNotFound() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handlerNotValid(MethodArgumentNotValidException ex) {
        var errors = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(errors.stream().map(NotValidExceptionDTO::new).toList());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity handlerNotReadable(HttpMessageNotReadableException ex) {
        return ResponseEntity.badRequest().body(new NotReadableExceptionDTO(ex));
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity handlerConstraint(SQLIntegrityConstraintViolationException ex){
        return ResponseEntity.badRequest().body(new ConstraintExceptionDTO(ex.getMessage(), ex.getErrorCode()));
    }

}
