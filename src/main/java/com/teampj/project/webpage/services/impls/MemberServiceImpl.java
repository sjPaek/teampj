package com.teampj.project.webpage.services.impls;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teampj.project.webpage.entities.MemberEntity;
import com.teampj.project.webpage.models.MemberModel;
import com.teampj.project.webpage.repos.MemberRepo;
import com.teampj.project.webpage.services.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    MemberRepo memberRepo;
    
    public List<MemberEntity> selectUsers(){        
        return memberRepo.findAll();    
    }

    public Optional<MemberEntity> getMemberBySeq(int seq){
        return memberRepo.findById(seq);
    }

    public void insertMember(MemberEntity entity){
        memberRepo.save(entity);
    }

    public void updateMember(MemberEntity entity){
        memberRepo.save(entity);
    }

    public void deleteMember(int seq){
        memberRepo.deleteById(seq);
    }

    public String encodePassswordSha512(String password){
        String changePassword = null;
        try{            
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(password.getBytes("UTF-8"));
            changePassword = String.format("%0128x",new BigInteger(1, md.digest()));
        }catch(Exception e){

        }
        return changePassword;
    }
}
