package com.example.demo.api;

import com.example.demo.domain.Carro;
import com.example.demo.domain.CarroService;
import com.example.demo.domain.dto.CarroDTO;
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

    /*@GetMapping()
    public ResponseEntity<List<CarroDTO>> get(){
        // retorno codigo 200 salvamento concluido com sucesso
        return  ResponseEntity.ok(service.getCarros());
        // ou na segunte sintaxe >>>> return new ResponseEntity<>( service.getCarros(), HttpStatus.OK);
    }*/
    @GetMapping()
    public ResponseEntity get() {
        List<CarroDTO> carros = service.getCarros();
        return ResponseEntity.ok(carros);
    }

    @GetMapping("/{id}")
    // url: http://localhost:8080/api/v1/carros/(insere aqui o id)
    public ResponseEntity get(@PathVariable("id") Long id){ // caso não tenha um carro correspondente ao id
       Optional<Carro> carro = service.getCarroById(id); // o optional retorna null.
        // Algumas formas de implementar o condicional
        // --com lambda
       //  return carro.map( c ->  ResponseEntity.ok(c)), que pode ser escrito da maneira abaixo
        return carro
                .map(ResponseEntity::ok) // se existir ele retorna ok - código 200
                .orElse(ResponseEntity.notFound().build());
        // ----------- ternario ----------
        //return carro.isPresent() ? ResponseEntity.ok(carro.get()) : ResponseEntity.notFound().build();
        // --------- condicional if-else
       /** if(carro.isPresent()){
           return ResponseEntity.ok(carro.get());
       } else {
           return ResponseEntity.notFound().build();
       } **/
    }

    @GetMapping("tipo/{tipo}")
    // http://localhost:8080/api/v1/carros/(insere o tipo: luxuoso, esportivo ou clássico)
    // exemplo>>> http://localhost:8080/api/v1/carros/tipo/esportivos
    public ResponseEntity<List<CarroDTO>> getCarrosByTipo(@PathVariable("tipo") String tipo){
        List<CarroDTO> carros = service.getCarroByTipo(tipo);
        return carros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(carros);

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
