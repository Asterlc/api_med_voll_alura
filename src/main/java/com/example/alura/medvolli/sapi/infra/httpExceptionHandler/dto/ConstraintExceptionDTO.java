package com.example.alura.medvolli.sapi.infra.httpExceptionHandler.dto;

import java.sql.SQLIntegrityConstraintViolationException;

public record ConstraintExceptionDTO(String message, int code) {
    public ConstraintExceptionDTO(SQLIntegrityConstraintViolationException ex){
        this(ex.getMessage(), ex.getErrorCode());
    }
}
