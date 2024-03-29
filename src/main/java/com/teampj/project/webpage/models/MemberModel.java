package com.teampj.project.webpage.models;

import com.teampj.project.webpage.entities.MemberEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberModel {
    
    private Integer seq;
    private String userName;
    private String userId;
    private String userPassword;
    private String userPasswordCheck;
    private String userAddress;
    private String userEmail;
    private String userTel;
    private Integer userLevel;

    public MemberModel (MemberEntity member) {
        seq = member.getSeq();
        userName = member.getUserName();
        userId = member.getUserId();
        userPassword = member.getUserPassword();
        userAddress = member.getUserAddress();
        userEmail = member.getUserEmail();
        userTel = member.getUserTel();
        userLevel = member.getUserLevel();
    }
    
}
