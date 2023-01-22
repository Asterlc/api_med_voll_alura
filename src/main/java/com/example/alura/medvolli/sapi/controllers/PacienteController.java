package com.example.alura.medvolli.sapi.controllers;

import com.example.alura.medvolli.sapi.paciente.PacienteDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    @PostMapping
    public void cadastroPaciente(@RequestBody PacienteDTO data){
        System.out.println(data);
    }
}
