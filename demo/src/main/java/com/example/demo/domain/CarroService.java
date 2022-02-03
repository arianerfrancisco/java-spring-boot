package com.example.demo.domain;

import java.util.ArrayList;
import java.util.List;

public class CarroService {
 public List<Carro> getCarros(){
     List<Carro> carros = new ArrayList<>();
     carros.add(new Carro(1L,"Fusca")); // Esse L serve para dizer ao Java para que trate o número como sendo do tipo Long e não do tipo Int.
     carros.add(new Carro(1L,"Monza"));
     carros.add(new Carro(1L,"Chevete"));
     return carros;
 }
}
