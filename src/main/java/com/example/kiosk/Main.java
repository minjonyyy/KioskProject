package com.example.kiosk;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("---------------------------------------------------------------");
            System.out.println("[ SHAKESHACK MENU ]");
            System.out.println("1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
            System.out.println("2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
            System.out.println("3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
            System.out.println("4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거");
            System.out.println("0. 종료      | 종료");
            System.out.print("메뉴를 골라주세요. : ");

            int num = sc.nextInt();

            if (num==0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (num==1){
                System.out.println("ShackBurger을 선택하셨습니다. 6,900원을 결제해주세요.");
            } else if (num==2){
                System.out.println("SmokeShack 선택하셨습니다. 8,900원을 결제해주세요.");
            } else if (num==3){
                System.out.println("Cheeseburger 선택하셨습니다. 6,900원을 결제해주세요.");
            } else if (num==4) {
                System.out.println("Hamburger 선택하셨습니다. 5,400원을 결제해주세요.");
            } else {
                System.out.println("잘못된 숫자입니다. 다시 입력해주세요.");
            }

        }



    }
}