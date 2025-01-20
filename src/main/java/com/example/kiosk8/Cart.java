package com.example.kiosk8;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cart {
    private final List<CartItem> carts;

    public Cart(){
        this.carts = new ArrayList<>();

    }

    // 장바구니에 메뉴 추가하는 메서드
    public void addMenuToCart(CartItem item){
        carts.add(item);
        System.out.println("\n"+item.getName()+"이 장바구니에 추가되었습니다.");
    }

    // 장바구니 목록 출력하는 메서드
    public void printCart(){
        System.out.println("[ SHOPPING CART ]");
        for (CartItem item : carts) {
            System.out.println(item.getName() + " | W " + item.getPrice() + " | 수량 : " + item.getQuantity());
        }
    }

    //장바구니 초기화(비우기) 메서드
    public void emptyCart(){
        carts.clear();
    }

    // 특정 이름을 가진 메뉴를 제외하고 다시 출력해주는 메서드
    public void removeAndPrintCart(){
        System.out.println("[ SHOPPING CART ] - 'SmokeShack'을 제외한 장바구니입니다.");

        //스트림 사용하여 필터링
        List<CartItem> filteredCarts = carts.stream()
                .filter(item -> !item.getName().equals("SmokeShack"))
                .toList();

        carts.clear(); //기존 장바구니 초기화
        carts.addAll(filteredCarts); // 특정 이름을 가진 메뉴 제외한 filterCarts 리스트를 기존 장바구니로 이동
        carts.forEach(System.out::println); // 장바구니 출력
    }


    //장바구니 getter 메서드
    public List<CartItem> getCarts(){
        return carts;
    }

    // totalPrice 계산하는 메서드
    public double calculateTotalPrice(){
        double totalPrice = 0.0;
        for (CartItem cartItem : carts) {
            totalPrice += cartItem.getPrice() * cartItem.getQuantity();
        }
        return totalPrice;
    }

    // 계산된 totalPrice 출력하는 메서드 (이중계산 막기위해 나누어줌)
//    public void printTotalPrice(){
//        System.out.println("\n[ Total Price ]  W " + String.format("%.1f", totalPrice));
//    }

    // 특정 메뉴 아이템이 장바구니에 들어있는지 확인하는 메서드
    public boolean isContainCart(MenuItem item){
        for (CartItem cartItem : carts) {
            if (item.getName().equals(cartItem.getName())) {
                return true;
            }
        }
        return false;
    }

    // 특정 메뉴 아이템의 수량을 +1 해주는 메서드
    public void plusQuantity(MenuItem item){
        for (CartItem cartItem : carts) {
            if (item.getName().equals(cartItem.getName())) {
                cartItem.setQuantity(cartItem.getQuantity()+1);
            }
        }
    }



}
