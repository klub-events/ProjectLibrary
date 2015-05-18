/** barbogs-kode
  	CREATE TABLE barbog (
	ID int primary key AUTO_INCREMENT,
    pris int (10),
    vare varchar (255),
    tilgængelig tinyint (1),
    vigtignote varchar (255),
    saldo int (10));
 */

package Datalink;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import Domain.Barbog;
import GUI.BarbogTabel;

public class DBHentBarbog{
	public static ArrayList<Barbog> barbogs = new ArrayList<Barbog>();
	private Barbog m;
	public DBHentBarbog(){
		
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
					"SELECT * FROM barbog "
					+ "ORDER BY barbog.id ASC, vare"
					+ ";");
			
				while(rs.next()){
					int id = rs.getInt("ID");
					int pris = rs.getInt("pris");
					String vare = rs.getString("vare");
					int tilgængelig = rs.getInt("tilgængelig");
					String vigtigNote = rs.getString("vigtigNote");
					int saldo = rs.getInt("saldo");
					barbogs.add(m = new Barbog (id, pris, vare, tilgængelig, vigtigNote,saldo));
					System.out.println(id + "\t" + pris + "\t" + vare + "\t" + tilgængelig + "\t" + vigtigNote + "\t" + saldo);	
					System.out.println(m.toString());
					}
				conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public static ArrayList<Barbog> getBarbog() {
		return barbogs;
	}
}