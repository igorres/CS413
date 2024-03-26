/*************************************************
File: LandingPage.java
By: Igor Tello
Date: 3/26/24
Compile: 
Usage: 
System: java
Description: Opening page of the application, should be run first
*************************************************/
package Assignment2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LandingPage extends JFrame implements ActionListener {
    
    JButton jbCustLogin, jbAdminLogin;
    
    LandingPage() {
    
        setLayout(null);
    
        JLabel theLabel = new JLabel();
        theLabel.setBounds(0, 0, 1100,630);
        add(theLabel);
        
        JLabel heading = new JLabel("Welcome to The Bank.");
        heading.setBounds(100, 100, 600,40);
        heading.setFont(new Font("Tahoma", Font.BOLD, 25));
        theLabel.add(heading);
        
        jbCustLogin = new JButton("Customer Log In");
        jbCustLogin.setBounds(100, 200, 200,40);
        jbCustLogin.addActionListener(this);
        theLabel.add(jbCustLogin);
        
        jbAdminLogin = new JButton("Admin Log In");
        jbAdminLogin.setBounds(100, 250, 200,40);
        jbAdminLogin.addActionListener(this);
        theLabel.add(jbAdminLogin);
        
        setSize(1120, 630);
        setLocation(250, 100);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae) {

        if((ae.getSource()) == jbCustLogin
        ) { 
                new CustomerLogin();
        } else if((ae.getSource()) == jbAdminLogin) {
                new AdminLogin();
        } 
    }
    
    public static void main(String[] args) {
        new LandingPage();
    }
    
}
