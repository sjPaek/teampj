package com.teampj.project.webpage.services.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teampj.project.webpage.entities.UserEntity;
import com.teampj.project.webpage.models.UserModel;
import com.teampj.project.webpage.repos.UserRepo;
import com.teampj.project.webpage.services.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;
    
    public List<UserEntity> selectUsers(){
        return userRepo.findAll();

    }
    
}
