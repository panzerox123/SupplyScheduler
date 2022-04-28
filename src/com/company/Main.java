package com.company;

import com.company.model.Producer;
import com.company.model.Supply;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        DatabaseController db = DatabaseController.getInstance();
        String res = db.registerProducer(new Producer("kunal1", "pass", "kunal@gmail.com"));
        System.out.println("here" + res);
        res = db.loginProducer("kunal1", "pass");
        System.out.println(res);
        db.storeSupply(res, new Supply("Vimal Paan Masala", 12, 100));
        db.storeSupply(res, new Supply("Vimal Paan Masala 2", 24, 400));
        ArrayList<Supply> r = db.getSupplies(res);
        for(Supply s: r){
            System.out.println(s.getName());
        }
        //UI ui = UI.getInstance();
        //ui.mainUI();
        Database db = Database.getInstance();
        db.registerConsumer(new Consumer("kunal1", "pass", "kunal@gmail.com"));
        db.loginConsumer("kunal1","pass");
    }
    public void Login(String Uname,String pass,String email){
//        if(Uname=="");
//        else ;

    }
    public void Register(String Uname,String pass,String email,int type){
        //call userbuilder
    }
}

