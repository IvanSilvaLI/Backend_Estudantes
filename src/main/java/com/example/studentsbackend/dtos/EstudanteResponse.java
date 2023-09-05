package com.example.studentsbackend.dtos;

import java.util.Map;

public record EstudanteResponse(
    Long id,
    String nome,
    int idade,
    String dataNascimento,
    String cpf
) {

    public Map<String, ?> getId() {
        return null;
    }
    
}
