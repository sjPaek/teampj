package com.teampj.project.webpage.services.impls;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teampj.project.webpage.entities.MemberEntity;
import com.teampj.project.webpage.models.MemberModel;
import com.teampj.project.webpage.models.ResponseModel;
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

    public Optional<MemberEntity> getMemberByUserId(String memberId){
        return memberRepo.findByUserId(memberId);
    }


    public ResponseModel<MemberModel> saveMember(MemberModel member, String state){
        
        if("insert".equals(state)){

        }else{                        
            Optional<MemberEntity> memberEntity =  memberRepo.findById(member.getSeq());

            if(!memberEntity.isPresent()){
                log.info("not exist data");
                return new ResponseModel<>(false, "존재하지 않는 데이터입니다", null, null);
            }
                        
            //update
            MemberEntity forSave = memberEntity.get();

            try{                    
                            
                String encodePassword = encodePassswordSha512(member.getUserPassword());                
                forSave.setUserPassword(encodePassword);
                forSave.setUserName(member.getUserName());
                forSave.setUserEmail(member.getUserEmail());
                forSave.setUserTel(member.getUserTel());
                forSave.setUserAddress(member.getUserAddress());
                
                log.info("SAVE MEMBER INFO : " + forSave.toString());
                memberRepo.save(forSave);            

            }catch (Exception e){
                log.error(e.getMessage());
                log.info("catch");
                return new ResponseModel<>(false, "저장 중 오류가 발생하였습니다", null, null);
            }

        }

        return new ResponseModel<>(true, "정상적으로 저장되었습니다", null, null);
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
