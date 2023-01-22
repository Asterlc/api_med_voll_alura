package com.example.alura.medvolli.sapi.endereco;

public record EnderecoDTO(
        String rua,
        String numero,
        String bairro,
        String logradouro,
        String cep,
        String complemento,
        String cidade,
        String uf
) {
}
