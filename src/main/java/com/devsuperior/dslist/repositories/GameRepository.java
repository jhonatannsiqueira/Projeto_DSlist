package com.devsuperior.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> { 
	// Informa <Tipo da Entity e o Tipo do Id da Entity>
	// interface Repository é a camada responsável por acesso aos Dados do Banco

}