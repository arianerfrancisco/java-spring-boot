package com.example.demo.domain.dto;

import com.example.demo.domain.Carro;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class CarroDTO {
    private Long id;
    private String nome;
    private String tipo;

    public static CarroDTO create(Carro carro) { // converte Carro para CarroDTO
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(carro, CarroDTO.class);
    }
}
