package com.example.alura.medvolli.sapi.domain.medico;

import com.example.alura.medvolli.sapi.domain.endereco.EnderecoDTO;

public record AtualizarMedicoDTO(
        String nome,
        String telefone,
        EnderecoDTO endereco) {

}
