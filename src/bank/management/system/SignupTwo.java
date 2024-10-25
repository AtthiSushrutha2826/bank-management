/*
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupTwo extends JFrame implements ActionListener {

    JTextField aadharTextField, pincodeTextField, mobileTextField, accounttypeTextField;
    JRadioButton male, female;
    JButton next;
    JComboBox<String> religion, category, income, education;
    String formno;

    SignupTwo(String formno) {
        this.formno = formno;
        setLayout(null); // This sets the layout manager to null, using absolute positioning.
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel additionalDetails = new JLabel("PAGE 2: ADDITIONAL DETAILS"); // Fixed typo here
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 29));
        additionalDetails.setBounds(200, 80, 500, 30);
        add(additionalDetails);

        JLabel religionLabel = new JLabel("RELIGION:");
        religionLabel.setFont(new Font("Raleway", Font.BOLD, 22));
        religionLabel.setBounds(100, 140, 200, 30);
        add(religionLabel);

        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religion = new JComboBox<>(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.white);
        add(religion);

        JLabel categoryLabel = new JLabel("CATEGORY:");
        categoryLabel.setFont(new Font("Raleway", Font.BOLD, 22));
        categoryLabel.setBounds(100, 190, 200, 30);
        add(categoryLabel);

        String valCategory[] = {"General", "OBC", "SC", "ST", "Other"};
        category = new JComboBox<>(valCategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.white);
        add(category);

        JLabel incomeLabel = new JLabel("INCOME:");
        incomeLabel.setFont(new Font("Raleway", Font.BOLD, 22));
        incomeLabel.setBounds(100, 240, 200, 30);
        add(incomeLabel);

        String incomeCategory[] = {"Null", "< 1,50,000", "< 2,50,0000", "<5,00,000", "Upto 10,00,000"};
        income = new JComboBox<>(incomeCategory);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.white);
        add(income);

        JLabel educationLabel = new JLabel("EDUCATION:");
        educationLabel.setFont(new Font("Raleway", Font.BOLD, 22));
        educationLabel.setBounds(100, 290, 200, 30);
        add(educationLabel);

        JLabel qualificationLabel = new JLabel("QUALIFICATION:");
        qualificationLabel.setFont(new Font("Raleway", Font.BOLD, 22));
        qualificationLabel.setBounds(100, 340, 200, 30);
        add(qualificationLabel);

        String educationValues[] = {"Non-Graduation", "Graduate", "Post-Graduation", "Doctorate", "Others"};
        education = new JComboBox<>(educationValues);
        education.setBounds(300, 340, 400, 30);
        education.setBackground(Color.white);
        add(education);

        JLabel occupationLabel = new JLabel("OCCUPATION:");
        occupationLabel.setFont(new Font("Raleway", Font.BOLD, 22));
        occupationLabel.setBounds(100, 390, 200, 30);
        add(occupationLabel);

        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharTextField.setBounds(300, 390, 400, 30);
        add(aadharTextField);

        JLabel pancardLabel = new JLabel("PANCARD NUMBER:");
        pancardLabel.setFont(new Font("Raleway", Font.BOLD, 22));
        pancardLabel.setBounds(100, 440, 200, 30);
        add(pancardLabel);

        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        pincodeTextField.setBounds(300, 440, 400, 30);
        add(pincodeTextField);

        JLabel seniorCitizenLabel = new JLabel("SENIOR CITIZENSHIP:");
        seniorCitizenLabel.setFont(new Font("Raleway", Font.BOLD, 22));
        seniorCitizenLabel.setBounds(100, 490, 200, 30);
        add(seniorCitizenLabel);

        mobileTextField = new JTextField();
        mobileTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        mobileTextField.setBounds(300, 490, 400, 30);
        add(mobileTextField);

        JLabel loanAppliedLabel = new JLabel("LOAN APPLIED:");
        loanAppliedLabel.setFont(new Font("Raleway", Font.BOLD, 22));
        loanAppliedLabel.setBounds(100, 540, 200, 30);
        add(loanAppliedLabel);

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

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String religionValue = (String) religion.getSelectedItem();
        String categoryValue = (String) category.getSelectedItem();
        String incomeValue = (String) income.getSelectedItem();
        String educationValue = (String) education.getSelectedItem();
        String occupation = aadharTextField.getText();
        String pancard = pincodeTextField.getText();
        String seniorCitizenship = mobileTextField.getText();
        String loanApplied = accounttypeTextField.getText();

        try {
            if (religionValue == null || categoryValue == null || incomeValue == null || educationValue == null) {
                JOptionPane.showMessageDialog(null, "All ComboBox selections are required");
            } else if (occupation.equals("") || pancard.equals("") || seniorCitizenship.equals("") || loanApplied.equals("")) {
                JOptionPane.showMessageDialog(null, "All TextFields are required");
            } else {
                Conn c = new Conn();
                String query = "INSERT INTO signuptwo (formno, religion, category, income, education, occupation, pancard, seniorCitizenship, loanApplied) VALUES('" + formno + "', '" + religionValue + "', '" + categoryValue + "', '" + incomeValue + "', '" + educationValue + "', '" + occupation + "', '" + pancard + "', '" + seniorCitizenship + "', '" + loanApplied + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Submitted Successfully");
                setVisible(false);
                new SignupThree(formno).setVisible(true); // Move to the next form
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new SignupTwo(""); // Example form number for testing
    }
}
*/
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupTwo extends JFrame implements ActionListener {

    JTextField aadharTextField, pincodeTextField, mobileTextField, accounttypeTextField;
    JComboBox<String> religion, category, income, education;
    JButton next;
    String formno;

    SignupTwo(String formno) {
        this.formno = formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel additionalDetails = new JLabel("PAGE 2: ADDITIONAL DETAILS");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 29));
        additionalDetails.setBounds(200, 80, 500, 30);
        add(additionalDetails);

        JLabel religionLabel = new JLabel("RELIGION:");
        religionLabel.setFont(new Font("Raleway", Font.BOLD, 22));
        religionLabel.setBounds(100, 140, 200, 30);
        add(religionLabel);

        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religion = new JComboBox<>(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.white);
        add(religion);

        JLabel categoryLabel = new JLabel("CATEGORY:");
        categoryLabel.setFont(new Font("Raleway", Font.BOLD, 22));
        categoryLabel.setBounds(100, 190, 200, 30);
        add(categoryLabel);

        String valCategory[] = {"General", "OBC", "SC", "ST", "Other"};
        category = new JComboBox<>(valCategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.white);
        add(category);

        JLabel incomeLabel = new JLabel("INCOME:");
        incomeLabel.setFont(new Font("Raleway", Font.BOLD, 22));
        incomeLabel.setBounds(100, 240, 200, 30);
        add(incomeLabel);

        String incomeCategory[] = {"Null", "< 1,50,000", "< 2,50,0000", "<5,00,000", "Upto 10,00,000"};
        income = new JComboBox<>(incomeCategory);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.white);
        add(income);

        JLabel educationLabel = new JLabel("EDUCATION:");
        educationLabel.setFont(new Font("Raleway", Font.BOLD, 22));
        educationLabel.setBounds(100, 290, 200, 30);
        add(educationLabel);

        String educationValues[] = {"Non-Graduation", "Graduate", "Post-Graduation", "Doctorate", "Others"};
        education = new JComboBox<>(educationValues);
        education.setBounds(300, 290, 400, 30);
        education.setBackground(Color.white);
        add(education);

        JLabel occupationLabel = new JLabel("OCCUPATION:");
        occupationLabel.setFont(new Font("Raleway", Font.BOLD, 22));
        occupationLabel.setBounds(100, 340, 200, 30);
        add(occupationLabel);

        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharTextField.setBounds(300, 340, 400, 30);
        add(aadharTextField);

        JLabel pancardLabel = new JLabel("PANCARD NUMBER:");
        pancardLabel.setFont(new Font("Raleway", Font.BOLD, 22));
        pancardLabel.setBounds(100, 390, 200, 30);
        add(pancardLabel);

        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        pincodeTextField.setBounds(300, 390, 400, 30);
        add(pincodeTextField);

        JLabel seniorCitizenLabel = new JLabel("SENIOR CITIZENSHIP:");
        seniorCitizenLabel.setFont(new Font("Raleway", Font.BOLD, 22));
        seniorCitizenLabel.setBounds(100, 440, 200, 30);
        add(seniorCitizenLabel);

        mobileTextField = new JTextField();
        mobileTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        mobileTextField.setBounds(300, 440, 400, 30);
        add(mobileTextField);

        JLabel loanAppliedLabel = new JLabel("LOAN APPLIED:");
        loanAppliedLabel.setFont(new Font("Raleway", Font.BOLD, 22));
        loanAppliedLabel.setBounds(100, 490, 200, 30);
        add(loanAppliedLabel);

        accounttypeTextField = new JTextField();
        accounttypeTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        accounttypeTextField.setBounds(300, 490, 400, 30);
        add(accounttypeTextField);

        next = new JButton("NEXT");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 550, 80, 30);
        add(next);

        next.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String religionValue = (String) religion.getSelectedItem();
        String categoryValue = (String) category.getSelectedItem();
        String incomeValue = (String) income.getSelectedItem();
        String educationValue = (String) education.getSelectedItem();
        String occupation = aadharTextField.getText();
        String pancard = pincodeTextField.getText();
        String seniorCitizenship = mobileTextField.getText();
        String loanApplied = accounttypeTextField.getText();

        try {
            if (religionValue == null || categoryValue == null || incomeValue == null || educationValue == null) {
                JOptionPane.showMessageDialog(null, "All ComboBox selections are required");
            } else if (occupation.equals("") || pancard.equals("") || seniorCitizenship.equals("") || loanApplied.equals("")) {
                JOptionPane.showMessageDialog(null, "All TextFields are required");
            } else {
                Conn c = new Conn();
                String query = "INSERT INTO signuptwo (formno, religion, category, income, education, occupation, pancard, seniorCitizenship, loanApplied) VALUES('" + formno + "', '" + religionValue + "', '" + categoryValue + "', '" + incomeValue + "', '" + educationValue + "', '" + occupation + "', '" + pancard + "', '" + seniorCitizenship + "', '" + loanApplied + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Submitted Successfully");
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SignupTwo(""); // Example form number for testing
    }
}
