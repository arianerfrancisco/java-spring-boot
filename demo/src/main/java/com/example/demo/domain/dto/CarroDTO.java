package com.example.demo.domain.dto;

import com.example.demo.domain.Carro;
import lombok.Data;

@Data
public class CarroDTO {
    private Long id;
    private String nome;
    private String tipo;

    public CarroDTO(Carro carro) {
        this.id = carro.getId();
        this.nome = carro.getNome();
        this.tipo = carro.getTipo();
    }

}
