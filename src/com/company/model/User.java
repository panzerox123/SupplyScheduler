package com.company.model;

public abstract class User {
    int uid;
    String username;
    String password;
    String emailId;
    public User(int uid, String username, String password, String emailId){
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.emailId = emailId;
    }
}
