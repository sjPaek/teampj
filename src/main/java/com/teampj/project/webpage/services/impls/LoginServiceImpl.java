package com.teampj.project.webpage.services.impls;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teampj.project.webpage.entities.MemberEntity;
import com.teampj.project.webpage.models.MemberModel;
import com.teampj.project.webpage.models.ResponseModel;
import com.teampj.project.webpage.repos.MemberRepo;
import com.teampj.project.webpage.services.LoginService;
import com.teampj.project.webpage.services.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepo memberRepo;
    public ResponseModel<MemberModel> doLogin(MemberModel model, HttpServletRequest request){
        
        if("".equals(model.getUserId()) || model.getUserId() == null) return new ResponseModel<MemberModel>(false, "잘못된 정보입니다", null, null);
        if("".equals(model.getUserPassword()) || model.getUserPassword() == null) return new ResponseModel<MemberModel>(false, "잘못된 정보입니다", null, null);

        HttpSession session = request.getSession();

        Optional<MemberEntity> omEntity = memberRepo.findByUserId(model.getUserId());

        if(!omEntity.isPresent()) return new ResponseModel<MemberModel>(false, "존재하지 않는 계정입니다", null, null);

        MemberEntity memberEntity = omEntity.get();
    
        MemberModel member = memberEntity.toModel();

        try{
            String encodePassword = memberService.encodePassswordSha512(model.getUserPassword());
            log.info(encodePassword);
            log.info(member.getUserPassword());
            if(encodePassword.equals(member.getUserPassword())){            
                if(session == null || session.getAttribute("logged") == null){
                    session.setAttribute("logged", member);
                }            
                return new ResponseModel<>(true, "정상적으로 로그인 되었습니다", null, null);
            }else{            
                return new ResponseModel<>(false, "로그인이 실패했습니다. 다시 시도해주세요", null, null);
            }       
        }catch (Exception e){
            log.error(e.getMessage());
            return new ResponseModel<>(false, "로그인이 실패했습니다. 다시 시도해주세요", null, null);
        }
        
    }

    
}
