package com.company.model;

import java.util.ArrayList;
import java.util.List;

public class Producer extends Consumer{
    String producerAddress;
    String producerName;
    List<Supply> supplyList;
    public Producer(String username, String password, String emailId){
        super(username, password, emailId);
        supplyList = new ArrayList<Supply>();
        producerName = "";
        producerAddress = "";
    }

    public void setProducerAddress(String producerAddress) {
        this.producerAddress = producerAddress;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public void setSupplyList(List<Supply> supplyList) {
        this.supplyList = supplyList;
    }

    public String getProducerAddress() {
        return producerAddress;
    }

    public String getProducerName(){
        return producerName;
    }
}
