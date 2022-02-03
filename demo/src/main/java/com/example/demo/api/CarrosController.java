package com.example.demo.api;

import com.example.demo.domain.Carro;
import com.example.demo.domain.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    // url: http://localhost:8080/api/v1/carros/(insere aqui o id)
    public Optional<Carro> get(@PathVariable("id") Long id){ // caso não tenha um carro correspondente ao id
        // o optional retorna null.
        return service.getCarroById(id);
    }

    @GetMapping("tipo/{tipo}")
    // http://localhost:8080/api/v1/carros/(insere o tipo: luxuoso, esportivo ou clássico)
    // exemplo>>> http://localhost:8080/api/v1/carros/tipo/esportivos
    public Iterable<Carro> getCarrosByTipo(@PathVariable("tipo") String tipo){
        return service.getCarroByTipo(tipo);
    }

}
