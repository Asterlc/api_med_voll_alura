package com.example.alura.medvolli.sapi.controllers;

import com.example.alura.medvolli.sapi.medico.ListMedicosDTO;
import com.example.alura.medvolli.sapi.medico.Medico;
import com.example.alura.medvolli.sapi.medico.MedicoDTO;
import com.example.alura.medvolli.sapi.medico.MedicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medico")
@Transactional
public class MedicoController {
    @Autowired
    private MedicoRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody @Valid MedicoDTO data) {
        repository.save(new Medico(data));
    }

    @GetMapping
    public Page<ListMedicosDTO> listagem(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        return repository.findAll(paginacao).map(ListMedicosDTO::new);
    }
}
