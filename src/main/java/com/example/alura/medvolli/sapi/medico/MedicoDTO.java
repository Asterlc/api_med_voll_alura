package com.example.alura.medvolli.sapi.medico;

import com.example.alura.medvolli.sapi.endereco.EnderecoDTO;

public record MedicoDTO(String nome, String email, String crm, EspecialidadeEnum especialidade, EnderecoDTO endereco) {
}
