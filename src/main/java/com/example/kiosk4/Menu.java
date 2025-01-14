package com.example.kiosk4;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    // Menu 클래스의 필드
    private final String menuCategory;
    private List<MenuItem> menuItems;

    // 생성자
    public Menu(String menuCategory){
        this.menuCategory = menuCategory;
        this.menuItems = new ArrayList<>();
    }

    //메뉴 카테고리를 반환하는 getter 메서드
    public String getMenuCategory(){
        return menuCategory;
    }

    public void addMenuItems(MenuItem item){
        menuItems.add(item);
    }

    public void printMenuItems() {
        for(int i=0; i<menuItems.size(); i++){
            System.out.print((i+1) + ". " + menuItems.get(i).getName());
            System.out.print("  | W " + menuItems.get(i).getPrice());
            System.out.println("| " + menuItems.get(i).getInfo());
        }
    }


//    public void printMenuCategory(){
//        for (int i=0; i<)
//    }


}
