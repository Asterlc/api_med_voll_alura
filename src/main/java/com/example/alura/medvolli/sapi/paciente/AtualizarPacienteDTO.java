package com.example.alura.medvolli.sapi.paciente;

import com.example.alura.medvolli.sapi.endereco.EnderecoDTO;

public record AtualizarPacienteDTO(
        String nome,
        String telefone,
        String email,
        EnderecoDTO endereco
) {
}
