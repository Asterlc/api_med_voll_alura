package com.example.alura.medvolli.sapi.domain.medico;

public record ListMedicosDTO(Long id, String nome, String crm, String email, String telefone, EspecialidadeEnum especialidade) {
    public ListMedicosDTO(Medico medico) {
        this(
                medico.getId(),
                medico.getNome(),
                medico.getCrm(),
                medico.getEmail(),
                medico.getTelefone(),
                medico.getEspecialidade()
        );
    }
}
