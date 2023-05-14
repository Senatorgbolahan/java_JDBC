package Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHandler extends Config {  // We inherit the config. The config file contains variables used for login
    
    Connection dbConnection; 


    // getDBConnection() returns the dbConnection for connection
    
    public Connection getDBConnection() throws ClassNotFoundException, SQLException{   

        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        Class.forName("com.mysql.jdbc.Driver");    // mysql driver link
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);  // call the variables in config file
        
        return dbConnection;
    }
}
