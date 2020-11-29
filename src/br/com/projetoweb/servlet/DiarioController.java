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

import br.com.projetoweb.beans.Nota;
import br.com.projetoweb.model.NotaModel;

/**
 * Servlet implementation class PessoaController
 */
@WebServlet("/diario")
public class DiarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NotaModel notaModel = new NotaModel();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		switch (request.getParameter("action")) {
		case "listNotas":
			listaNotasAction(request, response);
			break;
		case "cadNota":
			cadNotaAction(request, response);
			break;
		case "verNota":
			verNotaAction(request, response);
			break;
		case "editNota":
			editNotaAction(request, response);
			break;
		case "delNota":
			delNotaAction(request, response);
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
		String assunto = request.getParameter("assunto");
		String dtNota = request.getParameter("dtNota");
		String texto = request.getParameter("texto");
		int retorno = 0;
		Nota notaSubmit = new Nota();
		notaSubmit.setAssunto(assunto);
		notaSubmit.setDtNota(dtNota);
		notaSubmit.setTexto(texto);

		try {
			Integer id = Integer.parseInt(request.getParameter("id"));
			notaSubmit.setId(id);
			retorno = NotaModel.updateNota(notaSubmit);
		} catch (Exception e) {
			retorno = NotaModel.cadastraNota(notaSubmit);
		}

		PrintWriter out = response.getWriter();
		if (retorno > 0) {
			out.println("<body>");
			out.println("<b>Nota " + assunto + " criada com Sucesso!</b>");
			out.println("<a href='diario?action=listNotas'>Voltar</a>");
			out.println("</body>");
		} else {
			out.println("<body>");
			out.println("<b>Ocorreu um erro, n�o foi poss�vel cadastrar a nota!</b>");
			out.println("<a href='diario?action=listNotas'>Voltar</a>");
			out.println("</body>");
		}
	}

	protected void listaNotasAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Nota> objListaNota = new ArrayList<Nota>();
		objListaNota = notaModel.listaNotas();

		request.setAttribute("listaNotas", objListaNota);
		RequestDispatcher rd = request.getRequestDispatcher("listaNotasAction.jsp");
		rd.forward(request, response);
	}

	protected void cadNotaAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("cadNotaAction.jsp");
		rd.forward(request, response);
	}

	private void verNotaAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Nota nota = notaModel.getNotaById(id);

		request.setAttribute("objNota", nota);
		RequestDispatcher rd = request.getRequestDispatcher("verNotaAction.jsp");
		rd.forward(request, response);

	}

	private void delNotaAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		if (NotaModel.delNota(id) > 0) {
			response.getWriter().print("OK");
		} else {
			response.getWriter().print("ERRO");
		}

	}

	private void editNotaAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Nota nota = notaModel.getNotaById(id);

		request.setAttribute("objNota", nota);
		RequestDispatcher rd = request.getRequestDispatcher("editNotaAction.jsp");
		rd.forward(request, response);

	}

}
