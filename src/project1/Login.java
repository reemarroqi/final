/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

// Done! all complete


public class Login {
    
    public Login(){
        JFrame frame = new JFrame("Login");
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        Container c = frame.getContentPane();
        c.setLayout(null);
        
        Font font = new Font("Arial",Font.PLAIN,16);
        
       ImageIcon image = new ImageIcon(getClass().getResource("loginicon.png"));
        JLabel myImage = new JLabel(image);
        myImage.setBounds(140, 5, 200, 200);
        c.add(myImage);
       
        JLabel username = new JLabel("User Name:");
        username.setFont(font);
        username.setBounds(60, 200, 100, 30);
        c.add(username);
        JTextField usernameField = new JTextField();
        usernameField.setBounds(220,200,200,30);
        c.add(usernameField);
        
        JLabel password = new JLabel("Password:");
        password.setFont(font);
        password.setBounds(60, 270, 100, 30);
        c.add(password);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(220,270,200,30);
        c.add(passwordField);
        
         
          JLabel wrong = new JLabel();
          wrong.setForeground(Color.red);
          wrong.setBounds(150,400,400,30);
          c.add(wrong);
                    
        JButton ok = new JButton("Ok");
        ok.setFont(font);
        ok.setBounds(120, 350, 100, 30);
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (usernameField.getText().equals("admin1")&&passwordField.getText().equals("admin123456")){
                    frame.setVisible(false);
                    MainMenu menu = new MainMenu();}
                else {
                    wrong.setText("Wrong user name or password");
                    
                    
                }
                    
                
            }
        });
        c.add(ok);
        JButton cancel = new JButton("Cancel");
        cancel.setFont(font);
        cancel.setBounds(250, 350, 100, 30);
        c.add(cancel);
        
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
    }
    
}
