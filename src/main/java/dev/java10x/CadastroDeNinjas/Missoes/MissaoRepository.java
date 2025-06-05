package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.data.jpa.repository.JpaRepository;

//Abstração para as queries do BD
//ORM (Object Relational Mapping) fica scanneando a classe MissaoModel e o tipo do id para criar a PK da tabela
public interface MissaoRepository extends JpaRepository<MissaoModel,Long>{

}
