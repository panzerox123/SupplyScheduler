package com.company.model;

import java.util.ArrayList;
import java.util.List;

public class Producer extends Consumer{
    String producerAddress;
    String producerName;
    List<Supply> supplyList;
<<<<<<< HEAD
    public Producer(String username, String password, String emailId){
=======
    public Producer( String username, String password, String emailId) {
>>>>>>> UI
        super(username, password, emailId);
        supplyList = new ArrayList<Supply>();
        producerName = "";
        producerAddress = "";
    }

<<<<<<< HEAD
    public void setProducerAddress(String producerAddress) {
        this.producerAddress = producerAddress;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
=======
    @Override
    public String getEmailId() {
        return super.getEmailId();
>>>>>>> UI
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
