package com.teampj.project.webpage.services.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teampj.project.webpage.entities.MemberEntity;
import com.teampj.project.webpage.repos.MemberRepo;
import com.teampj.project.webpage.services.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    MemberRepo memberRepo;
    
    public List<MemberEntity> selectUsers(){
        return memberRepo.findAll();

    }
    
}
