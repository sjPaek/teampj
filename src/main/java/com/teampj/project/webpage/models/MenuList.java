package com.teampj.project.webpage.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("menuList")
public class MenuList {

    //BEST , TOP , OUTER , KNIT/CARDIGAN , PANTS , ETC 
    public static final String MENU_00 = "HOME";
    public static final String MENU_01 = "BEST";
    public static final String MENU_02 = "TOP";
    public static final String MENU_03 = "OUTER";
    public static final String MENU_04 = "KNIT/CARDIGAN";
    public static final String MENU_05 = "PANTS";
    public static final String MENU_06 = "ETC";

    public static List<MenuModel> mainMenuList;

    public MenuList(){
        mainMenuList =  new ArrayList<>();
        mainMenuList.add(new MenuModel(MENU_00, "Home", "", "/", false, 1));
        mainMenuList.add(new MenuModel(MENU_01, "Best", "", "/best", false, 1));
        mainMenuList.add(new MenuModel(MENU_02, "Top", "", "/top", true, 1));
        mainMenuList.add(new MenuModel(MENU_03, "Outer", "", "/outer", true, 1));
        mainMenuList.add(new MenuModel(MENU_04, "Knit/Cardigan", "", "/knit", true, 1));
        mainMenuList.add(new MenuModel(MENU_05, "Pants", "", "/pants", true, 1));
        mainMenuList.add(new MenuModel(MENU_06, "Etc", "", "/etc", true, 1));
    }
    
}
