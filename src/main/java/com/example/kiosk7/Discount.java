package com.example.kiosk7;

public class Discount {


    public enum DiscountType {
        VETERAN(1,"국가유공자", 10),
        SOLDIER(2,"군인",5),
        STUDENT(3,"학생",3),
        GENERAL(4,"일반",0);

        private final int discountRate;
        private final String type;
        private final int num;

        DiscountType(int num, String type, int discountRate) {
            this.num = num;
            this.discountRate = discountRate;
            this.type = type;
        }

        public int getDiscountRate(){ return discountRate; }
    }

    public void printDiscountRate(){
        for (DiscountType type : DiscountType.values()){
            System.out.println(type.num + "."+type.type +"  : "+ type.discountRate + "%");
        }
    }

    public double calculateDiscount(int discountTypeNum, double totalPrice){
        for (DiscountType type : DiscountType.values()){
            if ( discountTypeNum == type.num){
                totalPrice = totalPrice * (1.0 - type.discountRate * 0.01);
            }
        }
        return totalPrice;
    }
}
