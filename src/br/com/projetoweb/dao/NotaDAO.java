package br.com.projetoweb.dao;

import java.sql.*;
import java.util.ArrayList;

import br.com.projetoweb.beans.Nota;
import br.com.projetoweb.cnn.ConnectionFactory;

public class NotaDAO {

	public static ArrayList<Nota> listaNotas() {
		Connection cnn = ConnectionFactory.getConnection();
		String query = "select * from d_notas";
		ArrayList<Nota> arNotas = new ArrayList();

		try {
			PreparedStatement pStm = cnn.prepareStatement(query);
			ResultSet rsNotas = pStm.executeQuery();

			while (rsNotas.next()) {
				Nota not = new Nota(rsNotas.getLong("id"), rsNotas.getString("assunto"),
						rsNotas.getString("dt_nota"), rsNotas.getString("texto"));
				arNotas.add(not);
			}
			cnn.close();
			rsNotas.close();
			return arNotas;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Nota getNotaById(int id) {
		Nota notaRetorno = new Nota();
		String query = "SELECT * FROM d_notas WHERE id = ?";
		Connection cnn = ConnectionFactory.getConnection();

		try {
			PreparedStatement pStmt = cnn.prepareStatement(query);
			pStmt.setInt(1, id);

			ResultSet rsNota = pStmt.executeQuery();
			while (rsNota.next()) {
				notaRetorno.setId(id);
				notaRetorno.setAssunto(rsNota.getString("assunto"));
				notaRetorno.setDtNota(rsNota.getString("dt_nota"));
				notaRetorno.setTexto(rsNota.getString("texto"));
			}
			rsNota.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return notaRetorno;
	}

	public static int cadastraNota(Nota notaSubmit) {
		String query = "INSERT INTO d_notas(assunto, dt_nota, texto) values (?, ?, ?)";
		Connection cnn = ConnectionFactory.getConnection();
		int linhasAfetadas = 0;

		try {
			PreparedStatement pStmt = cnn.prepareStatement(query);
			pStmt.setString(1, notaSubmit.getAssunto());
			pStmt.setString(2, notaSubmit.getDtNota());
			pStmt.setString(3, notaSubmit.getTexto());
			linhasAfetadas = pStmt.executeUpdate();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return linhasAfetadas;
	}

	public static int updateNota(Nota notaSubmit) {
		String query = "UPDATE d_notas SET assunto = ?, dt_nota = ?, texto = ? WHERE id= ?";
		Connection cnn = ConnectionFactory.getConnection();
		int linhasAfetadas = 0;

		try {
			PreparedStatement pStmt = cnn.prepareStatement(query);
			pStmt.setString(1, notaSubmit.getAssunto());
			pStmt.setString(2, notaSubmit.getDtNota());
			pStmt.setString(3, notaSubmit.getTexto());
			pStmt.setLong(4, notaSubmit.getId());
			linhasAfetadas = pStmt.executeUpdate();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return linhasAfetadas;
	}

	public static int delNota(int id) {
		String query = "DELETE FROM d_notas WHERE id= ?";
		Connection cnn = ConnectionFactory.getConnection();
		int linhasAfetadas = 0;

		try {
			PreparedStatement pStmt = cnn.prepareStatement(query);
			pStmt.setInt(1, id);
			linhasAfetadas = pStmt.executeUpdate();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return linhasAfetadas;
	}
}
