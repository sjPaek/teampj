package com.teampj.project.webpage.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseModel <T> {
    private boolean ok;
    private String msg;    
    private T object;
    private List<T> list;
}
