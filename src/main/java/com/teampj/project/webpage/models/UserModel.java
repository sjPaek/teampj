package com.teampj.project.webpage.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {
    
    private int seq;
    private String userName;
    private String userId;
    private String userPasswod;
    private String userAddress;
    private String userEmail;
    
}
