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

    JTextField pan, aadhar;
    JRadioButton syes, sno;
    JButton next;
    JComboBox<String> religion, category, occupation, education, income;
    String formno;

    // Constructor
    SignupTwo(String formno) {
        this.formno = formno;
        setLayout(null);
        setTitle("NEW APPLICATION FORM PAGE-2");

        JLabel additionalDetails = new JLabel("PAGE 2: ADDITIONAL DETAILS");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 29));
        additionalDetails.setBounds(250, 80, 500, 30);
        add(additionalDetails);

        JLabel name = new JLabel("RELIGION:");
        name.setFont(new Font("Raleway", Font.BOLD, 22));
        name.setBounds(100, 140, 200, 30);
        add(name);

        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religion = new JComboBox<>(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.white);
        add(religion);

        JLabel age = new JLabel("CATEGORY:");
        age.setFont(new Font("Raleway", Font.BOLD, 22));
        age.setBounds(100, 190, 200, 30);
        add(age);

        String valCategory[] = {"General", "OBC", "SC", "ST", "Other"};
        category = new JComboBox<>(valCategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.white);
        add(category);

        JLabel dob = new JLabel("INCOME:");
        dob.setFont(new Font("Raleway", Font.BOLD, 22));
        dob.setBounds(100, 240, 200, 30);
        add(dob);

        String incomeCategory[] = {"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000"};
        income = new JComboBox<>(incomeCategory);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.white);
        add(income);

        JLabel gender = new JLabel("EDUCATIONAL:");
        gender.setFont(new Font("Raleway", Font.BOLD, 22));
        gender.setBounds(100, 290, 200, 30);
        add(gender);

        JLabel email = new JLabel("QUALIFICATION:");
        email.setFont(new Font("Raleway", Font.BOLD, 22));
        email.setBounds(100, 315, 200, 30);
        add(email);

        String educationValues[] = {"Non-Graduation", "Graduate", "Post-Graduation", "Doctorate", "Others"};
        education = new JComboBox<>(educationValues);
        education.setBounds(300, 315, 400, 30);
        education.setBackground(Color.white);
        add(education);

        JLabel abc = new JLabel("OCCUPATION:");
        abc.setFont(new Font("Raleway", Font.BOLD, 22));
        abc.setBounds(100, 390, 200, 30);
        add(abc);

        String occupationValues[] = {"Salaried", "Self Employed", "Business", "Student", "Retired", "Others"};
        occupation = new JComboBox<>(occupationValues);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.white);
        add(occupation);

        JLabel pincode = new JLabel("PAN NUMBER:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 22));
        pincode.setBounds(100, 440, 200, 30);
        add(pincode);

        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(300, 440, 400, 30);
        add(pan);

        JLabel mobile = new JLabel("AADHAR NUMBER:");
        mobile.setFont(new Font("Raleway", Font.BOLD, 22));
        mobile.setBounds(100, 490, 200, 30);
        add(mobile);

        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
        aadhar.setBounds(300, 490, 400, 30);
        add(aadhar);

        JLabel accounttype = new JLabel("SENIOR CITIZEN:");
        accounttype.setFont(new Font("Raleway", Font.BOLD, 22));
        accounttype.setBounds(100, 540, 250, 30);
        add(accounttype);

        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450, 540, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup emaritalgroup = new ButtonGroup();
        emaritalgroup.add(syes);
        emaritalgroup.add(sno);

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
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String seniorcitizen = null;

        if (syes.isSelected()) {
            seniorcitizen = "Yes";
        } else if (sno.isSelected()) {
            seniorcitizen = "No";
        }

        String span = pan.getText();
        String saadhar = aadhar.getText();

        try {
            if (sreligion.isEmpty() || scategory.isEmpty() || sincome.isEmpty() || seducation.isEmpty() ||
                soccupation.isEmpty() || span.isEmpty() || saadhar.isEmpty() || seniorcitizen == null) {
                JOptionPane.showMessageDialog(null, "All details are required");
            } else {
                Conn c = new Conn();
                String query = "INSERT INTO signuptwo (formno, religion, category, income, education, occupation, pan, aadhar, seniorcitizen) " +
                               "VALUES('" + formno + "', '" + sreligion + "', '" + scategory + "', '" + sincome + "', '" +
                               seducation + "', '" + soccupation + "', '" + span + "', '" + saadhar + "', '" + seniorcitizen + "')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Details Submitted Successfully");
                setVisible(false);
                new SignupThree(formno).setVisible(true);  // Transition to the next page
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new SignupTwo("");
    }
}
