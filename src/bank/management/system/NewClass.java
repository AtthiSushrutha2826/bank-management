/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JFrame;
import java.awt.BorderLayout;

public class NewClass {
    public static void main(String[] args) {
        // Create a new JFrame
        JFrame frame = new JFrame("Display Image");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300); // Set the size of the frame

        // Load the image
        ImageIcon imageIcon = new ImageIcon("src/bank/management/system/atm.jpg");

        // Create a label and set the icon
        JLabel label = new JLabel();
        label.setIcon(imageIcon);

        // Add the label to the frame
        frame.add(label, BorderLayout.CENTER);

        // Set the frame visible
        frame.setVisible(true);
    }
}

