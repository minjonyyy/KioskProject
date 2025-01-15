package com.example.kiosk6;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        // 버거 객체 생성
        Menu Burgers = new Menu("BURGERS");

        Burgers.addMenuItems(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        Burgers.addMenuItems(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        Burgers.addMenuItems(new MenuItem("ShackBurger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        Burgers.addMenuItems(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        // 음료, 디저트 객체 생성
        Menu Drinks = new Menu("DRINKS");
        Menu Desserts = new Menu("DESSERTS");

        // 메뉴판 리스트 생성
        List<Menu> menus = new ArrayList<>();
        menus.add(Burgers);
        menus.add(Drinks);
        menus.add(Desserts);

        // 테스트용 출력
//        for (int i=0; i< menus.size(); i++){
//            System.out.println("[ " + menus.get(i).getMenuCategory() + " MENU ]");
//        }
        // 테스트용 출력
//        System.out.println("-------테스트1-------");
//        Burgers.printMenuItems();
//        System.out.println("-------테스트2-------");
//        menus.get(0).printMenuItems();

        /// 키오스크 객체 생성 및 시작하는 함수 호출
        Kiosk kiosk = new Kiosk(menus);
        kiosk.start();
    }
}