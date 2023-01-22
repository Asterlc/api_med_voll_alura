package com.example.alura.medvolli.sapi.controllers;

import com.example.alura.medvolli.sapi.medico.Medico;
import com.example.alura.medvolli.sapi.medico.MedicoDTO;
import com.example.alura.medvolli.sapi.medico.MedicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medico")
@Transactional
public class MedicoController {
    @Autowired
    private MedicoRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody MedicoDTO data) {
        repository.save(new Medico(data));
    }
}
