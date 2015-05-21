package Datalink;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Domain.Medlem;

public class DBOpretMedlem {
	
		public void opretMedlem(Medlem medlem) {
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
		
		String statementToQuery = medlem.toString();
		PreparedStatement ps = conn.prepareStatement("INSERT INTO medlemmer VALUES(" + statementToQuery + ");");
		ps.executeUpdate();
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
