package com.company.model;

public abstract class User {
    String username;
    String password;
    String emailId;
    public User(String username, String password, String emailId){
        this.username = username;
        this.password = password;
        this.emailId = emailId;
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
