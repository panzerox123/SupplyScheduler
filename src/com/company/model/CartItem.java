package com.company.model;

public class CartItem {
    Supply item;
    int quantity;
    int totalCost;
    public CartItem(Supply item,int quantity){
        this.item=item;
        this.quantity=quantity;
        this.totalCost = this.quantity * this.item.cost;
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
}
