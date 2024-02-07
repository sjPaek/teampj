package com.teampj.project.webpage.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teampj.project.webpage.entities.MemberEntity;

public interface MemberRepo extends JpaRepository<MemberEntity, Integer>{

    List<MemberEntity> findAll();

    MemberEntity findByUserId(String userId);
}
