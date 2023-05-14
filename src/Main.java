
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Helper.DBHandler;


public class Main {

    static private DBHandler dbHandler;
    static private Connection conn;
    static private PreparedStatement preparedStatement;
    static private ResultSet resultSet;


    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
      dbHandler = new DBHandler();
      conn = dbHandler.getDBConnection();
      
       //  writeToDB();
       //  readFromDB();
       //  updateDB("Henry", "Fatola", "Fatty", "21 Abiodun Street ketu", 23, 4);
         deleteUser(3);

    }

    public static void writeToDB() throws SQLException{
        String insert = "INSERT INTO users(firstname,lastname,usernam,address,age)" + "VALUES(?,?,?,?,?)";
      
        preparedStatement = conn.prepareStatement(insert);
        preparedStatement.setString(1, "Adebimpe");
        preparedStatement.setString(2, "Precious");
        preparedStatement.setString(3, "Mariam");
        preparedStatement.setString(4, "No 19 Kumuyi Street Mushin, Lagos");
        preparedStatement.setInt(5, 23);
        preparedStatement.executeUpdate();
  
    }

    // read record from Database
    public static void readFromDB() throws SQLException{

        String query = "SELECT * from users";
        preparedStatement = conn.prepareStatement(query);

        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.println("Names: " + resultSet.getString("usernam") + 
                " " + resultSet.getString("lastname") +
                " " + resultSet.getInt("age")
            );
        }
    }

    
    public static void updateDB(String firstname, String lastname, String usernam, String address, int age, int id){

        String query = "UPDATE users SET firstname = ?, lastname = ?, usernam = ?, address = ?, age = ?" + " where userid = ?";

        try {
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, firstname);
            preparedStatement.setString(2, lastname);
            preparedStatement.setString(3, usernam);
            preparedStatement.setString(4, address);
            preparedStatement.setInt(5, age);
            preparedStatement.setInt(6, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void deleteUser(int id){
        String query = "DELETE from users where userid = ?";
        // String query = "DELETE from users" + " where userid = ?";

        try {
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
