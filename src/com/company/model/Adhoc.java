package com.company.model;

public class Adhoc extends CartItem{
    String address;
    public Adhoc(Supply item, int quantity){
        super(item, quantity);
        address = "";
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
