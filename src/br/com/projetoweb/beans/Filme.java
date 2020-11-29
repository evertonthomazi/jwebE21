package br.com.projetoweb.beans;

public class Filme {
	long id;
	String titulo;
	String classificacao;
	String genero;
	String topFilme;
	String capa;

	public Filme(long id, String titulo, String classificacao, String genero, String topFilme, String capa) {
		this.id = id;
		this.titulo = titulo;
		this.classificacao = classificacao;
		this.genero = genero;
		this.topFilme = topFilme;
		this.capa = capa;
	}

	public Filme() {

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

	public String getTopFilme() {
		return topFilme;
	}

	public void setTopFilme(String top_filme) {
		this.topFilme = top_filme;
	}

	public String getCapa() {
		return capa;
	}

	public void setCapa(String capa) {
		this.capa = capa;
	}

}
