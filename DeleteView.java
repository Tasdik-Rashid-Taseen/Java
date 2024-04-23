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

public class DeleteView extends JFrame implements ActionListener {

    JFrame addFrame;
    JPanel panel1, panel2, panel3;
    JLabel lab1, lab2, lab3, lab4, lab5;
    JTextField txt1, txt2, txt3, txt4;
    JButton btn1;
    String inputID;
    Color cusSkyBlue = new Color(123, 161, 201);

    public DeleteView() {
        addFrame = new JFrame();
        addFrame.setSize(400, 290);
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

        lab1 = new JLabel("Delete Student");
        lab1.setBounds(120, 20, 200, 25);
        lab1.setForeground(Color.BLACK);
        lab1.setFont(headerFont);
        panel1.add(lab1);

        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(0, 50, 390, 120);
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

        panel3 = new JPanel();
        panel3.setLayout(null);
        panel3.setBounds(0, 170, 390, 30);
        //panel3.setBackground(Color.BLACK);
        addFrame.add(panel3);

        btn1 = new JButton("DELETE");
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
            int a = JOptionPane.showConfirmDialog(null, "Are you sure?");
            if (a == 0) {
                inputID = txt1.getText();
                System.out.println(inputID);
                addFrame.setVisible(false);
                addToDatabase();
                new Home();
            } else if (a == 1) {
                addFrame.setVisible(false);
            } else {
                addFrame.setVisible(false);
            }

        }
    }

    private void addToDatabase() {
        String url = "jdbc:sqlserver://tasdik-laptop\\sqlexpress;databaseName=JavaProject;encrypt=true;trustServerCertificate=true";
        String user = "tasdik";
        String password = "tasdik";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the Microsoft SQL Server");

            String deleteSql = "DELETE FROM STUDENTS WHERE ID = ?";

            PreparedStatement statement = connection.prepareStatement(deleteSql);

            statement.setString(1, inputID);

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Deleted successfully");
                JOptionPane.showMessageDialog(this, "Record deleted successfully");
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
