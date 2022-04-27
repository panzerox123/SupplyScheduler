package com.company.model;

public class UserBuilder {
    public static User getUser(int type,String username, String password, String emailId){
        switch(type){
            case 1:
                return new Consumer(username,password,emailId);
            case 2:
                return new Producer(username, password, emailId);
            default:
                return null;
        }
    }
}
