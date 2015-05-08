package Datalink;
import Medlem_tabel;
import Medlemmer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

public class db_Connector{
	public ArrayList<Medlemmer> medlemmer = new ArrayList<Medlemmer>();
	
	public db_Connector(){
		
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
					int fødselsdato = rs.getInt("fødselsdato");
					int telefon = rs.getInt("telefon");
					String email = rs.getString("email");
					String navnPåDør = rs.getString("navnPåDør");
					boolean billeder = rs.getBoolean("billeder");
					medlemmer.add(new Medlemmer (id, fornavn, efternavn, adresse, fødselsdato, telefon, email, navnPåDør, billeder));
					System.out.println(id + "\t" + fornavn + "\t" + efternavn + "\t" + adresse + "\t" + fødselsdato + "\t" + telefon + "\t" + email + "\t" + navnPåDør + "\t" + billeder );	
					}
				conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		new Medlem_tabel (medlemmer);
	}
}