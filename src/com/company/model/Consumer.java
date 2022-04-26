package com.company.model;

import java.util.ArrayList;
import java.util.List;

public class Consumer extends User{
    List<Requirement> requirementList;
    List<Adhoc> adhocList;
    public Consumer(int uid, String username, String password, String emailId){
        super(uid, username, password, emailId);
        requirementList = new ArrayList<Requirement>();
        adhocList = new ArrayList<Adhoc>();
    }
}
