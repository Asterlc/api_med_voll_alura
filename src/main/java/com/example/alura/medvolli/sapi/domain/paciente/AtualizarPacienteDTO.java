package com.example.alura.medvolli.sapi.domain.paciente;

import com.example.alura.medvolli.sapi.domain.endereco.EnderecoDTO;

public record AtualizarPacienteDTO(
        String nome,
        String telefone,
        String email,
        EnderecoDTO endereco
) {
}
