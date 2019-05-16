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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Arroqi
 */
public class AddProduct {
    public AddProduct() throws ClassNotFoundException, SQLException{
        
        Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/customerorder";
            Connection con = DriverManager.getConnection(url,"root","");
           Statement stat = con.createStatement();
          ResultSet rs;
          
        JFrame frame = new JFrame("Add Product");
        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);
        Container c = frame.getContentPane();
        c.setLayout(null);
        
        ImageIcon image = new ImageIcon(getClass().getResource("addProductIcon.png"));
        JLabel myImage = new JLabel(image);
        myImage.setBounds(90, 25, 70, 70);
        c.add(myImage);
        
        JLabel header = new JLabel("Add Product");
        header.setFont(new Font("Arial",Font.PLAIN,35));
        header.setBounds(170, 35, 300, 40);
        c.add(header);
        
        Font font = new Font("Arial",Font.PLAIN,18);
        
         JLabel idLabel = new JLabel("ID");
        idLabel.setFont(font);
        idLabel.setBounds(55, 125, 100, 30);
        c.add(idLabel);
        JTextField id = new JTextField();
        id.setBounds(200, 125, 230, 30);
        c.add(id);
        
        JLabel nameLabel = new JLabel("Name");
        nameLabel.setFont(font);
        nameLabel.setBounds(55, 165, 100, 30);
        c.add(nameLabel);
        JTextField name = new JTextField();
        name.setBounds(200, 165, 230, 30);
        c.add(name);
        
        
        JLabel categoryLabel = new JLabel("Category");
        categoryLabel.setFont(font);
        categoryLabel.setBounds(55, 205, 100, 30);
        c.add(categoryLabel);
        String[] categories = {"Mobiles","Mobile Accessories","Computers","Computer Accessories","Bags"};
        JComboBox category = new JComboBox(categories);
        category.setBounds(200, 205, 230, 30);
        c.add(category);
        
        JLabel priceLabel = new JLabel("Price");
        priceLabel.setFont(font);
        priceLabel.setBounds(55, 245, 100, 30);
        c.add(priceLabel);
        JTextField price = new JTextField();
        price.setBounds(200, 245, 215, 30);
        c.add(price);
        JLabel dollar = new JLabel("$");
        dollar.setFont(font);
        dollar.setBounds(420, 245, 40, 30);
        c.add(dollar);
        
        JLabel quantityLabel = new JLabel("Quantity");
        quantityLabel.setFont(font);
        quantityLabel.setBounds(55, 285, 100, 30);
        c.add(quantityLabel);
        JTextField quantity = new JTextField();
        quantity.setBounds(200, 285, 230, 30);
        c.add(quantity);
        
        JLabel descriptionlLabel = new JLabel("Description");
        descriptionlLabel.setFont(font);
        descriptionlLabel.setBounds(55, 325, 100, 30);
        c.add(descriptionlLabel);
        JTextArea description = new JTextArea();
        description.setLineWrap(true);
        JScrollPane scroll = new JScrollPane(description);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(200, 325, 230, 60);
        c.add(scroll);
        
        
        
        JButton add = new JButton("Add");
        add.setFont(font);
        add.setBounds(90, 425, 100, 30);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    
                    
                   stat.execute("insert into product values ('"+id.getText()
                           +"','"+name.getText()
                           +"','"+category.getSelectedItem().toString()
                           +"','"+price.getText()
                           +"','"+quantity.getText()+
                           "','"+description.getText()+"')"); 
                   JOptionPane.showMessageDialog(frame, "Successfully Added!");
                   
                   
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(frame, "Something went wrong, try again");
                    ex.printStackTrace();
                    
                }
            }
        });
        c.add(add);
        
        JButton cancel = new JButton("Cancel");
        cancel.setFont(font);
        cancel.setBounds(310, 425, 100, 30);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                ManageProductMenu mpm = new ManageProductMenu();
            }
        });
        c.add(cancel);
        


        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
                
        
    }
}
