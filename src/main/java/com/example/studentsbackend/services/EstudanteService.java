package com.example.studentsbackend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentsbackend.dtos.EstudanteRequest;
import com.example.studentsbackend.dtos.EstudanteResponse;
import com.example.studentsbackend.entities.Estudante;
import com.example.studentsbackend.mappers.EstudanteMapper;
import com.example.studentsbackend.repositories.EstudanteRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EstudanteService {

    @Autowired
    private EstudanteRepository repository;

    public List<Estudante> getEstudantes() {
        return this.repository.findAll();
    }

    public Estudante getEstudante(Long id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Estudante not found"));
    }

    public void deleteEstudanteById(Long id) {
        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Estudante not found");
        }
    }

    public EstudanteResponse save(EstudanteRequest estudante) {
        var entity = this.repository.save(EstudanteMapper.toEntity(estudante));
        return EstudanteMapper.toDTO(entity);
    }

    public void update(Long id, Estudante estudante) {

        try {
            var updateEstudante = this.repository.getReferenceById(id);
            updateEstudante.setNome(estudante.getNome());
            updateEstudante.setIdade(estudante.getIdade());
            updateEstudante.setDataNascimento(estudante.getDataNascimento());
            updateEstudante.setCpf(estudante.getCpf());
            this.repository.save(updateEstudante);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Estudante not found");
        }

    }
}
