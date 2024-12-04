//
//package bank.management.system;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.Random;
//
//public class SignupOne extends JFrame implements ActionListener {
//
//    long random;
//    JTextField nameTextField, ageTextField, dobTextField, emailTextField, aadharTextField, pincodeTextField, mobileTextField, accounttypeTextField;
//    JRadioButton male, female;
//    JButton next;
//
//    SignupOne() {
//        setLayout(null);
//        getContentPane().setBackground(Color.white);
//        Random ran = new Random();
//        random = Math.abs((ran.nextLong() % 9000L) + 1000L);
//        
//        JLabel formno = new JLabel("APPLICATION FORM NUMBER: " + random);
//        formno.setFont(new Font("Raleway", Font.BOLD, 38));
//        formno.setBounds(140, 20, 800, 40);
//        add(formno);
//        
//        JLabel personDetails = new JLabel("PAGE 1: PERSONAL DETAILS");
//        personDetails.setFont(new Font("Raleway", Font.BOLD, 29));
//        personDetails.setBounds(250, 80, 500, 30);
//        add(personDetails);
//        
//        JLabel name = new JLabel("NAME:");
//        name.setFont(new Font("Raleway", Font.BOLD, 22));
//        name.setBounds(100, 140, 200, 30);
//        add(name);
//        
//        nameTextField = new JTextField();
//        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
//        nameTextField.setBounds(300, 140, 400, 30);
//        add(nameTextField);
//        
//        JLabel age = new JLabel("AGE:");
//        age.setFont(new Font("Raleway", Font.BOLD, 22));
//        age.setBounds(100, 190, 200, 30);
//        add(age);
//        
//        ageTextField = new JTextField();
//        ageTextField.setFont(new Font("Raleway", Font.BOLD, 14));
//        ageTextField.setBounds(300, 190, 400, 30);
//        add(ageTextField);
//        
//        JLabel dob = new JLabel("DOB:");
//        dob.setFont(new Font("Raleway", Font.BOLD, 22));
//        dob.setBounds(100, 240, 200, 30);
//        add(dob);
//        
//        dobTextField = new JTextField();
//        dobTextField.setFont(new Font("Raleway", Font.BOLD, 14));
//        dobTextField.setBounds(300, 240, 400, 30);
//        add(dobTextField);
//        
//        JLabel gender = new JLabel("GENDER:");
//        gender.setFont(new Font("Raleway", Font.BOLD, 22));
//        gender.setBounds(100, 290, 200, 30);
//        add(gender);
//        
//        male = new JRadioButton("Male");
//        male.setFont(new Font("Raleway", Font.BOLD, 14));
//        male.setBounds(300, 290, 100, 30);
//        male.setBackground(Color.WHITE);
//        add(male);
//        
//        female = new JRadioButton("Female");
//        female.setFont(new Font("Raleway", Font.BOLD, 14));
//        female.setBounds(450, 290, 100, 30);
//        female.setBackground(Color.WHITE);
//        add(female);
//        
//        ButtonGroup genderGroup = new ButtonGroup();
//        genderGroup.add(male);
//        genderGroup.add(female);
//
//        JLabel email = new JLabel("E-MAIL:");
//        email.setFont(new Font("Raleway", Font.BOLD, 22));
//        email.setBounds(100, 340, 200, 30);
//        add(email);
//        
//        emailTextField = new JTextField();
//        emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
//        emailTextField.setBounds(300, 340, 400, 30);
//        add(emailTextField);
//        
//        JLabel aadhar = new JLabel("AADHAR NUMBER:");
//        aadhar.setFont(new Font("Raleway", Font.BOLD, 22));
//        aadhar.setBounds(100, 390, 200, 30);
//        add(aadhar);
//        
//        aadharTextField = new JTextField();
//        aadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
//        aadharTextField.setBounds(300, 390, 400, 30);
//        add(aadharTextField);
//        
//        JLabel pincode = new JLabel("PINCODE:");
//        pincode.setFont(new Font("Raleway", Font.BOLD, 22));
//        pincode.setBounds(100, 440, 200, 30);
//        add(pincode);
//        
//        pincodeTextField = new JTextField();
//        pincodeTextField.setFont(new Font("Raleway", Font.BOLD, 14));
//        pincodeTextField.setBounds(300, 440, 400, 30);
//        add(pincodeTextField);
//        
//        JLabel mobile = new JLabel("MOBILE:");
//        mobile.setFont(new Font("Raleway", Font.BOLD, 22));
//        mobile.setBounds(100, 490, 200, 30);
//        add(mobile);
//        
//        mobileTextField = new JTextField();
//        mobileTextField.setFont(new Font("Raleway", Font.BOLD, 14));
//        mobileTextField.setBounds(300, 490, 400, 30);
//        add(mobileTextField);
//        
//        JLabel accounttype = new JLabel("ACCOUNT TYPE:");
//        accounttype.setFont(new Font("Raleway", Font.BOLD, 22));
//        accounttype.setBounds(100, 540, 200, 30);
//        add(accounttype);
//        
//        accounttypeTextField = new JTextField();
//        accounttypeTextField.setFont(new Font("Raleway", Font.BOLD, 14));
//        accounttypeTextField.setBounds(300, 540, 400, 30);
//        add(accounttypeTextField);
//        
//        next = new JButton("NEXT");
//        next.setBackground(Color.BLACK);
//        next.setForeground(Color.WHITE);
//        next.setFont(new Font("Raleway", Font.BOLD, 14));
//        next.setBounds(620, 610, 80, 30);
//        add(next);
//        
//        next.addActionListener(this);
//        
//        setSize(850, 800);
//        setLocation(350, 10);
//        setVisible(true);
//    }
//    
//    @Override
//    public void actionPerformed(ActionEvent ae) {
//        String formno = "" + random;
//        String name = nameTextField.getText();
//        String age = ageTextField.getText();
//        String dob = dobTextField.getText();
//        String gender = null;
//        if (male.isSelected()) {
//            gender = "Male";
//        } else if (female.isSelected()) {
//            gender = "Female";
//        }
//        String email = emailTextField.getText();
//        String aadhar = aadharTextField.getText();
//        String pincode = pincodeTextField.getText();
//        String mobile = mobileTextField.getText();
//        String accounttype = accounttypeTextField.getText();
//        
//        try {
//            if (name.equals("") || age.equals("") || dob.equals("") || email.equals("") || aadhar.equals("") || pincode.equals("") || mobile.equals("") || accounttype.equals("") || gender == null) {
//                JOptionPane.showMessageDialog(null, "All details are required");
//            } else {
//                Conn c = new Conn();
//                String query = "INSERT INTO signup  VALUES('" + formno + "', '" + name + "', '" + age + "', '" + dob + "', '" + gender + "', '" + email + "', '" + aadhar + "', '" + pincode + "', '" + mobile + "', '" + accounttype + "')";
//                c.s.executeUpdate(query);
//                JOptionPane.showMessageDialog(null, "Details Submitted Successfully");
//                setVisible(false);
//                new SignupTwo(formno).setVisible(true);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    
//    public static void main(String[] args) {
//        new SignupOne();
//    }
//}

