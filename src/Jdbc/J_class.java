package Jdbc;

import java.awt.image.ShortLookupTable;
import java.sql.*;
import java.util.ArrayList;

public class J_class {

    public static void main(String[] args) {

        insert_data("Pieta","revenge",2016,3);

        Films film=new Films("Pieta","revenge","2016","3");

        String title=film.getTitle();

        delete(title);





    }

    public static void delete(String title)
    {
        Db_helper helper=new Db_helper();
        PreparedStatement statement=null;

        selectdemo();//silinmeden önce


        try {
            Connection connection= helper.getconnection();
            String sql="delete from sakila.film where title=?;";
            statement=connection.prepareStatement(sql);
            statement.setString(1,title);
            statement.executeUpdate();
            System.out.println("The registration has just deleted");

        } catch (SQLException e) {

            helper.showErrormessage(e);
        }

        selectdemo();//silinmeden sonra
    }

    public static void insert_data(String name,String description,int year,int language_id)
    {
        Db_helper helper=new Db_helper();
        PreparedStatement statement=null;

        selectdemo();//eklenmeden önce


        try {
            Connection connection= helper.getconnection();
            String sql="insert into sakila.film (title,description,release_year,language_id) values (?,?,?,?)";
            statement=connection.prepareStatement(sql);
            statement.setString(1,name);
            statement.setString(2,description);
            statement.setInt(3,year);
            statement.setInt(4,language_id);
            statement.executeUpdate();
            System.out.println("it's just been registered");




        } catch (SQLException e) {

            helper.showErrormessage(e);
        }

        selectdemo();//eklenmeden sonra

    }

    public static void update()
    {
        Db_helper helper=new Db_helper();
        PreparedStatement statement=null;
        PreparedStatement statement1=null;
        PreparedStatement statement2=null;

        selectdemo();//eklenmeden önce


        try {
            Connection connection= helper.getconnection();
            String sql="update sakila.film set description= 'impressive outstanding drama' where film_id='1012';";
            statement=connection.prepareStatement(sql);
            statement.executeUpdate();
            System.out.println("The description of the film has just updated!!");
            String sql1="update sakila.film set release_year=2016 where film_id='1012';";
            statement1=connection.prepareStatement(sql1);
            statement1.executeUpdate();
            System.out.println("The release year of the film has just updated!!");
            String sql2="update sakila.film set release_year=2018,description='captivating revenge' where film_id=?;";
            statement2=connection.prepareStatement(sql2);
            statement2.setInt(1,1012);
            statement2.executeUpdate();

            System.out.println("The last update has just uploaded to the database");




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
