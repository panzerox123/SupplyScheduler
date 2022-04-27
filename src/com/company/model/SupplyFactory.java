package com.company.model;

public class SupplyFactory {
    public static Supply getSupply(int type){
        switch (type){
            case 1:
                return new Perishable();
            case 2:
                return new Packaged();
            default:
                return null;
        }
    }
}
