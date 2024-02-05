package com.teampj.project.webpage.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.teampj.project.webpage.entities.UserEntity;
import com.teampj.project.webpage.models.UserModel;


public interface UserService {
    public List<UserEntity> selectUsers();
    
} 