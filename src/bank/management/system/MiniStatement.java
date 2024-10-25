/*
package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener{
 
    JButton b1, b2;
    JLabel text;
    MiniStatement(String pinnumber){
        super("Mini Statement");
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setSize(400,600);
        setLocation(20,20);
        
       JLabel mini = new JLabel();
        add(mini);
        
        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150, 20, 100, 20);
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);
        
        JLabel balance=new JLabel();
        balance.setBounds(20, 400, 300, 20);
        add(balance);
        
        
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number:    " + rs.getString("cardnumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
            }
        }catch(Exception e){}
        	 
        try{
            int bal = 0;
            Conn conn  = new Conn();
            ResultSet rs = conn.s.executeQuery("SELECT * FROM bank where pin = '"+pinnumber+"'");
            while(rs.next()){
                mini.setText(mini.getText() + "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("mode") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if(rs.getString("mode").equals("Deposit")){
                    bal += Integer.parseInt(rs.getString("amount"));
                }else{
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your total Balance is Rs "+bal);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        setLayout(null);
        b1 = new JButton("Exit");
        add(b1);
        
        b1.addActionListener(this);
        
        mini.setBounds(20, 140, 400, 200);
      
    }
    public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
    }
    
    public static void main(String[] args){
        new MiniStatement("").setVisible(true);
    }
    
}*/
package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener {

    JButton b1;
    JLabel mini, bank, card, balance;

    MiniStatement(String pinnumber) {
        super("Mini Statement");
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setSize(400, 600);
        setLocation(20, 20);

        // Labels for Mini Statement
        mini = new JLabel();
        mini.setBounds(20, 140, 400, 200);
        add(mini);

        bank = new JLabel("Indian Bank");
        bank.setBounds(150, 20, 100, 20);
        add(bank);

        card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);

        balance = new JLabel();
        balance.setBounds(20, 400, 300, 20);
        add(balance);

        // Retrieve Card Number
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pin = '" + pinnumber + "'");
            while (rs.next()) {
                card.setText("Card Number:    " + rs.getString("cardnumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Retrieve Mini Statement and Balance
        try {
            int bal = 0;
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("SELECT * FROM bank where pin = '" + pinnumber + "'");
            StringBuilder statement = new StringBuilder();
            while (rs.next()) {
                statement.append("<html>").append(rs.getString("date")).append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                         .append(rs.getString("mode")).append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                         .append(rs.getString("amount")).append("<br><br><html>");
                
                if (rs.getString("mode").equals("Deposit")) {
                    bal += Integer.parseInt(rs.getString("amount"));
                } else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            mini.setText(statement.toString());
            balance.setText("Your total Balance is Rs " + bal);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Exit button
        b1 = new JButton("Exit");
        b1.setBounds(150, 500, 100, 30);
        b1.addActionListener(this);
        add(b1);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }

    public static void main(String[] args) {
        new MiniStatement("").setVisible(true);
    }
}
