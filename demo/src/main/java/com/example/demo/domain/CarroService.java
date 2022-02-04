package com.example.demo.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service // agora essa classe pode ser invocada por outra classe através da injeção @Autowired
public class CarroService {

    @Autowired
    private CarroRepository rep;
    public Iterable<Carro> getCarros() {
        return rep.findAll();
    }

    public Optional<Carro> getCarroById(Long id) {
        return rep.findById(id);
    }

    public List<Carro> getCarroByTipo(String tipo) {
        return rep.findByTipo(tipo);
    }

    public List<Carro> getCarrosFake() {
        List<Carro> carros = new ArrayList<>();
        carros.add(new Carro(1L, "Fusca")); // Esse L serve para dizer ao Java para que trate o número como sendo do tipo Long e não do tipo Int.
        carros.add(new Carro(1L, "Monza"));
        carros.add(new Carro(1L, "Chevete"));
        return carros;
    }

    public Carro insert(Carro carro) {
        Assert.isNull(carro.getId(),"Não foi possível inserir o registro");
       return rep.save(carro);
    }

    public  Carro update(Carro carro, Long id) {
        Assert.isNull(carro.getId(),"Não foi possível atualizar o registro");
        // Busca o carro no banco de dados
        Optional<Carro> optional = getCarroById(id);
        if(optional.isPresent()) {
            Carro db = optional.get();
            // Copiar as propriedades
            db.setNome(carro.getNome());
            db.setTipo(carro.getTipo());
            System.out.println("Carro id: " + db.getId());
            // Atualiza o carro
            rep.save(db);
            return db;
        } else {
            throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        Optional<Carro> carro = getCarroById(id);
        if(carro.isPresent()){
            rep.deleteById(id);
        }
    }
}
