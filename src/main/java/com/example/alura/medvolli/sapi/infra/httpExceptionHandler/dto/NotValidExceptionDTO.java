package com.example.alura.medvolli.sapi.infra.httpExceptionHandler.dto;

import org.springframework.validation.FieldError;

public record NotValidExceptionDTO(String field, String message) {
    public NotValidExceptionDTO(FieldError error){
        this(error.getField(), error.getDefaultMessage());
    }
}
