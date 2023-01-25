package com.example.alura.medvolli.sapi.controllers;

import com.example.alura.medvolli.sapi.medico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/medico")
public class MedicoController {
    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid MedicoDTO data, UriComponentsBuilder uriBuilder) {
        var medico = new Medico(data);
        medicoRepository.save(medico);
        var uri = uriBuilder.path("/medico/detail/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(uri).body(new MedicoDetailDTO(medico));
    }

    @GetMapping
    public ResponseEntity<Page<ListMedicosDTO>> listagemAtivos(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        var medicoList = medicoRepository.findAllByAtivoTrue(paginacao).map(ListMedicosDTO::new);
        return ResponseEntity.ok(medicoList);
    }

    @GetMapping("detail")
    public ResponseEntity<Page<MedicoDetailDTO>> listagemAtivosDetalhado(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        var medicoListDetail = medicoRepository.findAllByAtivoTrue(paginacao).map(MedicoDetailDTO::new);
        return ResponseEntity.ok(medicoListDetail);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<MedicoDetailDTO> listarDetalhePorId(@PathVariable Long id) {
        var medico = medicoRepository.getReferenceById(id);
        return ResponseEntity.ok(new MedicoDetailDTO(medico));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid AtualizarMedicoDTO data, @PathVariable Long id) {
        var medico = medicoRepository.getReferenceById(id);
        medico.atualizarInformacoes(data);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var medico = medicoRepository.getReferenceById(id);
        medico.excluir();
        return ResponseEntity.noContent().build();
    }
}
