package com.java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.entities.Estudante;

public interface EstudanteRepository  extends JpaRepository<Estudante,Long>{
    
}
