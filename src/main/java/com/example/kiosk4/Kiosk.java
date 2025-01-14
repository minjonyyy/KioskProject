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

            //-------------- 사용자 선택1 (메뉴판 선택) -------------------------
            System.out.print("메뉴판을 선택해주세요. : ");
            int selectCategoryNum = sc.nextInt();


            if (selectCategoryNum==0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            try {
                Menu selectCategory = menus.get(selectCategoryNum-1);

                if (selectCategoryNum>=1 && selectCategoryNum<=menus.size()){
                    while(true){
                        System.out.println("-----------------------");
                        System.out.println("[ " + selectCategory.getMenuCategory() + " MENU ]");
                        selectCategory.printMenuItems();
                        System.out.println("0. 뒤로가기");

                        //-------------- 사용자 선택2 (메뉴 아이템 선택) -------------------------
                        System.out.print("메뉴를 골라주세요. : ");
                        int selectMenuItemNum = sc.nextInt();

                        if (selectMenuItemNum==0) {
                            break; //뒤로가기
                        }

                        try {
                            MenuItem selectMenuItem = selectCategory.getMenuItems().get(selectMenuItemNum-1);

                            if (selectMenuItemNum>=1 && selectMenuItemNum <= selectCategory.getMenuItems().size()){
                                System.out.println("선택한 메뉴: < " + selectMenuItem.getName() + " | " + "W " + selectMenuItem.getPrice() + " | " + selectMenuItem.getInfo() + " >");

                            }
                        } catch (IndexOutOfBoundsException e){
                            System.out.println("잘못된 숫자입니다. 다시 입력해주세요.");
                        }

                    }
                }
            } catch (IndexOutOfBoundsException e){
                System.out.println("잘못된 숫자입니다. 다시 입력해주세요.");
            }


        }

    }

}
