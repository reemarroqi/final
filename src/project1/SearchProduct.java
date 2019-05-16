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
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Arroqi
 */
public class SearchProduct {

    public SearchProduct() throws ClassNotFoundException, SQLException {

        JFrame frame = new JFrame("Search Product");
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        Container c = frame.getContentPane();
        c.setLayout(null);

        ImageIcon image = new ImageIcon(getClass().getResource("searchicon.png"));
        JLabel myImage = new JLabel(image);
        myImage.setBounds(50, 25, 70, 70);
        c.add(myImage);
        JLabel header = new JLabel("Search for Product");
        header.setFont(new Font("Arial", Font.PLAIN, 35));
        header.setBounds(120, 35, 300, 40);
        c.add(header);

        Font font = new Font("Arial", Font.PLAIN, 16);
        JLabel categoryLabel = new JLabel("Category");
        categoryLabel.setFont(font);
        categoryLabel.setBounds(55, 138, 100, 30);
        c.add(categoryLabel);
        String[] categories = {"Mobiles", "Mobile Accessories", "Computers", "Computer Accessories", "Bags"};
        JComboBox category = new JComboBox(categories);
        category.setBounds(150, 140, 160, 30);
        c.add(category);

        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/customerorder";
        Connection con = DriverManager.getConnection(url, "root", "");
        Statement stat = con.createStatement();

        JButton search = new JButton("search");
        search.setBounds(330, 140, 100, 30);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    ResultSet rs = stat.executeQuery("select * from product where category = "
                            + "'" + category.getSelectedItem().toString() + "'");

                    DefaultTableModel tm = new DefaultTableModel();
                    JTable table = new JTable(tm);
                    table.setEnabled(false);
                    tm.addColumn("id");
                    tm.addColumn("name");
                    tm.addColumn("price");
                    tm.addColumn("quantity");
                    tm.addColumn("description");
                    tm.setRowCount(0);
                    while (rs.next()) {
                        Object o[] = {rs.getInt("id"), rs.getString("name"),
                            rs.getFloat("price"), rs.getInt("quantity"), rs.getString("description")};
                        tm.addRow(o);
                    }
                  
                    JScrollPane scroll = new JScrollPane(table);
                    scroll.setBounds(5, 220, 490, 200);
                    scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                   
                    c.add(scroll);
                    
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        c.add(search);

        JButton cancel = new JButton("Cancel");
        cancel.setBounds(330, 420, 100, 30);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                ManageProductMenu mpm = new ManageProductMenu();
            }
        });
        c.add(cancel);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
