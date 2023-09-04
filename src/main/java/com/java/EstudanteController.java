package com.java;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.java.dtos.EstudanteRequest;
import com.java.dtos.EstudanteResponse;
import com.java.entities.Estudante;
import com.java.services.EstudanteService;


@RestController
@RequestMapping("estudantes")
public class EstudanteController {

    @Autowired
    private EstudanteService service;

    @GetMapping
    public ResponseEntity<List<Estudante>> getEstudantes() {
        var estudantes = this.service.getEstudantes();
        return ResponseEntity.ok(estudantes);
    }

    @GetMapping("{id}")
    public ResponseEntity<Estudante> getEstudante(@PathVariable Long id) {
        var estudante = this.service.getEstudante(id);
        return ResponseEntity.ok(estudante);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteEstudante(@PathVariable Long id) {
        this.service.deleteEstudanteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<EstudanteResponse> save(@Validated @RequestBody EstudanteRequest estudante) {
        var savedEstudante = this.service.save(estudante);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedEstudante.getId())
                .toUri();

        return ResponseEntity.created(location).body(savedEstudante);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@RequestBody Estudante estudante,
                                       @PathVariable Long id) {
        this.service.update(id, estudante);
        return ResponseEntity.ok().build();
    }
}
