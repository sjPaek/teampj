package com.teampj.project.webpage.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teampj.project.webpage.entities.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Integer>{

    List<UserEntity> findAll();
}
