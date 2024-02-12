package com.teampj.project.webpage.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teampj.project.webpage.entities.MemberEntity;
import com.teampj.project.webpage.models.MemberModel;
import com.teampj.project.webpage.repos.MemberRepo;
import com.teampj.project.webpage.services.LoginService;

@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    MemberRepo memberRepo;
    public MemberModel getMemberByUserId(MemberModel model){
        

        MemberEntity memberEntity = memberRepo.findByUserId(model.getUserId());
    
        MemberModel member = new MemberModel().builder()
                                            .userId(memberEntity.getUserId())
                                            .userName(memberEntity.getUserName())
                                            .userPassword(memberEntity.getUserPassword())
                                            .userAddress(memberEntity.getUserAddress())
                                            .userEmail(memberEntity.getUserEmail())
                                            .userTel(memberEntity.getUserTel())
                                            .userLevel(memberEntity.getUserLevel())
                                            .build();


        return member;
    }

    private String encodePassword (String pwd){
        return "";
    }
    
}
