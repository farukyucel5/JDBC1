package Jdbc;

import java.awt.image.ShortLookupTable;
import java.sql.*;
import java.util.ArrayList;

public class J_class {

    public static void main(String[] args) {
        Db_helper helper=new Db_helper();
        PreparedStatement statement=null;

        selectdemo();//eklenmeden önce


        try {
            Connection connection= helper.getconnection();
            String sql="insert into sakila.film (title,description,release_year,language_id) values (?,?,?,?)";
            statement=connection.prepareStatement(sql);
            statement.setString(1,"Pieta");
            statement.setString(2,"revenge");
            statement.setString(3,"2017");
            statement.setString(4,"2");
            statement.executeUpdate();
            System.out.println("it's just been registered");




        } catch (SQLException e) {

            helper.showErrormessage(e);
        }

        selectdemo();//eklenmeden sonra

    }

   public static void selectdemo()
    {
        Db_helper helper=new Db_helper();
        Statement statement=null;
        ResultSet resultSet;

        try {
            Connection connection= helper.getconnection();
            statement=connection.createStatement();
            resultSet=statement.executeQuery("select title,description,release_year,language_id from sakila.film");

            ArrayList<Films> films=new ArrayList<>();

            while (resultSet.next()) {
                Films film_object=new Films(resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getString("release_year"),
                        resultSet.getString("language_id"));
                films.add(film_object);

            }

            System.out.println(films.size());

        } catch (SQLException e) {

            helper.showErrormessage(e);
        }

    }
}
