package com.company.model;

public class Requirement extends CartItem {
    int interval; // Number of days between deliveries
    public Requirement(Supply item, int quantity){
        super(item, quantity);
        this.interval = 0;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }
}

