/*
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.util.*;
public class PinChange extends JFrame implements ActionListener{
    
    JTextField pin,repin;
    JButton change,back;
  PinChange(String pinchange){
      setLayout(null);
      
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bank/management/system/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
     
JLabel text= new JLabel ("CHANGE YOUR PIN");
text.setForeground (Color.WHITE);
text.setFont(new Font("System", Font. BOLD, 16));
text.setBounds (250, 280, 500, 35);
image.add(text);

JLabel pintext= new JLabel ("NEW PIN");
pintext.setForeground (Color.WHITE);
pintext.setFont(new Font("System", Font. BOLD, 16));
pintext.setBounds (165, 320, 180, 25);
image.add(pintext);


pin = new JTextField();
 pin.setBounds(330, 320, 180, 25);
 pin.setFont(new Font("Raleway", Font.BOLD, 25));
 add(pin);

 repintext= new JTextField ("RE-ENTER PIN");
repintext.setForeground (Color.WHITE);
repintext.setFont(new Font("System", Font. BOLD, 16));
repintext.setBounds (165, 320, 180, 25);
image.add(repintext);

 repin = new JTextField();
 repin.setBounds(330, 360, 180, 25);
 repin.setFont(new Font("Raleway", Font.BOLD, 25));
 add(repin);

change= new JButton ("CHANGE");
change.setForeground (Color.WHITE);
change.setBounds (355, 485, 150, 30);
change.addActionListener(this);
image.add(change);

back= new JButton ("BACK");
back.setForeground (Color.WHITE);
back.setBounds (355, 520, 150, 30);
back.addActionListener(this);
image.add(back);
        
        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
  }
        public void actionPerformed(ActionEvent ae) {
}
  
    
    public static void main(String args[]) {
       new PinChange("").setVisible(true);
    }
}
*/
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class PinChange extends JFrame implements ActionListener {
    
    private JPasswordField pin, repin;
    private JButton change, back;
    private String pinchange;

    public PinChange(String pinchange) {
        this.pinchange = pinchange;
        setLayout(null);

        // Set up the background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bank/management/system/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        // Change PIN text
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(250, 280, 500, 35);
        image.add(text);

        // New PIN label
        JLabel pintext = new JLabel("NEW PIN");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System", Font.BOLD, 16));
        pintext.setBounds(165, 320, 180, 25);
        image.add(pintext);

        // New PIN input field
        pin = new JPasswordField();
        pin.setBounds(330, 320, 180, 25);
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        image.add(pin);

        // Re-enter PIN label
        JLabel repintext = new JLabel("RE-ENTER PIN");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System", Font.BOLD, 16));
        repintext.setBounds(165, 360, 180, 25);
        image.add(repintext);

        // Re-enter PIN input field
        repin = new JPasswordField();
        repin.setBounds(330, 360, 180, 25);
        repin.setFont(new Font("Raleway", Font.BOLD, 25));
        image.add(repin);

        // Change button
        change = new JButton("CHANGE");
        
        change.setBounds(355, 485, 150, 30);
        change.addActionListener(this);
        image.add(change);

        // Back button
        back = new JButton("BACK");
       
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        // JFrame settings
        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String npin = new String(pin.getText());
            String rpin = new String(repin.getText());

            if (!npin.equals(rpin)) {
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }

            if (ae.getSource() == change) {
                if (npin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter New PIN");
                    return;
                }
                if (rpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Re-Enter new PIN");
                    return;
                }

                Conn conn = new Conn();
                String query1 = "update bank set pin = '" + rpin + "' where pin = '" + pinchange + "'";
                String query2 = "update login set pin = '" + rpin + "' where pin = '" + pinchange + "'";
                String query3 = "update signupThree set pin = '" + rpin + "' where pin = '" + pinchange + "'";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transactions(rpin).setVisible(true);

            } else if (ae.getSource() == back) {
                new Transactions(pinchange).setVisible(true);
                setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
}
