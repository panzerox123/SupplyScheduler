package com.company.model;

import java.util.ArrayList;
import java.util.List;

public class Consumer extends User{
    List<Requirement> requirementList;
    List<Adhoc> adhocList;
    public Consumer(String username, String password, String emailId){
        super( username, password, emailId);
        requirementList = new ArrayList<Requirement>();
        adhocList = new ArrayList<Adhoc>();
    }
//    public void addRequirement(Requirement r){
//        requirementList.add(r);
//    }
//    public void removeRequirement(Requirement r){
//        requirementList.remove(r);
//    }
//    public void addAdhoc(Adhoc a){
//        adhocList.add(a);
//    }
//    public void removeAdhoc(Adhoc a){
//        adhocList.remove(a);
//    }
    public void viewRequirements(){
        for(int i=0;i<requirementList.size();i++)
            System.out.println(requirementList.get(i));
    }
    public void viewAdhoc(){
        for(int i=0;i<adhocList.size();i++)
            System.out.println(adhocList.get(i));
    }


}
