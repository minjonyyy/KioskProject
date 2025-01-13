package com.example.kiosk4;

import java.util.List;
import java.util.Scanner;

public class Kiosk {
    List<MenuItem> menuItems;

    public Kiosk(List<MenuItem> menuItems){
        this.menuItems = menuItems;
    }

    public void start(){

        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("---------------------------------------------------------------");
            System.out.println("[ SHAKESHACK MENU ]");

            for (int i=0; i< menuItems.size();i++){
                MenuItem item = menuItems.get(i);
                System.out.println((i+1) +". "+ item.name + " | " + "W " + item.price + " | " + item.comment);
            }
            System.out.println("0. 종료      | 종료");

            System.out.print("메뉴를 골라주세요. : ");
            int num = sc.nextInt();

            if (num==0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (num>=1 && num<=5){
                MenuItem item = menuItems.get(num-1);
                System.out.println("선택한 메뉴: < " + item.name + " | " + "W " + item.price + " | " + item.comment + " >");
            } else {
                System.out.println("잘못된 숫자입니다. 다시 입력해주세요.");
            }
        }

    }

}
