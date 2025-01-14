package com.example.kiosk4;

import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private final List<Menu> menus;
    List<MenuItem> menuItems;

    public Kiosk(List<Menu> menus){
        this.menus = menus;
    }

    public void start(){

        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("-----------------------");
            System.out.println("[ MAIN MENU ]");

            for (int i=0; i< menus.size(); i++){
                System.out.println((i+1) +". " + menus.get(i).getMenuCategory());
            }

            System.out.println("0. 종료      | 종료");

            //--------------사용자 선택1-------------------------
            System.out.print("메뉴판을 선택해주세요. : ");
            int selectCategoryNum = sc.nextInt();
            Menu selectCategory = menus.get(selectCategoryNum-1);

            if (selectCategoryNum==0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (selectCategoryNum>=1 && selectCategoryNum<=3){
                System.out.println("-----------------------");
                System.out.println("[ " + selectCategory.getMenuCategory() + " MENU ]");
                selectCategory.printMenuItems();
                System.out.println("0. 뒤로가기");
            } else {
                System.out.println("잘못된 숫자입니다. 다시 입력해주세요.");
            }

            //--------------사용자 선택2-------------------------
            System.out.print("메뉴를 골라주세요. : ");
            int selectMenuItemNum = sc.nextInt();
            MenuItem selectMenuItem = selectCategory.getMenuItems().get(selectMenuItemNum-1);


            if (selectMenuItemNum==0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            if (selectMenuItemNum>=1 && selectMenuItemNum<=3){ //여기 수정
                System.out.println("선택한 메뉴: < " + selectMenuItem.getName() + " | " + "W " + selectMenuItem.getPrice() + " | " + selectMenuItem.getInfo() + " >");

            } else {
                System.out.println("잘못된 숫자입니다. 다시 입력해주세요.");
            }

        }

    }

}
