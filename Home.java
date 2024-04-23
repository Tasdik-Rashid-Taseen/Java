package project;

import project.User;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class Home extends JFrame implements ActionListener {

    JFrame homeFrame;
    JPanel panel1, panel2, panel3, panel4;
    JLabel lab1, lab2, lab3, lab4, lab5, lab6, lab7, lab8, lab9, lab10, lab11, lab12, lab13;
    JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    JTable table;
    Color cusSkyBlue = new Color(123, 161, 201);
    Color cusYellow = new Color(214, 207, 64);
    Color cusRed = new Color(232, 115, 107);

    public Home() {
        homeFrame = new JFrame();
        homeFrame.setSize(850, 860);
        homeFrame.setDefaultCloseOperation(3);
        homeFrame.setLayout(null);
        homeFrame.setTitle("Home");
        homeFrame.setLocationRelativeTo(null);
        //    	homeFrame.setResizable(false);
        homeFrame.setVisible(true);
        Font font = new Font("Arial", Font.BOLD, 15);
        Font headerFont = new Font("Arial", Font.BOLD, 25);
        Font inputFont = new Font("Arial", Font.PLAIN, 15);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);

        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(0, 0, 850, 50);
        //panel1.setBackground(Color.red);
        homeFrame.add(panel1);

        lab1 = new JLabel("Student Database");
        lab1.setBounds(20, 20, 500, 25);
        lab1.setForeground(Color.BLACK);
        lab1.setFont(headerFont);
        panel1.add(lab1);

        btn1 = new JButton("Add");
        btn1.addActionListener(this);
        btn1.setFont(font);
        btn1.setBounds(500, 15, 100, 30);
        panel1.add(btn1);
        btn1.setBackground(Color.WHITE);
        btn1.setForeground(cusSkyBlue);
        btn1.setFocusable(false);

        btn2 = new JButton("Update");
        btn2.addActionListener(this);
        btn2.setFont(font);
        btn2.setBounds(610, 15, 100, 30);
        panel1.add(btn2);
        btn2.setBackground(Color.WHITE);
        btn2.setForeground(cusYellow);
        btn2.setFocusable(false);

        btn3 = new JButton("Delete");
        btn3.addActionListener(this);
        btn3.setFont(font);
        btn3.setBounds(720, 15, 100, 30);
        panel1.add(btn3);
        btn3.setBackground(Color.WHITE);
        btn3.setForeground(cusRed);
        btn3.setFocusable(false);

        panel2 = new JPanel(new BorderLayout());
        panel2.setBounds(20, 60, 800, 700);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("HSC Result");
        model.addColumn("Department");
        model.addColumn("Occupation");

        table = new JTable(model);
        table.setName("MyStudents");
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.getTableHeader().setReorderingAllowed(false);

        JScrollPane scrollPane = new JScrollPane(table);
        panel2.add(scrollPane, BorderLayout.CENTER);

        homeFrame.add(panel2);
        show_user();

        panel3 = new JPanel();
        panel3.setLayout(null);
        panel3.setBounds(0, 760, 850, 50);
        //panel3.setBackground(Color.red);
        homeFrame.add(panel3);

        btn4 = new JButton("Sign Out ->");
        btn4.addActionListener(this);
        btn4.setFont(font);
        btn4.setBounds(360, 15, 120, 30);
        panel3.add(btn4);
        btn4.setBackground(Color.WHITE);
        //btn4.setForeground(Color.WHITE);
        btn4.setFocusable(false);

    }

    public ArrayList<User> userList() {
        ArrayList<User> usersList = new ArrayList<>();

        String url = "jdbc:sqlserver://tasdik-laptop\\sqlexpress;databaseName=JavaProject;encrypt=true;trustServerCertificate=true";
        String user = "tasdik";
        String password = "tasdik";
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the Microsoft SQL Server");

            String readSql = "SELECT * FROM STUDENTS";

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(readSql);

            User usr;
            while (rs.next()) {
                usr = new User(rs.getString("id"), rs.getString("name"), rs.getString("hsc"), rs.getString("department"));
                usersList.add(usr);
            }
            connection.close();
        } catch (SQLException ex) {
            System.out.println("Oops, there's an error");
            ex.printStackTrace();
        }
        return usersList;
    }

    public void show_user() {
        ArrayList<User> list = userList();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        Object[] row = new Object[4];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getName();
            row[2] = list.get(i).getHsc();
            row[3] = list.get(i).getDept();
            model.addRow(row);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            homeFrame.dispose();
            new AddView();
        } else if (e.getSource() == btn2) {
            homeFrame.dispose();
            new UpdateView();
        } else if (e.getSource() == btn3) {
            homeFrame.dispose();
            new DeleteView();
        } else if (e.getSource() == btn4) {
            homeFrame.dispose();
            new Register();
        }
    }

    private static void main(String args[]) {
        SwingUtilities.invokeLater(() -> new Home());
    }

}
