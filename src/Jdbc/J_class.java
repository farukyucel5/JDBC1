package Jdbc;

import java.awt.image.ShortLookupTable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class J_class {

    public static void main(String[] args) {
        Db_helper helper=new Db_helper();
        try {
            Connection connection= helper.getconnection();
            System.out.println("connected!!");
        } catch (SQLException e) {

            helper.showErrormessage(e);
        }

    }
}
