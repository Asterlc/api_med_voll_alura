package com.example.alura.medvolli.sapi.infra.dto;

import org.springframework.validation.FieldError;

public record HandlerNotValidExceptionDTO(String field, String message) {
    public HandlerNotValidExceptionDTO(FieldError error){
        this(error.getField(), error.getDefaultMessage());
    }
}
