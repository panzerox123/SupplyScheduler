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

    void loginUI(){
        JPanel loginPage = new JPanel();
        loginPage.setLayout(new GridLayout(3,1));
        loginPage.setBackground(Color.green);
        loginAsConsumerButton = new JButton();
        loginAsProducerButton = new JButton();
        registerButton = new JButton();
        loginAsProducerButton.setText("Producer Login");
        loginAsConsumerButton.setText("Consumer Login");
        registerButton.setText("Register");

        loginAsProducerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(loginPage);
                loginAsProducerUI();
            }
        });

        loginAsConsumerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(loginPage);
                loginAsConsumerUI();
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(loginPage);
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
        loginAsProducerPage = new JPanel();
        loginAsProducerPage.setBounds(0,0,800,600);
        loginAsProducerPage.setLayout(new FlowLayout());
        JTextField username = new JTextField("Username");
        JPasswordField password = new JPasswordField("Password");
        JButton submit = new JButton("Login Producer");

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                current_user = db.loginProducer(username.getText(), password.getText());
                frame.remove(loginAsProducerPage);
                producerMainUI();
            }
        });

        loginAsProducerPage.add(username);
        loginAsProducerPage.add(password);
        loginAsProducerPage.add(submit);
        frame.add(loginAsProducerPage);
        frame.repaint();
        frame.revalidate();
    }

    void loginAsConsumerUI(){
        loginAsConsumerPage = new JPanel();
        loginAsConsumerPage.setBounds(0,0,800,600);
        loginAsConsumerPage.setLayout(new FlowLayout());
        JTextField username = new JTextField("Username");
        JPasswordField password = new JPasswordField("Password");
        JButton submit = new JButton("Login Consumer");

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

        loginAsConsumerPage.add(username);
        loginAsConsumerPage.add(password);
        loginAsConsumerPage.add(submit);
        frame.add(loginAsConsumerPage);
        frame.repaint();
        frame.revalidate();
    }

    void registerUI(){
        registerPage = new JPanel();
        registerPage.setLayout(new FlowLayout());
        JTextField username = new JTextField("Username");
        JPasswordField password = new JPasswordField("Password");
        JTextField email = new JTextField("Email");

        final boolean[] isProducer = {false};

        JCheckBox prod = new JCheckBox("Producer");
        prod.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isProducer[0] = !isProducer[0];
            }
        });

        JButton submit = new JButton("Register");

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

        registerPage.add(username);
        registerPage.add(password);
        registerPage.add(email);
        registerPage.add(prod);
        registerPage.add(submit);
        frame.add(registerPage);
        frame.repaint();
        frame.revalidate();
    }

    JPanel producerMainPage;
    JPanel consumerMainPage;
    JPanel addSupplyPage;

    void producerMainUI(){
        producerMainPage = new JPanel();
        producerMainPage.setLayout(new GridLayout(2,3));
        producerMainPage.add(new JLabel("Producer ID: " + current_user));

        JButton addSupplyButton = new JButton("Add supply!");
        addSupplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(producerMainPage);
                addSupplyUI();
            }
        });
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
        JTable supplyTable = new JTable(data, colNames);
        producerMainPage.add(new JScrollPane(supplyTable));
        JButton deleteSupply = new JButton("Delete Supply");
        deleteSupply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = supplyTable.getSelectedRow();
                db.deleteSupply(data[row][0]);
                frame.remove(producerMainPage);
                producerMainUI();
            }
        });
        System.out.println(sl);
        producerMainPage.add(addSupplyButton);
        producerMainPage.add(deleteSupply);
        frame.add(producerMainPage);
        frame.repaint();
        frame.revalidate();
    }

    void addSupplyUI(){
        addSupplyPage = new JPanel();
        addSupplyPage.setLayout(new FlowLayout());
        frame.add(addSupplyPage);
        final boolean[] showDatePicker = new boolean[1];
        JTextField itemName = new JTextField("Name of item");
        JTextField itemCost = new JTextField("Cost");
        JTextField itemStock = new JTextField("Item Stock");
        JButton submit = new JButton("Submit");
        JCheckBox showDate = new JCheckBox("Perishable?");
        JPanel datePicker = new JPanel();
        JTextField dd = new JTextField("dd");
        JTextField mm = new JTextField("mm");
        JTextField yy = new JTextField("yy");

        datePicker.add(dd);
        datePicker.add(mm);
        datePicker.add(yy);
        datePicker.setLayout(new FlowLayout());
        datePicker.setVisible(false);

        addSupplyPage.add(showDate);
        addSupplyPage.add(datePicker);
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
        addSupplyPage.add(itemName);
        addSupplyPage.add(itemCost);
        addSupplyPage.add(itemStock);
        addSupplyPage.add(submit);

        frame.repaint();
        frame.revalidate();
    }

    void consumerMainUI(){
        consumerMainPage = new JPanel();
        consumerMainPage.setLayout(new GridLayout(2,4));
        consumerMainPage.add(new JLabel("Consumer ID: "+current_user));
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
        JTable supplyTable = new JTable(data, colNames);
        consumerMainPage.add(new JScrollPane(supplyTable));
        JButton showRequirementButton = new JButton("Show Requirements");
        showRequirementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(consumerMainPage);
                requirementUI();
            }
        });
        JButton showAdhocButton = new JButton("Show Adhoc");
        JButton addRequirementButton = new JButton("Add to Requirements");
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
        JButton addAdhocButton = new JButton("Add to adhoc");
        consumerMainPage.add(showRequirementButton);
        consumerMainPage.add(showAdhocButton);
        consumerMainPage.add(addRequirementButton);
        consumerMainPage.add(addAdhocButton);
        frame.add(consumerMainPage);
        frame.repaint();
        frame.revalidate();
    }

    JPanel requirementPage;

    void requirementUI(){
        requirementPage = new JPanel();
        requirementPage.setLayout(new GridLayout());

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
        requirementPage.add(new JScrollPane(supplyTable));
        JButton deleteButton = new JButton("Delete");
        JButton backButton = new JButton("Back");

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                db.deleteRequirement(data[supplyTable.getSelectedRow()][0]);
                frame.remove(requirementPage);
                requirementUI();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(requirementPage);
                consumerMainUI();
            }
        });
        requirementPage.add(deleteButton);
        requirementPage.add(backButton);
        frame.add(requirementPage);
        frame.repaint();
        frame.revalidate();
    }


    SingletonUI(){
        current_user = "";
        db = DatabaseController.getInstance();
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));
        loginUI();
    }

    public void setVisible() {
        frame.setVisible(true);
    }
}
