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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Arroqi
 */
public class UpdateCustomer {

    public UpdateCustomer() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/customerorder";
        Connection con = DriverManager.getConnection(url, "root", "");
        Statement stat = con.createStatement();
        ResultSet rs;

        JFrame frame = new JFrame("Update Customer");
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        Container c = frame.getContentPane();
        c.setLayout(null);

        ImageIcon image = new ImageIcon(getClass().getResource("updateicon.png"));
        JLabel myImage = new JLabel(image);
        myImage.setBounds(70, 25, 70, 70);
        c.add(myImage);
        JLabel header = new JLabel("Update Customer");
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

        JLabel fNameLabel = new JLabel("First Name");
        fNameLabel.setFont(font);
        fNameLabel.setBounds(55, 145, 100, 30);
        c.add(fNameLabel);
        JTextField firstName = new JTextField();
        firstName.setBounds(200, 145, 230, 30);
        c.add(firstName);

        JLabel lNameLabel = new JLabel("Last Name");
        lNameLabel.setFont(font);
        lNameLabel.setBounds(55, 185, 100, 30);
        c.add(lNameLabel);
        JTextField lastName = new JTextField();
        lastName.setBounds(200, 185, 230, 30);
        c.add(lastName);

        JLabel mobileLabel = new JLabel("Mobile");
        mobileLabel.setFont(font);
        mobileLabel.setBounds(55, 225, 100, 30);
        c.add(mobileLabel);
        JTextField mobile = new JTextField();
        mobile.setBounds(200, 225, 230, 30);
        c.add(mobile);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setFont(font);
        emailLabel.setBounds(55, 265, 100, 30);
        c.add(emailLabel);
        JTextField email = new JTextField();
        email.setBounds(200, 265, 230, 30);
        c.add(email);

        JLabel addressLabel = new JLabel("Address");
        addressLabel.setFont(font);
        addressLabel.setBounds(55, 305, 100, 30);
        c.add(addressLabel);
        JTextField address = new JTextField();
        address.setBounds(200, 305, 230, 30);
        c.add(address);

        JLabel genderLabel = new JLabel("Gender");
        genderLabel.setFont(font);
        genderLabel.setBounds(55, 345, 100, 30);
        c.add(genderLabel);

        JRadioButton male = new JRadioButton("Male");
        male.setFont(font);
        male.setBounds(200, 345, 100, 30);
        c.add(male);
        JRadioButton female = new JRadioButton("Female");
        female.setFont(font);
        female.setBounds(340, 345, 100, 30);
        c.add(female);
        ButtonGroup gender = new ButtonGroup();
        gender.add(male);
        gender.add(female);

        JButton search = new JButton("search");
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                id.setEnabled(false);

                try {
                    ResultSet rs = stat.executeQuery("Select * from customer where id = " + id.getText() + ";");
                    while(rs.next()){
                    firstName.setText(rs.getString("firstName"));
                    lastName.setText(rs.getString("lastName"));
                    mobile.setText(rs.getString("mobile"));
                    email.setText(rs.getString("email"));
                    address.setText(rs.getString("address"));
                    if(rs.getString("gender").equals("female"))
                        female.setSelected(true);
                    else if(rs.getString("gender").equals("female"))
                        male.setSelected(true);
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
                     stat.executeUpdate("update customer set "
                           + "firstName = "+"'"+firstName.getText()+"' ,"
                           + "lastName = "+"'"+lastName.getText()+"' ,"
                           + "mobile = "+"'"+mobile.getText()+"' ,"
                   + "email = "+"'"+email.getText()+"' ,"
                   + "address = "+"'"+address.getText()+"' where "
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
                ManageCustomerMenu mcm = new ManageCustomerMenu();
            }
        });
        c.add(cancel);

        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
