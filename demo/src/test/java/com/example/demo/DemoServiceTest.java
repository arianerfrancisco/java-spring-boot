package com.example.demo;

import com.example.demo.api.exception.ObjectNotFoundException;
import com.example.demo.domain.Carro;
import com.example.demo.domain.CarroService;
import com.example.demo.domain.dto.CarroDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


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
        c = service.getCarroById(id);
        assertNotNull(c);
        assertEquals("Ferrari", c.getNome());
        assertEquals("esportivos", c.getTipo());
        //Deletar o objeto após os testes
        service.delete(id);
        // verificar se deletou
        try {
            assertNotNull(service.getCarroById(id));
            fail("O carro não foi excluido");
        } catch (ObjectNotFoundException e) {
            //ok
        }

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
        CarroDTO c = service.getCarroById(11L); // analisar sobre ids
        assertNotNull(c);
        assertEquals("Ferrari FF", c.getNome());
    }
}
