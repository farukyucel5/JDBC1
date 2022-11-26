package Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db_helper {
    private String username="root";
    private String password="Faruk12068036";

    private String dbUrl="jdbc:mysql://localhost:3306/sakila";


    public Connection getconnection() throws SQLException {
        return DriverManager.getConnection(dbUrl,username,password);
    }

    public void showErrormessage(SQLException exception) {
        System.out.println("Error: "+exception.getMessage());
        System.out.println("Error: "+exception.getErrorCode());
    }
}
