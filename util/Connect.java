package org.davidsal.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    private static String url = "jdbc:mysql://localhost:3306/tareabd?serverTimezone=America/Mexico_City";

    private static String username = "root";
    private static String password = "root";
    private static Connection conn;

    public static Connection getConn(){
       if(conn == null){
           try {
               conn = DriverManager.getConnection(url, username, password);

           } catch (SQLException e) {
               throw new RuntimeException(e);
           }

       }
       
           return conn;

    }

}
