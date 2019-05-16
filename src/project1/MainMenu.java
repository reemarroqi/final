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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Arroqi
 */
public class MainMenu {
    
    public MainMenu(){
        JFrame frame = new JFrame("Main Menu");
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        Container c = frame.getContentPane();
        c.setLayout(null);
        
        JLabel header = new JLabel("Main Menu");
        header.setFont(new Font("Arial",Font.PLAIN,40));
        header.setBounds(140, 45, 300, 40);
        c.add(header);
        
        Font font = new Font("Arial",Font.PLAIN,16);
        JButton mProducts = new JButton("Manage Products");
        mProducts.setFont(font);
        mProducts.setBounds(90, 120, 300, 40);
        mProducts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                ManageProductMenu mp = new ManageProductMenu();
            }
        });
        c.add(mProducts);
        
        JButton mCustomers = new JButton("Manage Customers");
        mCustomers.setFont(font);
        mCustomers.setBounds(90, 190, 300, 40);
        mCustomers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                ManageCustomerMenu mcm = new ManageCustomerMenu();
                
            }
        });
        c.add(mCustomers);
        
        JButton mOrders = new JButton("Manage Orders");
        mOrders.setFont(font);
        mOrders.setBounds(90, 260, 300, 40);
        mOrders.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                ManageOrder mo = new ManageOrder();
            }
        });
        c.add(mOrders);
        
        JButton logOut = new JButton("Log Out");
        logOut.setFont(font);
        logOut.setBounds(90, 330, 300, 40);
        logOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        c.add(logOut);
        
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }
    
}
