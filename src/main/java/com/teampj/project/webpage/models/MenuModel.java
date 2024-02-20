package com.teampj.project.webpage.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuModel {    
    private String menuCode;
    private String menuName;
    private String menuIcon;
    private String menuURL; 
    private boolean hasSubMenu;
    private int menuLevel;
}

