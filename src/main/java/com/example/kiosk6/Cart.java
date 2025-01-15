package com.example.kiosk6;


import java.util.ArrayList;
import java.util.List;

public class Cart {

    private final List<MenuItem> carts;
    private double totalPrice;

    public Cart(){
        this.carts = new ArrayList<>();

    }

    public void addMenuToCart(MenuItem item){
        carts.add(item);
        System.out.println(item.getName()+"이 장바구니에 추가되었습니다.");
    }

    public void printCart(){
        System.out.println("< 장바구니 목록 >");
        for (MenuItem item : carts) {
            System.out.println(item.getName() + " | W " + item.getPrice() + " | 수량 : ");
        }
    }

    public void deleteCart(){
        carts.clear();
    }

    public List<MenuItem> getCarts(){
        return carts;
    }

    public void calculateTotalPrice(MenuItem item){
        totalPrice += item.getPrice();
    }

    public double printTotalPrice(){
        return totalPrice;
    }



}
