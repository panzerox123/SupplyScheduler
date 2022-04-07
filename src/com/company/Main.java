package com.company;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        JFrame frame = new JFrame();
        JButton button = new JButton("Click Here");
        button.setBounds(130,100,100,40);
        frame.add(button);
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
