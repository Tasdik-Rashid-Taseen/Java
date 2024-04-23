/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author tasdi
 */
public class Register extends JFrame implements ActionListener {

    JFrame regFrame;
    JPanel panel1, panel2, panel3;
    JLabel lab1, lab2, lab3, lab4, lab5, lab6, lab7, lab8;
    JTextField txt1, txt2, txt3, txt4, txt5, txt6, txt7;
    JButton btn1, btn2;

    String inputUser;
    String inputEmail;
    String inputPass;
    String inputConPass;
    String inputPhone;
    String inputAdd;
    String inputOcc;
    Color cusSkyBlue = new Color(123, 161, 201);

    public Register() {
        regFrame = new JFrame();
        regFrame.setSize(400, 730);
        regFrame.setDefaultCloseOperation(3);
        regFrame.setLayout(null);
        regFrame.setTitle("Register");
        regFrame.setLocationRelativeTo(null);
        regFrame.setResizable(false);
        regFrame.setVisible(true);
        Font font = new Font("Arial", Font.BOLD, 15);
        Font headerFont = new Font("Arial", Font.BOLD, 25);
        Font inputFont = new Font("Arial", Font.PLAIN, 15);
        Border border = BorderFactory.createLineBorder(cusSkyBlue, 2);

        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(0, 0, 390, 50);
        //panel1.setBackground(Color.red);
        regFrame.add(panel1);

        lab1 = new JLabel("Register");
        lab1.setBounds(15, 20, 100, 25);
        lab1.setForeground(Color.BLACK);
        lab1.setFont(headerFont);
        panel1.add(lab1);

        btn2 = new JButton("LOGIN");
        btn2.addActionListener(this);
        btn2.setFont(font);
        btn2.setBounds(270, 15, 100, 30);
        panel1.add(btn2);
        btn2.setBackground(Color.WHITE);
        btn2.setForeground(cusSkyBlue);
        btn2.setFocusable(false);

        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(0, 50, 390, 570);
        //panel2.setBackground(Color.red);
        regFrame.add(panel2);

        lab2 = new JLabel("USERNAME: ");
        lab2.setBounds(15, 25, 100, 15);
        lab2.setForeground(Color.BLACK);
        lab2.setFont(font);
        panel2.add(lab2);

        txt1 = new JTextField();
        txt1.setBounds(15, 50, 350, 35);
        txt1.setFont(inputFont);
        txt1.setBorder(border);
        txt1.setText("");
        panel2.add(txt1);

        lab3 = new JLabel("EMAIL: ");
        lab3.setBounds(15, 95, 100, 15);
        lab3.setForeground(Color.BLACK);
        lab3.setFont(font);
        panel2.add(lab3);

        txt2 = new JTextField();
        txt2.setBounds(15, 120, 350, 35);
        txt2.setFont(inputFont);
        txt2.setBorder(border);
        panel2.add(txt2);

        lab4 = new JLabel("PASSWORD: ");
        lab4.setBounds(15, 165, 100, 15);
        lab4.setForeground(Color.BLACK);
        lab4.setFont(font);
        panel2.add(lab4);

        txt3 = new JTextField();
        txt3.setBounds(15, 190, 350, 35);
        txt3.setFont(inputFont);
        txt3.setBorder(border);
        panel2.add(txt3);

        lab5 = new JLabel("CONFIRM PASSWORD: ");
        lab5.setBounds(15, 235, 200, 15);
        lab5.setForeground(Color.BLACK);
        lab5.setFont(font);
        panel2.add(lab5);

        txt4 = new JTextField();
        txt4.setBounds(15, 260, 350, 35);
        txt4.setFont(inputFont);
        txt4.setBorder(border);
        panel2.add(txt4);

        lab6 = new JLabel("Phone: ");
        lab6.setBounds(15, 305, 150, 15);
        lab6.setForeground(Color.BLACK);
        lab6.setFont(font);
        panel2.add(lab6);

        txt5 = new JTextField();
        txt5.setBounds(15, 325, 350, 35);
        txt5.setFont(inputFont);
        txt5.setBorder(border);
        panel2.add(txt5);

        lab7 = new JLabel("ADDRESS: ");
        lab7.setBounds(15, 375, 150, 15);
        lab7.setForeground(Color.BLACK);
        lab7.setFont(font);
        panel2.add(lab7);

        txt6 = new JTextField();
        txt6.setBounds(15, 405, 350, 35);
        txt6.setFont(inputFont);
        txt6.setBorder(border);
        panel2.add(txt6);
        
        lab8 = new JLabel("Occupation: ");
        lab8.setBounds(15, 455, 150, 15);
        lab8.setForeground(Color.BLACK);
        lab8.setFont(font);
        panel2.add(lab8);

        txt7 = new JTextField();
        txt7.setBounds(15, 485, 350, 35);
        txt7.setFont(inputFont);
        txt7.setBorder(border);
        panel2.add(txt7);

        panel3 = new JPanel();
        panel3.setLayout(null);
        panel3.setBounds(0, 620, 390, 60);
//        panel3.setBackground(Color.BLACK);
        regFrame.add(panel3);

        btn1 = new JButton("SUBMIT");
        btn1.addActionListener(this);
        btn1.setFont(font);
        btn1.setBounds(150, 0, 100, 30);
        panel3.add(btn1);
        btn1.setBackground(cusSkyBlue);
        btn1.setForeground(Color.WHITE);
        btn1.setFocusable(false);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            inputUser = txt1.getText();
            inputEmail = txt2.getText();
            inputPass = txt3.getText();
            inputConPass = txt4.getText();
            inputPhone = txt5.getText();
            inputAdd = txt6.getText();
            inputOcc = txt7.getText();
            String userNameRegex = "^[a-zA-Z]{3,10}$";
            String emailRegex = "^[a-z0-9]+@[a-z]+.[a-z]+$";
            String passRegex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@$]).*$";
            String mobileRegex = "^(\\+88)?01[2-9]\\d{8}$";

            if (!Pattern.matches(userNameRegex, inputUser)) {
                JOptionPane.showMessageDialog(null, "In Username only 3-10 character is allowed ");
            } else if (!Pattern.matches(emailRegex, inputEmail)) {
                JOptionPane.showMessageDialog(null, "Invalid email");
            } else if (!Pattern.matches(passRegex, inputPass)) {
                JOptionPane.showMessageDialog(null, "Invalid password");
            } else if (!inputPass.equals(inputConPass)) {
                JOptionPane.showMessageDialog(null, "Password doesn't match");
            } else if (!Pattern.matches(mobileRegex, inputPhone)) {
                JOptionPane.showMessageDialog(null, "Invalid phone number");
            } //                if(lenthCheck(inputUser)) {		
            //			JOptionPane.showMessageDialog(null, 
            //                    "Invalid Input.Username must have at least 8 characters",
            //                     "Validation Result", JOptionPane.ERROR_MESSAGE);
            //		}
            else {
                System.out.println(inputUser + " " + inputEmail + " " + inputPass + " " + inputPhone + " " + inputAdd);
                addToDatabase();
                regFrame.setVisible(false);
                new Login();
            }
        } else if (e.getSource() == btn2) {
            //regFrame.setVisible(false);
            regFrame.dispose();
            new Login();
        }
    }

    private boolean lenthCheck(String input) {
        return input.length() <= 7;
    }

    private void addToDatabase() {
        String url = "jdbc:sqlserver://tasdik-laptop\\sqlexpress;databaseName=JavaProject;encrypt=true;trustServerCertificate=true";
        String user = "tasdik";
        String password = "tasdik";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the Microsoft SQL Server");

            String createSql = "INSERT INTO ADMIN VALUES(?, ?, ?, ?, ?, ?)";

            //String deleteSql = "DELETE FROM STUDENTS WHERE ID = ?";
            PreparedStatement statement = connection.prepareStatement(createSql);

            statement.setString(1, inputUser);
            statement.setString(2, inputEmail);
            statement.setString(3, inputPass);
            statement.setString(4, inputPhone);
            statement.setString(5, inputAdd);
            statement.setString(6, inputOcc);
            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Registered successfully");
                JOptionPane.showMessageDialog(this, "Record registered successfully");
            }
//			else{
//				JOptionPane.showMessageDialog(this, "Record failed");
//			}
            connection.close();
        } catch (SQLException ex) {
            System.out.println("Oops, there's an error");
            ex.printStackTrace();
        }
    }

}
