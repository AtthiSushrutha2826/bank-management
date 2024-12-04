//
//package bank.management.system;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//import java.sql.*;
//
//public class Login extends JFrame implements ActionListener {
//    JButton login, signup, clear;
//    JTextField cardTextField;
//    JPasswordField pinTextField;
//
//    Login() {
//        setTitle("AUTOMATED TELLER MACHINE");
//        setSize(800, 480);
//        setLocation(350, 200);
//        setLayout(null);
//
//        JLabel text = new JLabel("ANY TIME MONEY!");
//        text.setFont(new Font("Osward", Font.BOLD, 38));
//        text.setBounds(200, 40, 400, 40);
//        add(text);
//
//        JLabel cardno = new JLabel("Card No:");
//        cardno.setFont(new Font("Raleway", Font.BOLD, 20));
//        cardno.setBounds(120, 150, 400, 40);
//        add(cardno);
//
//        cardTextField = new JTextField();
//        cardTextField.setBounds(300, 150, 250, 30);
//        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
//        add(cardTextField);
//
//        JLabel pin = new JLabel("PIN:");
//        pin.setFont(new Font("Raleway", Font.BOLD, 20));
//        pin.setBounds(120, 220, 250, 30);
//        add(pin);
//
//        pinTextField = new JPasswordField();
//        pinTextField.setBounds(300, 220, 250, 30);
//        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
//        add(pinTextField);
//
//        login = new JButton("SIGN IN");
//        login.setBounds(300, 300, 100, 30);
//        login.setBackground(Color.BLACK);
//        login.setForeground(Color.WHITE);
//        login.addActionListener(this);
//        add(login);
//
//        clear = new JButton("CLEAR");
//        clear.setBounds(430, 300, 100, 30);
//        clear.setBackground(Color.BLACK);
//        clear.setForeground(Color.WHITE);
//        clear.addActionListener(this);
//        add(clear);
//
//        signup = new JButton("SIGN UP");
//        signup.setBounds(300, 350, 230, 30);
//        signup.setBackground(Color.BLACK);
//        signup.setForeground(Color.WHITE);
//        signup.addActionListener(this);
//        add(signup);
//
//        getContentPane().setBackground(Color.WHITE);
//        setVisible(true); // Set visibility after adding all components
//    }
//
//    public void actionPerformed(ActionEvent ae) {
//        if (ae.getSource() == clear) {
//            cardTextField.setText("");
//            pinTextField.setText("");
//        } else if (ae.getSource() == login) {
//            String cardnumber = cardTextField.getText();
//            String pinnumber = new String(pinTextField.getPassword());
//            
//            if(cardnumber.isEmpty() || pinnumber.isEmpty()) {
//                JOptionPane.showMessageDialog(null, "Card number and PIN cannot be empty");
//                return;
//            }
//            
//            Conn conn = new Conn();
//            String query = "SELECT * FROM login WHERE cardnumber = '" + cardnumber + "' AND pinNumber = '" + pinnumber + "'";
//
//            
//            try  {
//                ResultSet rs=conn.s.executeQuery(query);
//                
//                
//                if (rs.next()) {
//                    setVisible(false);
//                    new Transactions().setVisible(true);
//                } else {
//                    JOptionPane.showMessageDialog(null, "Incorrect card number or pin");
//                }
//            } catch (SQLException e) {
//                JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
//            }
//        } else if (ae.getSource() == signup) {
//            setVisible(false);
//            new SignupOne().setVisible(true);
//        }
//    }
//
//    public static void main(String args[]) {
//        new Login();
//    }
//}

package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JButton login, signup, clear;
    JTextField cardTextField;
    JPasswordField pinTextField;

    Login() {
        setTitle("AUTOMATED TELLER MACHINE");
        setSize(800, 480);
        setLocation(350, 200);
        setLayout(null);

        JLabel text = new JLabel("ANY TIME MONEY!");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200, 40, 400, 40);
        add(text);

        JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Raleway", Font.BOLD, 20));
        cardno.setBounds(120, 150, 400, 40);
        add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 250, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(120, 220, 250, 30);
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 220, 250, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);

        login = new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(300, 350, 230, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == clear) {
            cardTextField.setText("");
            pinTextField.setText("");
        } else if (ae.getSource() == login) {
            String cardnumber = cardTextField.getText();
            String pinnumber = new String(pinTextField.getPassword());

            if (cardnumber.isEmpty() || pinnumber.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Card number and PIN cannot be empty");
                return;
            }

            Conn conn = new Conn();
            String query = "SELECT * FROM login WHERE cardnumber = '" + cardnumber + "' AND pinNumber = '" + pinnumber + "'";

            try {
                ResultSet rs = conn.s.executeQuery(query);

                if (rs.next()) {
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect card number or PIN");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
            }
        } else if (ae.getSource() == signup) {
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }

    public static void main(String args[]) {
        new Login();
    }
}


