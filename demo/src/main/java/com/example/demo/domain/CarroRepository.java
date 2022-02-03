package com.example.demo.domain;

import org.springframework.data.repository.CrudRepository;

public interface CarroRepository extends CrudRepository<Carro, Long> {
    Iterable<Carro> findByTipo(String tipo);
    // classe que fará a correspondencia com o banco de dados
}
