/*
package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener {

    JButton deposit, withdraw, fastCash, miniStatement, pinChange, balanceEnquiry, exit;
    String pinnumber;

    Transactions(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

       
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bank/management/system/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("SELECT YOUR TRANSACTION");
        text.setBounds(210, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(170, 415, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(355, 415, 150, 30);
        withdraw.addActionListener(this);
        image.add(withdraw);

        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(170, 450, 150, 30);
        fastCash.addActionListener(this);
        image.add(fastCash);

        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(355, 450, 150, 30);
        miniStatement.addActionListener(this);
        image.add(miniStatement);

        pinChange = new JButton("Pin Change");
        pinChange.setBounds(170, 485, 150, 30);
        pinChange.addActionListener(this);
        image.add(pinChange);

        balanceEnquiry = new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(355, 485, 150, 30);
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);

        exit = new JButton("Exit");
        exit.setBounds(355, 520, 150, 30);
        exit.addActionListener(this);
        image.add(exit);

        setSize(800, 800);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            System.exit(0);
        } else if (ae.getSource() == deposit) {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        } 
        /*else if (ae.getSource() == withdraw) {
            setVisible(false);
            new Withdraw(pinnumber).setVisible(true);
        } else if (ae.getSource() == fastCash) {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        } else if (ae.getSource() == miniStatement) {
            new MiniStatement(pinnumber).setVisible(true);
        } else if (ae.getSource() == pinChange) {
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        } else if (ae.getSource() == balanceEnquiry) {
            new BalanceEnquiry(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Transactions("");
    }
}

*/
package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Transactions extends JFrame implements ActionListener {

    JButton deposit, withdrawl, fastCash, miniStatement, pinChange, balanceEnquiry, exit;
    String pinnumber;

    Transactions(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        // Load the ATM background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bank/management/system/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("SELECT YOUR TRANSACTION");
        text.setBounds(210, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);


        // Add buttons with new positions to fit the screen layout
        deposit = new JButton("Deposit");
        deposit.setBounds(170, 415, 150, 30);  // Adjusted position
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl = new JButton("Withdraw");
        withdrawl.setBounds(355, 415, 150, 30);  // Adjusted position
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(170, 450, 150, 30);  // Adjusted position
        fastCash.addActionListener(this);
        image.add(fastCash);

        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(355, 450, 150, 30);  // Adjusted position
        miniStatement.addActionListener(this);
        image.add(miniStatement);

        pinChange = new JButton("Pin Change");
        pinChange.setBounds(170, 485, 150, 30);  // Adjusted position
        pinChange.addActionListener(this);
        image.add(pinChange);

        balanceEnquiry = new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(355, 485, 150, 30);  // Adjusted position
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);

        exit = new JButton("Exit");
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
            System.exit(0);
        } else if (ae.getSource() == deposit) {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }
        else if (ae.getSource() == withdrawl) {
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        // Add other actions here...
    }
        else if(ae.getSource()==fastCash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
      }
         else if(ae.getSource()==pinChange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
      }
        
        else if(ae.getSource()==balanceEnquiry){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
      }
        
        else if(ae.getSource()==miniStatement){
           
            new MiniStatement(pinnumber).setVisible(true);
      }
        
        
    }
    public static void main(String[] args) {
        new Transactions("");
    }
}
