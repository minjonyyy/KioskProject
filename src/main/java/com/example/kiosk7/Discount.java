package com.example.kiosk7;

public class Discount {


    public enum DiscountType {
        VETERAN("국가유공자", 10),
        SOLDIER("군인",5),
        STUDENT("학생",3),
        GENERAL("일반",0);

        private final int discountRate;
        private final String type;

        DiscountType(String type, int discountRate) {
            this.type = type;
            this.discountRate = discountRate;
        }

        public int getDiscountRate(){ return discountRate; }
    }

    public void printDiscountRate(){
        for (DiscountType type : DiscountType.values()){
            System.out.println("."+type.type +"  : "+ type.discountRate + "%");
        }
    }
}
