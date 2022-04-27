package com.company.model;

import java.util.ArrayList;
import java.util.List;

public class Producer extends Consumer{
    String producerAddress;
    String producerName;
    List<Supply> supplyList;
    public Producer( String username, String password, String emailId) {
        super(username, password, emailId);
        supplyList = new ArrayList<Supply>();
    }

    @Override
    public String getEmailId() {
        return super.getEmailId();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

    public String getProducerAddress() {
        return producerAddress;
    }

    public String getProducerName(){
        return producerName;
    }
}
