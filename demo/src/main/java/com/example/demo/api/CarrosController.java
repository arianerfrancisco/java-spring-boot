package com.example.demo.api;

import com.example.demo.domain.Carro;
import com.example.demo.domain.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Iterable<Carro>> get(){
        return  ResponseEntity.ok(service.getCarros());
        // ou na segunte sintaxe >>>> return new ResponseEntity<>( service.getCarros(), HttpStatus.OK);
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
    @PostMapping
    public String post(@RequestBody Carro carro) {
        // http://localhost:8080/api/v1/carros
        Carro c = service.insert(carro);
        return "Carro salvo com sucesso" + c.getId();
    }

    // atualizar um carro a partir do id passado na url
    // http://localhost:8080/api/v1/carros/'aqui coloca o id'
    @PutMapping("/{id}")
    public String put(@PathVariable("id") Long id, @RequestBody Carro carro ){
        Carro c = service.update(carro, id);
        return "Carro atualizado com sucesso" + c.getId();
    }
@DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        service.delete(id);
        return "Carro deletado com sucesso";
}
}
