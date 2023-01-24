package com.example.alura.medvolli.sapi.medico;

public record ListMedicosDTO(String nome, String crm , String email, EspecialidadeEnum especialidade) {
    public ListMedicosDTO(Medico medico) {
        this(medico.getNome(), medico.getCrm(), medico.getEmail(), medico.getEspecialidade());
    }
}
