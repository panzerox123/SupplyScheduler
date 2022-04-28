package com.company.model;

public class SupplyScheduler {
    public static Supply getSupply(int type, String name, int cost, int stock){
        switch (type){
            case 1:
                return new Perishable(name, cost, stock);
            case 2:
                return new Packaged(name, cost, stock);
            default:
                return null;
        }
    }
}
