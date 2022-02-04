package com.example.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarroRepository extends JpaRepository<Carro, Long> {
    // JPARepository é filha de CrudRepository
    // possue os mesmos metodos, mas a vantagem que seu metodo findAll retorna um List
    List<Carro> findByTipo(String tipo);
    // classe que fará a correspondencia com o banco de dados
}
