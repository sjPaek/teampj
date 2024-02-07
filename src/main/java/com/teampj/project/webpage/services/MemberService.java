package com.teampj.project.webpage.services;

import java.util.List;
import com.teampj.project.webpage.entities.MemberEntity;
import com.teampj.project.webpage.models.MemberModel;


public interface MemberService {
    public List<MemberEntity> selectUsers();

    
    
} 