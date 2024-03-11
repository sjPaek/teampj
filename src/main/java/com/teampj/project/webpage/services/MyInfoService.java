package com.teampj.project.webpage.services;

import javax.servlet.http.HttpServletRequest;

import com.teampj.project.webpage.models.MemberModel;
import com.teampj.project.webpage.models.ResponseModel;

public interface MyInfoService {
     public ResponseModel<MemberModel> updateMyInfo (MemberModel model, HttpServletRequest requset);
}
