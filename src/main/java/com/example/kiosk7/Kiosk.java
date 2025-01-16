package com.example.kiosk7;

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
            System.out.print("\n메뉴판을 선택해주세요. : ");
            int selectCategoryNum = sc.nextInt();

            // 0 누르면 프로그램 종료 -> break;
            if (selectCategoryNum==0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            // 5 누르면 장바구니 초기화
            if (selectCategoryNum==5) {
                if(!cart.getCarts().isEmpty()){ //장바구니에 메뉴 아이템이 있을때에만 유효함
                    cart.emptyCart();
                    System.out.println("장바구니가 비워졌습니다.");
                } else System.out.println("잘못된 숫자입니다. 다시 입력해주세요.");
                continue;
            }

            // 4 누르면 장바구니 주문 시작
            if(selectCategoryNum==4){
                if(!cart.getCarts().isEmpty()){ //장바구니에 메뉴 아이템이 있을때에만 유효함
                    System.out.println("아래와 같이 주문하시겠습니까?\n");
                    cart.printCart();
                    cart.printTotalPrice();

                    System.out.println("\n1. 주문        2. 메뉴판");
                    System.out.print("선택 :");
                    int orderOrBack =  sc.nextInt();

                    if (orderOrBack == 1){
                        System.out.print("\n주문이 완료되었습니다.  ");
                        cart.printTotalPrice();

                    } else if (orderOrBack == 2) { // 2 고르면 다시 메뉴 선택지로 돌아가기
                        continue;

                    } else System.out.println("잘못된 숫자입니다. 다시 입력해주세요.");
                    break; // 주문 완료시 프로그램 종료
                }
            }

            try { //예외 처리를 위한 try-catch문
                Menu selectCategory = menus.get(selectCategoryNum-1);

                if (selectCategoryNum>=1 && selectCategoryNum<=menus.size()){
                    while(true){ // 뒤로가기 기능을 위한 2중 반복문
                        // 메뉴 아이템들 출력
                        System.out.println("-----------------------");
                        System.out.println("[ " + selectCategory.getMenuCategory() + " MENU ]");
                        selectCategory.printMenuItems();
                        System.out.println("0. 뒤로가기");

                        //-------------- 사용자 선택2 (메뉴 아이템 선택) -------------------------
                        System.out.print("\n메뉴를 골라주세요. : ");
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
                                    System.out.println("\n위 메뉴를 장바구니에 추가하시겠습니까?");
                                    System.out.println("1. 확인        2. 취소");
                                    System.out.print("선택 : ");
                                    int selectOrder = sc.nextInt();

                                    if(selectOrder==1){
                                        // 1번 누르면 일단 선택했던 메뉴아이템의 속성으로 cartItem으로 객체 생성
                                        CartItem cartItem = new CartItem(selectMenuItem.getName(), selectMenuItem.getPrice(), 1);

                                        boolean isContainCart = cart.isContainCart(selectMenuItem); //선택한 메뉴아이템이 장바구니에 있는지 확인하는 로직

                                        if(isContainCart){ // 만약 장바구니에 이미 들어있는 항목이라면?
                                            cart.plusQuantity(selectMenuItem); // 기존 장바구니 항목에서 수량만 +1 해줌
                                            System.out.println("\n"+selectMenuItem.getName()+"이 장바구니에 추가되었습니다.");

                                        } else cart.addMenuToCart(cartItem); // 중복항목 없으면 그냥 장바구니 추가

                                        System.out.println("-----------------------");
                                        cart.calculateTotalPrice(); // 메뉴 추가할 때마다 totalPrice 새롭게 계산

                                        if(!cart.getCarts().isEmpty()){ //장바구니에 메뉴가 있다면 ORDER MENU 출력
                                            cart.printCart(); // 장바구니 목록 출력
                                            cart.printTotalPrice(); // totalPrice 출력
                                        }
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
