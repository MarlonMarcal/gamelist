package com.devesuperior.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devesuperior.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{
	
}
