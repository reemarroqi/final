/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Arroqi
 */
public class ManageCustomerMenu {
    
    public ManageCustomerMenu(){
        
        JFrame frame = new JFrame("Manage Customer Menu");
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        Container c = frame.getContentPane();
        c.setLayout(null);
        
        JLabel header = new JLabel("Manage Customer");
        header.setFont(new Font("Arial",Font.PLAIN,35));
        header.setBounds(102, 45, 300, 40);
        c.add(header);
        
        Font font = new Font("Arial",Font.PLAIN,16);
        
        JButton addCustomer = new JButton("Add Customer");
        addCustomer.setFont(font);
        addCustomer.setBounds(90, 120, 300, 40);
        addCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                try {
                    AddCustomer ac = new AddCustomer();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        c.add(addCustomer);
        
        JButton updateCustomer = new JButton("Update Customers");
        updateCustomer.setFont(font);
        updateCustomer.setBounds(90, 190, 300, 40);
        updateCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                try {
                    UpdateCustomer uc = new UpdateCustomer();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        c.add(updateCustomer);
        
        JButton deleteCustomer = new JButton("Delete Customer");
        deleteCustomer.setFont(font);
        deleteCustomer.setBounds(90, 260, 300, 40);
        deleteCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                try {
                    DeleteCustomer dc = new DeleteCustomer();
                } catch (ClassNotFoundException ex) {
                   ex.printStackTrace();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        c.add(deleteCustomer);
        
        JButton mainMenu = new JButton("Main Menu");
        mainMenu.setFont(font);
        mainMenu.setBounds(90, 330, 300, 40);
        mainMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                MainMenu main = new MainMenu();
            }
        });
        c.add(mainMenu);
        
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
}
