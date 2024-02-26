package com.teampj.project.webpage.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.teampj.project.webpage.models.MemberModel;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="members")
@NoArgsConstructor
@Data
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seq;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "user_address")
    private String userAddress;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_tel")
    private String userTel;

    @Column(name = "user_level")
    private Integer userLevel;

    public MemberModel toModel(){
        return new MemberModel(seq, userName, userId, userPassword, userAddress, userEmail, userTel, userLevel);
    }


 
}
