package br.com.projetoweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projetoweb.beans.Filme;
import br.com.projetoweb.model.FilmeModel;

/**
 * Servlet implementation class PessoaController
 */
@WebServlet("/filmes")
public class FilmeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FilmeModel FilmeModel = new FilmeModel();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		switch (request.getParameter("action")) {
		case "listFilmes":
			listaFilmesAction(request, response);
			break;
		case "cadFilme":
			cadFilmeAction(request, response);
			break;
		case "verFilme":
			verFilmeAction(request, response);
			break;
		case "editFilme":
			editFilmeAction(request, response);
			break;
		case "delFilme":
			delFilmeAction(request, response);
			break;

		default:
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String titulo = request.getParameter("titulo");
		String classificacao = request.getParameter("classificacao");
		String genero = request.getParameter("genero");
		String topFilme = request.getParameter("topFilmes");
		String capa = request.getParameter("capa");
		int retorno = 0;
		Filme filmeSubmit = new Filme();
		filmeSubmit.setTitulo(titulo);
		filmeSubmit.setClassificacao(classificacao);
		filmeSubmit.setGenero(genero);
		filmeSubmit.setTopFilme(topFilme);
		filmeSubmit.setCapa(capa);

		try {
			Integer id = Integer.parseInt(request.getParameter("id"));
			filmeSubmit.setId(id);
			retorno = FilmeModel.updateFilme(filmeSubmit);
		} catch (Exception e) {
			retorno = FilmeModel.cadastraFilme(filmeSubmit);
		}

		PrintWriter out = response.getWriter();
		if (retorno > 0) {
			out.println("<body>");
			out.println("<b>Filme " + titulo + " Alterada com Sucesso!</b>");
			out.println("<a href='filmes?action=listFilmes'>Voltar</a>");
			out.println("</body>");
		} else {
			out.println("<body>");
			out.println("<b>Ocorreu um erro, n�o foi poss�vel cadastrar o filme!</b>");
			out.println("<a href='filmes?action=listFilmes'>Voltar</a>");
			out.println("</body>");
		}
	}

	protected void listaFilmesAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Filme> objListaFilme = new ArrayList<Filme>();
		objListaFilme = FilmeModel.listaFilmes();

		request.setAttribute("listaFilmes", objListaFilme);
		RequestDispatcher rd = request.getRequestDispatcher("listaFilmesAction.jsp");
		rd.forward(request, response);
	}

	protected void cadFilmeAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("cadFilmeAction.jsp");
		rd.forward(request, response);
	}

	private void verFilmeAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Filme filme = FilmeModel.getFilmesById(id);

		request.setAttribute("objFilme", filme);
		RequestDispatcher rd = request.getRequestDispatcher("verFilmeAction.jsp");
		rd.forward(request, response);

	}

	private void delFilmeAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		if (FilmeModel.delFilme(id) > 0) {
			response.getWriter().print("OK");
		} else {
			response.getWriter().print("ERRO");
		}

	}

	private void editFilmeAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Filme filme = FilmeModel.getFilmesById(id);

		request.setAttribute("objFilme", filme);
		RequestDispatcher rd = request.getRequestDispatcher("editFilmeAction.jsp");
		rd.forward(request, response);

	}

}
