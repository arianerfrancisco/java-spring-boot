package com.example.demo.domain;

import lombok.*;

import javax.persistence.*;

@Entity // mapeamento com a tabela carro do banco de dados, coso o nome dessa classe fosse diferente
// do nome da tabela, precisaria ser da seguinte forma: @Entity(name="nomeDaTabela")
// @Getter @Setter @ToString @EqualsAndHashCode pode ser substituidos por @Data
@Data
@NoArgsConstructor
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //IDENTITY cria a chave primária com a própria notação de "auto_increment" do MySQL.
    private Long id;
    // caso o nome da coluna fosse direrente do nome desse atributo precisa ser mapeado:@Column(name="nomeDaColuna")
    private String nome;
    private String tipo;



}
