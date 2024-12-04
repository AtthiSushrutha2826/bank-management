package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton deposit, withdrawl, fastCash, miniStatement, pinChange, balanceEnquiry, exit;
    String pinnumber;

    FastCash(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        // Load the ATM background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bank/management/system/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(210, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        // Add buttons with new positions to fit the screen layout
        deposit = new JButton("RS 100");
        deposit.setBounds(170, 415, 150, 30);  // Adjusted position
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl = new JButton("RS 500 ");
        withdrawl.setBounds(355, 415, 150, 30);  // Adjusted position
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastCash = new JButton("RS 1,000");
        fastCash.setBounds(170, 450, 150, 30);  // Adjusted position
        fastCash.addActionListener(this);
        image.add(fastCash);

        miniStatement = new JButton("RS 2,000");
        miniStatement.setBounds(355, 450, 150, 30);  // Adjusted position
        miniStatement.addActionListener(this);
        image.add(miniStatement);

        pinChange = new JButton("RS 5,000");
        pinChange.setBounds(170, 485, 150, 30);  // Adjusted position
        pinChange.addActionListener(this);
        image.add(pinChange);

        balanceEnquiry = new JButton("RS 10,000");
        balanceEnquiry.setBounds(355, 485, 150, 30);  // Adjusted position
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);

        exit = new JButton("BACK");
        exit.setBounds(355, 520, 150, 30);  // Adjusted position
        exit.addActionListener(this);
        image.add(exit);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == exit) {
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    } else {
        // Extract amount from button text
        String amountText = ((JButton) ae.getSource()).getText().substring(3).replace(",", "").trim();

        // Convert the extracted amount string to a double and then cast to integer
        double amountDouble = 0;
        try {
            amountDouble = Double.parseDouble(amountText); // Handle floating-point values
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid amount format.");
            return;
        }

        // Convert to integer if the amount is whole (no decimal part)
        int amount = (amountDouble == (int) amountDouble) ? (int) amountDouble : (int) (amountDouble + 0.5);  // Round if necessary

        Conn c = new Conn();
        try {
            // Retrieve the balance
            ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE pinnumber = '" + pinnumber + "'");
            int balance = 0;
            while (rs.next()) {
                if (rs.getString("transaction_type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }

            // Check if balance is sufficient
            if (balance < amount) {
                JOptionPane.showMessageDialog(null, "Insufficient balance.");
                return;
            }

            // Format the date to match MySQL DATETIME format
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String formattedDate = sdf.format(date);

            // Insert withdrawal record into the database
            String query = "INSERT INTO bank (pinnumber, transaction_date, transaction_type, amount) VALUES ('" + pinnumber + "', '" + formattedDate + "', 'Withdrawal', '" + amount + "')";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Rs " + amount + " debited successfully.");
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "An error occurred.");
        }
    }
}



    public static void main(String[] args) {
        new FastCash("");
    }
}


