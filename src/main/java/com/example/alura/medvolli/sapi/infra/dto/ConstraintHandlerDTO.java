package com.example.alura.medvolli.sapi.infra.dto;

import java.sql.SQLIntegrityConstraintViolationException;

public record ConstraintHandlerDTO(String message, int Code) {
    public ConstraintHandlerDTO(SQLIntegrityConstraintViolationException ex){
        this(ex.getMessage(), ex.getErrorCode());
    }
}
