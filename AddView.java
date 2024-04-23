package project;

//import project.Add;
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

public class AddView extends JFrame implements ActionListener {

    JFrame addFrame;
    JPanel panel1, panel2, panel3;
    JLabel lab1, lab2, lab3, lab4, lab5;
    JTextField txt1, txt2, txt3, txt4;
    JButton btn1;
    String inputID;
    String inputName;
    String inputHsc;
    String inputDept;
    Color cusSkyBlue = new Color(123, 161, 201);
    Color cusYellow = new Color(214, 207, 64);
    Color cusRed = new Color(232, 115, 107);

    public AddView() {
        addFrame = new JFrame();
        addFrame.setSize(400, 470);
        addFrame.setDefaultCloseOperation(3);
        addFrame.setLayout(null);
        addFrame.setTitle("Add");
        addFrame.setLocationRelativeTo(null);
        addFrame.setResizable(false);
        addFrame.setVisible(true);
        Font font = new Font("Arial", Font.BOLD, 15);
        Font headerFont = new Font("Arial", Font.BOLD, 25);
        Font inputFont = new Font("Arial", Font.PLAIN, 15);
        Border border = BorderFactory.createLineBorder(cusSkyBlue, 2);

        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(0, 0, 390, 50);
        //panel1.setBackground(Color.red);
        addFrame.add(panel1);

        lab1 = new JLabel("Add Student");
        lab1.setBounds(120, 20, 200, 25);
        lab1.setForeground(Color.BLACK);
        lab1.setFont(headerFont);
        panel1.add(lab1);

        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(0, 50, 390, 300);
        //panel2.setBackground(Color.red);
        addFrame.add(panel2);

        lab2 = new JLabel("ID: ");
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

        lab3 = new JLabel("NAME: ");
        lab3.setBounds(15, 95, 100, 15);
        lab3.setForeground(Color.BLACK);
        lab3.setFont(font);
        panel2.add(lab3);

        txt2 = new JTextField();
        txt2.setBounds(15, 120, 350, 35);
        txt2.setFont(inputFont);
        txt2.setBorder(border);
        panel2.add(txt2);

        lab4 = new JLabel("HSC Result: (CGPA)");
        lab4.setBounds(15, 165, 200, 15);
        lab4.setForeground(Color.BLACK);
        lab4.setFont(font);
        panel2.add(lab4);

        txt3 = new JTextField();
        txt3.setBounds(15, 185, 350, 35);
        txt3.setFont(inputFont);
        txt3.setBorder(border);
        panel2.add(txt3);

        lab5 = new JLabel("Department: ");
        lab5.setBounds(15, 230, 200, 15);
        lab5.setForeground(Color.BLACK);
        lab5.setFont(font);
        panel2.add(lab5);

        txt4 = new JTextField();
        txt4.setBounds(15, 250, 350, 35);
        txt4.setFont(inputFont);
        txt4.setBorder(border);
        panel2.add(txt4);

        panel3 = new JPanel();
        panel3.setLayout(null);
        panel3.setBounds(0, 360, 390, 40);
        //panel3.setBackground(Color.BLACK);
        addFrame.add(panel3);

        btn1 = new JButton("ADD");
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
            inputName = txt2.getText();
            inputHsc = txt3.getText();
            inputDept = txt4.getText();
            System.out.println(inputID);
            addFrame.setVisible(false);
            addToDatabase();
            new Home();
        }
    }

    private void addToDatabase() {
        String url = "jdbc:sqlserver://tasdik-laptop\\sqlexpress;databaseName=JavaProject;encrypt=true;trustServerCertificate=true";
        String user = "tasdik";
        String password = "tasdik";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the Microsoft SQL Server");

            String createSql = "INSERT INTO STUDENTS VALUES(?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(createSql);

            statement.setString(1, inputID);
            statement.setString(2, inputName);
            statement.setString(3, inputHsc);
            statement.setString(4, inputDept);
            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Inserted successfully");
                JOptionPane.showMessageDialog(this, "Record inserted successfully");
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
