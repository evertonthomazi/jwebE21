package br.com.projetoweb.model;

import java.util.ArrayList;

import br.com.projetoweb.beans.Usuario;
import br.com.projetoweb.dao.UsuarioDAO;

public class UsuarioModel {
	private static final long serialVersionUID = 1L;

	public static ArrayList<Usuario> listaUsuarios() {
		return UsuarioDAO.listaUsuarios();
	}
}
