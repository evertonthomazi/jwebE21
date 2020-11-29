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

import br.com.projetoweb.beans.Pessoa;
import br.com.projetoweb.model.PessoaModel;

/**
 * Servlet implementation class PessoaController
 */
@WebServlet("/pessoa")
public class PessoaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PessoaModel pessoaModel = new PessoaModel();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		switch (request.getParameter("action")) {
		case "listPessoas":
			listaPessoasAction(request, response);
			break;
		case "cadPessoa":
			cadPessoaAction(request, response);
			break;
		case "verPessoa":
			verPessoaAction(request, response);
			break;
		case "editPessoa":
			editPessoaAction(request, response);
			break;
		case "delPessoa":
			delPessoaAction(request, response);
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
		String nome = request.getParameter("nome");
		String dataNascimento = request.getParameter("dataNascimento");
		String sexo = request.getParameter("sexo");
		String cpf = request.getParameter("cpf");
		int retorno = 0;
		Pessoa pessoaSubmit = new Pessoa();
		pessoaSubmit.setNome(nome);
		pessoaSubmit.setDtNascimento(dataNascimento);
		pessoaSubmit.setCpf(cpf);
		pessoaSubmit.setSexo(sexo.charAt(0));

		try {
			Integer id = Integer.parseInt(request.getParameter("id"));
			pessoaSubmit.setId(id);
			retorno = PessoaModel.updatePessoa(pessoaSubmit);
		} catch (Exception e) {
			retorno = PessoaModel.cadastraPessoa(pessoaSubmit);
		}

		PrintWriter out = response.getWriter();
		if (retorno > 0) {
			out.println("<body>");
			out.println("<b>Pessoa " + nome + " Alterada com Sucesso!</b>");
			out.println("<a href='pessoa?action=listPessoas'>Voltar</a>");
			out.println("</body>");
		} else {
			out.println("<body>");
			out.println("<b>Ocorreu um erro, n�o foi poss�vel cadastrar a pessoa!</b>");
			out.println("<a href='pessoa?action=listPessoas'>Voltar</a>");
			out.println("</body>");
		}
	}

	protected void listaPessoasAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Pessoa> objListaPessoa = new ArrayList<Pessoa>();
		objListaPessoa = pessoaModel.listaPessoas();

		request.setAttribute("listaPessoas", objListaPessoa);
		RequestDispatcher rd = request.getRequestDispatcher("listaPessoasAction.jsp");
		rd.forward(request, response);
	}

	protected void cadPessoaAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("cadPessoaAction.jsp");
		rd.forward(request, response);
	}

	private void verPessoaAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Pessoa pessoa = pessoaModel.getPessoaById(id);

		request.setAttribute("objPessoa", pessoa);
		RequestDispatcher rd = request.getRequestDispatcher("verPessoaAction.jsp");
		rd.forward(request, response);

	}

	private void delPessoaAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		if (PessoaModel.delPessoa(id) > 0) {
			response.getWriter().print("OK");
		} else {
			response.getWriter().print("ERRO");
		}

	}

	private void editPessoaAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Pessoa pessoa = pessoaModel.getPessoaById(id);

		request.setAttribute("objPessoa", pessoa);
		RequestDispatcher rd = request.getRequestDispatcher("editPessoaAction.jsp");
		rd.forward(request, response);

	}

}
