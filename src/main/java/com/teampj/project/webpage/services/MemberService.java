package com.teampj.project.webpage.services;

import java.util.List;
import java.util.Optional;

import com.teampj.project.webpage.entities.MemberEntity;

public interface MemberService {
    public List<MemberEntity> selectUsers();

    public Optional<MemberEntity> getMemberBySeq(int seq);

    public void insertMember(MemberEntity entity);

    public void updateMember(MemberEntity entity);

    public void deleteMember(int seq);
    
    public String encodePassswordSha512(String password) throws Exception;
} 