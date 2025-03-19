package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

class BalanceEnquiry extends JFrame implements ActionListener {

    JButton back;
    JLabel text;
    String pinnumber;

    BalanceEnquiry(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        // Setting up the background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bank/management/system/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        // Label to display the balance
        text = new JLabel();
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(170, 300, 400, 30);
        image.add(text);

        // Back button
        back = new JButton("BACK");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        // Calculating balance
        int balance = 0;
        try {
            Conn c = new Conn();
            PreparedStatement stmt = c.c.prepareStatement("SELECT transaction_type, amount FROM bank WHERE pinnumber = ?");
            stmt.setString(1, pinnumber);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String type = rs.getString("transaction_type");
                int amount = rs.getInt("amount");
                if ("Deposit".equalsIgnoreCase(type)) {
                    balance += amount;
                } else {
                    balance -= amount;
                }
            }

            rs.close();
            stmt.close();
            c.c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        text.setText("Your Current Account Balance is Rs " + balance);

        // JFrame settings
        setSize(900, 900);
        setUndecorated(true);
        setLocation(300, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("1234").setVisible(true);
    }
}
