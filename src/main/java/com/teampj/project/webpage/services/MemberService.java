package com.teampj.project.webpage.services;

import java.util.List;
import java.util.Optional;

import com.teampj.project.webpage.entities.MemberEntity;
import com.teampj.project.webpage.models.MemberModel;
import com.teampj.project.webpage.models.ResponseModel;

public interface MemberService {
    public List<MemberEntity> selectUsers();

    public Optional<MemberEntity> getMemberBySeq(int seq);

    public ResponseModel<MemberModel> saveMember(MemberModel member, String state);

    public void deleteMember(int seq);
    
    public String encodePassswordSha512(String password) throws Exception;
} 