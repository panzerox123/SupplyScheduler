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

    public int getUid() {
        return uid;
    }

    public String getUsername() {
        return username;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }
}
