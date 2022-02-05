package com.example.demo.domain;

import com.example.demo.domain.dto.CarroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service // agora essa classe pode ser invocada por outra classe através da injeção @Autowired
public class CarroService {

    @Autowired
    private CarroRepository rep;
    public List<CarroDTO> getCarros() {
       List<CarroDTO> list = rep.findAll().stream().map(CarroDTO::create).collect(Collectors.toList());
      return list;
    }

    public Optional<CarroDTO> getCarroById(Long id) {
        return rep.findById(id).map(CarroDTO::create);
    }

    public List<CarroDTO> getCarroByTipo(String tipo) {
        return rep.findByTipo(tipo).stream().map(CarroDTO::create).collect(Collectors.toList());
    }

    public CarroDTO insert(Carro carro) {
        Assert.isNull(carro.getId(),"Não foi possível inserir o registro");
       return CarroDTO.create(rep.save(carro));
    }

    public  CarroDTO  update(Carro carro, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro"); // validar a inserção
        // apenas se o id não estiver nulo
        // Busca o carro no banco de dados
        Optional<Carro> optional = rep.findById(id);
        if(optional.isPresent()) {
            Carro db = optional.get();
            // Copiar as propriedades
            db.setNome(carro.getNome());
            db.setTipo(carro.getTipo());
            System.out.println("Carro id: " + db.getId());
            // Atualiza o carro
            rep.save(db);
            return CarroDTO.create(db);
        } else {
            return null;
        }
    }

    public  void delete(Long id) {
            rep.deleteById(id);
    }
}
