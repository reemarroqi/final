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
public class UpdateProduct {
    public UpdateProduct() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/customerorder";
        Connection con = DriverManager.getConnection(url, "root", "");
        Statement stat = con.createStatement();
        ResultSet rs;

        JFrame frame = new JFrame("Update Product");
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        Container c = frame.getContentPane();
        c.setLayout(null);

        ImageIcon image = new ImageIcon(getClass().getResource("updateicon.png"));
        JLabel myImage = new JLabel(image);
        myImage.setBounds(70, 25, 70, 70);
        c.add(myImage);
        JLabel header = new JLabel("Update Product");
        header.setFont(new Font("Arial", Font.PLAIN, 35));
        header.setBounds(140, 35, 300, 40);
        c.add(header);

        Font font = new Font("Arial", Font.PLAIN, 18);

        JLabel idLabel = new JLabel("ID");
        idLabel.setFont(font);
        idLabel.setBounds(55, 105, 100, 30);
        c.add(idLabel);
        JTextField id = new JTextField();
        id.setBounds(200, 105, 150, 30);
        c.add(id);
        
        JLabel nameLabel = new JLabel("Name");
        nameLabel.setFont(font);
        nameLabel.setBounds(55, 145, 100, 30);
        c.add(nameLabel);
        JTextField name = new JTextField();
        name.setBounds(200, 145, 230, 30);
        c.add(name);

        JLabel categoryLabel = new JLabel("Category");
        categoryLabel.setFont(font);
        categoryLabel.setBounds(55, 195, 100, 30);
        c.add(categoryLabel);
        String[] categories = {"Mobiles","Mobile Accessories","Computers","Computer Accessories","Bags"};
        JComboBox category = new JComboBox(categories);
        category.setBounds(200, 195, 230, 30);
        c.add(category);

        JLabel priceLabel = new JLabel("Price");
        priceLabel.setFont(font);
        priceLabel.setBounds(55, 235, 100, 30);
        c.add(priceLabel);
        JTextField price = new JTextField();
        price.setBounds(200, 235, 230, 30);
        c.add(price);

        JLabel quantityLabel = new JLabel("Quantity");
        quantityLabel.setFont(font);
        quantityLabel.setBounds(55, 275, 100, 30);
        c.add(quantityLabel);
        JTextField quantity = new JTextField();
        quantity.setBounds(200, 275, 230, 30);
        c.add(quantity);
        

        JLabel descriptionLabel = new JLabel("Description");
        descriptionLabel.setFont(font);
        descriptionLabel.setBounds(55, 315, 100, 30);
        c.add(descriptionLabel);
        JTextArea description = new JTextArea();
        description.setLineWrap(true);
        JScrollPane scroll = new JScrollPane(description);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(200, 315, 230, 60);
        c.add(scroll);

        
        JButton search = new JButton("search");
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                id.setEnabled(false);

                try {
                    ResultSet rs = stat.executeQuery("Select * from product where id = " + id.getText() + ";");
                    while(rs.next()){
                    name.setText(rs.getString("name"));
                    category.setSelectedItem(rs.getString("category"));
                    price.setText(rs.getString("price"));
                    quantity.setText(rs.getString("quantity"));
                    description.setText(rs.getString("description"));
                    }
                    

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(frame,"something went wrong, try again.");
                    ex.printStackTrace();
                }

            }
        });
        search.setBounds(355, 105, 75, 30);
        c.add(search);

        JButton update = new JButton("Update");
        update.setFont(font);
        update.setBounds(100, 410, 100, 30);
      update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                     stat.executeUpdate("update product set "
                           + "name = "+"'"+name.getText()+"' ,"
                           + "category = "+"'"+category.getSelectedItem().toString()+"' ,"
                           + "price = "+"'"+price.getText()+"' ,"
                   + "quantity = "+"'"+quantity.getText()+"' ,"
                   + "description = "+"'"+description.getText()+"' where "
                           + "id = "+id.getText());
                    
                   JOptionPane.showMessageDialog(frame,"Updated Successfully");
                  
                   
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(frame,"something went wrong, try again.");
                    ex.printStackTrace();
                }
            }
        }); 
        c.add(update);

        JButton cancel = new JButton("Cancel");
        cancel.setFont(font);
        cancel.setBounds(300, 410, 100, 30);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                ManageProductMenu mcm = new ManageProductMenu();
            }
        });
        c.add(cancel);

        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
