package br.com.projetoweb.model;

import java.io.Serializable;
import java.util.ArrayList;

import br.com.projetoweb.beans.Filme;
import br.com.projetoweb.dao.FilmesDAO;

public class FilmeModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public ArrayList<Filme> listaFilmes() {
		return FilmesDAO.listaFilmes();
	}

	public Filme getFilmesById(int id) {
		return FilmesDAO.getFilmesById(id);
	}

	public int cadastraFilme(Filme filmeSubmit) {
		// TODO Auto-generated method stub
		return FilmesDAO.cadastrarFilme(filmeSubmit);
	}

	public int updateFilme(Filme filmeSubmit) {
		return FilmesDAO.updateFilme(filmeSubmit);
	}

	public int delFilme(int id) {
		return FilmesDAO.delFilme(id);
	}
}
