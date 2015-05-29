package Datalink;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

import Domain.Aktivitet;
import Domain.Tilmeld;
import Domain.Varer;
import Domain.Barbog;
import Domain.Medlem;

/**
 * Used for connecting to the database. As the system is designed for a single user, the DB_Connector are only accessible through<br>
 * the getInstance method, seeing as the class have a private Constructor. This makes sure that only one connection to the database<br>
 * gets created at any one time.
 * @author PeterRaasthøj
 *
 */
public class DB_Connector {

	private Connection conn;
	private ResultSet rs;
	private String DATABASE_USR = "root";
	private String DATABASE_PWD = "";

	private String JDCB_DRIVER = "com.mysql.jdbc.Driver";
	private String DATABASE_URL = "jdbc:mysql://localhost:3306/borupclub";

	private static DB_Connector database;

	/**
	 * Handling all communication with the database.
	 * The DB_Connector has a private constructor to prevent outside instantiation. 
	 */
	private DB_Connector() {
		try {

			Class.forName(JDCB_DRIVER);

			conn = DriverManager.getConnection(DATABASE_URL, DATABASE_USR,
					DATABASE_PWD);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showConfirmDialog(null, "Internal error");
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showConfirmDialog(null, "Database error");
		}
	}

	/**
	 * Returns the singleton instance of the DB class; instantiates it if it
	 * is not instantiated yet
	 * @return new instance of the database
	 */
	public static DB_Connector getInstance() {
		if (database == null) {
			database = new DB_Connector();
		}
		return database;
	}

	/**
	 * A method used for extracting a specific member from the database.
	 * the method uses the <b>ID</b> of a member, to find it.
	 * 
	 * <p>takes an <b>int</b> as parameter.</p>
	 * @param identifier
	 * @return A Medlem filled with data gotten directly from the database
	 */
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


