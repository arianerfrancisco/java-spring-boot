package com.example.demo.domain;

import javax.persistence.*;

@Entity // mapeamento com a tabela carro do banco de dados, coso o nome dessa classe fosse diferente
// do nome da tabela, precisaria ser da seguinte forma: @Entity(name="nomeDaTabela")
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //IDENTITY cria a chave primária com a própria notação de "auto_increment" do MySQL.
    private Long id;
    // caso o nome da coluna fosse direrente do nome desse atributo precisa ser mapeado:@Column(name="nomeDaColuna")
    private String nome;

    public Carro() {
    }

    public Carro(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
