package com.example.alura.medvolli.sapi.medico;

import com.example.alura.medvolli.sapi.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String crm;
    @Enumerated(EnumType.STRING)
    private EspecialidadeEnum especialidade;
    @Embedded
    private Endereco endereco;

    public Medico(MedicoDTO data) {
        this.id = null;
        this.nome = data.nome();
        this.email = data.email();
        this.crm = data.crm();
        this.especialidade = data.especialidade();
        this.endereco = new Endereco(data.endereco());
    }
}
