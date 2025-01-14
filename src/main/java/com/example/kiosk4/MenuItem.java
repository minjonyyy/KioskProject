package com.example.kiosk4;

public class MenuItem {

    public String name;
    public double price;
    public String info;


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
