package Datalink;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Domain.Barbog;
import Domain.Medlem;


public class DB_Connector  {

        private Connection conn; 
        private ResultSet rs; 
        private String DATABASE_USR = "root";
        private String DATABASE_PWD = "";
                
        private String JDCB_DRIVER = "com.mysql.jdbc.Driver";
        private String DATABASE_URL = "jdbc:mysql://localhost:3306/borupclub";
        
        private static DB_Connector database;
        
        private DB_Connector() { // Private constructor to prevent outside instantiation.. Singleton
                try {
                        
                        Class.forName(JDCB_DRIVER);
                
                        conn = DriverManager.getConnection(DATABASE_URL, DATABASE_USR, DATABASE_PWD);
        
                        System.out.println("Connected to database,, YEEEAHHHH");
                } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                        System.out.println("Internal error");
                } catch (SQLException e) {
                        e.printStackTrace();
                        System.out.println("Database error");
                }
        }  
        
//      Returns the singleton instance of the DB class; instantiates it if it isn't: 
        public static DB_Connector getInstance() { 
                if (database == null){
                        database = new DB_Connector();
                }
                return database;
        }

        public void opretMedlem(Medlem medlem) {
                
                try {
                	String sql = "INSERT INTO medlemmer VALUES(" + medlem.toString() + ");";
                	System.out.println(sql);
            		conn.createStatement().executeUpdate(sql);
                } catch (SQLException e) {
                        e.printStackTrace();
                }
        }
        
        public void opretBarbog(Barbog barbog){
        	try{
        		String sql = "INSERT INTO barbog VALUES(" + barbog.toString() + ");";
        		System.out.println(sql);
        		conn.createStatement().executeUpdate(sql);
        	} catch (SQLException e){
        		e.printStackTrace();
        	}
        }
}
