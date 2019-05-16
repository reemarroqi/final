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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Arroqi
 */
public class ManageOrder {
    
    public ManageOrder() throws ClassNotFoundException, SQLException{
        JFrame frame = new JFrame("Manage Orders");
        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);
        Container c = frame.getContentPane();
        c.setLayout(null);
        
        ImageIcon image = new ImageIcon(getClass().getResource("ordericon.png"));
        JLabel myImage = new JLabel(image);
        myImage.setBounds(120, 15, 70, 70);
        c.add(myImage);
        
        JLabel header = new JLabel("Orders");
        header.setFont(new Font("Arial",Font.PLAIN,35));
        header.setBounds(200, 30, 300, 40);
        c.add(header);
        
        Font font = new Font("Arial",Font.PLAIN,18);
        Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/customerorder";
            Connection con = DriverManager.getConnection(url,"root","");
           Statement stat = con.createStatement();
           
          ResultSet rs = stat.executeQuery("select firstName, lastName from customer");
          
          ArrayList<String> names = new ArrayList();
          while(rs.next()){
              names.add(rs.getString("firstName")+" "+rs.getString("lastName"));
          }
          
          ResultSet rs2 = stat.executeQuery("select name from product");
        ArrayList<String> products = new ArrayList();
        while(rs2.next()){
            products.add(rs2.getString("name"));
        }
        
        JLabel customerLabel = new JLabel("Customer");
        customerLabel.setFont(font);
        customerLabel.setBounds(55, 90, 100, 30);
        c.add(customerLabel);
        JComboBox customer = new JComboBox(names.toArray());
        customer.setBounds(200, 90, 200, 30);
        c.add(customer);
        
         JLabel productLabel = new JLabel("Product");
        productLabel.setFont(font);
        productLabel.setBounds(55, 130, 100, 30);
        c.add(productLabel);
        JComboBox product = new JComboBox(products.toArray());
        product.setBounds(200, 130, 200, 30);
        c.add(product);
        
        JLabel priceLabel = new JLabel("Price");
        priceLabel.setFont(font);
        priceLabel.setBounds(55, 170, 100, 30);
        c.add(priceLabel);
        JTextField price = new JTextField();
        price.setBounds(200, 170, 200, 30);
        c.add(price);
        
        JLabel quantityLabel = new JLabel("Quantity");
        quantityLabel.setFont(font);
        quantityLabel.setBounds(55, 210, 100, 30);
        c.add(quantityLabel);
        JTextField quantity = new JTextField();
        quantity.setBounds(200, 210, 200, 30);
        c.add(quantity);
        
        JButton insert = new JButton("Insert order");
        insert.setBounds(10, 250, 150, 30);
        insert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    stat.executeUpdate("insert into orders values ('"+customer.getSelectedItem().toString()
                    +"', '"+product.getSelectedItem().toString()+"', "+price.getText()+", "+quantity.getText()
                            +", "+(Float.valueOf(price.getText())*Integer.parseInt(quantity.getText()))+")");
                    
                    
                    JOptionPane.showMessageDialog(frame, "Successfully inserted");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(frame, "something went wrong");
                    ex.printStackTrace();
                }
            }
        });
        c.add(insert);
        
        JButton show = new JButton("show all orders");
        show.setBounds(170, 250, 150, 30);
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
             try {
                    ResultSet rs = stat.executeQuery("select * from orders");

                    DefaultTableModel tm = new DefaultTableModel();
                    JTable table = new JTable(tm);
                    table.setEnabled(false);
                    tm.addColumn("customer");
                    tm.addColumn("product");
                    tm.addColumn("price");
                    tm.addColumn("quantity");
                    tm.addColumn("total");
                    tm.setRowCount(0);
                    while (rs.next()) {
                        Object o[] = {rs.getString("customer"), rs.getString("product"),
                            rs.getFloat("price"), rs.getInt("quantity"), rs.getFloat("total")};
                        tm.addRow(o);
                    }
                  
                    JScrollPane scroll = new JScrollPane(table);
                    scroll.setBounds(5, 290, 490, 200);
                    scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                   
                    c.add(scroll);
                    
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        c.add(show);
        
        JButton cancel = new JButton("Cancel");
        cancel.setBounds(330, 250, 150, 30);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 frame.setVisible(false);
                 MainMenu main = new MainMenu();
            }
        });
        c.add(cancel);
        
        
        
        
        
        
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }
}
