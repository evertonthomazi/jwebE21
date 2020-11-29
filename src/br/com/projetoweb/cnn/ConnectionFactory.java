package br.com.projetoweb.cnn;

import java.sql.*;

public class ConnectionFactory {

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/projetoweb?useTimezone=true&serverTimezone=UTC&useSSL=false";
			Connection cnn = DriverManager.getConnection(url,"root","23619200");
			return cnn;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
		return null;
	}
}
