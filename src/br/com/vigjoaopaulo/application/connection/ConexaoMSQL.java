package br.com.vigjoaopaulo.application.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMSQL {
	static Connection conn;

	public static Connection conectar() {

		try {
			// load the driver
			//Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");

			// create the connection
			String user = "root";
			String password = "vertrigo";
			String url = "jdbc:mysql://localhost:3306/db_fanaticos?autoReconnect=true&useSSL=false";

			try {
				conn = DriverManager.getConnection(url, user, password);				
				if(conn != null) {
					System.out.println("Connected to Database.");
					conn.close();
				}
				return conn;
			
			} catch (SQLException e) {
				throw new RuntimeException("Cannot connect to database", e);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;

	}

	
}
