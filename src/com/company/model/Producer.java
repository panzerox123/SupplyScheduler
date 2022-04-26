package com.company.model;

import java.util.ArrayList;
import java.util.List;

public class Producer extends Consumer{
    List<Supply> supplyList;
    public Producer(int uid, String username, String password, String emailId){
        super(uid, username, password, emailId);
        supplyList = new ArrayList<Supply>();
    }
}
