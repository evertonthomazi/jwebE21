package br.com.projetoweb.beans;

import java.io.Serializable;

public class Nota implements Serializable {
	private static final long serialVersionUID = 1L;
	private long id;
	private String assunto;
	private String dtNota;
	private String texto;

	public Nota(long id, String assunto, String dtNota, String texto) {
		super();
		this.id = id;
		this.assunto = assunto;
		this.dtNota = dtNota;
		this.texto = texto;
	}

	public Nota() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getDtNota() {
		return dtNota;
	}

	public void setDtNota(String dtNota) {
		this.dtNota = dtNota;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
