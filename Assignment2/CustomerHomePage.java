/*************************************************
File: CustomerHomePage.java
By: Igor Tello
Date: 3/26/24
Compile: 
Usage: 
System: java
Description: Creates a GUI frame for the Customer's home page
            allows customer to view accounts and create transactions.
*************************************************/
package Assignment2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CustomerHomePage extends JFrame implements ActionListener {
    
    JButton jbAll, jbTrans, jbCreateTrans;
    
    CustomerHomePage() {
    
        setLayout(null);
        
        
        //create icon you want on the frame
        //ImageIcon iIcon = new ImageIcon(ClassLoader.getSystemResource("icons/emp.jpg"));
        //Image anImage = iIcon.getImage().getScaledInstance(1000, 630, Image.SCALE_DEFAULT);
        //ImageIcon iIcon2 = new ImageIcon(anImage);
        JLabel theLabel = new JLabel();
        theLabel.setBounds(0, 0, 1100,630);
        add(theLabel);
        
        
        JLabel heading = new JLabel("Welcome to your page");
        heading.setBounds(100, 100, 400,40);
        heading.setFont(new Font("Tahoma", Font.BOLD, 25));
        theLabel.add(heading);
        
        jbCreateTrans = new JButton("Create a transaction");
        jbCreateTrans.setBounds(100, 150, 200,40);
        jbCreateTrans.addActionListener(this);
        theLabel.add(jbCreateTrans);

        jbAll = new JButton("View all accounts");
        jbAll.setBounds(100, 200, 200,40);
        jbAll.addActionListener(this);
        theLabel.add(jbAll);
        
        jbTrans = new JButton("View all transactions");
        jbTrans.setBounds(100, 250, 200,40);
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
        } else if((ae.getSource()) == jbCreateTrans) {
            JOptionPane.showMessageDialog(null, "Functionality to create a transaction coming soon..");
        }
    }
    
    //This main method is not needed, unless you want to run this class by itself from your IDE to validate its look'n feel
    //This frame(window) will be called as a result of an action(click, select etc) from another widget on on another winhow during the GUI workflow
    public static void main(String[] args) {

        new CustomerHomePage();

    }
    
}
