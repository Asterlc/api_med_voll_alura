package com.example.alura.medvolli.sapi.medico;

import com.example.alura.medvolli.sapi.endereco.Endereco;

public record MedicoDetailDTO(Long id, String nome, String email, String crm, String telefone,
                              EspecialidadeEnum especialidade, Endereco endereco) {
    public MedicoDetailDTO(Medico medico) {
        this(
                medico.getId(),
                medico.getNome(),
                medico.getEmail(),
                medico.getCrm(),
                medico.getTelefone(),
                medico.getEspecialidade(),
                medico.getEndereco()
        );
    }
}
