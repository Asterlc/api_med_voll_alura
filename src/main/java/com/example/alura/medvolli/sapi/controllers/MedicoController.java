package com.example.alura.medvolli.sapi.controllers;

import com.example.alura.medvolli.sapi.medico.MedicoDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medico")
public class MedicoController {
    @PostMapping
    public void cadastrar(@RequestBody MedicoDTO data) {
          System.out.println(data);
    }
}
