package br.com.projetoweb.model;

import java.io.Serializable;
import java.util.ArrayList;

import br.com.projetoweb.beans.Serie;
import br.com.projetoweb.dao.SeriesDAO;

public class SerieModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public ArrayList<Serie> listaSeries() {
		return SeriesDAO.listaSeries();
	}

	public Serie getSeriesById(int id) {
		return SeriesDAO.getSeriesById(id);
	}

	public int cadastraSerie(Serie serieSubmit) {
		// TODO Auto-generated method stub
		return SeriesDAO.cadastrarSerie(serieSubmit);
	}

	public int updateSerie(Serie serieSubmit) {
		return SeriesDAO.updateSerie(serieSubmit);
	}

	public int delSerie(int id) {
		return SeriesDAO.delSerie(id);
	}
}
