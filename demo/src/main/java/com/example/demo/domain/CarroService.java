package com.example.demo.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service // agora essa classe pode ser invocada por outra classe através da injeção @Autowired
public class CarroService {

    @Autowired
    private CarroRepository rep;
    public Iterable<Carro> getCarros() {
        return rep.findAll();
    }

    public List<Carro> getCarrosFake() {
        List<Carro> carros = new ArrayList<>();
        carros.add(new Carro(1L, "Fusca")); // Esse L serve para dizer ao Java para que trate o número como sendo do tipo Long e não do tipo Int.
        carros.add(new Carro(1L, "Monza"));
        carros.add(new Carro(1L, "Chevete"));
        return carros;
    }
}
