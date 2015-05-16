package Datalink;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import Domain.Medlem;
import GUI.MedlemTabel;

public class DBConnector{
	public static ArrayList<Medlem> medlemmer = new ArrayList<Medlem>();
	private Medlem m;
	public DBConnector(){
		
		java.sql.Statement stmt = null;
		ResultSet rs = null;
		
		try{
			String DATABASE_USR = "root";
			String DATABASE_PWD = "";
			String DATABASE_URL = "jdbc:mysql://localhost:3306/borupclub";
			Connection conn;
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(DATABASE_URL, DATABASE_USR, DATABASE_PWD);
			System.out.println("Connection made!");
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(
					"SELECT * FROM medlemmer "
					+ "ORDER BY medlemmer.id ASC, Fornavn"
					+ ";");
			
				while(rs.next()){
					int id = rs.getInt("ID");
					String fornavn = rs.getString("fornavn");
					String efternavn = rs.getString("efternavn");
					String adresse = rs.getString("adresse");
					int f�dselsdato = rs.getInt("f�dselsdato");
					int telefon = rs.getInt("telefon");
					String email = rs.getString("email");
					String navnP�D�r = rs.getString("navnP�D�r");
					boolean billeder = rs.getBoolean("billeder");
					medlemmer.add(m = new Medlem (id, fornavn, efternavn, adresse, f�dselsdato, telefon, email, navnP�D�r, billeder));
					System.out.println(id + "\t" + fornavn + "\t" + efternavn + "\t" + adresse + "\t" + f�dselsdato + "\t" + telefon + "\t" + email + "\t" + navnP�D�r + "\t" + billeder );	
					System.out.println(m.toString());
					}
				conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public static ArrayList<Medlem> getMedlemmer() {
		return medlemmer;
	}
}