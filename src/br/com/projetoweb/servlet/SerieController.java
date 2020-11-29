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

import br.com.projetoweb.beans.Serie;
import br.com.projetoweb.model.SerieModel;

/**
 * Servlet implementation class PessoaController
 */
@WebServlet("/series")
public class SerieController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SerieModel SerieModel = new SerieModel();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		switch (request.getParameter("action")) {
		case "listSeries":
			listaSeriesAction(request, response);
			break;
		case "cadSerie":
			cadSerieAction(request, response);
			break;
		case "verSerie":
			verSerieAction(request, response);
			break;
		case "editSerie":
			editSerieAction(request, response);
			break;
		case "delSerie":
			delSerieAction(request, response);
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
		String topFilme = request.getParameter("topSeries");
		String capa = request.getParameter("capa");
		int retorno = 0;
		Serie serieSubmit = new Serie();
		serieSubmit.setTitulo(titulo);
		serieSubmit.setClassificacao(classificacao);
		serieSubmit.setGenero(genero);
		serieSubmit.setTopSerie(topFilme);
		serieSubmit.setCapa(capa);

		try {
			Integer id = Integer.parseInt(request.getParameter("id"));
			serieSubmit.setId(id);
			retorno = SerieModel.updateSerie(serieSubmit);
		} catch (Exception e) {
			retorno = SerieModel.cadastraSerie(serieSubmit);
		}

		PrintWriter out = response.getWriter();
		if (retorno > 0) {
			out.println("<body>");
			out.println("<b>Filme " + titulo + " Alterada com Sucesso!</b>");
			out.println("<a href='series?action=listSeries'>Voltar</a>");
			out.println("</body>");
		} else {
			out.println("<body>");
			out.println("<b>Ocorreu um erro, n�o foi poss�vel cadastrar a serie!</b>");
			out.println("<a href='series?action=listSeries'>Voltar</a>");
			out.println("</body>");
		}
	}

	protected void listaSeriesAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Serie> objListaSerie = new ArrayList<Serie>();
		objListaSerie = SerieModel.listaSeries();

		request.setAttribute("listaSeries", objListaSerie);
		RequestDispatcher rd = request.getRequestDispatcher("listaSeriesAction.jsp");
		rd.forward(request, response);
	}

	protected void cadSerieAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("cadSerieAction.jsp");
		rd.forward(request, response);
	}

	private void verSerieAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Serie serie = SerieModel.getSeriesById(id);

		request.setAttribute("objSerie", serie);
		RequestDispatcher rd = request.getRequestDispatcher("verSerieAction.jsp");
		rd.forward(request, response);

	}

	private void delSerieAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		if (SerieModel.delSerie(id) > 0) {
			response.getWriter().print("OK");
		} else {
			response.getWriter().print("ERRO");
		}

	}

	private void editSerieAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Serie serie = SerieModel.getSeriesById(id);

		request.setAttribute("objSerie", serie);
		RequestDispatcher rd = request.getRequestDispatcher("editSerieAction.jsp");
		rd.forward(request, response);

	}

}
