package project;

import project.Home;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.border.Border;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {

    JFrame loginFrame;
    JPanel panel1, panel2, panel3;
    JLabel lab1, lab2, lab3, lab4;
    JTextField txt1, txt2;
    JButton btn1, btn2;
    Color cusSkyBlue = new Color(123, 161, 201);

    public Login() {
        loginFrame = new JFrame();
        loginFrame.setSize(400, 400);
        loginFrame.setDefaultCloseOperation(3);
        loginFrame.setLayout(null);
        loginFrame.setTitle("Login");
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setResizable(false);
        loginFrame.setVisible(true);
        Font font = new Font("Arial", Font.BOLD, 15);
        Font headerFont = new Font("Arial", Font.BOLD, 25);
        Font inputFont = new Font("Arial", Font.PLAIN, 15);
        Border border = BorderFactory.createLineBorder(cusSkyBlue, 2);

        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(0, 0, 390, 50);
        //panel1.setBackground(Color.red);
        loginFrame.add(panel1);

        lab1 = new JLabel("Login");
        lab1.setBounds(15, 20, 100, 25);
        lab1.setForeground(Color.BLACK);
        lab1.setFont(headerFont);
        panel1.add(lab1);

        btn2 = new JButton("REGISTER");
        btn2.addActionListener(this);
        btn2.setFont(font);
        btn2.setBounds(250, 15, 120, 30);
        panel1.add(btn2);
        btn2.setBackground(Color.WHITE);
        btn2.setForeground(cusSkyBlue);
        btn2.setFocusable(false);

        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(0, 50, 390, 210);
        //panel2.setBackground(Color.red);
        loginFrame.add(panel2);

        lab2 = new JLabel("EMAIL: ");
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

        lab3 = new JLabel("PASSWORD: ");
        lab3.setBounds(15, 95, 100, 15);
        lab3.setForeground(Color.BLACK);
        lab3.setFont(font);
        panel2.add(lab3);

        txt2 = new JTextField();
        txt2.setBounds(15, 120, 350, 35);
        txt2.setFont(inputFont);
        txt2.setBorder(border);
        panel2.add(txt2);

        panel3 = new JPanel();
        panel3.setLayout(null);
        panel3.setBounds(0, 260, 390, 60);
//        panel3.setBackground(Color.BLACK);
        loginFrame.add(panel3);

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
            checkInDatabase();
        } else if (e.getSource() == btn2) {
            loginFrame.dispose();
            new Register();
        }
    }

    private void checkInDatabase() {
        String url = "jdbc:sqlserver://tasdik-laptop\\sqlexpress;databaseName=JavaProject;encrypt=true;trustServerCertificate=true";
        String user = "tasdik";
        String password = "tasdik";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the Microsoft SQL Server");

            String inputEmail = txt1.getText();
            String inputPass = txt2.getText();

            String readSql = "SELECT * FROM ADMIN";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(readSql);
            int flag = 0;
            while (rs.next()) {
                String tableEmail = rs.getString(2);
                String tablePass = rs.getString(3);
                if (inputEmail.equals(tableEmail) && inputPass.equals(tablePass)) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) {
                loginFrame.dispose();
                new Home();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid email or password");
            }

            connection.close();
        } catch (SQLException ex) {
            System.out.println("Oops, there's an error");
            ex.printStackTrace();
        }
    }

    private boolean lenthCheck(String input) {
        return input.length() <= 7;
    }

}
