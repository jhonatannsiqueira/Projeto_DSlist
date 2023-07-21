package com.devsuperior.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.services.GameListService;

@RestController
@RequestMapping(value = "/lists") // Configura o caminho URL
public class GameListController {
	// Controller é a camada responsável por implementar o Back-End/API

	@Autowired
	private GameListService gameListService;

	@GetMapping
	public List<GameListDTO> fingAll() {
		List<GameListDTO> result = gameListService.findAll();
		return result;
	}

}
