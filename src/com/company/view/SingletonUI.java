package com.company.view;
import com.company.DatabaseController;
import com.company.model.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.Document;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

public class SingletonUI {
    static SingletonUI instance = new SingletonUI();

    public static SingletonUI getInstance() {
        return instance;
    }

    DatabaseController db;
    JFrame frame;
    JButton loginAsProducerButton;
    JButton loginAsConsumerButton;
    JButton registerButton;
    JPanel loginPage;
    JPanel loginAsProducerPage;
    JPanel loginAsConsumerPage;
    JPanel registerPage;

    String current_user;
    int isProd = 0;

    void loginUI(){
        JPanel loginPage = new JPanel(null);
        loginPage.setBackground(new Color(79, 195, 247));
        loginAsConsumerButton = new JButton();
        loginAsProducerButton = new JButton();
        registerButton = new JButton();
        loginAsConsumerButton.setBounds(300, 50, 200, 50);
        loginAsProducerButton.setBounds(300, 150, 200, 50);
        registerButton.setBounds(300, 250, 200, 50);
        loginAsProducerButton.setText("Producer Login");
        loginAsConsumerButton.setText("Consumer Login");
        registerButton.setText("Register");
        loginAsProducerButton.setBackground(new Color(255, 255, 255));
        loginAsConsumerButton.setBackground(new Color(255, 255, 255));
        registerButton.setBackground(new Color(255, 255, 255));

        loginAsProducerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(loginPage);
                isProd = 1;
                loginAsProducerUI();
            }
        });

        loginAsConsumerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(loginPage);
                isProd = 0;
                loginAsConsumerUI();
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(loginPage);
                isProd = 0;
                registerUI();
            }
        });

        loginPage.add(loginAsConsumerButton);
        loginPage.add(loginAsProducerButton);
        loginPage.add(registerButton);
        frame.add(loginPage);
        frame.repaint();
        frame.revalidate();
    }

    void loginAsProducerUI(){
        loginAsProducerPage = new JPanel(null);
        loginAsProducerPage.setBounds(0,0,800,600);
        loginAsProducerPage.setBackground(new Color(79, 195, 247));
        JTextField username = new JTextField("Username");
        JPasswordField password = new JPasswordField("Password");
        JButton submit = new JButton("Login Producer");
        JButton back = new JButton("Back");

        username.setBounds(300, 50, 200, 30);
        password.setBounds(300, 130, 200, 30);
        submit.setBounds(300, 210, 200, 50);
        back.setBounds(300, 310, 200, 50);
        submit.setBackground(new Color(255, 255, 255));
        back.setBackground(new Color(255, 255, 255));

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                current_user = db.loginProducer(username.getText(), password.getText());
                frame.remove(loginAsProducerPage);
                producerMainUI();
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(loginAsProducerPage);
                loginUI();
            }
        });

        loginAsProducerPage.add(username);
        loginAsProducerPage.add(password);
        loginAsProducerPage.add(submit);
        loginAsProducerPage.add(back);
        frame.add(loginAsProducerPage);
        frame.repaint();
        frame.revalidate();
    }

    void loginAsConsumerUI(){
        loginAsConsumerPage = new JPanel(null);
        loginAsConsumerPage.setBounds(0,0,800,600);
        loginAsConsumerPage.setBackground(new Color(79, 195, 247));
        JTextField username = new JTextField("Username");
        JPasswordField password = new JPasswordField("Password");
        JButton submit = new JButton("Login Consumer");
        JButton back = new JButton("Back");
        submit.setBackground(new Color(255, 255, 255));
        back.setBackground(new Color(255, 255, 255));

        username.setBounds(300, 50, 200, 30);
        password.setBounds(300, 130, 200, 30);
        submit.setBounds(300, 210, 200, 50);
        back.setBounds(300, 310, 200, 50);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println(username.getText() + password.getText());
                current_user = db.loginConsumer(username.getText(), password.getText());
                frame.remove(loginAsConsumerPage);
                System.out.println(current_user);
                consumerMainUI();
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(loginAsConsumerPage);
                loginUI();
            }
        });

        loginAsConsumerPage.add(username);
        loginAsConsumerPage.add(password);
        loginAsConsumerPage.add(submit);
        loginAsConsumerPage.add(back);
        frame.add(loginAsConsumerPage);
        frame.repaint();
        frame.revalidate();
    }

    void registerUI(){
        registerPage = new JPanel(null);
        registerPage.setBackground(new Color(79, 195, 247));
        JTextField username = new JTextField("Username");
        JPasswordField password = new JPasswordField("Password");
        JTextField email = new JTextField("Email");
        final boolean[] isProducer = {false};
        JCheckBox prod = new JCheckBox("Producer");
        JButton submit = new JButton("Register");
        JButton back = new JButton("Back");
        submit.setBackground(new Color(255, 255, 255));
        back.setBackground(new Color(255, 255, 255));
        prod.setBackground(new Color(79, 195, 247));

        username.setBounds(300, 50, 200, 30);
        password.setBounds(300, 130, 200, 30);
        email.setBounds(300, 210, 200, 30);
        prod.setBounds(300, 290, 200, 30);
        submit.setBounds(300, 370, 200, 50);
        back.setBounds(300, 470, 200, 50);

        prod.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isProducer[0] = !isProducer[0];
                if(isProducer[0]) {
                    isProd = 1;
                }
                else {
                    isProd = 0;
                }
            }
        });

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println(isProducer[0]);
                if(isProducer[0]) {
                    Producer producer = new Producer(username.getText(), password.getText(), email.getText());
                    current_user = db.registerProducer(producer);
                    frame.remove(registerPage);
                    producerMainUI();
                }
                else {
                    Consumer consumer = new Consumer(username.getText(), password.getText(), email.getText());
                    current_user = db.registerConsumer(consumer);
                    frame.remove(registerPage);
                    consumerMainUI();
                }
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(registerPage);
                loginUI();
            }
        });

        registerPage.add(username);
        registerPage.add(password);
        registerPage.add(email);
        registerPage.add(prod);
        registerPage.add(submit);
        registerPage.add(back);

        frame.add(registerPage);
        frame.repaint();
        frame.revalidate();
    }

    JPanel producerMainPage;
    JPanel consumerMainPage;
    JPanel addSupplyPage;

    void producerMainUI(){

        ArrayList<Supply> sl = db.getSupplies(current_user);
        String data [][] = new String[sl.size()][4];
        String colNames[] = {"ID", "NAME", "COST", "STOCK"};

        int i = 0;
        for(Supply s: sl){
            data[i][0] = s.getItem_id();
            data[i][1] = s.getName();
            data[i][2] = Integer.toString(s.getCost());
            data[i][3] = Integer.toString(s.getStock());
            i+=1;
        }

        producerMainPage = new JPanel(null);
        producerMainPage.setBackground(new Color(79, 195, 247));
        JLabel prodId = new JLabel("Producer ID: " + current_user);
        JButton addSupplyButton = new JButton("Add supply!");
        JTable supplyTable = new JTable(data, colNames);
        JScrollPane supplyTableScroll = new JScrollPane(supplyTable);
        JButton deleteSupply = new JButton("Delete Supply");
        JButton back = new JButton("Back");
        supplyTableScroll.setBackground(new Color(255, 255, 255));
        deleteSupply.setBackground(new Color(255, 255, 255));
        back.setBackground(new Color(255, 255, 255));
        addSupplyButton.setBackground(new Color(255, 255, 255));

        prodId.setBounds(300, 30, 200, 30);
        supplyTableScroll.setBounds(200, 90, 400, 200);
        addSupplyButton.setBounds(300, 320, 200, 50);
        deleteSupply.setBounds(300, 400, 200, 50);
        back.setBounds(300, 480, 200, 50);

        addSupplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(producerMainPage);
                addSupplyUI();
            }
        });
        deleteSupply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = supplyTable.getSelectedRow();
                db.deleteSupply(data[row][0]);
                frame.remove(producerMainPage);
                producerMainUI();
            }
        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(producerMainPage);
                loginUI();
            }
        });

        System.out.println(sl);
        producerMainPage.add(prodId);
        producerMainPage.add(supplyTableScroll);
        producerMainPage.add(addSupplyButton);
        producerMainPage.add(deleteSupply);
        producerMainPage.add(back);

        frame.add(producerMainPage);
        frame.repaint();
        frame.revalidate();
    }

    void addSupplyUI(){

        addSupplyPage = new JPanel(null);
        addSupplyPage.setBackground(new Color(79, 195, 247));
        final boolean[] showDatePicker = new boolean[1];
        JTextField itemName = new JTextField("Name of item");
        JTextField itemCost = new JTextField("Cost");
        JTextField itemStock = new JTextField("Item Stock");
        JButton submit = new JButton("Submit");
        JCheckBox showDate = new JCheckBox("Perishable?");
        JButton back = new JButton("Back");
        submit.setBackground(new Color(255, 255, 255));
        back.setBackground(new Color(255, 255, 255));
        showDate.setBackground(new Color(79, 195, 247));

        JPanel datePicker = new JPanel(null);
        datePicker.setBackground(new Color(79, 195, 247));
        JTextField dd = new JTextField("dd");
        JTextField mm = new JTextField("mm");
        JTextField yy = new JTextField("yy");

        dd.setBounds(0, 0, 200, 30);
        mm.setBounds(0, 60, 200, 30);
        yy.setBounds(0, 120, 200, 30);
        datePicker.add(dd);
        datePicker.add(mm);
        datePicker.add(yy);
        datePicker.setVisible(false);

        itemName.setBounds(300, 30, 200, 30);
        itemCost.setBounds(300, 90, 200, 30);
        itemStock.setBounds(300, 150, 200, 30);
        showDate.setBounds(300, 210, 200, 30);
        datePicker.setBounds(300, 270, 200, 150);
        submit.setBounds(300, 450, 200, 50);
        back.setBounds(300, 530, 200, 50);

        showDate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDatePicker[0] = !showDatePicker[0];
                datePicker.setVisible(showDatePicker[0]);
            }
        });

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("CLicked!");
                Supply s = SupplyScheduler.getSupply(1,itemName.getText(), Integer.parseInt(itemCost.getText()), Integer.parseInt(itemStock.getText()));
                db.storeSupply(current_user, s);
                frame.remove(addSupplyPage);
                producerMainUI();
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(addSupplyPage);
                producerMainUI();
            }
        });

        addSupplyPage.add(showDate);
        addSupplyPage.add(datePicker);
        addSupplyPage.add(itemName);
        addSupplyPage.add(itemCost);
        addSupplyPage.add(itemStock);
        addSupplyPage.add(submit);
        addSupplyPage.add(back);

        frame.add(addSupplyPage);
        frame.repaint();
        frame.revalidate();
    }

    void consumerMainUI(){

        consumerMainPage = new JPanel(null);
        consumerMainPage.setBackground(new Color(79, 195, 247));

        ArrayList<Supply> sl = db.getSupplies();
        String data [][] = new String[sl.size()][4];
        String colNames[] = {"ID", "NAME", "COST", "STOCK"};
        int i = 0;
        for(Supply s: sl){
            data[i][0] = s.getItem_id();
            data[i][1] = s.getName();
            data[i][2] = Integer.toString(s.getCost());
            data[i][3] = Integer.toString(s.getStock());
            i+=1;
        }

        JLabel consId = new JLabel("Consumer ID: "+ current_user);
        JTable supplyTable = new JTable(data, colNames);
        JScrollPane supplyTableScroll = new JScrollPane(supplyTable);
        JButton showRequirementButton = new JButton("Show Requirements");
        JButton addRequirementButton = new JButton("Add to Requirements");
        JButton back = new JButton("Back");
        supplyTableScroll.setBackground(new Color(255, 255, 255));
        showRequirementButton.setBackground(new Color(255, 255, 255));
        addRequirementButton.setBackground(new Color(255, 255, 255));
        back.setBackground(new Color(255, 255, 255));

        consId.setBounds(300, 30, 200, 30);
        supplyTableScroll.setBounds(200, 90, 400, 200);
        addRequirementButton.setBounds(300, 320, 200, 50);
        showRequirementButton.setBounds(300, 400, 200, 50);
        back.setBounds(300, 480, 200, 50);

        showRequirementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(consumerMainPage);
                requirementUI();
            }
        });

        addRequirementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("CALLED");
                int row = supplyTable.getSelectedRow();
                Supply s = db.returnSupply(data[row][0]);
                System.out.println(s.getName());
                Requirement r = new Requirement(s, 1);
                db.storeRequirement(current_user, r);
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(consumerMainPage);
                loginUI();
            }
        });

        consumerMainPage.add(consId);
        consumerMainPage.add(supplyTableScroll);
        consumerMainPage.add(showRequirementButton);
        consumerMainPage.add(addRequirementButton);
        consumerMainPage.add(back);

        frame.add(consumerMainPage);
        frame.repaint();
        frame.revalidate();
    }

    JPanel requirementPage;

    void requirementUI(){

        requirementPage = new JPanel(null);
        requirementPage.setBackground(new Color(79, 195, 247));

        ArrayList<Requirement> req =  db.getRequirements(current_user);
        String data [][] = new String[req.size()][4];
        String colNames[] = {"ID", "NAME", "QUANTITY", "COST"};
        int i = 0;
        for(Requirement r : req){
            data[i][0] = r.getId();
            data[i][1] = r.getItem().getName();
            data[i][2] = Integer.toString(r.getQuantity());
            data[i][3] = Integer.toString(r.getTotalCost());
            i+=1;
        }

        JTable supplyTable = new JTable(data, colNames);
        JScrollPane supplyTableScroll = new JScrollPane(supplyTable);
        JButton deleteButton = new JButton("Delete");
        JButton back = new JButton("Back");
        supplyTableScroll.setBackground(new Color(255, 255, 255));
        deleteButton.setBackground(new Color(255, 255, 255));
        back.setBackground(new Color(255, 255, 255));

        supplyTableScroll.setBounds(200, 50, 400, 200);
        deleteButton.setBounds(300, 300, 200, 50);
        back.setBounds(300, 400, 200, 50);

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                db.deleteRequirement(data[supplyTable.getSelectedRow()][0]);
                frame.remove(requirementPage);
                requirementUI();
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isProd == 1) {
                    frame.remove(requirementPage);
                    producerMainUI();
                }
                else {
                    frame.remove(requirementPage);
                    consumerMainUI();
                }
            }
        });

        requirementPage.add(supplyTableScroll);
        requirementPage.add(deleteButton);
        requirementPage.add(back);
        frame.add(requirementPage);
        frame.repaint();
        frame.revalidate();
    }


    SingletonUI(){
        current_user = "";
        db = DatabaseController.getInstance();
        frame = new JFrame("Supply Scheduler");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 700);
        loginUI();
    }

    public void setVisible() {
        frame.setVisible(true);
    }
}
