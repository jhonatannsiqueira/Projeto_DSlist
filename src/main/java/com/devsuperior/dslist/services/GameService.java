package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameRepository;

@Service // Registra a service como um Componente do Sistema
public class GameService {
	// Service é o componente responsável por implementar a Lógica/Regra de Negócio

	@Autowired // Injetar
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true) // Garante que o Método o service fique transacional, garante que a operação com o BD sera executada
	public GameDTO findById(Long id) {
		Game result = gameRepository.findById(id).get();
		GameDTO dto = new GameDTO(result);
		return dto;
		// readOnly = true assegura que não será realizada nenhuma operação de escrita
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll() {
		List<Game> result = gameRepository.findAll();
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList(); // x equivale a Game
		// stream() é uma Lib que permite fazer operações com sequencias de Dados
		// o .map é uma operação da stream() Objetos de uma coisa para outra
		return dto;
		// a consulta DTO customiza o formato da saída da API
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findByList(Long listId) {
		List<GameMinProjection> result = gameRepository.searchByList(listId);
		return result.stream().map(x -> new GameMinDTO(x)).toList();
	}

}
