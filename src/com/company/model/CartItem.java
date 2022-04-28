package com.company.model;

public class CartItem {
    Supply item;
    int quantity;
    int totalCost;
    String id;
    public CartItem(Supply item,int quantity){
        this.item=item;
        this.quantity=quantity;
        this.totalCost = this.quantity * this.item.cost;
        this.id = "";
    }

    public Supply getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
