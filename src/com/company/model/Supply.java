package com.company.model;

public class Supply {
    String name;
    int cost;
    int stock;
    String item_id;
    public Supply(String name, int cost, int stock){
        this.name = name;
        this.cost = cost;
        this.stock = stock;
        this.item_id = "";
    }

    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }

    public int getCost() {
        return cost;
    }
    public void incrementStock(int x){
        stock+=x;
    }
    public void decrementStock(int x){
        stock-=x;
    }

    public void setItem_id(String item_id){
        this.item_id = item_id;
    }

    public String getItem_id() {
        return item_id;
    }
}
