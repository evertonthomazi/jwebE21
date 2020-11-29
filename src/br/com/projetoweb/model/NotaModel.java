package br.com.projetoweb.model;

import java.io.Serializable;
import java.util.ArrayList;

import br.com.projetoweb.beans.Nota;
import br.com.projetoweb.dao.NotaDAO;

public class NotaModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public ArrayList<Nota> listaNotas() {
		return NotaDAO.listaNotas();
	}

	public Nota getNotaById(int id) {
		return NotaDAO.getNotaById(id);
	}

	public static int cadastraNota(Nota notaSubmit) {
		// TODO Auto-generated method stub
		return NotaDAO.cadastraNota(notaSubmit);
	}

	public static int updateNota(Nota notaSubmit) {
		return NotaDAO.updateNota(notaSubmit);
	}

	public static int delNota(int id) {
		return NotaDAO.delNota(id);
	}
}
