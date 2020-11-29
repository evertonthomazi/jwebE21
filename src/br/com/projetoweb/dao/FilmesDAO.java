package br.com.projetoweb.dao;

import java.sql.*;
import java.util.ArrayList;

import br.com.projetoweb.beans.Filme;
import br.com.projetoweb.beans.Pessoa;
import br.com.projetoweb.cnn.ConnectionFactory;

public class FilmesDAO {
	
	public static ArrayList<Filme> listaFilmes() {
		Connection cnn = ConnectionFactory.getConnection();
		String query = "select * from filmes";
		ArrayList<Filme> arFilmes = new ArrayList();

		try {
			PreparedStatement pStm = cnn.prepareStatement(query);
			ResultSet rsFilme = pStm.executeQuery();

			while (rsFilme.next()) {
				Filme film = new Filme(rsFilme.getLong("id"), rsFilme.getString("titulo"),
						rsFilme.getString("classificacao"), rsFilme.getString("genero"), rsFilme.getString("topFilmes"),
						rsFilme.getString("capa"));
				arFilmes.add(film);
			}
			cnn.close();
			rsFilme.close();
			return arFilmes;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static int cadastrarFilme(Filme filmeSubmit) {
		String query = "INSERT INTO filmes (titulo, classificacao, genero, topFilmes, capa) values (?, ?, ?, ?, ?)";
		Connection cnn = ConnectionFactory.getConnection();
		int linhasAfetadas = 0;

		try {
			PreparedStatement pStmt = cnn.prepareStatement(query);
			pStmt.setString(1, filmeSubmit.getTitulo());
			pStmt.setString(2, filmeSubmit.getClassificacao());
			pStmt.setString(3, filmeSubmit.getGenero());
			pStmt.setString(4, filmeSubmit.getTopFilme());
			pStmt.setString(5, filmeSubmit.getCapa());
			linhasAfetadas = pStmt.executeUpdate();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return linhasAfetadas;
	}

	public static int updateFilme(Filme filmeSubmit) {
		String query = "UPDATE filmes SET titulo = ? , classificacao = ? , genero = ? , topFilmes, capa = ? WHERE id = ?";
		Connection cnn = ConnectionFactory.getConnection();
		int linhasAfetadas = 0;

		try {
			PreparedStatement pStmt = cnn.prepareStatement(query);
			pStmt.setString(1, filmeSubmit.getTitulo());
			pStmt.setString(2, filmeSubmit.getClassificacao());
			pStmt.setString(3, filmeSubmit.getGenero());
			pStmt.setString(4, filmeSubmit.getTopFilme());
			pStmt.setString(5, filmeSubmit.getCapa());
			pStmt.setLong(6, filmeSubmit.getId());
			linhasAfetadas = pStmt.executeUpdate();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return linhasAfetadas;
	}

	public static Filme getFilmesById(int id) {
		Filme filmeRetorno = new Filme();
		String query = "SELECT * FROM filmes WHERE id = ?";
		Connection cnn = ConnectionFactory.getConnection();

		try {
			PreparedStatement pStmt = cnn.prepareStatement(query);
			pStmt.setInt(1, id);

			ResultSet rsFilme = pStmt.executeQuery();
			while (rsFilme.next()) {
				filmeRetorno.setId(id);
				filmeRetorno.setTitulo(rsFilme.getString("titulo"));
				filmeRetorno.setClassificacao(rsFilme.getString("classificacao"));
				filmeRetorno.setGenero(rsFilme.getString("genero"));
				filmeRetorno.setTopFilme(rsFilme.getString("topFilmes"));
				filmeRetorno.setCapa(rsFilme.getString("capa"));
			}
			rsFilme.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return filmeRetorno;
	}

	public static int delFilme(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
}
