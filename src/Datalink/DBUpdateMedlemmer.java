package Datalink;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Domain.Medlem;

public class DBUpdateMedlemmer {
	
		public void opdaterMedlemmer(ArrayList<Medlem> updateMedlemmer) {
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
		
		  for (Medlem medlem : updateMedlemmer) {
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
		
		
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
