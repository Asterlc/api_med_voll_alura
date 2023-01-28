package com.example.alura.medvolli.sapi.infra.httpExceptionHandler.dto;

public record NotReadableExceptionDTO(String message) {
    public NotReadableExceptionDTO(Exception ex) {
        this(ex.getMessage());
    }
}
