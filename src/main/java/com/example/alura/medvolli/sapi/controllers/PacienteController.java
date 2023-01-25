package com.example.alura.medvolli.sapi.controllers;

import com.example.alura.medvolli.sapi.medico.AtualizarMedicoDTO;
import com.example.alura.medvolli.sapi.medico.ListMedicosDTO;
import com.example.alura.medvolli.sapi.medico.Medico;
import com.example.alura.medvolli.sapi.medico.MedicoDTO;
import com.example.alura.medvolli.sapi.paciente.AtualizarPacienteDTO;
import com.example.alura.medvolli.sapi.paciente.ListPacientesDTO;
import com.example.alura.medvolli.sapi.paciente.Paciente;
import com.example.alura.medvolli.sapi.paciente.PacienteDTO;
import com.example.alura.medvolli.sapi.paciente.PacienteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    @Autowired
    private PacienteRepository pacienteRepository;
    @PostMapping
    public void cadastrar(@RequestBody @Valid PacienteDTO data){
        pacienteRepository.save(new Paciente(data));
    }

    @GetMapping
    public Page<ListPacientesDTO> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return pacienteRepository.findAll(paginacao).map(ListPacientesDTO::new);
    }

    @GetMapping("/{id}")
    public Stream listarPorId(@PathVariable Long id) {
        return pacienteRepository.findById(id).stream().map(ListPacientesDTO::new);
    }

    @PutMapping("/{id}")
    @Transactional
    public void atualizar(@RequestBody @Valid AtualizarPacienteDTO data, @PathVariable Long id) {
        var paciente = pacienteRepository.getReferenceById(id);
        paciente.atualizarInformacoes(data);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        pacienteRepository.deleteById(id);
    }
}
