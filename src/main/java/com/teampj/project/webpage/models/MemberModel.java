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
    
    private int seq;
    private String userName;
    private String userId;
    private String userPassword;
    private String userAddress;
    private String userEmail;
    private String userTel;
    private Integer userLevel;

    public MemberModel (MemberEntity member) {
        seq = member.getSeq();
        userName = member.getUserName();
        userPassword = member.getUserPassword();
        userAddress = member.getUserAddress();
        userEmail = member.getUserEmail();
        userTel = member.getUserTel();
        userLevel = member.getUserLevel();
    }
    
}
