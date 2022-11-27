package Jdbc;

import java.awt.image.ShortLookupTable;
import java.sql.*;
import java.util.ArrayList;

public class J_class {

    public static void main(String[] args) {
        Db_helper helper=new Db_helper();
        Statement statement=null;
        ResultSet resultSet;

        try {
            Connection connection= helper.getconnection();
            statement=connection.createStatement();
            resultSet=statement.executeQuery("select title,description,release_year from sakila.film");

            ArrayList<Films> films=new ArrayList<>();

            while (resultSet.next()) {
                Films film_object=new Films(resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getString("release_year"));
                films.add(film_object);

            }

            System.out.println(films.size());

        } catch (SQLException e) {

            helper.showErrormessage(e);
        }

    }
}
