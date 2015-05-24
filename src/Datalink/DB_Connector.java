package Datalink;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import Domain.Barbog;
import Domain.Medlem;

public class DB_Connector {

	private Connection conn;
	private ResultSet rs;
	private String DATABASE_USR = "root";
	private String DATABASE_PWD = "";

	private String JDCB_DRIVER = "com.mysql.jdbc.Driver";
	private String DATABASE_URL = "jdbc:mysql://localhost:3306/borupclub";

	private static DB_Connector database;

	private DB_Connector() { // Private constructor to prevent outside
							// instantiation.. Singleton
		try {

			Class.forName(JDCB_DRIVER);

			conn = DriverManager.getConnection(DATABASE_URL, DATABASE_USR,
					DATABASE_PWD);

			System.out.println("Connected to database");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Internal error");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Database error");
		}
	}

	// Returns the singleton instance of the DB class; instantiates it if it
	// is not instantiated yet
	public static DB_Connector getInstance() {
		if (database == null) {
			database = new DB_Connector();
		}
		return database;
	}

	public void opretMedlem(Medlem medlem) {

		try {
			String sql = "INSERT INTO medlemmer VALUES("+medlem.toString()+");";
			System.out.println(sql);
			PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.executeUpdate();
	        try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	                medlem.setId(generatedKeys.getInt(1));
	            }
	            else {
	            	System.out.println("No keys generated - hvor er mit medlem?");
	            }
	        }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void opretBarbog(Barbog barbog) {
		try {
			String sql = "INSERT INTO barbog VALUES(" + barbog.toString()
					+ ");";
			System.out.println(sql);
			conn.createStatement().executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Medlem> hentMedlemmer(){
		ArrayList<Medlem> medlemmer = new ArrayList<Medlem>();
		try{
		String sql = "SELECT * FROM medlemmer ORDER BY medlemmer.id ASC;";
		rs = conn.createStatement().executeQuery(sql);
		while(rs.next()){
			int id = rs.getInt("ID");
			String fornavn = rs.getString("fornavn");
			String efternavn = rs.getString("efternavn");
			String adresse = rs.getString("adresse");
			int fødselsdato = rs.getInt("fødselsdato");
			int telefon = rs.getInt("telefon");
			String email = rs.getString("email");
			String navnPåDør = rs.getString("navnPåDør");
			int billeder = rs.getInt("billeder");
			medlemmer.add(new Medlem (id, fornavn, efternavn, adresse, fødselsdato, telefon, email, navnPåDør, billeder));
			}
	}
	catch(Exception e){
		e.printStackTrace();
	}
		return medlemmer;	
		
	}
	
	public ArrayList<Barbog> hentBarbog(){
		ArrayList<Barbog> barbogs = new ArrayList<Barbog>();
		try{
		String sql = "SELECT * FROM barbog ORDER BY barbog.id ASC;";
		rs = conn.createStatement().executeQuery(sql);
		while(rs.next()){
			int id = rs.getInt("ID");
			String vigtigNote = rs.getString("vigtigNote");
			int saldo = rs.getInt("saldo");
			barbogs.add(new Barbog (id, vigtigNote,saldo));
			}
	} catch(Exception e){
		e.printStackTrace();
	}
		return barbogs;	
		
	}

	public void opdaterBarbog(ArrayList<Barbog> opdateretBarbog) {
		try{
		for (Barbog barbog : opdateretBarbog) {
			String statementToQuery = "UPDATE barbog"
		  + " SET vigtigNote = ?, saldo = ?"
		  + " WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(statementToQuery);
			ps.setInt(3, barbog.getId());
			ps.setString(1,barbog.getVigtigNote());
			ps.setInt(2,barbog.getSaldo());
			ps.executeUpdate();
		  }
		} catch(Exception e){
			e.printStackTrace();
		}
	}
public void opdaterMedlemmer(ArrayList<Medlem> opdateretMedlemmer){
	try{
	for (Medlem medlem : opdateretMedlemmer) {
		String statementToQuery = "UPDATE medlemmer"
	  + " SET fornavn = ?, efternavn = ?, adresse = ?, fødselsdato = ?, telefon = ?, Email = ?, navnpådør = ?, billeder = ?"
	  + " WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(statementToQuery);
		ps.setInt(9, medlem.getId());
		ps.setString(1,medlem.getFornavn());
		ps.setString(2,medlem.getEfternavn());
		ps.setString(3,medlem.getAdresse());
		ps.setInt(4,medlem.getFødselsdato());
		ps.setInt(5,medlem.getTelefon());
		ps.setString(6,medlem.getEmail());
		ps.setString(7,medlem.getNavnPåDør());
		ps.setInt(8,medlem.getBilleder());
		
		ps.executeUpdate();
			}
		} catch(Exception e){
			e.printStackTrace();
		}
	}

public void sletMedlem(int identifier) {
	try{
		String statementToQuery = "DELETE FROM medlemmer WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(statementToQuery);
		ps.setInt(1, identifier);
		ps.executeUpdate();
		
	} catch(Exception e){
		e.printStackTrace();
	}
	
	}
}
