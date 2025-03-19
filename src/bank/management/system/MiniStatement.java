package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener {
    JButton exit;
    JLabel card, balance, image;
    String pinnumber;

    MiniStatement(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        // Background Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bank/management/system/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        // Card Number Label
        card = new JLabel();
        card.setForeground(Color.WHITE);
        card.setFont(new Font("System", Font.BOLD, 16));
        card.setBounds(170, 250, 400, 20);
        image.add(card);

        // Fetch and Display Card Number
        try {
            Conn conn = new Conn();
            PreparedStatement stmt = conn.c.prepareStatement("SELECT cardNumber FROM login WHERE pinNumber = ?");
            stmt.setString(1, pinnumber);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                String cardNumber = rs.getString("cardNumber");
                card.setText("Card Number: " + cardNumber.substring(0, 4) + "XXXXXXXX" + cardNumber.substring(12));
            }
            rs.close();
            stmt.close();
            conn.c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Transactions Label
        JLabel text = new JLabel("Your Mini Statement");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(170, 300, 400, 20);
        image.add(text);

        JTextArea statementArea = new JTextArea();
        statementArea.setFont(new Font("Raleway", Font.BOLD, 14));
        statementArea.setBounds(170, 330, 320, 150);
        statementArea.setBackground(Color.WHITE);
        statementArea.setEditable(false);
        image.add(statementArea);

        // Fetch and Display Transactions
        try {
            Conn conn = new Conn();
            int bal = 0;
            PreparedStatement stmt = conn.c.prepareStatement("SELECT transaction_date, transaction_type, amount FROM bank WHERE pinnumber = ? ORDER BY transaction_date DESC LIMIT 10");
            stmt.setString(1, pinnumber);
            ResultSet rs = stmt.executeQuery();
            
            StringBuilder statement = new StringBuilder();
            while (rs.next()) {
                statement.append(rs.getString("transaction_date")).append("  ")
                         .append(rs.getString("transaction_type")).append("  Rs.")
                         .append(rs.getInt("amount")).append("\n");
                
                if (rs.getString("transaction_type").equalsIgnoreCase("Withdraw")) {
                    bal -= rs.getInt("amount");
                } else {
                    bal += rs.getInt("amount");
                }
            }
            
            statementArea.setText(statement.toString());
            rs.close();
            stmt.close();
            conn.c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Balance Label
        balance = new JLabel();
        balance.setForeground(Color.WHITE);
        balance.setFont(new Font("System", Font.BOLD, 16));
        balance.setBounds(170, 500, 400, 20);
        image.add(balance);
        balance.setText("Your Balance: Updating...");
        
        // Exit Button
        exit = new JButton("EXIT");
        exit.setBounds(355, 550, 150, 30);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900, 900);
        setUndecorated(true);
        setLocation(500, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }

    public static void main(String[] args) {
        new MiniStatement("1234").setVisible(true);
    }
}
