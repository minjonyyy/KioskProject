package com.example.kiosk6;


import java.util.ArrayList;
import java.util.List;

public class Cart {

    private final List<MenuItem> carts;
    private double totalPrice;

    public Cart(){
        this.carts = new ArrayList<>();

    }

    // 장바구니에 메뉴 추가하는 메서드
    public void addMenuToCart(MenuItem item){
        carts.add(item);
        System.out.println(item.getName()+"이 장바구니에 추가되었습니다.");
    }

    // 장바구니 목록 추가하는 메서드
    public void printCart(){
        System.out.println("< 장바구니 목록 >");
        for (MenuItem item : carts) {
            System.out.println(item.getName() + " | W " + item.getPrice() + " | 수량 : ");
        }
    }

    //장바구니 초기화(비우기) 메서드
    public void deleteCart(){
        carts.clear();
    }

    //장바구니 getter 메서드
    public List<MenuItem> getCarts(){
        return carts;
    }

    // totalPrice 계산하는 메서드
    public void calculateTotalPrice(MenuItem item){
        totalPrice += item.getPrice();
    }

    // 계산된 totalPrice 출력하는 메서드 (이중계산 막기위해 나누어줌)
    public double printTotalPrice(){
        return totalPrice;
    }



}
