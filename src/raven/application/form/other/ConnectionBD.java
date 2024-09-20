/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.application.form.other;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *
 * @author Zoky_liva
 */
public class ConnectionBD {
    Connection conn = null;
    public static Connection connect() throws FileNotFoundException, IOException{
        Properties props = new Properties();
        try (FileInputStream input = new FileInputStream("C:\\Users\\Zoky_liva\\Downloads\\Compressed\\flatlaf-dashboard-main\\config.properties")) {
            props.load(input);
            
            String url = props.getProperty("db.url");
            String username = props.getProperty("db.username");
            String password = props.getProperty("db.password");
            String driver = props.getProperty("db.driver");
            
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url,username,password);
            if(conn != null){
                System.out.println("connexion etablie avec la base Projet24");
            }else{
                System.out.println("Probleme de connexion");
            }
            return conn;
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        return null;
        }    
    }
}
