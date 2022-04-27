package com.company.model;

import java.util.ArrayList;
import java.util.List;

public class Producer extends Consumer{
    List<Supply> supplyList;
    public Producer(String username, String password, String emailId){
        super(username, password, emailId);
        supplyList = new ArrayList<Supply>();
    }
    public void addProduct(Supply prod){
        supplyList.add(prod);
    }
    public void removeProduct(Supply prod){
        supplyList.remove(prod);
    }
}
