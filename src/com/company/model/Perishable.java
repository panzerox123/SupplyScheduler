package com.company.model;

import java.util.Date;

public class Perishable extends Supply{
    Date expiry;
    public Perishable(String name, int cost, int stock){
        super(name, cost, stock);
        expiry = new Date();
    }

    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }
}
