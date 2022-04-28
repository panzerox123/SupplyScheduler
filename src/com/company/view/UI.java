package com.company.view;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UI {

    JFrame frame = new JFrame("Supply Scheduler");
    JPanel login = new JPanel(null);
    JPanel consumerLogin = new JPanel(null);
    JPanel producerLogin = new JPanel(null);
    JPanel order = new JPanel(null);
    JPanel orderView = new JPanel(null);
    JPanel adhoc = new JPanel(null);
    JPanel requirement = new JPanel(null);
    JPanel supply = new JPanel(null);

    JLabel usernameL = new JLabel("Username");
    JLabel emailL = new JLabel("Email");
    JLabel passwordL = new JLabel("Password");
    JTextField usernameF = new JTextField("Enter Username");
    JTextField emailF = new JTextField("Enter email Id");
    JPasswordField passwordF = new JPasswordField("Enter password");
    JButton loginBut = new JButton("Login");
    JButton registerBut = new JButton("Register");
    JRadioButton producerBut = new JRadioButton("Producer");
    int isProducer = 0;

    JButton orderButCons = new JButton("New Order");
    JButton orderViewButCons = new JButton("My Orders");
    JButton logoutButCons = new JButton("Logout");

    JButton orderButProds = new JButton("New Order");
    JButton orderViewButProds = new JButton("My Orders");
    JButton logoutButProds = new JButton("Logout");
    JButton supplyBut = new JButton("My Supplies");

    JLabel suppliesL = new JLabel("Supplies");
    JLabel quantityL = new JLabel("Quantity");
    JComboBox suppliesF = new JComboBox(); // takes a parameter which is a list of Strings for display in the drop down
    JTextField quantityF = new JTextField("Enter quantity of items");
    JButton adhocBut = new JButton("Place adhoc order");
    JButton requirementBut = new JButton("Place requirement");
    JButton backButLoginsOrder = new JButton("Back");

    JComboBox ordersF = new JComboBox(); // takes a parameter which is a list of Strings for display in the drop down
    JButton removeOrderBut = new JButton("Remove Order");
    JButton backButLoginsOrderView = new JButton("Back");

    JLabel descriptionAdhocL = new JLabel("Description");
    JLabel addressAdhocL = new JLabel("Address");
    JTextArea descriptionAdhocF = new JTextArea("Enter Description");
    JTextArea addressAdhocF = new JTextArea("Enter Address");
    JButton orderAdhocBut = new JButton("Order");
    JButton backButOrderAdhoc = new JButton("Back");

    JLabel descriptionRequirementL = new JLabel("Description");
    JLabel addressRequirementL = new JLabel("Address");
    JTextArea descriptionRequirementF = new JTextArea("Enter Description");
    JTextArea addressRequirementF = new JTextArea("Enter Address");
    JLabel intervalL = new JLabel("Interval");
    JTextField intervalF = new JTextField("Enter Interval");
    JButton orderRequirementBut = new JButton("Order");
    JButton backButOrderRequirement = new JButton("Back");

    JLabel itemNameL = new JLabel("Name");
    JLabel itemQuantityL = new JLabel("Quantity");
    JLabel costL = new JLabel("Cost");
    JRadioButton perishableBut = new JRadioButton("Perishable");
    JLabel bestBeforeL = new JLabel("Best Before Date");
    JTextField itemNameF = new JTextField("Enter Name");
    JTextField itemQuantityF = new JTextField("Enter Quantity");
    JTextField costF = new JTextField("Enter Cost Per Item");
    JTextField bestBeforeF = new JTextField("Enter Best Before Date if applicable");
    JButton makeSupplyBut = new JButton("Create Supply");
    JButton backButLoginsSupply = new JButton("Back");
    int isPerishable = 0;

    public UI() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);

        login.setBounds(0, 0, 400, 300);
        usernameL.setBounds(220, 10, 160, 20);
        usernameF.setBounds(220, 40, 160, 20);
        emailL.setBounds(220, 70, 160, 20);
        emailF.setBounds(220, 100, 160, 20);
        passwordL.setBounds(220, 130, 160, 20);
        passwordF.setBounds(220, 160, 160, 20);
        producerBut.setBounds(220, 190, 160, 20);
        loginBut.setBounds(220, 220, 160, 20);
        registerBut.setBounds(220, 250, 160, 20);
        loginBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usernameS = usernameF.getText();
                String emailS = emailF.getText();
                String passwordS = String.valueOf(passwordF.getPassword());

                //Login Logic

                //if login successful
                frame.getContentPane().removeAll();
                if(isProducer == 1) {
                    frame.getContentPane().add(producerLogin);
                }
                else {
                    frame.getContentPane().add(consumerLogin);
                }
                frame.validate();
            }
        });
        registerBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usernameS = usernameF.getText();
                String emailS = emailF.getText();
                String passwordS = String.valueOf(passwordF.getPassword());

                //Register Logic

                //if register successful
                frame.getContentPane().removeAll();
                if(isProducer == 1) {
                    frame.getContentPane().add(producerLogin);
                }
                else {
                    frame.getContentPane().add(consumerLogin);
                }
                frame.validate();
            }
        });
        producerBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(producerBut.isSelected()){
                    isProducer = 1;
                }
                else {
                    isProducer = 0;
                }
            }
        });
        login.add(usernameL);
        login.add(usernameF);
        login.add(passwordL);
        login.add(passwordF);
        login.add(emailL);
        login.add(emailF);
        login.add(producerBut);
        login.add(loginBut);
        login.add(registerBut);
        frame.getContentPane().add(login);
        frame.setVisible(true);


        orderButCons.setBounds(200, 30, 200, 50);
        orderViewButCons.setBounds(200, 110, 200, 50);
        logoutButCons.setBounds(500, 10, 80, 30);
        orderButCons.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(order);
                frame.validate();
            }
        });
        orderViewButCons.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(orderView);
                frame.validate();
            }
        });
        logoutButCons.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(login);
                frame.validate();
            }
        });
        consumerLogin.add(orderButCons);
        consumerLogin.add(orderViewButCons);
        consumerLogin.add(logoutButCons);

        orderButProds.setBounds(200, 30, 200, 50);
        orderViewButProds.setBounds(200, 110, 200, 50);
        logoutButProds.setBounds(500, 10, 80, 30);
        orderButProds.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(order);
                frame.validate();
            }
        });
        orderViewButProds.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(orderView);
                frame.validate();
            }
        });
        logoutButProds.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(login);
                frame.validate();
            }
        });
        supplyBut.setBounds(200, 190, 200, 50);
        supplyBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(supply);
                frame.validate();
            }
        });
        producerLogin.add(orderButProds);
        producerLogin.add(orderViewButProds);
        producerLogin.add(supplyBut);
        producerLogin.add(logoutButProds);

        suppliesL.setBounds(200, 30, 200, 20);
        suppliesF.setBounds(200, 80, 200, 20);
        quantityL.setBounds(200, 130, 200, 20);
        quantityF.setBounds(200, 180, 200, 20);
        adhocBut.setBounds(200, 230, 200, 50);
        requirementBut.setBounds(200, 310, 200, 50);
        backButLoginsOrder.setBounds(500, 10, 80, 30);
        adhocBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(adhoc);
                frame.validate();
            }
        });
        requirementBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(requirement);
                frame.validate();
            }
        });
        backButLoginsOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                if(isProducer == 1) {
                    frame.getContentPane().add(producerLogin);
                }
                else {
                    frame.getContentPane().add(consumerLogin);
                }
                frame.validate();
            }
        });
        order.add(suppliesL);
        order.add(suppliesF);
        order.add(quantityL);
        order.add(quantityF);
        order.add(adhocBut);
        order.add(requirementBut);
        order.add(backButLoginsOrder);

        ordersF.setBounds(200, 30, 200, 50);
        removeOrderBut.setBounds(200,110, 200, 50);
        backButLoginsOrderView.setBounds(500, 10, 80, 30);
        removeOrderBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //add functionality to remove order
                int orderS = ordersF.getSelectedIndex();
            }
        });
        backButLoginsOrderView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                if(isProducer == 1) {
                    frame.getContentPane().add(producerLogin);
                }
                else {
                    frame.getContentPane().add(consumerLogin);
                }
                frame.validate();
            }
        });
        orderView.add(ordersF);
        orderView.add(removeOrderBut);
        orderView.add(backButLoginsOrderView);

        descriptionAdhocL.setBounds(200, 30, 200, 20);
        descriptionAdhocF.setBounds(200, 80, 200, 50);
        addressAdhocL.setBounds(200, 160, 200, 20);
        addressAdhocF.setBounds(200, 210, 200, 50);
        orderAdhocBut.setBounds(200, 290, 200, 20);
        backButOrderAdhoc.setBounds(500, 10, 80, 30);
        orderAdhocBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String descriptionAdhocS = descriptionAdhocF.getText();
                String addressAdhocS = addressAdhocF.getText();
                //add functionality to create adhoc order
            }
        });
        backButOrderAdhoc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(order);
                frame.validate();
            }
        });
        adhoc.add(descriptionAdhocL);
        adhoc.add(descriptionAdhocF);
        adhoc.add(addressAdhocL);
        adhoc.add(addressAdhocF);
        adhoc.add(orderAdhocBut);
        adhoc.add(backButOrderAdhoc);

        descriptionRequirementL.setBounds(200, 30, 200, 20);
        descriptionRequirementF.setBounds(200, 80, 200, 50);
        addressRequirementL.setBounds(200, 160, 200, 20);
        addressRequirementF.setBounds(200, 210, 200, 50);
        intervalL.setBounds(200, 290, 200, 20);
        intervalF.setBounds(200, 340, 200, 50);
        orderRequirementBut.setBounds(200, 420, 200, 20);
        backButOrderRequirement.setBounds(500, 10, 80, 30);
        orderRequirementBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String descriptionRequirementS = descriptionRequirementF.getText();
                String addressRequirementS = addressRequirementF.getText();
                String intervalS = intervalF.getText();
            }
        });
        backButOrderRequirement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(order);
                frame.validate();
            }
        });
        requirement.add(descriptionRequirementL);
        requirement.add(descriptionRequirementF);
        requirement.add(addressRequirementL);
        requirement.add(addressRequirementF);
        requirement.add(intervalL);
        requirement.add(intervalF);
        requirement.add(orderRequirementBut);
        requirement.add(backButOrderRequirement);

        itemNameL.setBounds(200, 30, 200, 20);
        itemNameF.setBounds(200, 80, 200, 20);
        itemQuantityL.setBounds(200, 130, 200, 20);
        itemQuantityF.setBounds(200, 180, 200, 20);
        costL.setBounds(200, 230, 200, 20);
        costF.setBounds(200, 280, 200, 20);
        perishableBut.setBounds(200,330, 200, 20);
        bestBeforeL.setBounds(200, 380, 200, 20);
        bestBeforeF.setBounds(200, 430, 200, 20);
        makeSupplyBut.setBounds(200, 480, 200, 20);
        backButLoginsSupply.setBounds(500, 10, 80, 30);
        perishableBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(perishableBut.isSelected()){
                    isPerishable = 1;
                }
                else {
                    isPerishable = 0;
                }
            }
        });
        makeSupplyBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String itemNameS = itemNameF.getText();
                String itemQuantityS = itemQuantityF.getText();
                String costS = costF.getText();
                String bestBeforeS = bestBeforeF.getText();

                //add functionality to create supply
            }
        });
        backButLoginsSupply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                if(isProducer == 1) {
                    frame.getContentPane().add(producerLogin);
                }
                else {
                    frame.getContentPane().add(consumerLogin);
                }
                frame.validate();
            }
        });
        supply.add(itemNameL);
        supply.add(itemNameF);
        supply.add(itemQuantityL);
        supply.add(itemQuantityF);
        supply.add(costL);
        supply.add(costF);
        supply.add(perishableBut);
        supply.add(bestBeforeL);
        supply.add(bestBeforeF);
        supply.add(makeSupplyBut);
        supply.add(backButLoginsSupply);
    }
}
