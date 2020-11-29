package br.com.projetoweb.beans;

public class Serie {
	long id;
	String titulo;
	String classificacao;
	String genero;
	String topSerie;
	String capa;

	public Serie(long id, String titulo, String classificacao, String genero, String topSerie, String capa) {
		this.id = id;
		this.titulo = titulo;
		this.classificacao = classificacao;
		this.genero = genero;
		this.topSerie = topSerie;
		this.capa = capa;
	}

	public Serie() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getTopSerie() {
		return topSerie;
	}

	public void setTopSerie(String topSerie) {
		this.topSerie = topSerie;
	}

	public String getCapa() {
		return capa;
	}

	public void setCapa(String capa) {
		this.capa = capa;
	}

}
