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
import com.teampj.project.webpage.services.MemberService;
import com.teampj.project.webpage.services.MyInfoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MyInfoServiceImpl implements MyInfoService {

    @Autowired
    MemberRepo memberRepo;

    @Autowired
    MemberService memberService;

    public ResponseModel<MemberModel> updateMyInfo(MemberModel model, HttpServletRequest request) {        
        HttpSession session = request.getSession();
        Optional<MemberEntity> memberEntity = memberRepo.findById(model.getSeq());

        if (!memberEntity.isPresent()) {
            log.info("not exist data");
            return new ResponseModel<>(false, "존재하지 않는 데이터입니다", null, null);
        }

        // update
        MemberEntity forSave = memberEntity.get();

        try {
            if (model.getUserPassword() != null && !"".equals(model.getUserPassword())) {
                if (model.getUserPassword().equals(model.getUserPasswordCheck())) {
                    String encodePassword = memberService.encodePassswordSha512(model.getUserPassword());
                    forSave.setUserPassword(encodePassword);
                }
            }

            forSave.setUserName(model.getUserName());
            forSave.setUserEmail(model.getUserEmail());
            forSave.setUserTel(model.getUserTel());
            forSave.setUserAddress(model.getUserAddress());

            log.info("SAVE MEMBER INFO : " + forSave.toString());
            memberRepo.save(forSave);
            
            session.setAttribute("logged", forSave.toModel());        

        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseModel<>(false, "저장 중 오류가 발생하였습니다", null, null);
        }

        return new ResponseModel<>(true, "정상적으로 저장되었습니다", null, null);
    }

}
