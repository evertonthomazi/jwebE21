package br.com.projetoweb.dao;

import java.sql.*;
import java.util.ArrayList;

import br.com.projetoweb.beans.Serie;
import br.com.projetoweb.cnn.ConnectionFactory;

public class SeriesDAO {
	
	public static ArrayList<Serie> listaSeries() {
		Connection cnn = ConnectionFactory.getConnection();
		String query = "select * from series";
		ArrayList<Serie> arSeries = new ArrayList();

		try {
			PreparedStatement pStm = cnn.prepareStatement(query);
			ResultSet rsSerie = pStm.executeQuery();

			while (rsSerie.next()) {
				Serie serie = new Serie(rsSerie.getLong("id"), rsSerie.getString("titulo"),
						rsSerie.getString("classificacao"), rsSerie.getString("genero"), rsSerie.getString("topSeries"),
						rsSerie.getString("capa"));
				arSeries.add(serie);
			}
			cnn.close();
			rsSerie.close();
			return arSeries;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static int cadastrarSerie(Serie serieSubmit) {
		String query = "INSERT INTO series (titulo, classificacao, genero, topSeries, capa) values (?, ?, ?, ?, ?)";
		Connection cnn = ConnectionFactory.getConnection();
		int linhasAfetadas = 0;

		try {
			PreparedStatement pStmt = cnn.prepareStatement(query);
			pStmt.setString(1, serieSubmit.getTitulo());
			pStmt.setString(2, serieSubmit.getClassificacao());
			pStmt.setString(3, serieSubmit.getGenero());
			pStmt.setString(4, serieSubmit.getTopSerie());
			pStmt.setString(5, serieSubmit.getCapa());
			linhasAfetadas = pStmt.executeUpdate();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return linhasAfetadas;
	}

	public static int updateSerie(Serie serieSubmit) {
		String query = "UPDATE series SET titulo = ? , classificacao = ? , genero = ? , topSeries, capa = ? WHERE id = ?";
		Connection cnn = ConnectionFactory.getConnection();
		int linhasAfetadas = 0;

		try {
			PreparedStatement pStmt = cnn.prepareStatement(query);
			pStmt.setString(1, serieSubmit.getTitulo());
			pStmt.setString(2, serieSubmit.getClassificacao());
			pStmt.setString(3, serieSubmit.getGenero());
			pStmt.setString(4, serieSubmit.getTopSerie());
			pStmt.setString(5, serieSubmit.getCapa());
			pStmt.setLong(6, serieSubmit.getId());
			linhasAfetadas = pStmt.executeUpdate();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return linhasAfetadas;
	}

	public static Serie getSeriesById(int id) {
		Serie serieRetorno = new Serie();
		String query = "SELECT * FROM series WHERE id = ?";
		Connection cnn = ConnectionFactory.getConnection();

		try {
			PreparedStatement pStmt = cnn.prepareStatement(query);
			pStmt.setInt(1, id);

			ResultSet rsSerie = pStmt.executeQuery();
			while (rsSerie.next()) {
				serieRetorno.setId(id);
				serieRetorno.setTitulo(rsSerie.getString("titulo"));
				serieRetorno.setClassificacao(rsSerie.getString("classificacao"));
				serieRetorno.setGenero(rsSerie.getString("genero"));
				serieRetorno.setTopSerie(rsSerie.getString("topSeries"));
				serieRetorno.setCapa(rsSerie.getString("capa"));
			}
			rsSerie.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return serieRetorno;
	}

	public static int delSerie(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
}
