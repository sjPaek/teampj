package com.teampj.project.webpage.services;

import javax.servlet.http.HttpServletRequest;

import com.teampj.project.webpage.models.MemberModel;
import com.teampj.project.webpage.models.ResponseModel;

public interface LoginService {
 
    public ResponseModel<MemberModel> doLogin(MemberModel model, HttpServletRequest request) ;
}
