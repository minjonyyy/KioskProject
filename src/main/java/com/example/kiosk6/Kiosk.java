package com.example.kiosk6;

import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private final List<Menu> menus;
    List<MenuItem> menuItems;
    private final Cart cart;

    public Kiosk(List<Menu> menus, Cart cart){

        this.menus = menus;
        this.cart = cart;
    }

    public void start(){

        Scanner sc = new Scanner(System.in);

        // 메인 메뉴 고르는 반복문 시작
        while (true){
            System.out.println("-----------------------");
            System.out.println("[ MAIN MENU ]");

            // Menu.java의 getMenuCategory로 메인 메뉴판 출력
            for (int i=0; i< menus.size(); i++){
                System.out.println((i+1) +". " + menus.get(i).getMenuCategory());
            }

            System.out.println("0. 종료      | 종료");

            //-------------- 사용자 선택1 (메뉴판 선택) -------------------------
            System.out.print("메뉴판을 선택해주세요. : ");
            int selectCategoryNum = sc.nextInt();

            // 0 누르면프로그램 종료 -> break;
            if (selectCategoryNum==0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            try { //예외 처리를 위한 try-catch문
                Menu selectCategory = menus.get(selectCategoryNum-1);

                if (selectCategoryNum>=1 && selectCategoryNum<=menus.size()){
                    while(true){ // 뒤로가기 기능을 위한 2중 반복문
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

                        try { //예외 처리를 위한 try-catch문
                            MenuItem selectMenuItem = selectCategory.getMenuItems().get(selectMenuItemNum-1);

                            // 구현해두었던 printMenuItems() 메서드를 사용할 수는 없나? 수정해보기 (59, 62~63)
                            if (selectMenuItemNum>=1 && selectMenuItemNum <= selectCategory.getMenuItems().size()){
                                System.out.println("선택한 메뉴: < " + selectMenuItem.getName() + " | " + "W " + selectMenuItem.getPrice() + " | " + selectMenuItem.getInfo() + " >");

                                while (true){
                                    System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                                    System.out.println("1. 확인        2. 취소");
                                    System.out.println("선택 : ");
                                    int selectOrder = sc.nextInt();

                                    if(selectOrder==1){
                                        cart.addMenuToCart(selectMenuItem);
                                        System.out.println("--------------------");
                                        cart.printCart(); //임시 출력
                                        break;
                                    } else if (selectOrder == 2) {
                                        break;
                                    } else System.out.println("잘못된 숫자입니다. 다시 입력해주세요.");
                                }

                            }
                        } catch (IndexOutOfBoundsException e){ // 0 이나 메뉴판에 없는 숫자 고를 시에 예외처리
                            System.out.println("잘못된 숫자입니다. 다시 입력해주세요.");
                        }

                    }
                }
            } catch (IndexOutOfBoundsException e){ // 0 이나 메인 메뉴판에 없는 숫자 고를 시에 예외처리
                System.out.println("잘못된 숫자입니다. 다시 입력해주세요.");
            }


        }

    }

}
