package com.example.kiosk6;

import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private final List<Menu> menus;
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

            if(!cart.getCarts().isEmpty()){ //장바구니에 메뉴가 있다면 ORDER MENU 출력
                System.out.println("\n[ ORDER MENU ]");
                System.out.println("4. Orders       | 장바구니를 확인 후 주문합니다.");
                System.out.println("5. Cancel       | 진행중인 주문을 취소합니다. (장바구니 비우기)");
            }

            //-------------- 사용자 선택1 (메뉴판 선택) -------------------------
            System.out.print("메뉴판을 선택해주세요. : ");
            int selectCategoryNum = sc.nextInt();

            // 0 누르면 프로그램 종료 -> break;
            if (selectCategoryNum==0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            // 5 누르면 장바구니 초기화
            if (selectCategoryNum==5) {
                cart.deleteCart();
                System.out.println("장바구니가 비워졌습니다.");
                continue;
            }

            // 4 누르면 주문 시작
            if(selectCategoryNum==4){
                if(!cart.getCarts().isEmpty()){
                    System.out.println("아래와 같이 주문하시겠습니까?\n");
                    cart.printCart();

                    System.out.println("\n[ Total ]");
                    double totalPrice = cart.printTotalPrice();
                    System.out.print("W " + totalPrice);

                    System.out.println("\n1. 주문        2. 메뉴판");
                    int orderOrBack =  sc.nextInt();
                    if (orderOrBack == 1){
                        System.out.print("주문이 완료되었습니다. 금액은 W " + totalPrice + "입니다.");
                    } else if (orderOrBack == 2) { // 2 고르면 다시 메뉴 선택지로 돌아가기
                        continue;
                    } else System.out.println("잘못된 숫자입니다. 다시 입력해주세요.");
                    break; // 주문 완료시 프로그램 종료
                }
            } else System.out.println("잘못된 숫자입니다. 다시 입력해주세요.");

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

                                while (true){ //장바구니 추가 기능
                                    System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                                    System.out.println("1. 확인        2. 취소");
                                    System.out.print("선택 : ");
                                    int selectOrder = sc.nextInt();

                                    if(selectOrder==1){
                                        cart.addMenuToCart(selectMenuItem); //장바구니 추가
                                        System.out.println("--------------------");
                                        cart.calculateTotalPrice(selectMenuItem); // 메뉴 추가할 때마다 totalPrice 계산
                                        cart.printCart(); // 장바구니 목록 출력
                                        break;
                                    } else if (selectOrder == 2) { //2번 취소 누르면 메뉴판으로 돌아가기
                                        break;
                                    } else System.out.println("잘못된 숫자입니다. 다시 입력해주세요.");
                                }
                                break;
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
