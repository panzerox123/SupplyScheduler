package com.company.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class UI {
    static UI instance = new UI();
    JFrame frame;
    JLabel title;
    JLabel subtitle;
    JPanel mainPanel;
    public static UI getInstance(){
        return instance;
    }

    static int login_type = 1;
    static String user_id = "";

    public void mainUI(){
        JButton loginAsConsumer = new JButton();
        loginAsConsumer.setText("Consumer");
        loginAsConsumer.setBounds(300,200,200,50);
        JButton loginAsProducer = new JButton();
        loginAsProducer.setText("Producer");
        loginAsProducer.setBounds(300,300,200,50);
        JButton register = new JButton();
        register.setText("Register");
        register.setBounds(350,400,100,50);

        frame.add(loginAsConsumer);
        frame.add(loginAsProducer);
        frame.add(register);
    }

    UI(){
        frame = new JFrame();
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
        frame.setSize(800,600);
        frame.setLayout(null);
        frame.setVisible(true);

    }
}
