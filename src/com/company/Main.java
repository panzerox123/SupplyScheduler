package com.company;

import com.company.model.Consumer;
import com.company.model.Database;
import com.company.view.UI;

import javax.xml.crypto.Data;

public class Main {

    public static void main(String[] args) {
        //Database db = Database.getInstance();
        //db.registerConsumer(new Consumer("kunal", "pass", "kunal@gmail.com"));
        //Consumer res = db.loginConsumer("kunal","pass");
        //System.out.println(res.getEmailId() + res.getUsername());
        UI ui = UI.getInstance();
        ui.mainUI();
    }
    public void Login(String Uname,String pass,String email){
//        if(Uname=="");
//        else ;

    }
    public void Register(String Uname,String pass,String email,int type){
        //call userbuilder
    }
}

