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
public class ManageProductMenu {
    public ManageProductMenu(){
        
        JFrame frame = new JFrame("Manage Product Menu");
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        Container c = frame.getContentPane();
        c.setLayout(null);
        
        JLabel header = new JLabel("Manage Product");
        header.setFont(new Font("Arial",Font.PLAIN,35));
        header.setBounds(102, 45, 300, 40);
        c.add(header);
        
        Font font = new Font("Arial",Font.PLAIN,16);
        
        JButton addProduct = new JButton("Add Product");
        addProduct.setFont(font);
        addProduct.setBounds(90, 120, 300, 40);
        addProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                try {
                    AddProduct ac = new AddProduct();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        c.add(addProduct);
        
        JButton updateProduct = new JButton("Update Product");
        updateProduct.setFont(font);
        updateProduct.setBounds(90, 180, 300, 40);
        updateProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                try {
                    UpdateProduct up = new UpdateProduct();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        c.add(updateProduct);
        
        JButton deleteProduct = new JButton("Delete Product");
        deleteProduct.setFont(font);
        deleteProduct.setBounds(90, 250, 300, 40);
        deleteProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                try {
                    DeleteProduct dp = new DeleteProduct();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        c.add(deleteProduct);
        
        JButton searchProduct = new JButton("Search Product");
        searchProduct.setFont(font);
        searchProduct.setBounds(90, 320, 300, 40);
        searchProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                try {
                    SearchProduct main = new SearchProduct();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                } catch (SQLException ex) {
                     ex.printStackTrace();
                }
            }
        });
        c.add(searchProduct);
        
        JButton mainMenu = new JButton("Main Menu");
        mainMenu.setFont(font);
        mainMenu.setBounds(90, 390, 300, 40);
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
