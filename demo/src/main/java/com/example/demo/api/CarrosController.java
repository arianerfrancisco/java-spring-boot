package com.example.demo.api;

import com.example.demo.domain.Carro;
import com.example.demo.domain.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/carros")
// chamada: http://localhost:8080/api/v1/carros
public class CarrosController {
    @Autowired
    // A classe CarroService foi marcada com @Service, assim pode ser invocada atraves desta injeção
    // não sendo necessiario ser instanciada com new CarroService();
    private CarroService service;

    @GetMapping()
    public Iterable<Carro> get(){
        return service.getCarros();
    }


}
