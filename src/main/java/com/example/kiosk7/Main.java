package com.example.kiosk7;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        // 버거 객체 생성
        Menu Burgers = new Menu("BURGERS");

        Burgers.addMenuItems(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        Burgers.addMenuItems(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        Burgers.addMenuItems(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        Burgers.addMenuItems(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        // 음료, 디저트 객체 생성
        Menu Drinks = new Menu("DRINKS");

        Drinks.addMenuItems(new MenuItem("Coke", 1.0, "코카콜라"));
        Drinks.addMenuItems(new MenuItem("Sprite", 1.0, "사이다"));
        Drinks.addMenuItems(new MenuItem("Lemon Ade", 1.5, "수제 레몬청이 들어간 레몬 에이드"));

        Menu Desserts = new Menu("DESSERTS");

        Desserts.addMenuItems(new MenuItem("Cookies", 3.5, "초코칩 쿠키"));
        Desserts.addMenuItems(new MenuItem("Cake", 4.8, "딸기 / 블루베리 케이크"));

        // 메뉴판 리스트 생성
        List<Menu> menus = new ArrayList<>();
        menus.add(Burgers);
        menus.add(Drinks);
        menus.add(Desserts);


        Cart cart = new Cart();

        /// 키오스크 객체 생성 및 시작하는 함수 호출
        Kiosk kiosk = new Kiosk(menus, cart);
        kiosk.start();
    }
}