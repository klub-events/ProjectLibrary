package Datalink;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Domain.Barbog;

public class DBUpdateBarbog {
	
		public void opdaterBarbog(ArrayList<Barbog> updateBarbog) {
		try {
			String DATABASE_USR = "root";
			String DATABASE_PWD = "";
			String DATABASE_URL = "jdbc:mysql://localhost:3306/borupclub";
			Connection conn;

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(DATABASE_URL, DATABASE_USR,
					DATABASE_PWD);
			System.out.println("Connection made!");

		java.sql.Statement stmt = null;
		ResultSet rs = null;
 		  for (Barbog barbog : updateBarbog) {
			String statementToQuery = "UPDATE barbog"
		  + " SET pris = ?, vare = ?, tilgængelig = ?, vigtigNote = ?, saldo = ?"
		  + " WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(statementToQuery);
			ps.setInt(9, barbog.getId());
			ps.setInt(1,barbog.getPris());
			ps.setString(2,barbog.getVare());
			ps.setInt(3,barbog.getTilgængelig());
			ps.setString(4,barbog.getVigtigNote());
			ps.setInt(5,barbog.getSaldo());
	
			ps.executeUpdate();
		  }
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

