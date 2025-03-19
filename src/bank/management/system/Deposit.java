package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;

public class Deposit extends JFrame implements ActionListener {
    JTextField amountField;
    JButton depositButton, backButton;
    String pinNumber;

    Deposit(String pinNumber) {
        this.pinNumber = pinNumber;
        setLayout(null);

        // Background Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bank/management/system/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        // Label Text
        JLabel text = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(170, 300, 400, 20);
        image.add(text);

        // Amount TextField
        amountField = new JTextField();
        amountField.setFont(new Font("Raleway", Font.BOLD, 22));
        amountField.setBounds(170, 350, 320, 25);
        image.add(amountField);

        // Deposit Button
        depositButton = new JButton("DEPOSIT");
        depositButton.setBounds(355, 485, 150, 30);
        depositButton.addActionListener(this);
        image.add(depositButton);

        // Back Button
        backButton = new JButton("BACK");
        backButton.setBounds(355, 520, 150, 30);
        backButton.addActionListener(this);
        image.add(backButton);

        // Frame settings
        setSize(900, 900);
        setUndecorated(true);
        setLocation(500, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == depositButton) {
            String amount = amountField.getText();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String formattedDate = sdf.format(new java.util.Date());

            if (amount.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter an amount");
                return;
            }

            try {
                Conn conn = new Conn();
                String query = "INSERT INTO bank (pinnumber, transaction_date, transaction_type, amount) VALUES (?, ?, ?, ?)";
                PreparedStatement pstmt = conn.c.prepareStatement(query);
                pstmt.setString(1, pinNumber);
                pstmt.setString(2, formattedDate);
                pstmt.setString(3, "Deposit");
                pstmt.setDouble(4, Double.parseDouble(amount));
                
                int result = pstmt.executeUpdate();
                if (result > 0) {
                    JOptionPane.showMessageDialog(null, "₹" + amount + " Deposited Successfully");
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Deposit Failed");
                }
                pstmt.close();
                conn.c.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "An error occurred while processing your request.");
                e.printStackTrace();
            }
        } else if (ae.getSource() == backButton) {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Deposit("7554").setVisible(true);
    }
}
