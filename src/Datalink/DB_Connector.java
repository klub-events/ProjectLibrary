package Datalink;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
        
        
        
//         Returns the singleton instance of the DB class; instantiates it if it isn't: 
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
        
        public void opretBarbog()
        {
        	
        }
        public void addItemGroup(String name, int position, String color) {
                try {
                        String sql = "INSERT INTO item_group (Name, Position, Color)"
                                        + " VALUES ('"+name+"', "+position+" ,'"+color+"')";
                        System.out.println(sql);
                  conn.createStatement().executeUpdate(sql);
                } catch (SQLException e) {
                        e.printStackTrace();
                }
                
        }
        
//        public void removeItemGroup(int item_id)
//        {
//                try {
//                        String sql = "DELETE FROM item WHERE Item_id = '"+ item_id +"'";
//                        System.out.println(sql);
//                  conn.createStatement().executeUpdate(sql);
//                } catch (SQLException e) {
//                        e.printStackTrace();
//                }
//        }
//        
//        public void removeItem(int group_id)
//        {
//                try {
//                        String sql = "DELETE FROM item_group WHERE Group_id = '"+ group_id +"'";
//                        System.out.println(sql);
//                  conn.createStatement().executeUpdate(sql);
//                } catch (SQLException e) {
//                        e.printStackTrace();
//                }
//        }
//        
//        public void editItem(int group_id, String name, double price, String itemDescription, String color, int location, int item_id)
//        {
//                int id = item_id + 1;
//                
//                try {
//                        String sql = "UPDATE item SET Name = '"+name+"', Price = '"+price+"', Description = '"+itemDescription+"', "
//                                        + "Position = '"+location+"', Color ='"+color+"', Group_id = '"+group_id+"' WHERE Item_id = '"+id+"'";
//                        System.out.println(sql);
//                  conn.createStatement().executeUpdate(sql);
//                } catch (SQLException e) {
//                        e.printStackTrace();
//                }
//                
//        }
//        
//        public void editItemGroup()
//        {
//        // TODO GOGOGOGOGOGOG        
//                
//        }
//        public ArrayList<Item> getAllItems()
//        {
//                ArrayList<Item> item = new ArrayList<Item>();
//                
//                try {
//                        rs = conn.createStatement().executeQuery("SELECT * FROM         item;");
//                        
//                        while (rs.next()){
//                                item.add(new Item(rs.getString("Name"),rs.getDouble("Price"),rs.getString("Description"),rs.getInt("Position"),rs.getString("Color"),rs.getInt("Group_id")));
//                        }
//                } catch (SQLException e) {
//                        e.printStackTrace();
//                }
//                return item;
//        }
//        
//        public ArrayList<Item_Group> getAllItemGroups() {
//                ArrayList<Item_Group> item_Groups = new ArrayList<Item_Group>();
//                
//                try {
//                        rs = conn.createStatement().executeQuery("SELECT * FROM         item_group;");
//                        
//                        while (rs.next()){
//                                item_Groups.add(new Item_Group(rs.getString("Name"),rs.getInt("Position"),rs.getString("Color")));
//                        }
//                } catch (SQLException e) {
//                        e.printStackTrace();
//                }
//                return item_Groups;
//        }
}
