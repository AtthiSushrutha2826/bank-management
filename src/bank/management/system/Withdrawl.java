//package bank.management.system;
//
//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
//import java.util.*;
//import java.text.SimpleDateFormat;  // Import SimpleDateFormat
//import java.sql.*;
//
//public class Withdrawl extends JFrame implements ActionListener {
//
//    JTextField amount;
//    JButton withdrawl, back;
//    String pinnumber;
//
//    Withdrawl(String pinnumber) {
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
//        JLabel text = new JLabel("ENTER AMOUNT YOU WANT TO WITHDRAW");
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
//        // Withdrawal button
//        withdrawl = new JButton("WITHDRAWAL");
//        withdrawl.setBounds(355, 485, 150, 30);
//        withdrawl.addActionListener(this);
//        image.add(withdrawl);
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
//        if (ae.getSource() == withdrawl) {
//            String number = amount.getText();
//            java.util.Date date = new java.util.Date();  // Use java.util.Date for current date and time
//
//            // Format the date to MySQL-compatible format
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            String formattedDate = sdf.format(date);
//
//            if (number.equals("")) {
//                JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
//            } else {
//                try {
//                    Conn conn = new Conn();
//                    // SQL query with formatted date
//                    String query = "INSERT INTO bank (pinnumber, transaction_date, transaction_type, amount) "
//                            + "VALUES ('" + pinnumber + "', '" + formattedDate + "', 'Withdrawal', '" + Double.parseDouble(number) + "')";
//                    
//                    conn.s.executeUpdate(query);  // Execute the query
//                    JOptionPane.showMessageDialog(null, "Rs " + number + " withdrawn successfully");
//                    setVisible(false);
//                    new Transactions(pinnumber).setVisible(true);
//                } catch (Exception e) {
//                    System.out.println(e);
//                    JOptionPane.showMessageDialog(null, "An error occurred while processing your request.");
//                }
//            }
//        } else if (ae.getSource() == back) {
//            setVisible(false);
//            new Transactions(pinnumber).setVisible(true);
//        }
//    }
//
//    public static void main(String[] args) {
//        new Withdrawl("").setVisible(true);
//    }
//}
package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.text.SimpleDateFormat;  // Import SimpleDateFormat
import java.sql.*;
public class Withdrawl extends JFrame implements ActionListener {

    JTextField amount;
    JButton withdrawl, back;
    String pinnumber;

    Withdrawl(String cardnumber) {
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
        if (ae.getSource() == withdrawl) {
            String number = amount.getText();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String formattedDate = sdf.format(new java.util.Date());

            if (number.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
            } else {
                try {
                    Conn conn = new Conn();
                    String query = "INSERT INTO bank (pinnumber, transaction_date, transaction_type, amount) "
                            + "VALUES ('" + pinnumber + "', '" + formattedDate + "', 'Withdrawal', '" + Double.parseDouble(number) + "')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " + number + " withdrawn successfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                } catch (Exception e) {
                    System.out.println(e);
                    JOptionPane.showMessageDialog(null, "An error occurred while processing your request.");
                }
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Withdrawl("7747218089672079").setVisible(true);  // Pass cardnumber here
    }
}

