package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.sql.*;

public class Withdrawl extends JFrame implements ActionListener {

    JTextField amount;
    JButton withdrawl, back;
    String pinnumber;

    Withdrawl(String cardnumber) {
        this.pinnumber = fetchPin(cardnumber);
        setLayout(null);

        // Background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bank/management/system/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        // Label text
        JLabel text = new JLabel("ENTER AMOUNT YOU WANT TO WITHDRAW");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(170, 300, 400, 20);
        image.add(text);

        // Text field for entering amount
        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(170, 350, 320, 25);
        image.add(amount);

        // Withdrawal button
        withdrawl = new JButton("WITHDRAWAL");
        withdrawl.setBounds(355, 485, 150, 30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        // Back button
        back = new JButton("BACK");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        // Frame settings
        setSize(900, 900);
        setUndecorated(true);
        setLocation(500, 0);
        setVisible(true);
    }

    // Method to fetch PIN from the database using cardnumber
    private String fetchPin(String cardnumber) {
        String pin = "";
        try {
            Conn conn = new Conn();
            String query = "SELECT pinNumber FROM login WHERE cardNumber = ?";
            PreparedStatement pstmt = conn.c.prepareStatement(query);
            pstmt.setString(1, cardnumber);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                pin = rs.getString("pinNumber");
            }
            rs.close();
            pstmt.close();
            conn.c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pin;
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == withdrawl) {
            String number = amount.getText();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String formattedDate = sdf.format(new java.util.Date());

            if (number.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
                return;
            }

            try {
                double withdrawAmount = Double.parseDouble(number);
                if (withdrawAmount <= 0) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid amount.");
                    return;
                }

                Conn conn = new Conn();

                // Check available balance
                String balanceQuery = "SELECT COALESCE(SUM(amount), 0) FROM bank WHERE pinnumber = ?";
                PreparedStatement balanceStmt = conn.c.prepareStatement(balanceQuery);
                balanceStmt.setString(1, pinnumber);
                ResultSet rs = balanceStmt.executeQuery();
                double balance = 0;
                if (rs.next()) {
                    balance = rs.getDouble(1);
                }

                if (balance < withdrawAmount) {
                    JOptionPane.showMessageDialog(null, "Insufficient balance!");
                    rs.close();
                    balanceStmt.close();
                    conn.c.close();
                    return;
                }

                // Insert withdrawal transaction
                String query = "INSERT INTO bank (pinnumber, transaction_date, transaction_type, amount) VALUES (?, ?, ?, ?)";
                PreparedStatement pstmt = conn.c.prepareStatement(query);
                pstmt.setString(1, pinnumber);
                pstmt.setString(2, formattedDate);
                pstmt.setString(3, "Withdrawal");
                pstmt.setDouble(4, -withdrawAmount);
                pstmt.executeUpdate();

                JOptionPane.showMessageDialog(null, "Rs " + number + " withdrawn successfully");

                // Close resources
                rs.close();
                pstmt.close();
                balanceStmt.close();
                conn.c.close();

                setVisible(false);
                new Transactions(pinnumber).setVisible(true);

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a numeric value.");
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "An error occurred while processing your request.");
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Withdrawl("7747218089672079").setVisible(true);
    }
}
