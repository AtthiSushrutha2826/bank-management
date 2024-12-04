/*
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class SignupThree extends JFrame implements ActionListener {

    JRadioButton savingAccount, fixedDepositAccount, currentAccount, recurringDepositAccount;
    JCheckBox atmCard, internetBanking, mobileBanking, emailSmsAlerts, chequeBook, eStatement, declaration;
    JButton submit, cancel;
    String formno;
    SignupThree(String formno) {
        this.formno=formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");

        JLabel accountDetails = new JLabel("Page 3: Account Details");
        accountDetails.setFont(new Font("Raleway", Font.BOLD, 29));
        accountDetails.setBounds(250, 50, 400, 40);
        add(accountDetails);

        JLabel accountType = new JLabel("Account Type:");
        accountType.setFont(new Font("Raleway", Font.BOLD, 22));
        accountType.setBounds(100, 120, 200, 30);
        add(accountType);

        savingAccount = new JRadioButton("Saving Account");
        savingAccount.setFont(new Font("Raleway", Font.BOLD, 16));
        savingAccount.setBackground(Color.WHITE);
        savingAccount.setBounds(100, 160, 150, 30);
        add(savingAccount);

        fixedDepositAccount = new JRadioButton("Fixed Deposit Account");
        fixedDepositAccount.setFont(new Font("Raleway", Font.BOLD, 16));
        fixedDepositAccount.setBackground(Color.WHITE);
        fixedDepositAccount.setBounds(350, 160, 250, 30);
        add(fixedDepositAccount);

        currentAccount = new JRadioButton("Current Account");
        currentAccount.setFont(new Font("Raleway", Font.BOLD, 16));
        currentAccount.setBackground(Color.WHITE);
        currentAccount.setBounds(100, 200, 250, 30);
        add(currentAccount);

        recurringDepositAccount = new JRadioButton("Recurring Deposit Account");
        recurringDepositAccount.setFont(new Font("Raleway", Font.BOLD, 16));
        recurringDepositAccount.setBackground(Color.WHITE);
        recurringDepositAccount.setBounds(350, 200, 250, 30);
        add(recurringDepositAccount);

        ButtonGroup groupAccountType = new ButtonGroup();
        groupAccountType.add(savingAccount);
        groupAccountType.add(fixedDepositAccount);
        groupAccountType.add(currentAccount);
        groupAccountType.add(recurringDepositAccount);

        JLabel cardNumber = new JLabel("Card Number:");
        cardNumber.setFont(new Font("Raleway", Font.BOLD, 22));
        cardNumber.setBounds(100, 270, 200, 30);
        add(cardNumber);

        JLabel cardNumberValue = new JLabel("XXXX-XXXX-XXXX-4184");
        cardNumberValue.setFont(new Font("Raleway", Font.BOLD, 22));
        cardNumberValue.setBounds(330, 270, 300, 30);
        add(cardNumberValue);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 320, 200, 30);
        add(pin);

        JLabel pinValue = new JLabel("XXXX");
        pinValue.setFont(new Font("Raleway", Font.BOLD, 22));
        pinValue.setBounds(330, 320, 300, 30);
        add(pinValue);

        JLabel servicesRequired = new JLabel("Services Required:");
        servicesRequired.setFont(new Font("Raleway", Font.BOLD, 22));
        servicesRequired.setBounds(100, 380, 200, 30);
        add(servicesRequired);

        atmCard = new JCheckBox("ATM CARD");
        atmCard.setBackground(Color.WHITE);
        atmCard.setFont(new Font("Raleway", Font.BOLD, 16));
        atmCard.setBounds(100, 420, 200, 30);
        add(atmCard);

        internetBanking = new JCheckBox("Internet Banking");
        internetBanking.setBackground(Color.WHITE);
        internetBanking.setFont(new Font("Raleway", Font.BOLD, 16));
        internetBanking.setBounds(350, 420, 200, 30);
        add(internetBanking);

        mobileBanking = new JCheckBox("Mobile Banking");
        mobileBanking.setBackground(Color.WHITE);
        mobileBanking.setFont(new Font("Raleway", Font.BOLD, 16));
        mobileBanking.setBounds(100, 460, 200, 30);
        add(mobileBanking);

        emailSmsAlerts = new JCheckBox("EMAIL & SMS Alerts");
        emailSmsAlerts.setBackground(Color.WHITE);
        emailSmsAlerts.setFont(new Font("Raleway", Font.BOLD, 16));
        emailSmsAlerts.setBounds(350, 460, 200, 30);
        add(emailSmsAlerts);

        chequeBook = new JCheckBox("Cheque Book");
        chequeBook.setBackground(Color.WHITE);
        chequeBook.setFont(new Font("Raleway", Font.BOLD, 16));
        chequeBook.setBounds(100, 500, 200, 30);
        add(chequeBook);

        eStatement = new JCheckBox("E-Statement");
        eStatement.setBackground(Color.WHITE);
        eStatement.setFont(new Font("Raleway", Font.BOLD, 16));
        eStatement.setBounds(350, 500, 200, 30);
        add(eStatement);

        declaration = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge");
        declaration.setBackground(Color.WHITE);
        declaration.setFont(new Font("Raleway", Font.BOLD, 12));
        declaration.setBounds(100, 560, 700, 30);
        add(declaration);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(250, 600, 100, 30);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(450, 600, 100, 30);
        add(cancel);

        submit.addActionListener(this);
        cancel.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String accountType = null;
            if (savingAccount.isSelected()) {
                accountType = "Saving Account";
            } else if (fixedDepositAccount.isSelected()) {
                accountType = "Fixed Deposit Account";
            } else if (currentAccount.isSelected()) {
                accountType = "Current Account";
            } else if (recurringDepositAccount.isSelected()) {
                accountType = "Recurring Deposit Account";
            }

            String services = "";
            if (atmCard.isSelected()) {
                services += " ATM Card";
            }
            if (internetBanking.isSelected()) {
                services += " Internet Banking";
            }
            if (mobileBanking.isSelected()) {
                services += " Mobile Banking";
            }
            if (emailSmsAlerts.isSelected()) {
                services += " EMAIL & SMS Alerts";
            }
            if (chequeBook.isSelected()) {
                services += " Cheque Book";
            }
            if (eStatement.isSelected()) {
                services += " E-Statement";
            }

            Random random = new Random();
            String cardNumber = String.format("%016d", Math.abs(random.nextLong()) % 10000000000000000L);
            String pinNumber = String.format("%04d", Math.abs(random.nextInt(10000)));

            try {
                if (accountType == null) {
                    JOptionPane.showMessageDialog(null, "Account Type is Required");
                } else if (!declaration.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Please declare that the details are correct");
                } else {
                    Conn c = new Conn();
                    
                    String query1= "INSERT INTO signupThree (accountType, services, cardNumber, pinNumber) VALUES('" + accountType + "', '" + services + "', '" + cardNumber + "', '" + pinNumber + "')";
                    String query2 = "INSERT INTO login values('"+formno+"', '"+cardNumber+"', '"+pinNumber+"')";
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, "Account Created Successfully\nCard Number: " + cardNumber + "\nPIN: " + pinNumber);
                    // Move to the next form or perform any other action
                    // new SignupFour(formno); // Example if there's a next form
                    // dispose();
                    JOptionPane.showMessageDialog(null,"cardNumber: " + cardNumber + "\n Pin: " +pinNumber);
;                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == cancel) {
            // Handle the cancel action, for example, close the form
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new SignupThree("");
    }
}
*/
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener {

    JRadioButton savingAccount, fixedDepositAccount, currentAccount, recurringDepositAccount;
    JCheckBox atmCard, internetBanking, mobileBanking, emailSmsAlerts, chequeBook, eStatement, declaration;
    JButton submit, cancel;
    String formno;
    SignupThree(String formno) {
        this.formno=formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");

        JLabel accountDetails = new JLabel("Page 3: Account Details");
        accountDetails.setFont(new Font("Raleway", Font.BOLD, 29));
        accountDetails.setBounds(250, 50, 400, 40);
        add(accountDetails);

        JLabel accountType = new JLabel("Account Type:");
        accountType.setFont(new Font("Raleway", Font.BOLD, 22));
        accountType.setBounds(100, 120, 200, 30);
        add(accountType);

        savingAccount = new JRadioButton("Saving Account");
        savingAccount.setFont(new Font("Raleway", Font.BOLD, 16));
        savingAccount.setBackground(Color.WHITE);
        savingAccount.setBounds(100, 160, 150, 30);
        add(savingAccount);

        fixedDepositAccount = new JRadioButton("Fixed Deposit Account");
        fixedDepositAccount.setFont(new Font("Raleway", Font.BOLD, 16));
        fixedDepositAccount.setBackground(Color.WHITE);
        fixedDepositAccount.setBounds(350, 160, 250, 30);
        add(fixedDepositAccount);

        currentAccount = new JRadioButton("Current Account");
        currentAccount.setFont(new Font("Raleway", Font.BOLD, 16));
        currentAccount.setBackground(Color.WHITE);
        currentAccount.setBounds(100, 200, 250, 30);
        add(currentAccount);

        recurringDepositAccount = new JRadioButton("Recurring Deposit Account");
        recurringDepositAccount.setFont(new Font("Raleway", Font.BOLD, 16));
        recurringDepositAccount.setBackground(Color.WHITE);
        recurringDepositAccount.setBounds(350, 200, 250, 30);
        add(recurringDepositAccount);

        ButtonGroup groupAccountType = new ButtonGroup();
        groupAccountType.add(savingAccount);
        groupAccountType.add(fixedDepositAccount);
        groupAccountType.add(currentAccount);
        groupAccountType.add(recurringDepositAccount);

        JLabel cardNumber = new JLabel("Card Number:");
        cardNumber.setFont(new Font("Raleway", Font.BOLD, 22));
        cardNumber.setBounds(100, 270, 200, 30);
        add(cardNumber);

        JLabel cardNumberValue = new JLabel("XXXX-XXXX-XXXX-4184");
        cardNumberValue.setFont(new Font("Raleway", Font.BOLD, 22));
        cardNumberValue.setBounds(330, 270, 300, 30);
        add(cardNumberValue);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 320, 200, 30);
        add(pin);

        JLabel pinValue = new JLabel("XXXX");
        pinValue.setFont(new Font("Raleway", Font.BOLD, 22));
        pinValue.setBounds(330, 320, 300, 30);
        add(pinValue);

        JLabel servicesRequired = new JLabel("Services Required:");
        servicesRequired.setFont(new Font("Raleway", Font.BOLD, 22));
        servicesRequired.setBounds(100, 380, 200, 30);
        add(servicesRequired);

        atmCard = new JCheckBox("ATM CARD");
        atmCard.setBackground(Color.WHITE);
        atmCard.setFont(new Font("Raleway", Font.BOLD, 16));
        atmCard.setBounds(100, 420, 200, 30);
        add(atmCard);

        internetBanking = new JCheckBox("Internet Banking");
        internetBanking.setBackground(Color.WHITE);
        internetBanking.setFont(new Font("Raleway", Font.BOLD, 16));
        internetBanking.setBounds(350, 420, 200, 30);
        add(internetBanking);

        mobileBanking = new JCheckBox("Mobile Banking");
        mobileBanking.setBackground(Color.WHITE);
        mobileBanking.setFont(new Font("Raleway", Font.BOLD, 16));
        mobileBanking.setBounds(100, 460, 200, 30);
        add(mobileBanking);

        emailSmsAlerts = new JCheckBox("EMAIL & SMS Alerts");
        emailSmsAlerts.setBackground(Color.WHITE);
        emailSmsAlerts.setFont(new Font("Raleway", Font.BOLD, 16));
        emailSmsAlerts.setBounds(350, 460, 200, 30);
        add(emailSmsAlerts);

        chequeBook = new JCheckBox("Cheque Book");
        chequeBook.setBackground(Color.WHITE);
        chequeBook.setFont(new Font("Raleway", Font.BOLD, 16));
        chequeBook.setBounds(100, 500, 200, 30);
        add(chequeBook);

        eStatement = new JCheckBox("E-Statement");
        eStatement.setBackground(Color.WHITE);
        eStatement.setFont(new Font("Raleway", Font.BOLD, 16));
        eStatement.setBounds(350, 500, 200, 30);
        add(eStatement);

        declaration = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge");
        declaration.setBackground(Color.WHITE);
        declaration.setFont(new Font("Raleway", Font.BOLD, 12));
        declaration.setBounds(100, 560, 700, 30);
        add(declaration);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(250, 600, 100, 30);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(450, 600, 100, 30);
        add(cancel);

        submit.addActionListener(this);
        cancel.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }
    

    public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == submit) {
        String accountType = null;
        if (savingAccount.isSelected()) {
            accountType = "Saving Account";
        } else if (fixedDepositAccount.isSelected()) {
            accountType = "Fixed Deposit Account";
        } else if (currentAccount.isSelected()) {
            accountType = "Current Account";
        } else if (recurringDepositAccount.isSelected()) {
            accountType = "Recurring Deposit Account";
        }
        
        Random random = new Random();
        String cardNumber = String.format("%016d", Math.abs(random.nextLong()) % 10000000000000000L);
        String pinNumber = String.format("%04d", Math.abs(random.nextInt(10000)));


        String services = "";
        if (atmCard.isSelected()) {
            services += " ATM Card";
        }
        if (internetBanking.isSelected()) {
            services += " Internet Banking";
        }
        if (mobileBanking.isSelected()) {
            services += " Mobile Banking";
        }
        if (emailSmsAlerts.isSelected()) {
            services += " EMAIL & SMS Alerts";
        }
        if (chequeBook.isSelected()) {
            services += " Cheque Book";
        }
        if (eStatement.isSelected()) {
            services += " E-Statement";
        }

        
        try {
            if (accountType == null) {
                JOptionPane.showMessageDialog(null, "Account Type is Required");
            } else if (!declaration.isSelected()) {
                JOptionPane.showMessageDialog(null, "Please declare that the details are correct");
            } else {
                Conn c = new Conn();
                
                String query1 = "INSERT INTO signupThree (accountType, services, cardNumber, pinNumber) VALUES('" + accountType + "', '" + services + "', '" + cardNumber + "', '" + pinNumber + "')";
                String query2 = "INSERT INTO login VALUES('" + formno + "', '" + cardNumber + "', '" + pinNumber + "')";
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null, "Account Created Successfully\nCard Number: " + cardNumber + "\nPIN: " + pinNumber);
                // Move to the next form (Example: SignupFour)
              
                setVisible(false);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    } else if (ae.getSource() == cancel) {
        // Handle the cancel action, for example, close the form
        setVisible(false);
        new Login().setVisible(true); // Proper instantiation of Login
    }
}


    public static void main(String[] args) {
        new SignupThree("");
    }
}

