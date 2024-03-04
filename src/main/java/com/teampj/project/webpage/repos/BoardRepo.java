package com.teampj.project.webpage.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teampj.project.webpage.entities.BoardEntity;

public interface BoardRepo extends JpaRepository<BoardEntity, Integer>{
    
}
