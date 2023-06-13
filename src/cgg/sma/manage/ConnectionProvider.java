package cgg.sma.manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	
	static Connection conn;
	public static Connection createConnection() {
		try {
			//load driver
			Class.forName("org.postgresql.Driver");
			String url="jdbc:postgresql://localhost:5432/Student_manager";
			String username = "postgres";
			String password = "Harika@1248";
			conn = DriverManager.getConnection(url,username,password);
				
			
			
		}catch(ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}
		return conn;
	}

}
