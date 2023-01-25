package com.example.alura.medvolli.sapi.medico;

import com.example.alura.medvolli.sapi.endereco.EnderecoDTO;

public record AtualizarMedicoDTO(
        String nome,
        String telefone,
        EnderecoDTO endereco) {

}
