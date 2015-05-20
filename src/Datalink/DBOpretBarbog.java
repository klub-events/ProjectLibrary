package Datalink;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Domain.Barbog;

public class DBOpretBarbog {
	Barbog barbogs;
//	private static final String SQL_SERIALIZE_OBJECT = "INSERT INTO medlemmer(Fornavn, Efternavn, Adresse, Fødselsdato, Telefon, Email, NavnPåDør, Billeder) VALUES (?,?,?,?,?,?,?,?)";
//	public static long serializeJavaObjectToDB(Connection connection,
//			Medlem objectToSerialize) throws SQLException {
//
//		PreparedStatement pstmt = connection
//				.prepareStatement(SQL_SERIALIZE_OBJECT);
//
//		// just setting the class name
//		pstmt.setString(1, objectToSerialize.getClass().getName());
//		pstmt.setObject(2, objectToSerialize);
//		pstmt.executeUpdate();
//		ResultSet rs = pstmt.getGeneratedKeys();
//		int serialized_id = -1;
//		if (rs.next()) {
//			serialized_id = rs.getInt(1);
//		}
//		rs.close();
//		pstmt.close();
//		System.out.println("Java object serialized to database. Object: "
//				+ objectToSerialize);
//		return serialized_id;
//	}
	
	public DBOpretBarbog(Barbog barbogs) {
		

		this.barbogs = barbogs;

		java.sql.Statement stmt = null;
		ResultSet rs = null;
		try {
			String DATABASE_USR = "root";
			String DATABASE_PWD = "";
			String DATABASE_URL = "jdbc:mysql://localhost:3306/borupclub";
			Connection conn;

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(DATABASE_URL, DATABASE_USR,
					DATABASE_PWD);
			System.out.println("Connection made!");
			String statementToQuery = barbogs.toString();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO barbog VALUES(" + statementToQuery + ");");
			ps.executeUpdate();
			//long serialized_id = serializeJavaObjectToDB(conn, medlem);
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
