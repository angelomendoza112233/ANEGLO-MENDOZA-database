
package javaapplication3data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JavaApplication3data {
    
    //Connection Method to SQLITE
public static Connection connectDB() {
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC"); // Load the SQLite JDBC driver
            con = DriverManager.getConnection("jdbc:sqlite:database.db"); // Establish connection
            System.out.println("Connection Successful");
        } catch (Exception e) {
            System.out.println("Connection Failed: " + e);
        }
        return con;
    }

    public static void main(String[] args) {
        Scanner sc =new Scanner (System.in);
        System.out.println("enter student id");
        int id =sc .nextInt();
        System.out.println("enter frist name: ");
        String fn = sc.next();
        System.out.println("enter last name: ");
        String ln = sc.next();
        System.out.println("enter email: ");
        String em = sc.next();
        System.out.println("enter status : ");
        String s = sc.next();
        
        String sql = "INSERT INTO Students (s_id, s_fname, s_lname, s_email, s_status)VALUES (?,?,?,?,?)" ; 
        try {
        Connection con =connectDB();
        PreparedStatement pst=con.prepareStatement(sql);
        pst.setInt(1,id);
        pst.setString(2,fn);
        pst.setString(3,ln);
        pst.setString(4,em);
        pst.setString(5,s);
        pst.executeUpdate();
        System.out.println("inserted successfully");
        }catch (SQLException ex){
        
        System.out.println("Connection error"+ex.getMessage());
        };
                
        
        
        
        }
        
        
        
        
    }
    

