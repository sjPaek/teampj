package com.teampj.project.webpage.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.teampj.project.webpage.entities.MemberEntity;
import com.teampj.project.webpage.models.MemberModel;
import com.teampj.project.webpage.models.ResponseModel;
import com.teampj.project.webpage.services.MemberService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@Slf4j
@Controller
public class MemberController {

    @Autowired
    MemberService memberService;

    @GetMapping("/members")
    public String test() {
        return "members";
    }

    @GetMapping("/members/list")
    public @ResponseBody ResponseModel<List<MemberModel>> memberList() {
        List<MemberEntity> membersEntity = memberService.selectUsers();

        List<MemberModel> members = membersEntity.stream().map(MemberModel::new).collect(Collectors.toList());
        
        return new ResponseModel<>(true, "정상적으로 조회되었습니다", members, null);
    }

    @GetMapping("/member/{seq}")
    public @ResponseBody ResponseModel<MemberModel> getMethodName(@PathVariable("seq") int seq) {
        
        Optional<MemberEntity> entity = memberService.getMemberBySeq(seq);

        if(!entity.isPresent()){
            return new ResponseModel<>(false, "존재하지 않는 데이터입니다", null, null);
        }
      
        MemberModel member = entity.get().toModel();
        return new ResponseModel<>(true, "정상적으로 조회되었습니다", member, null );
    }
    

    @PostMapping("/member/insert")
    public @ResponseBody ResponseModel<MemberModel> insertMember(MemberModel model) {
        if(model == null){
            return new ResponseModel<>(false, "해당 데이터를 저장할 수 없습니다", null, null);
        }

        MemberEntity insertMember = new MemberEntity();

        try{
            String password = memberService.encodePassswordSha512(model.getUserPassword());            
    
            insertMember.setUserId(model.getUserId());
            insertMember.setUserPassword(password);
            insertMember.setUserEmail(model.getUserEmail());
            insertMember.setUserLevel(model.getUserLevel());
            insertMember.setUserName(model.getUserName());
            insertMember.setUserTel(model.getUserTel());
            insertMember.setUserAddress(model.getUserAddress());

            memberService.insertMember(insertMember);            
        }catch (Exception e){
            log.error("Error", e.getMessage());
            return new ResponseModel<>(false, "저장 중 오류가 발생하였습니다", null, null);
        }
        

        
        return new ResponseModel<>(true, "정상적으로 저장되었습니다", null, null);
    }


    @PostMapping("/member/update")
    public @ResponseBody ResponseModel<MemberModel> updateMember(MemberModel model) {
        if(model == null){
            return new ResponseModel<>(false, "존재하지 않는 데이터입니다", null, null);
        }

        Optional<MemberEntity> getMember = memberService.getMemberBySeq(model.getSeq());

        if(!getMember.isPresent()){
            return new ResponseModel<>(false, "존재하지 않는 데이터입니다", null, null);
        }

        MemberEntity updateMember = new MemberEntity(); 

        

        try{
            String password = memberService.encodePassswordSha512(model.getUserPassword());            
    
            // updateMember.setUserId(model.getUserId());
            updateMember.setUserPassword(password);
            updateMember.setUserEmail(model.getUserEmail());
            // updateMember.setUserLevel(model.getUserLevel());
            updateMember.setUserName(model.getUserName());
            updateMember.setUserTel(model.getUserTel());
            updateMember.setUserAddress(model.getUserAddress());
            
            memberService.updateMember(updateMember);            
        }catch (Exception e){
            log.error("Error", e.getMessage());
            return new ResponseModel<>(false, "저장 중 오류가 발생하였습니다", null, null);
        }
        

        
        return new ResponseModel<>(true, "정상적으로 저장되었습니다", null, null);
    }
    
    @PostMapping("/member/delete")
    public @ResponseBody ResponseModel<MemberModel> deleteMember(MemberModel model) {
        
        try{
            memberService.deleteMember(model.getSeq());
        }catch(Exception e){
            log.error("Error", e.getMessage());
            return new ResponseModel<>(false, "삭제 중 오류가 발생하였습니다", null, null);
        }
        return new ResponseModel<>(true, "정상적으로 삭제되었습니다", null, null);
    }
    
    
    
    
}
