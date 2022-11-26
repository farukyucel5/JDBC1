package Jdbc;

import java.awt.image.ShortLookupTable;
import java.sql.*;

public class J_class {

    public static void main(String[] args) {
        Db_helper helper=new Db_helper();
        Statement statement=null;
        ResultSet resultSet;

        try {
            Connection connection= helper.getconnection();
            statement=connection.createStatement();
            resultSet=statement.executeQuery("select title,description,release_year from sakila.film");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("title"));
            }
        } catch (SQLException e) {

            helper.showErrormessage(e);
        }

    }
}
