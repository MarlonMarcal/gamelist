package com.devesuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devesuperior.dslist.dto.GameDTO;
import com.devesuperior.dslist.dto.GameMinDTO;
import com.devesuperior.dslist.entities.Game;
import com.devesuperior.dslist.projections.GameMinProjection;
import com.devesuperior.dslist.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		Game result = gameRepository.findById(id).get();
		GameDTO dto = new GameDTO(result);
		return dto;
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll(){
		List<Game> result = gameRepository.findAll();
		return result.stream().map(x -> new GameMinDTO(x)).toList();
		
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findByList(Long ListId){
		List<GameMinProjection> result = gameRepository.searchByList(ListId);
		return result.stream().map(x -> new GameMinDTO(x)).toList();
		
	}

}
