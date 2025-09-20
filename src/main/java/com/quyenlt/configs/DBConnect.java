package com.quyenlt.configs;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;

public class DBConnect {
    
    private static String DB_URL = "jdbc:mysql://localhost:3306/ltwebct2";
    private static String USER_NAME = "root";
    private static String PASSWORD = "03051008";
    private static Connection con;

    public static Connection getConnection() {
        con = null;
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            con = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    public static void main(String[] args) {
        Connection c = getConnection();
        if (c == null) {
            System.out.println("something wrong");
        } else {
            System.out.println("ok");
        }
    }
}