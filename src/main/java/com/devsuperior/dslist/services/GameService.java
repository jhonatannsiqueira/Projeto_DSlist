package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;

@Service // Registra a service como um Componente do Sistema
public class GameService {
	// Service é o componente responsável por implementar a Lógica/Regra de Negócio

	@Autowired // Injetar
	private GameRepository gameRepository;

	public List<GameMinDTO> findAll() {
		List<Game> result = gameRepository.findAll();
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList(); // x equivale a Game
		// stream() é uma Lib que permite fazer operações com sequencias de Dados
		// o .map é uma operação da stream() Objetos de uma coisa para outra
		return dto;
		// a consulta DTO customiza o formato da saída da API
	}

}
