<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="inc/header.jsp"></jsp:include>
<header>
	<h1>Lista de Usuários</h1>
	<hr>
</header>

<main>
	<table style="width: 80%; margin: 0 auto; border: 1px solid #ccc;">
		<thead>
			<tr>
				<td>#</td>
				<td>Login</td>
				<td>Senha</td>
				<td>Status</td>
				<td>Pessoa</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="usuario" items="${listaUsuarios}">
				<tr>
					<td><c:out value="${usuario.id}"></c:out></td>
					<td><c:out value="${usuario.login}"></c:out></td>
					<td><c:out value="${usuario.senha}"></c:out></td>
					<td><c:out value="${usuario.status}"></c:out></td>
					<td><c:out value="${usuario.pessoa_ID}"></c:out></td>
					<td><a href="pessoa?action=verPessoa&id=${usuario.id}"><button
								type="button" class="btn btn-success">Ver</button></a> <a
						href="pessoa?action=editPessoa&id=${usuario.id}"><button
								type="button" class="btn btn-primary">Editar</button></a> <a
						href="pessoa?action=deletePessoa&id=${usuario.id}"><button
								type="button" class="btn btn-danger btn-sm"
								onclick="apagarPessoa(${usuario.id}))">Apagar</button></a></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
</main>
<jsp:include page="inc/scripts.jsp"></jsp:include>
</body>
</html>