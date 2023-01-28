package com.example.alura.medvolli.sapi.domain.paciente;

import com.example.alura.medvolli.sapi.domain.endereco.EnderecoDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record PacienteDTO(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotNull
        @Valid
        EnderecoDTO endereco,
        @NotBlank
        @Pattern(regexp = "\\d{8,9}")
        String telefone) {

}
