//package bank.management.system;
//
//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
//import java.sql.*;
//import java.util.*;
//
//public class Deposit extends JFrame implements ActionListener {
//
//    JTextField amount;
//    JButton deposit, back;
//    String pinnumber;
//
//    Deposit(String pinnumber) {
//        this.pinnumber = pinnumber;
//        setLayout(null);
//
//        // Background image
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bank/management/system/atm.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel image = new JLabel(i3);
//        image.setBounds(0, 0, 900, 900);
//        add(image);
//
//        // Label text
//        JLabel text = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
//        text.setForeground(Color.WHITE);
//        text.setFont(new Font("System", Font.BOLD, 16));
//        text.setBounds(170, 300, 400, 20);
//        image.add(text);
//
//        // Text field for entering amount
//        amount = new JTextField();
//        amount.setFont(new Font("Raleway", Font.BOLD, 22));
//        amount.setBounds(170, 350, 320, 25);
//        image.add(amount);
//
//        // Deposit button
//        deposit = new JButton("DEPOSIT");
//        deposit.setBounds(355, 485, 150, 30);
//        deposit.addActionListener(this);
//        image.add(deposit);
//
//        // Back button
//        back = new JButton("BACK");
//        back.setBounds(355, 520, 150, 30);
//        back.addActionListener(this);
//        image.add(back);
//
//        // Frame settings
//        setSize(900, 900);
//        setUndecorated(true);
//        setLocation(500, 0);
//        setVisible(true);
//    }
//
//    public void actionPerformed(ActionEvent ae) {
//        if (ae.getSource() == deposit) {
//            String number = amount.getText();
//
//            if (number.equals("")) {
//                JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
//            } else {
//                try {
//                    Conn conn = new Conn();
//                    
//                    // Use java.sql.Timestamp for the current date and time
//                    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//
//                    // Prepare the SQL query
//                    String query = "INSERT INTO bank (pinnumber, transaction_date, transaction_type, amount) VALUES (?, ?, ?, ?)";
//                    PreparedStatement pst = conn.c.prepareStatement(query);  // Use conn.c for connection
//                    pst.setString(1, pinnumber);
//                    pst.setTimestamp(2, timestamp);  // Use setTimestamp to store current date and time
//                    pst.setString(3, "Deposit");
//                    pst.setDouble(4, Double.parseDouble(number)); // Convert amount to Double for correct database insertion
//
//                    pst.executeUpdate();
//                    JOptionPane.showMessageDialog(null, "Rs " + number + " Deposited Successfully");
//                    setVisible(false);
//                    new Transactions(pinnumber).setVisible(true);
//                } catch (Exception e) {
//                    System.out.println(e);
//                    JOptionPane.showMessageDialog(null, "An error occurred while processing your deposit.");
//                }
//            }
//        } else if (ae.getSource() == back) {
//            setVisible(false);
//            new Transactions(pinnumber).setVisible(true);
//        }
//    }
//
//    public static void main(String[] args) {
//        new Deposit("").setVisible(true);
//    }
//}
package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
public class Deposit extends JFrame implements ActionListener {

    JTextField amount;
    JButton deposit, back;
    String pinnumber;

    Deposit(String cardnumber) {
        this.pinnumber = fetchPin(cardnumber);  // Fetch the PIN based on cardnumber
        setLayout(null);

        // Background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bank/management/system/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        // Label text
        JLabel text = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(170, 300, 400, 20);
        image.add(text);

        // Text field for entering amount
        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(170, 350, 320, 25);
        image.add(amount);

        // Deposit button
        deposit = new JButton("DEPOSIT");
        deposit.setBounds(355, 485, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);

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
            ResultSet rs = conn.s.executeQuery("SELECT pin FROM login WHERE cardnumber = '" + cardnumber + "'");
            if (rs.next()) {
                pin = rs.getString("pin");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return pin;
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == deposit) {
            String number = amount.getText();

            if (number.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
            } else {
                try {
                    Conn conn = new Conn();
                    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                    
                    // Constructing the query for the deposit transaction
                    String query = "INSERT INTO bank (pinnumber, transaction_date, transaction_type, amount) VALUES (?, ?, ?, ?)";
                    PreparedStatement pst = conn.c.prepareStatement(query);
                    
                    // Set the parameters for the PreparedStatement
                    pst.setString(1, pinnumber);  // Use the fetched PIN
                    pst.setTimestamp(2, timestamp);  // Current timestamp
                    pst.setString(3, "Deposit");  // Transaction type
                    pst.setDouble(4, Double.parseDouble(number));  // Amount to deposit
                    
                    // Print query for debugging
                    System.out.println("Executing query: " + pst.toString());
                    
                    // Execute the update and commit the transaction
                    int rowsAffected = pst.executeUpdate();
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Rs " + number + " Deposited Successfully");
                    } else {
                        JOptionPane.showMessageDialog(null, "Deposit failed. Please try again.");
                    }

                    // Close the frame and open the Transactions screen
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();  // Print detailed exception for debugging
                    JOptionPane.showMessageDialog(null, "An error occurred while processing your deposit.");
                }
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Deposit("7747218089672079").setVisible(true);  // Pass cardnumber here
    }
}
