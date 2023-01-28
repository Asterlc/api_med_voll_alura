package com.example.alura.medvolli.sapi.domain.paciente;

import com.example.alura.medvolli.sapi.domain.endereco.Endereco;

public record ListPacientesDTO(Long id, String nome, String email, Endereco endereco, String telefone) {

    public ListPacientesDTO(Paciente paciente) {
        this(
                paciente.getId(),
                paciente.getNome(),
                paciente.getEmail(),
                paciente.getEndereco(),
                paciente.getTelefone()
        );
    }
}
