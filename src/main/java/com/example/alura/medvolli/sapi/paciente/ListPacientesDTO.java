package com.example.alura.medvolli.sapi.paciente;

import com.example.alura.medvolli.sapi.endereco.Endereco;
import com.example.alura.medvolli.sapi.endereco.EnderecoDTO;

public record ListPacientesDTO(String nome, String email, Endereco endereco, String telefone) {

    public ListPacientesDTO(Paciente paciente) {
        this(
                paciente.getNome(),
                paciente.getEmail(),
                paciente.getEndereco(),
                paciente.getTelefone()
        );
    }
}
