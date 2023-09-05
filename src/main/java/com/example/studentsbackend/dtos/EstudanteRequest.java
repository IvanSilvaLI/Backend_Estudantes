package com.example.studentsbackend.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record EstudanteRequest(
    
    @NotBlank(message = "Nome não pode ser em branco")
    String name,
    
    @Min(value = 0, message = "O valor mínimo para o preço é zero")
    double price
) {

    public int idade() {
        return 0;
    }

    public String cpf() {
        return null;
    }

    public String dataNascimento() {
        return null;
    }
    
}