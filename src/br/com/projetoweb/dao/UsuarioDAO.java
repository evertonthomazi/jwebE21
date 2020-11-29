package br.com.projetoweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.projetoweb.beans.Pessoa;
import br.com.projetoweb.beans.Usuario;
import br.com.projetoweb.cnn.ConnectionFactory;

public class UsuarioDAO {

	public static ArrayList<Usuario> listaUsuarios() {
		Connection cnn = ConnectionFactory.getConnection();
		String query = "SELECT * FROM usuario";
		ArrayList<Usuario> arUsuarios = new ArrayList<Usuario>();

		try {
			PreparedStatement pStm = cnn.prepareStatement(query);
			ResultSet rsUsuarios = pStm.executeQuery();

			while (rsUsuarios.next()) {
				Usuario user = new Usuario(rsUsuarios.getInt("id"), rsUsuarios.getString("login"),
						rsUsuarios.getString("senha"), rsUsuarios.getString("status"), rsUsuarios.getInt("pessoa_ID"));
				arUsuarios.add(user);
			}
			cnn.close();
			rsUsuarios.close();
			return arUsuarios;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
