package br.com.projetoweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.projetoweb.beans.Usuario;
import br.com.projetoweb.cnn.ConnectionFactory;

public class LoginDAO {
	public static boolean Login(String n, String p) throws SQLException, ClassNotFoundException {

		String sql = "SELECT * FROM usuario WHERE login=? AND senha=?";

		Connection cnn = ConnectionFactory.getConnection();
		try {
			PreparedStatement psmt = cnn.prepareStatement(sql);

			psmt.setString(1, n);
			psmt.setString(2, p);

			ResultSet rs = psmt.executeQuery();

			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		cnn.close();
		return false;
	}
}
