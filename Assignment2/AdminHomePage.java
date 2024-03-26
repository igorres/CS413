/*************************************************
File: AdminHomePage.java
By: Igor Tello
Date: 3/26/24
Compile: 
Usage: 
System: java
Description: Creates a GUI frame to show the home page 
            for Admin, with powers of creating new customers,
            new bank accounts, viewing all customer and accounts.
*************************************************/
package Assignment2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminHomePage extends JFrame implements ActionListener {
    
    JButton jbAll, jbTrans, jbCreateCust, jbCreateAcc, jbCreateAdmin;
    
    AdminHomePage() {
    
        setLayout(null);
        
        
        //create icon you want on the frame
        //ImageIcon iIcon = new ImageIcon(ClassLoader.getSystemResource("icons/emp.jpg"));
        //Image anImage = iIcon.getImage().getScaledInstance(1000, 630, Image.SCALE_DEFAULT);
        //ImageIcon iIcon2 = new ImageIcon(anImage);
        JLabel theLabel = new JLabel();
        theLabel.setBounds(0, 0, 1100,630);
        add(theLabel);
        
        
        JLabel heading = new JLabel("Welcome to the admin page");
        heading.setBounds(100, 100, 400,40);
        heading.setFont(new Font("Tahoma", Font.BOLD, 25));
        theLabel.add(heading);
        
        jbCreateCust = new JButton("Create a Customer profile");
        jbCreateCust.setBounds(100, 150, 200,40);
        jbCreateCust.addActionListener(this);
        theLabel.add(jbCreateCust);

        jbCreateAcc = new JButton("Create an account");
        jbCreateAcc.setBounds(100, 200, 200, 40);
        jbCreateAcc.addActionListener(this);
        theLabel.add(jbCreateAcc);

        jbCreateAdmin = new JButton("Create new Admin");
        jbCreateAdmin.setBounds(100, 250, 200, 40);
        jbCreateAdmin.addActionListener(this);
        theLabel.add(jbCreateAdmin);

        jbAll = new JButton("View all accounts");
        jbAll.setBounds(100, 300, 200,40);
        jbAll.addActionListener(this);
        theLabel.add(jbAll);
        
        jbTrans = new JButton("View all transactions");
        jbTrans.setBounds(100, 350, 200,40);
        jbTrans.addActionListener(this);
        theLabel.add(jbTrans);
        
        setSize(1120, 630);
        setLocation(250, 100);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae) {
        
        if((ae.getSource()) == jbTrans) { 
            JOptionPane.showMessageDialog(null, "Functionality to view all transactions coming soon..");
            this.setVisible(true);
        } else if((ae.getSource()) == jbAll) {
            JOptionPane.showMessageDialog(null, "Functionality to view all accounts coming soon..");
            this.setVisible(true);
        } else if((ae.getSource()) == jbCreateCust) {
            new CustomerFrame();
        } else if((ae.getSource()) == jbCreateAcc) {
            new BankAccountFrame();
        } else if((ae.getSource()) == jbCreateAdmin) {
            new AdminFrame();
        }
    }
    
    //This main method is not needed, unless you want to run this class by itself from your IDE to validate its look'n feel
    //This frame(window) will be called as a result of an action(click, select etc) from another widget on on another winhow during the GUI workflow
    public static void main(String[] args) {

        new AdminHomePage();

    }
    
}
