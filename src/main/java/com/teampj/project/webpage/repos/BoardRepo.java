package com.teampj.project.webpage.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teampj.project.webpage.entities.DocumentEntity;

public interface BoardRepo extends JpaRepository<DocumentEntity, Integer>{
    
}
