package com.example.studentsbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentsbackend.entities.Estudante;

public interface EstudanteRepository  extends JpaRepository<Estudante,Long>{
    
}
