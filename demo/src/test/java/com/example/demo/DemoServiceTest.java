package com.example.demo;

import com.example.demo.domain.Carro;
import com.example.demo.domain.CarroRepository;
import com.example.demo.domain.CarroService;
import com.example.demo.domain.dto.CarroDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

// NA METODOLOGIA TDD - ESCREVE-SE O TESTE ANTES DA LÓGICA
@SpringBootTest
class DemoServiceTest {
    @Autowired // Serve para injetar a classe abaixo.
    private CarroService service;

    @Test
    void testSave() {
        Carro carro = new Carro();
        carro.setNome("Ferrari");
        carro.setTipo("esportivos");
        CarroDTO c = service.insert(carro);
        assertNotNull(c);
        Long id = c.getId();
        assertNotNull(id);
        // Buscar o Objeto
        Optional<CarroDTO> op = service.getCarroById(id);
        assertTrue(op.isPresent());
        c = op.get(); // Confirmar se os dados deletados foram os passados para cancelamento
        assertEquals("Ferrari", c.getNome());
        assertEquals("esportivos", c.getTipo());
        //Deletar o objeto após os testes
        service.delete(id);
        // verificar se deletou
        assertFalse(service.getCarroById(id).isPresent());
    }

    @Test
    void testLista() {
		List<CarroDTO> carros = service.getCarros();
        assertEquals(30, carros.size());
	}
    @Test
    void testListaPorTipo() {
     //   List<CarroDTO> carros = service.getCarroByTipo("esportivos");
        assertEquals(10, service.getCarroByTipo("esportivos").size());// analisar sobre ids
    }
    @Test
    void testGet() {
        Optional<CarroDTO> op = service.getCarroById(11L); // analisar sobre ids
        assertTrue(op.isPresent());
        CarroDTO c = op.get();
        assertEquals("Ferrari FF", c.getNome());
    }
}
