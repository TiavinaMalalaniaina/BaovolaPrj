/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author tiavi
 */
public class DBConnection {
    private static String URL = "jdbc:postgresql://localhost:5432/Test";
    private static String USER = "postgres";
    private static String PASSWORD = "malalaniaina";
    private static String DRIVER = "org.postgresql.Driver";
    
    
//    
//    private DBConnection(String propertiesFile) throws ClassNotFoundException, SQLException {
//        Properties properties = new Properties();
//        try (FileInputStream input = new FileInputStream(propertiesFile)) {
//            properties.load(input);
//        } catch (IOException e) {
//        }
//        URL = properties.getProperty("database.url");
//        USER = properties.getProperty("database.user");
//        PASSWORD = properties.getProperty("database.password");
//        DRIVER = properties.getProperty("database.driver");
//        setting();
//    }

    
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
         try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            return connection;
        } catch (ClassNotFoundException e) {
            System.err.println("Le pilote PostgreSQL n'a pas été trouvé.");
            throw e;
        } catch (SQLException e) {
            System.err.println("Erreur lors de la connexion à la base de données PostgreSQL.");
            throw e;
        }
    }
}
