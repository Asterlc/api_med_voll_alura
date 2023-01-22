package com.example.alura.medvolli.sapi.medico;

import com.example.alura.medvolli.sapi.endereco.EnderecoDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record MedicoDTO(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Pattern(regexp = "\\d{8,9}")
        String telefone,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,

        @NotNull
        EspecialidadeEnum especialidade,
        @NotNull
        @Valid
        EnderecoDTO endereco) {
}
