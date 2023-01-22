package com.example.alura.medvolli.sapi.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    private String rua;
    private String numero;
    private String bairro;
    private String logradouro;
    private String telefone = "0";

    private String complemento;
    private String uf;
    private String cep;
    private String cidade;

    public Endereco(EnderecoDTO dto) {
        this.logradouro = dto.logradouro();
        this.rua = dto.rua();
        this.numero = dto.numero();
        this.complemento = dto.complemento();
        this.uf= dto.uf();
        this.cep = dto.cep();
        this.bairro = dto.bairro();
        this.cidade = dto.cidade();

    }
}
