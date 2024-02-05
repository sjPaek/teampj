package com.teampj.project.webpage.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseModel <T> {
    
    private String msg;
    private boolean ok;
    private T data;
    
    public ResponseModel(boolean ok, String msg, T data){
        this.ok = ok;
        this.msg = msg;
        this.data = data;
    }
}
