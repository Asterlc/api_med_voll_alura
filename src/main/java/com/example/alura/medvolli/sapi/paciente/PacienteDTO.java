package com.example.alura.medvolli.sapi.paciente;

import com.example.alura.medvolli.sapi.endereco.EnderecoDTO;

public record PacienteDTO(String nome, String email, EnderecoDTO endereco) {
}