	/**
	 * <p>Creates a new Medlem in the database, with data from a Medlem object.<br>
	 * Uses the Medlem toString() to insert the data, as this has been formatted<br>
	 * to fit into sql syntax.</p>
	 * <p>sets the Medlem id = the generated id for Medlemmer in the database, for immediate use.<br>
	 * This is especially useful for deleting members via their id.</p>
	 * 
	 * <p>takes a <b>Medlem</b> as parameter.</p>
	 * @param medlem
	 */
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
					JOptionPane.showConfirmDialog(null,"No keys generated - hvor er mit medlem?");
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 *  * <p>Creates a new Barbog in the database, with data from a Barbog object.<br>
	 * Uses the Barbog toString() to insert the data, as this has been formatted<br>
	 * to fit into sql syntax.</p>
	 * 
	 * <p>takes a <b>Barbog</b> as parameter.</p>
	 * @param barbog
	 */
	public void opretBarbog(Barbog barbog) {
		try {
			String sql = "INSERT INTO barbog VALUES(" + barbog.toString()+");";
			conn.createStatement().executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Creates a new <i>Tilmelding</i> in the <i>tilmeld</i> database. id should be set as 0 if id is set as AutoIncremendet in database.<br>
	 * fk_medlemNavn and fk_aktivitetID comes from the <i>Medlem</i> class and <i>Aktivitet</i> class via the getters for these attributes.<br>
	 * used every time a new <i>Member</i> joins a new <i>Aktivitet</i>.
	 * 
	 * <p>takes <b>int</b>, <b>String</b>,<b>int</b> as parameters.</p>
	 * @param id
	 * @param fk_medlemNavn
	 * @param fk_aktivitetID
	 */
	public void opretTilmelding(int id, String fk_medlemNavn, int fk_aktivitetID) {
		try {
			String statementToQuery = "INSERT INTO tilmeld VALUES(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(statementToQuery);
			ps.setInt(1, 0);
			ps.setString(2, fk_medlemNavn);
			ps.setInt(3,fk_aktivitetID);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Creates a new Aktivitet in the database with the Aktivitet object.<br>
	 * Uses the Aktivitet toString() to insert the data, as this has been formatted
	 * to fit into sql syntax.
	 * 
	 * <p>Takes an <b>Aktivitet</b> in the constructor</p>
	 * @param aktivitet
	 */
	public void opretAktivitet(Aktivitet aktivitet) {
		
		try {
			String sql = "INSERT INTO aktiviteter VALUES(" + aktivitet.toString() 
					+ ");";
			conn.createStatement().executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	/**
	 * Sends a select all statement to the database, which selects everything in the member table.<br>
	 * All of the data from the database then get's saved as a new Medlem and get's added to an Arraylist which is returned.
	 * 
	 * <p>Useful for filling up JTable with data, and getting general data from the members, out of the database.
	 * @return ArrayList filled with members from the database
	 */
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
	
	/**
	 * Sends a select all statement to the database, which selects everything in the tilmeld table.<br>
	 * All of the data from the database then get's saved as a new Tilmeld and get's added to an Arraylist which is returned.
	 * 
	 * <p>Useful for filling up JTable with data, and getting general data from participants, out of the database.
	 * @return ArrayList filled with tilmeldninger from the database
	 */
	public ArrayList<Tilmeld> hentTilmeldinger(){
		ArrayList<Tilmeld> tilmeld = new ArrayList<Tilmeld>();
		try{
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
	
	/**
	 * Sends a select all statement to the database, which selects everything in the aktivitet table.<br>
	 * All of the data from the database then get's saved as a new Aktivitet and get's added to an Arraylist which is returned.
	 * 
	 * <p>Useful for filling up JTable with data, and getting general data from participants, out of the database.
	 * @return An ArrayList filled with activities from the database
	 */
	public ArrayList<Aktivitet> hentAktiviteter(){
		ArrayList<Aktivitet> aktiviteter = new ArrayList<Aktivitet>();
		try{
			String sql = "SELECT * FROM aktiviteter ORDER BY aktiviteter.id ASC;";
			rs = conn.createStatement().executeQuery(sql);
			while(rs.next()){
				int id = rs.getInt("id");
				String navn = rs.getString("navn");
				String pris = rs.getString("pris");
				String antal = rs.getString("antal");
				String dato = rs.getString("dato");
				aktiviteter.add(new Aktivitet (id, navn, pris, antal, dato));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return aktiviteter;
	}
	
	/**
	 * Sends a select all statement to the database, while inner joining the barbog table with medlem table which selects everything in the barbogs table.<br>
	 * All of the data from the database then get's saved as a new Barbog and get's added to an Arraylist which is returned.
	 * 
	 * <p>Useful when wanting access to a members balance, for use with transactions, or increase/decrease in balance.
	 * @return An ArrayList with a member's id, balance, important notes, and name.
	 */
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

	/**
	 * Used when updates has been made to a members balance, or important note. Selects all of the member accounts (barbøger)<br>
	 * in an ArrayList, and updates their important note, and balance. It finds the update targets based on their id.
	 * 
	 * <p>takes an<b>ArrayList</b> of Barbog as parameter. Used when you either want to update a single Barbog, or if you<br>
	 * want to update all of the Barbog's all together.</p>
	 * @param opdateretBarbog
	 */
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
	
	/**
	 * Used when updates has been made to a member Selects all of the members<br>
	 * in an ArrayList, and updates all of their info. It finds the update targets based on their id.
	 * 
	 * <p>takes an<b>ArrayList</b> of Medlem as parameter. Used when you either want to update a single Medlem, or if you<br>
	 * want to update all of the Medlem's all together.</p>
	 * @param opdateretMedlemmer
	 */
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

	/**
	 * Used whenever a member needs to get deleted from the database.
	 * <p>Takes an <b>int</b> as a parameter.
	 * @param identifier
	 */
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
	/**
	 * Used whenever a Barbog needs to get deleted from the database.
	 * <p>Takes an <b>int</b> as a parameter.
	 * @param identifier
	 */
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

	/**
	 * Creates a new ware (Varer) in the database.
	 * 
	 * <p>Takes an <b>int</b> as a parameter.</p>
	 * 
	 * @param vare
	 */
	public void opretVare(Varer vare) {
		try {
			String sql = "INSERT INTO Varer VALUES(" + vare.toString() + ");";
			conn.createStatement().executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	 
	
	/**
	 * Used whenever a ware needs to get deleted from the database.
	 * <p>Takes an <b>int</b> as a parameter.
	 * @param identifier
	 */
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

	/**
	 * Used for either ordering the wares, or getting the price of each ware.
	 * @return ArrayList with wares from the database. Filled with Varer <b>objects</b>.
	 */
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

	/**
	 * Updates all of the wares in the database. Usefull for setting the price, or updating available amount, and availability.
	 * <p>Takes an <b>ArrayList</b> filled with <b>Varer</b> as a parameter.</p>
	 * @param opdaterVare
	 */
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

	/**
	 * Used for depositing an amount into a members account
	 * <p>Takes <b>int</b>,<b>int</b> as parameters.</p>
	 * @param total
	 * @param id
	 */
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

	/**
	 * Used to withdraw an amount from a members account
	 * <p>Takes <b>int</b>,<b>int</b> as parameters.</p>
	 * @param total
	 * @param id
	 */
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

	/**
	 * Used when updating the important note for a members account(Barbog).
	 * 
	 * <p>Takes <b>int</b>,<b>String</b> as parameters.
	 * @param identifier
	 * @param note
	 */
	public void updateNote(int identifier, String note) {
		try {	
			String statementToQuery = "UPDATE barbog"
					+ " SET vigtigNote = ?  WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(statementToQuery);
			ps.setString(1, note);
			ps.setInt(2, identifier);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


}
