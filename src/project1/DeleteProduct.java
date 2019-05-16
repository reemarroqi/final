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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Arroqi
 */
public class DeleteProduct {

    public DeleteProduct() throws ClassNotFoundException, SQLException {
        
        JFrame frame = new JFrame("Delete Product");
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        Container c = frame.getContentPane();
        c.setLayout(null);
        
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/customerorder";
        Connection con = DriverManager.getConnection(url, "root", "");
        Statement stat = con.createStatement();

        ResultSet rs = stat.executeQuery("select * from product");

        DefaultTableModel tm = new DefaultTableModel();
        JTable table = new JTable(tm);
       
        tm.addColumn("id");
        tm.addColumn("name");
        tm.addColumn("category");
        tm.addColumn("price");
        tm.addColumn("quantity");
        tm.addColumn("description");
        tm.setRowCount(0);
        while (rs.next()) {
            Object o[] = {rs.getInt("id"), rs.getString("name"),rs.getString("category"),
                rs.getFloat("price"), rs.getInt("quantity"), rs.getString("description")};
            tm.addRow(o);
        }

        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(5, 220, 490, 200);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        c.add(scroll);
        

        

        ImageIcon image = new ImageIcon(getClass().getResource("deleteicon.png"));
        JLabel myImage = new JLabel(image);
        myImage.setBounds(90, 25, 70, 70);
        c.add(myImage);

        JLabel header = new JLabel("Delete Product");
        header.setFont(new Font("Arial", Font.PLAIN, 35));
        header.setBounds(160, 45, 300, 40);
        c.add(header);

        JButton delete = new JButton("Delete");
        delete.setBounds(70, 420, 100, 30);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    int column = 0;
                    int row = table.getSelectedRow();
                    int selectedId =  (int) table.getModel().getValueAt(row, column);
                   stat.executeUpdate("delete from product where id = "+selectedId);
                   JOptionPane.showMessageDialog(frame, "successfully deleted");
                   
                } catch (SQLException ex) {
                   JOptionPane.showMessageDialog(frame, "something went wrong");
                   ex.printStackTrace();
                }
            }
        });
        c.add(delete);

        JButton refresh = new JButton("Refresh");
        refresh.setBounds(200, 420, 100, 30);
        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               //tm.fireTableDataChanged();
             //  table.setModel(tm);
            try{   
          ResultSet rs = stat.executeQuery("select * from product");

        DefaultTableModel tm = new DefaultTableModel();
        JTable table = new JTable(tm);
       
        tm.addColumn("id");
        tm.addColumn("name");
        tm.addColumn("category");
        tm.addColumn("price");
        tm.addColumn("quantity");
        tm.addColumn("description");
        tm.setRowCount(0);
        while (rs.next()) {
            Object o[] = {rs.getInt("id"), rs.getString("name"),rs.getString("category"),
                rs.getFloat("price"), rs.getInt("quantity"), rs.getString("description")};
            tm.addRow(o);
        }

        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(5, 220, 490, 200);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        c.add(scroll);}
            catch(Exception ex){
                
                ex.printStackTrace();
            }
            }
        });
        c.add(refresh);

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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
