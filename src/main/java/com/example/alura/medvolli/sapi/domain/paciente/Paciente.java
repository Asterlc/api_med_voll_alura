package com.example.alura.medvolli.sapi.domain.paciente;

import com.example.alura.medvolli.sapi.domain.endereco.Endereco;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "pacientes")
@Entity(name="Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    @Embedded
    private Endereco endereco;
    private String telefone;

    public Paciente(PacienteDTO dto){
        this.id = null;
        this.nome = dto.nome();
        this.email = dto.email();
        this.endereco = new Endereco(dto.endereco());
        this.telefone = dto.telefone();
    }

    public void atualizarInformacoes(AtualizarPacienteDTO data) {
        if(data.nome() != null){
            this.nome = data.nome();
        }
        if(data.email() != null){
            this.email = data.email();
        }

        if(data.nome() != null){
            this.telefone = data.telefone();
        }
    }
}
