package Datalink;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import Domain.AKtivitet;
import Domain.Tilmeld;
import Domain.Varer;
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

	public Medlem findMedlem(String identifier){
		Medlem medlem = null;
		try{
			String statementToQuery = "SELECT FROM medlemmer WHERE name = ?";
			PreparedStatement ps = conn.prepareStatement(statementToQuery);
			ps.setString(1, identifier);
			ps.executeUpdate();
			while(rs.next()){
				int id = rs.getInt("ID");
				String fornavn = rs.getString("fornavn");
				String efternavn = rs.getString("efternavn");
				String adresse = rs.getString("adresse");
				String fødselsdato = rs.getString("fødselsdato");
				String telefon = rs.getString("telefon");
				String email = rs.getString("email");
				String navnPåDør = rs.getString("navnPåDør");
				int billeder = rs.getInt("billeder");
				medlem = new Medlem (id, fornavn, efternavn, adresse, fødselsdato, telefon, email, navnPåDør, billeder);
			}

		} catch(Exception e){
			e.printStackTrace();
		}
		return medlem;

	}


	public void opretMedlem(Medlem medlem) {

		try {
			String sql = "INSERT INTO medlemmer VALUES("+medlem.toString()+");";
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

	public void opretBarbog(Barbog barbog, Medlem medlem) {
		try {
			String sql = "INSERT INTO barbog VALUES(" + barbog.toString()+");";
					
			System.out.println(sql);
			conn.createStatement().executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void opretTilmelding(Tilmeld tilmeld) {
		try {
			String sql = "INSERT INTO tilmeld VALUES(" + tilmeld.toString() 
					+ ");";
			System.out.println(sql);
			conn.createStatement().executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void opretAktivitet(AKtivitet aktivitet) {
		
		try {
			String sql = "INSERT INTO aktiviteter VALUES(" + aktivitet.toString() 
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
				String fødselsdato = rs.getString("fødselsdato");
				String telefon = rs.getString("telefon");
				String email = rs.getString("email");
				String navnPåDør = rs.getString("navnPåDør");
				int billeder = rs.getInt("billeder");
				medlemmer.add(new Medlem (id, fornavn, efternavn, adresse, fødselsdato, telefon, email, navnPåDør, billeder));
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return medlemmer;	

	}
	
	public ArrayList<Tilmeld> hentTilmeldinger(){
		ArrayList<Tilmeld> tilmeld = new ArrayList<Tilmeld>();
		try
		{
			String sql = "SELECT tilmeld.id, tilmeld.fk_medlemNavn, aktiviteter.navn FROM tilmeld LEFT JOIN aktiviteter ON tilmeld.aktivitetID = aktiviteter.id ORDER BY tilmeld.id ASC;";
			rs = conn.createStatement().executeQuery(sql);
			while(rs.next()){
				int id = rs.getInt("tilmeld.id");
				String aktivitetnavn = rs.getString("aktiviteter.navn");
				String medlemNavn = rs.getString("tilmeld.fk_medlemNavn");
			
				
				
				tilmeld.add(new Tilmeld (id, aktivitetnavn, medlemNavn));
				
			}
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		return tilmeld;
	}
	
	public ArrayList<AKtivitet> hentAktiviteter(){
		ArrayList<AKtivitet> aktiviteter = new ArrayList<AKtivitet>();
		try{
			String sql = "SELECT * FROM aktiviteter ORDER BY aktiviteter.id ASC;";
			rs = conn.createStatement().executeQuery(sql);
			while(rs.next()){
				int id = rs.getInt("id");
				String navn = rs.getString("navn");
				String pris = rs.getString("pris");
				String antal = rs.getString("antal");
				String dato = rs.getString("dato");
				aktiviteter.add(new AKtivitet (id, navn, pris, antal, dato));
				
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return aktiviteter;	

	}
	public ArrayList<Barbog> hentBarbog(){
		ArrayList<Barbog> barbogs = new ArrayList<Barbog>();
		try{
			//should try to test performance differnce for the actual defense, to see which is better (no time for the report)
			//String sql = "SELECT m.ID, m.fornavn, b.vigtignote, b.saldo FROM medlemmer m, barbog b WHERE m.ID = b.ID ORDER BY b.ID ASC;";
			String sql = "SELECT medlemmer.ID, medlemmer.fornavn, barbog.vigtignote, barbog.saldo FROM medlemmer INNER JOIN barbog WHERE medlemmer.ID = barbog.ID ORDER BY barbog.ID ASC;";
			//String sql = "SELECT * FROM barbog ORDER BY barbog.id ASC;";
			rs = conn.createStatement().executeQuery(sql);
			while(rs.next()){
				int id = rs.getInt("ID");
				String navn = rs.getString("fornavn");
				String vigtigNote = rs.getString("vigtigNote");
				int saldo = rs.getInt("saldo");
				barbogs.add(new Barbog (id, navn, vigtigNote,saldo));
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
				ps.setString(4,medlem.getFødselsdato());
				ps.setString(5,medlem.getTelefon());
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
			String statementToQuery = "DELETE FROM medlemmer WHERE id = ?;";
			//String statementToQuery = "DELETE FROM barbog WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(statementToQuery);
			ps.setInt(1, identifier);
			ps.executeUpdate();

		} catch(Exception e){
			e.printStackTrace();
		}
		sletBarbog(identifier);
	}
	public void sletBarbog(int identifier) {
		try{
			String statementToQuery =  "DELETE FROM barbog WHERE barbog.id = ?;";
			//String statementToQuery = "DELETE FROM barbog WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(statementToQuery);
			ps.setInt(1, identifier);
			ps.executeUpdate();

		} catch(Exception e){
			e.printStackTrace();
		}

	}

	public void opretVare(Varer vare) {
		try {
			String sql = "INSERT INTO Varer VALUES(" + vare.toString() + ");";
			System.out.println(sql);
			conn.createStatement().executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**	
	public Varer findVare(String identifier) {
		return db.findVare(identifier);
	}
	 **/
	public void sletVare(int identifier) {
		try{
			String statementToQuery = "DELETE FROM varer WHERE id = ?";
			//String statementToQuery = "DELETE FROM barbog WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(statementToQuery);
			ps.setInt(1, identifier);
			ps.executeUpdate();

		} catch(Exception e){
			e.printStackTrace();
		}

	}

	public ArrayList<Varer> hentVarer(){
		ArrayList<Varer> varer = new ArrayList<Varer>();
		try{
			String sql = "SELECT * FROM varer ORDER BY varer.id ASC;";
			rs = conn.createStatement().executeQuery(sql);
			while(rs.next()){
				int id = rs.getInt("ID");
				int pris = rs.getInt("pris");
				String navn = rs.getString("navn");
				int tilgængelig = rs.getInt("tilgængelig");
				int antal = rs.getInt("lagertal");
				varer.add(new Varer (id, pris, navn, tilgængelig, antal));
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		return varer;	

	}

	public void opdaterDBVarer(ArrayList <Varer> opdaterVare){
		try{
			for (Varer vare : opdaterVare) {
				String statementToQuery = "UPDATE varer"
						+ " SET pris = ?, navn = ?,  = ?, tilgængelig = ?, antal = ?"
						+ " WHERE id = ?";
				PreparedStatement ps = conn.prepareStatement(statementToQuery);
				ps.setInt(9, vare.getId());
				ps.setInt(1,vare.getPris());
				ps.setString(2,vare.getNavn());
				ps.setInt(3,vare.getTilgængelig());
				ps.setInt(4,vare.getAntal());
				ps.executeUpdate();
			}
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	public void indsaetBeloeb(int total, int id) {
		try {	
			String statementToQuery = "UPDATE barbog"
					+ " SET saldo = ?  WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(statementToQuery);
			ps.setInt(1, total);
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
					

	}

	public void traekBeloeb(int total, int id) {
		try {	
			String statementToQuery = "UPDATE barbog"
					+ " SET saldo = ?  WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(statementToQuery);
			ps.setInt(1, total);
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}


}
