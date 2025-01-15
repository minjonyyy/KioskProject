package com.example.kiosk6;

import com.example.kiosk6.MenuItem;


import java.util.ArrayList;
import java.util.List;

public class Cart {

    private final List<MenuItem> carts;

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
            System.out.println(item.getName() + " | " + "W " + item.getPrice() + " | " + item.getInfo());
        }
    }

    public List<MenuItem> getCarts(){
        return carts;
    }

    public double calculatePrice(){
        double totalPrice=0.0;
        for (MenuItem item : carts) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

}
