package com.example.kiosk7;

public class Discount {

    public enum DiscountType {
        VETERAN(10), SOLDIER(5), STUDENT(3), GENERAL(0);

        private final int discountRate;

        DiscountType(int discountRate) {
            this.discountRate = discountRate;
        }

        public int getDiscountRate(){ return discountRate; }
    }
}
