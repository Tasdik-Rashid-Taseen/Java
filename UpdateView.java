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
public class UpdateView extends JFrame implements ActionListener {

    JFrame updateFrame, optionFrame, nameFrame, hscFrame, deptFrame, allFrame;
    JPanel panel1, panel2, panel3;
    JLabel lab1, lab2, lab3, lab4;
    JTextField txt1, txt2, txt3, txt4, txt5, txt6, txt7;
    JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    String inputID, inputName, inputHsc, inputDept;
    Color cusSkyBlue = new Color(123, 161, 201);
    Color cusYellow = new Color(214, 207, 64);
    Color cusRed = new Color(232, 115, 107);

    public UpdateView() {
        updateFrame = new JFrame();
        updateFrame.setSize(400, 280);
        updateFrame.setDefaultCloseOperation(3);
        updateFrame.setLayout(null);
        updateFrame.setTitle("Update");
        updateFrame.setLocationRelativeTo(null);
        updateFrame.setResizable(false);
        updateFrame.setVisible(true);
        Font font = new Font("Arial", Font.BOLD, 15);
        Font headerFont = new Font("Arial", Font.BOLD, 25);
        Font inputFont = new Font("Arial", Font.PLAIN, 15);
        Border border = BorderFactory.createLineBorder(cusSkyBlue, 2);

        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(0, 0, 390, 50);
        //panel1.setBackground(Color.red);
        updateFrame.add(panel1);

        lab1 = new JLabel("Update");
        lab1.setBounds(160, 20, 100, 25);
        lab1.setForeground(Color.BLACK);
        lab1.setFont(headerFont);
        panel1.add(lab1);

        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(0, 50, 390, 110);
        //panel2.setBackground(Color.red);
        updateFrame.add(panel2);

        lab2 = new JLabel("ID: ");
        lab2.setBounds(15, 25, 100, 15);
        lab2.setForeground(Color.BLACK);
        lab2.setFont(font);
        panel2.add(lab2);

        txt1 = new JTextField();
        txt1.setBounds(15, 50, 350, 35);
        txt1.setFont(inputFont);
        txt1.setBorder(border);
        panel2.add(txt1);

        panel3 = new JPanel();
        panel3.setLayout(null);
        panel3.setBounds(0, 170, 390, 60);
//        panel3.setBackground(Color.BLACK);
        updateFrame.add(panel3);

        btn1 = new JButton("NEXT");
        btn1.addActionListener(this);
        btn1.setFont(font);
        btn1.setBounds(150, 0, 100, 30);
        panel3.add(btn1);
        btn1.setBackground(Color.WHITE);
        btn1.setForeground(cusSkyBlue);
        btn1.setFocusable(false);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            inputID = txt1.getText();
            if (!inputID.equals("")) {
                updateFrame.dispose();
                optionUpdate(inputID);
            } else {
                JOptionPane.showMessageDialog(this, "ID field can't be empty");
            }

        } else if (e.getSource() == btn2) {
            optionFrame.dispose();
            nameUpdate(inputID);

        } else if (e.getSource() == btn3) {
            optionFrame.dispose();
            hscUpdate(inputID);

        } else if (e.getSource() == btn4) {
            optionFrame.dispose();
            departmentUpdate(inputID);
        } else if (e.getSource() == btn5) {
            optionFrame.dispose();
            allUpdate(inputID);
        } else if (e.getSource() == btn6) {
            inputName = txt2.getText();
            if (!inputName.equals("")) {
                nameFrame.dispose();
                nameUpdateInDatabase(inputID, inputName);
                new Home();
            } else {
                JOptionPane.showMessageDialog(this, "Name field can't be empty");
            }
        } else if (e.getSource() == btn7) {
            inputHsc = txt3.getText();
            if (!inputHsc.equals("")) {
                double formattedDoubleHsc = Double.parseDouble(inputHsc);
                String formattedHsc = String.format("%.2f", formattedDoubleHsc);
                double inputHscDouble = Double.parseDouble(formattedHsc);
                hscFrame.dispose();
                hscUpdateInDatabase(inputID, inputHscDouble);
                new Home();
            } else {
                JOptionPane.showMessageDialog(this, "HSC field can't be empty");
            }
        } else if (e.getSource() == btn8) {
            inputDept = txt4.getText();
            if (!inputDept.equals("")) {
                deptFrame.dispose();
                departmentUpdateInDatabase(inputID, inputDept);
                new Home();
            } else {
                JOptionPane.showMessageDialog(this, "HSC field can't be empty");
            }
        } else if (e.getSource() == btn9) {
            inputName = txt5.getText();
            inputHsc = txt6.getText();
            double formattedDoubleHsc = Double.parseDouble(inputHsc);
            String formattedHsc = String.format("%.2f", formattedDoubleHsc);
            double inputHscDouble = Double.parseDouble(formattedHsc);
            inputDept = txt7.getText();
            if (!inputName.equals("") || !inputHsc.equals("") || !inputDept.equals("")) {
                allFrame.dispose();
                allUpdateInDatabase(inputID, inputName, inputHscDouble, inputDept);
                new Home();
            } else {
                JOptionPane.showMessageDialog(this, "Any field can't be empty");
            }
        }

    }

    private void optionUpdate(String inputID) {
        optionFrame = new JFrame();
        optionFrame.setSize(450, 180);
        optionFrame.setDefaultCloseOperation(3);
        optionFrame.setLayout(null);
        optionFrame.setTitle("Update Option");
        optionFrame.setLocationRelativeTo(null);
        optionFrame.setResizable(false);
        optionFrame.setVisible(true);
        Font font = new Font("Arial", Font.BOLD, 15);
        Font headerFont = new Font("Arial", Font.BOLD, 25);
        Font inputFont = new Font("Arial", Font.PLAIN, 15);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);

        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(0, 0, 390, 50);
        //panel1.setBackground(Color.red);
        optionFrame.add(panel1);

        lab1 = new JLabel("What you want to update?");
        lab1.setBounds(15, 10, 300, 25);
        lab1.setForeground(Color.BLACK);
        lab1.setFont(font);
        panel1.add(lab1);

        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(0, 50, 450, 110);
        //panel2.setBackground(Color.red);
        optionFrame.add(panel2);

        btn2 = new JButton("Name");
        btn2.addActionListener(this);
        btn2.setFont(font);
        btn2.setBounds(15, 0, 80, 30);
        panel2.add(btn2);
        btn2.setBackground(Color.WHITE);
        btn2.setForeground(cusSkyBlue);
        btn2.setFocusable(false);

        btn3 = new JButton("HSC");
        btn3.addActionListener(this);
        btn3.setFont(font);
        btn3.setBounds(105, 0, 80, 30);
        panel2.add(btn3);
        btn3.setBackground(Color.WHITE);
        btn3.setForeground(cusSkyBlue);
        btn3.setFocusable(false);

        btn4 = new JButton("Department");
        btn4.addActionListener(this);
        btn4.setFont(font);
        btn4.setBounds(195, 0, 130, 30);
        panel2.add(btn4);
        btn4.setBackground(Color.WHITE);
        btn4.setForeground(cusSkyBlue);
        btn4.setFocusable(false);

        btn5 = new JButton("All");
        btn5.addActionListener(this);
        btn5.setFont(font);
        btn5.setBounds(335, 0, 60, 30);
        panel2.add(btn5);
        btn5.setBackground(Color.WHITE);
        btn5.setForeground(cusSkyBlue);
        btn5.setFocusable(false);
    }

    private void nameUpdate(String inputID) {
        nameFrame = new JFrame();
        nameFrame.setSize(400, 280);
        nameFrame.setDefaultCloseOperation(3);
        nameFrame.setLayout(null);
        nameFrame.setTitle("Update Name");
        nameFrame.setLocationRelativeTo(null);
        nameFrame.setResizable(false);
        nameFrame.setVisible(true);
        Font font = new Font("Arial", Font.BOLD, 15);
        Font headerFont = new Font("Arial", Font.BOLD, 25);
        Font inputFont = new Font("Arial", Font.PLAIN, 15);
        Border border = BorderFactory.createLineBorder(cusSkyBlue, 2);

        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(0, 0, 390, 50);
        //panel1.setBackground(Color.red);
        nameFrame.add(panel1);

        lab1 = new JLabel("Update Name");
        lab1.setBounds(120, 20, 160, 25);
        lab1.setForeground(cusYellow);
        lab1.setFont(headerFont);
        panel1.add(lab1);

        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(0, 50, 390, 110);
        //panel2.setBackground(Color.red);
        nameFrame.add(panel2);

        lab2 = new JLabel("NAME: ");
        lab2.setBounds(15, 25, 100, 15);
        lab2.setForeground(Color.BLACK);
        lab2.setFont(font);
        panel2.add(lab2);

        txt2 = new JTextField();
        txt2.setBounds(15, 50, 350, 35);
        txt2.setFont(inputFont);
        txt2.setBorder(border);
        panel2.add(txt2);

        panel3 = new JPanel();
        panel3.setLayout(null);
        panel3.setBounds(0, 170, 390, 60);
//        panel3.setBackground(Color.BLACK);
        nameFrame.add(panel3);

        btn6 = new JButton("UPDATE");
        btn6.addActionListener(this);
        btn6.setFont(font);
        btn6.setBounds(150, 0, 100, 30);
        panel3.add(btn6);
        btn6.setBackground(Color.WHITE);
        btn6.setForeground(cusSkyBlue);
        btn6.setFocusable(false);
    }

    private void nameUpdateInDatabase(String inputID, String inputName) {
        String url = "jdbc:sqlserver://tasdik-laptop\\sqlexpress;databaseName=JavaProject;encrypt=true;trustServerCertificate=true";
        String user = "tasdik";
        String password = "tasdik";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the Microsoft SQL Server");

            String updateNameSql = "UPDATE  STUDENTS SET [name] = ? where id = ?";

            PreparedStatement statement = connection.prepareStatement(updateNameSql);

            statement.setString(1, inputName);

            statement.setString(2, inputID);

            int rows = statement.executeUpdate();
            

            if (rows > 0) {
                System.out.println("Updated successfully");
                JOptionPane.showMessageDialog(this, "Record updated successfully");
            } else {
                System.out.println("Update unsuccessfull");
                JOptionPane.showMessageDialog(this, "No data found with " + inputID + " ID");
            }

            connection.close();
        } catch (SQLException ex) {
            System.out.println("Oops, there's an error");
            ex.printStackTrace();
        }
    }

    private void hscUpdate(String inputID) {
        hscFrame = new JFrame();
        hscFrame.setSize(400, 280);
        hscFrame.setDefaultCloseOperation(3);
        hscFrame.setLayout(null);
        hscFrame.setTitle("Update Name");
        hscFrame.setLocationRelativeTo(null);
        hscFrame.setResizable(false);
        hscFrame.setVisible(true);
        Font font = new Font("Arial", Font.BOLD, 15);
        Font headerFont = new Font("Arial", Font.BOLD, 25);
        Font inputFont = new Font("Arial", Font.PLAIN, 15);
        Border border = BorderFactory.createLineBorder(cusSkyBlue, 2);

        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(0, 0, 390, 50);
        //panel1.setBackground(Color.red);
        hscFrame.add(panel1);

        lab1 = new JLabel("Update HSC result");
        lab1.setBounds(90, 20, 260, 25);
        lab1.setForeground(cusYellow);
        lab1.setFont(headerFont);
        panel1.add(lab1);

        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(0, 50, 390, 110);
        //panel2.setBackground(Color.red);
        hscFrame.add(panel2);

        lab2 = new JLabel("HSC Result: ");
        lab2.setBounds(15, 25, 180, 15);
        lab2.setForeground(Color.BLACK);
        lab2.setFont(font);
        panel2.add(lab2);

        txt3 = new JTextField();
        txt3.setBounds(15, 50, 350, 35);
        txt3.setFont(inputFont);
        txt3.setBorder(border);
        panel2.add(txt3);

        panel3 = new JPanel();
        panel3.setLayout(null);
        panel3.setBounds(0, 170, 390, 60);
//        panel3.setBackground(Color.BLACK);
        hscFrame.add(panel3);

        btn7 = new JButton("UPDATE");
        btn7.addActionListener(this);
        btn7.setFont(font);
        btn7.setBounds(150, 0, 100, 30);
        panel3.add(btn7);
        btn7.setBackground(Color.WHITE);
        btn7.setForeground(cusSkyBlue);
        btn7.setFocusable(false);
    }

    private void hscUpdateInDatabase(String inputID, Double inputHscDouble) {
        String url = "jdbc:sqlserver://tasdik-laptop\\sqlexpress;databaseName=JavaProject;encrypt=true;trustServerCertificate=true";
        String user = "tasdik";
        String password = "tasdik";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the Microsoft SQL Server");

            String updateNameSql = "UPDATE  STUDENTS SET [hsc] = ? where id = ?";

            PreparedStatement statement = connection.prepareStatement(updateNameSql);

            statement.setDouble(1, inputHscDouble);

            statement.setString(2, inputID);

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Updated successfully");
                JOptionPane.showMessageDialog(this, "Record updated successfully");
            } else {
                System.out.println("Update unsuccessfull");
                JOptionPane.showMessageDialog(this, "No data found with " + inputID + " ID");
            }

            connection.close();
        } catch (SQLException ex) {
            System.out.println("Oops, there's an error");
            ex.printStackTrace();
        }
    }

    private void departmentUpdate(String inputID) {
        deptFrame = new JFrame();
        deptFrame.setSize(400, 280);
        deptFrame.setDefaultCloseOperation(3);
        deptFrame.setLayout(null);
        deptFrame.setTitle("Update Name");
        deptFrame.setLocationRelativeTo(null);
        deptFrame.setResizable(false);
        deptFrame.setVisible(true);
        Font font = new Font("Arial", Font.BOLD, 15);
        Font headerFont = new Font("Arial", Font.BOLD, 25);
        Font inputFont = new Font("Arial", Font.PLAIN, 15);
        Border border = BorderFactory.createLineBorder(cusSkyBlue, 2);

        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(0, 0, 390, 50);
        //panel1.setBackground(Color.red);
        deptFrame.add(panel1);

        lab1 = new JLabel("Update Department");
        lab1.setBounds(80, 20, 250, 25);
        lab1.setForeground(cusYellow);
        lab1.setFont(headerFont);
        panel1.add(lab1);

        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(0, 50, 390, 110);
        //panel2.setBackground(Color.red);
        deptFrame.add(panel2);

        lab2 = new JLabel("DEPARTMENT: ");
        lab2.setBounds(15, 25, 140, 15);
        lab2.setForeground(Color.BLACK);
        lab2.setFont(font);
        panel2.add(lab2);

        txt4 = new JTextField();
        txt4.setBounds(15, 50, 350, 35);
        txt4.setFont(inputFont);
        txt4.setBorder(border);
        panel2.add(txt4);

        panel3 = new JPanel();
        panel3.setLayout(null);
        panel3.setBounds(0, 170, 390, 60);
//        panel3.setBackground(Color.BLACK);
        deptFrame.add(panel3);

        btn8 = new JButton("UPDATE");
        btn8.addActionListener(this);
        btn8.setFont(font);
        btn8.setBounds(150, 0, 100, 30);
        panel3.add(btn8);
        btn8.setBackground(Color.WHITE);
        btn8.setForeground(cusSkyBlue);
        btn8.setFocusable(false);
    }

    private void departmentUpdateInDatabase(String inputID, String inputDept) {
        String url = "jdbc:sqlserver://tasdik-laptop\\sqlexpress;databaseName=JavaProject;encrypt=true;trustServerCertificate=true";
        String user = "tasdik";
        String password = "tasdik";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the Microsoft SQL Server");

            String updateNameSql = "UPDATE  STUDENTS SET department = ? where id = ?";

            PreparedStatement statement = connection.prepareStatement(updateNameSql);

            statement.setString(1, inputDept);

            statement.setString(2, inputID);

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Updated successfully");
                JOptionPane.showMessageDialog(this, "Record updated successfully");
            } else {
                System.out.println("Update unsuccessfull");
                JOptionPane.showMessageDialog(this, "No data found with " + inputID + " ID");
            }

            connection.close();
        } catch (SQLException ex) {
            System.out.println("Oops, there's an error");
            ex.printStackTrace();
        }
    }

    private void allUpdate(String inputID) {
        allFrame = new JFrame();
        allFrame.setSize(400, 400);
        allFrame.setDefaultCloseOperation(3);
        allFrame.setLayout(null);
        allFrame.setTitle("All Update");
        allFrame.setLocationRelativeTo(null);
        allFrame.setResizable(false);
        allFrame.setVisible(true);
        Font font = new Font("Arial", Font.BOLD, 15);
        Font headerFont = new Font("Arial", Font.BOLD, 25);
        Font inputFont = new Font("Arial", Font.PLAIN, 15);
        Border border = BorderFactory.createLineBorder(cusSkyBlue, 2);

        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(0, 0, 390, 50);
        //panel1.setBackground(Color.red);
        allFrame.add(panel1);

        lab1 = new JLabel("Update All");
        lab1.setBounds(130, 20, 130, 25);
        lab1.setForeground(cusYellow);
        lab1.setFont(headerFont);
        panel1.add(lab1);

        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(0, 50, 390, 260);
        //panel2.setBackground(Color.red);
        allFrame.add(panel2);

        lab2 = new JLabel("NAME: ");
        lab2.setBounds(15, 25, 100, 15);
        lab2.setForeground(Color.BLACK);
        lab2.setFont(font);
        panel2.add(lab2);

        txt5 = new JTextField();
        txt5.setBounds(15, 50, 350, 35);
        txt5.setFont(inputFont);
        txt5.setBorder(border);
        txt5.setText("");
        panel2.add(txt5);

        lab3 = new JLabel("HSC: ");
        lab3.setBounds(15, 95, 100, 15);
        lab3.setForeground(Color.BLACK);
        lab3.setFont(font);
        panel2.add(lab3);

        txt6 = new JTextField();
        txt6.setBounds(15, 120, 350, 35);
        txt6.setFont(inputFont);
        txt6.setBorder(border);
        panel2.add(txt6);

        lab4 = new JLabel("DEPARTMENT: ");
        lab4.setBounds(15, 165, 180, 15);
        lab4.setForeground(Color.BLACK);
        lab4.setFont(font);
        panel2.add(lab4);

        txt7 = new JTextField();
        txt7.setBounds(15, 190, 350, 35);
        txt7.setFont(inputFont);
        txt7.setBorder(border);
        panel2.add(txt7);

        panel3 = new JPanel();
        panel3.setLayout(null);
        panel3.setBounds(0, 310, 390, 60);
//        panel3.setBackground(Color.BLACK);
        allFrame.add(panel3);

        btn9 = new JButton("UPDATE");
        btn9.addActionListener(this);
        btn9.setFont(font);
        btn9.setBounds(150, 0, 100, 30);
        panel3.add(btn9);
        btn9.setBackground(Color.WHITE);
        btn9.setForeground(cusSkyBlue);
        btn9.setFocusable(false);
    }

    private void allUpdateInDatabase(String inputID, String inputName, Double inputHscDouble, String inputDept) {
        String url = "jdbc:sqlserver://tasdik-laptop\\sqlexpress;databaseName=JavaProject;encrypt=true;trustServerCertificate=true";
        String user = "tasdik";
        String password = "tasdik";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the Microsoft SQL Server");

            String updateNameSql = "UPDATE  STUDENTS SET name = ? , hsc = ? , department = ? where id = ?";

            PreparedStatement statement = connection.prepareStatement(updateNameSql);

            statement.setString(1, inputName);
            statement.setDouble(2, inputHscDouble);
            statement.setString(3, inputDept);
            statement.setString(4, inputID);

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Updated successfully");
                JOptionPane.showMessageDialog(this, "Record updated successfully");
            } else {
                System.out.println("Update unsuccessfull");
                JOptionPane.showMessageDialog(this, "No data found with " + inputID + " ID");
            }

            connection.close();
        } catch (SQLException ex) {
            System.out.println("Oops, there's an error");
            ex.printStackTrace();
        }
    }
}
