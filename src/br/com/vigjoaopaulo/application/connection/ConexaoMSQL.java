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
			String USER = "root";
			String PASSWORD = "vertrigo";
			String BD = "db_fanaticos";
			String URL = "jdbc:mysql://localhost:3306/"+BD+"?autoReconnect=true&useSSL=false";

			try {
				conn = DriverManager.getConnection(URL, USER, PASSWORD);				
				if(conn != null) {
					//System.out.println("Connected to Database.");					
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