package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupOne extends JFrame implements ActionListener {

    long random;
    JTextField nameTextField, ageTextField, dobTextField, emailTextField, aadharTextField, pincodeTextField, mobileTextField, accounttypeTextField;
    JRadioButton male, female;
    JButton next;

    SignupOne() {
        setLayout(null);
        getContentPane().setBackground(Color.white);

        // Generate random application form number
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);

        JLabel formno = new JLabel("APPLICATION FORM NUMBER: " + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140, 20, 800, 40);
        add(formno);

        JLabel personDetails = new JLabel("PAGE 1: PERSONAL DETAILS");
        personDetails.setFont(new Font("Raleway", Font.BOLD, 29));
        personDetails.setBounds(250, 80, 500, 30);
        add(personDetails);

        JLabel name = new JLabel("NAME:");
        name.setFont(new Font("Raleway", Font.BOLD, 22));
        name.setBounds(100, 140, 200, 30);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);

        JLabel age = new JLabel("AGE:");
        age.setFont(new Font("Raleway", Font.BOLD, 22));
        age.setBounds(100, 190, 200, 30);
        add(age);

        ageTextField = new JTextField();
        ageTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        ageTextField.setBounds(300, 190, 400, 30);
        add(ageTextField);

        JLabel dob = new JLabel("DOB:");
        dob.setFont(new Font("Raleway", Font.BOLD, 22));
        dob.setBounds(100, 240, 200, 30);
        add(dob);

        dobTextField = new JTextField();
        dobTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        dobTextField.setBounds(300, 240, 400, 30);
        add(dobTextField);

        JLabel gender = new JLabel("GENDER:");
        gender.setFont(new Font("Raleway", Font.BOLD, 22));
        gender.setBounds(100, 290, 200, 30);
        add(gender);

        male = new JRadioButton("Male");
        male.setFont(new Font("Raleway", Font.BOLD, 14));
        male.setBounds(300, 290, 100, 30);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setFont(new Font("Raleway", Font.BOLD, 14));
        female.setBounds(450, 290, 100, 30);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JLabel email = new JLabel("E-MAIL:");
        email.setFont(new Font("Raleway", Font.BOLD, 22));
        email.setBounds(100, 340, 200, 30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        emailTextField.setBounds(300, 340, 400, 30);
        add(emailTextField);

        JLabel aadhar = new JLabel("AADHAR NUMBER:");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 22));
        aadhar.setBounds(100, 390, 200, 30);
        add(aadhar);

        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharTextField.setBounds(300, 390, 400, 30);
        add(aadharTextField);

        JLabel pincode = new JLabel("PINCODE:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 22));
        pincode.setBounds(100, 440, 200, 30);
        add(pincode);

        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        pincodeTextField.setBounds(300, 440, 400, 30);
        add(pincodeTextField);

        JLabel mobile = new JLabel("MOBILE:");
        mobile.setFont(new Font("Raleway", Font.BOLD, 22));
        mobile.setBounds(100, 490, 200, 30);
        add(mobile);

        mobileTextField = new JTextField();
        mobileTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        mobileTextField.setBounds(300, 490, 400, 30);
        add(mobileTextField);

        JLabel accounttype = new JLabel("ACCOUNT TYPE:");
        accounttype.setFont(new Font("Raleway", Font.BOLD, 22));
        accounttype.setBounds(100, 540, 200, 30);
        add(accounttype);

        accounttypeTextField = new JTextField();
        accounttypeTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        accounttypeTextField.setBounds(300, 540, 400, 30);
        add(accounttypeTextField);

        next = new JButton("NEXT");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 610, 80, 30);
        add(next);

        next.addActionListener(this);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String formno = "" + random;
        String name = nameTextField.getText();
        String age = ageTextField.getText();
        String dob = dobTextField.getText();
        String gender = null;
        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }
        String email = emailTextField.getText();
        String aadhar = aadharTextField.getText();
        String pincode = pincodeTextField.getText();
        String mobile = mobileTextField.getText();
        String accounttype = accounttypeTextField.getText();

        try {
            if (name.isEmpty() || age.isEmpty() || dob.isEmpty() || email.isEmpty() || aadhar.isEmpty() || pincode.isEmpty() || mobile.isEmpty() || accounttype.isEmpty() || gender == null) {
                JOptionPane.showMessageDialog(null, "All details are required");
            } else {
                Conn c = new Conn();
                String query = "INSERT INTO signup VALUES('" + formno + "', '" + name + "', '" + age + "', '" + dob + "', '" + gender + "', '" + email + "', '" + aadhar + "', '" + pincode + "', '" + mobile + "', '" + accounttype + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Submitted Successfully");
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SignupOne();
    }
}

