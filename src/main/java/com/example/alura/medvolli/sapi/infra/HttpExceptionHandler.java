package com.example.alura.medvolli.sapi.infra;

import com.example.alura.medvolli.sapi.infra.dto.ConstraintHandlerDTO;
import com.example.alura.medvolli.sapi.infra.dto.HandlerNotValidExceptionDTO;
import com.example.alura.medvolli.sapi.infra.dto.NotReadableExceptionDTO;
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
        return ResponseEntity.badRequest().body(errors.stream().map(HandlerNotValidExceptionDTO::new).toList());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity handlerNotReadable(HttpMessageNotReadableException ex) {
        return ResponseEntity.badRequest().body(new NotReadableExceptionDTO(ex));
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity handlerConstraint(SQLIntegrityConstraintViolationException ex){
        return ResponseEntity.badRequest().body(new ConstraintHandlerDTO(ex.getMessage(), ex.getErrorCode()));
    }

}
