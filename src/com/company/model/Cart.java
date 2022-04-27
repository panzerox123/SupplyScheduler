package com.company.model;

import java.util.ArrayList;
import java.util.List;
import  java.sql.Timestamp;

public class Cart {
    int noOfItems=0;
    int totalCost=0;
    List<CartItem> itemList;
    Timestamp time = new Timestamp(System.currentTimeMillis());

    public void addItem(CartItem c){
        itemList.add(c);
        totalCost+=c.totalCost;
        noOfItems+=1;
        //extend functionality to add reduce repeated cart items
    }
    public void removeItem(CartItem c){
        itemList.remove(c);
        totalCost-=c.totalCost;
        noOfItems-=1;
    }





}
