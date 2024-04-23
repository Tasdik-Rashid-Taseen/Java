/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tasdi
 */
public class DBConnect {

    private Connection connection;
    private Statement st;

    public DBConnect() {
        String url = "jdbc:sqlserver://tasdik-laptop\\sqlexpress;databaseName=JavaProject;encrypt=true;trustServerCertificate=true";
        String user = "tasdik";
        String password = "tasdik";
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the Microsoft SQL Server");

            st = connection.createStatement();

            connection.close();
        } catch (SQLException ex) {
            System.out.println("Oops, there's an error");
            ex.printStackTrace();
        }
    }

    public void Read(String readSql) {

    }
}
