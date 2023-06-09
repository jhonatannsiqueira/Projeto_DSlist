package com.devsuperior.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.services.GameService;

@RestController
@RequestMapping(value = "/games") // Configura o caminho URL
public class GameController {
	// Controller é a camada responsável por implementar o Back-End/API
	
	@Autowired
	private GameService gameService;
	
	@GetMapping
	public List<GameMinDTO> fingAll(){
		List<GameMinDTO> result = gameService.findAll();
		return result;
	}

}
