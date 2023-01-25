package com.example.alura.medvolli.sapi.controllers;

import com.example.alura.medvolli.sapi.medico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping("/medico")

public class MedicoController {
    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid MedicoDTO data) {
        repository.save(new Medico(data));
    }

    @GetMapping
    public Page<ListMedicosDTO> listagemAtivos(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(ListMedicosDTO::new);
    }

    @GetMapping("/{id}")
    public Stream listarPorId(@PathVariable Long id) {
        return repository.findById(id).stream().map(ListMedicosDTO::new);
    }

    @PutMapping("/{id}")
    @Transactional
    public void atualizar(@RequestBody @Valid AtualizarMedicoDTO data, @PathVariable Long id) {
        var medico = repository.getReferenceById(id);
        medico.atualizarInformacoes(data);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);
        medico.excluir();
    }
}
