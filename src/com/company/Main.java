package com.company;

import com.company.model.Consumer;
import com.company.model.Database;

import javax.xml.crypto.Data;

public class Main {

    public static void main(String[] args) {
        Database db = Database.getInstance();
        db.registerConsumer(new Consumer(123,"kunal1", "pass", "kunal@gmail.com"));
        db.loginConsumer("kuna","pass");
    }
    public void Login(String Uname,String pass,String email){
//        if(Uname=="");
//        else ;

    }
    public void Register(String Uname,String pass,String email,int type){
        //call userbuilder
    }
}

