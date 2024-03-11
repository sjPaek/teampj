package com.teampj.project.webpage.repos;

import java.lang.reflect.Member;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teampj.project.webpage.entities.MemberEntity;
import com.teampj.project.webpage.models.MemberModel;

public interface MemberRepo extends JpaRepository<MemberEntity, Integer>{

    List<MemberEntity> findAll();

    Optional<MemberEntity> findById(int seq);

    Optional<MemberEntity> findByUserId(String userId);

    // MemberEntity findByUserId(String userId);

    MemberEntity deleteById(int seq);
}
