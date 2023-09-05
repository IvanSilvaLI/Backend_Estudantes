package com.example.studentsbackend.mappers;


import com.example.studentsbackend.dtos.EstudanteRequest;
import com.example.studentsbackend.dtos.EstudanteResponse;
import com.example.studentsbackend.entities.Estudante;

public class EstudanteMapper {

    public static Estudante toEntity(EstudanteRequest request) {
        Estudante estudante = new Estudante();
        estudante.setNome(request.name());
        estudante.setIdade(request.idade());
        estudante.setDataNascimento(request.dataNascimento());
        estudante.setCpf(request.cpf());
        return estudante;
    }

    public static EstudanteResponse toDTO(Estudante estudante) {
        return new EstudanteResponse(estudante.getId(),
                estudante.getNome(),
                estudante.getIdade(),
                estudante.getDataNascimento(),
                estudante.getCpf());
    }

}
