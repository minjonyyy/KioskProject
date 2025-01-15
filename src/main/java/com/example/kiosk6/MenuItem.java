package com.example.kiosk6;

public class MenuItem {

    private final String name;
    private final double price;
    private final String info;


    public MenuItem(String name, double price, String info) {
        this.name = name;
        this.price = price;
        this.info = info;
    }

    public String getName() {
        return name;
    }
    public double getPrice(){
        return price;
    }
    public String getInfo(){
        return info;
    }
}
