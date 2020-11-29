<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="inc/header.jsp"></jsp:include>

<main>
	<div class="container"></div>
	<div class="row">
		<br>
		<table class="table table-hover">
			<thead>
				<tr>
					<td>#</td>
					<td>Assunto</td>
					<td>Data</td>
					<td>Texto</td>
					<td>Ações</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="nota" items="${listaNotas}">
					<tr>
						<td><c:out value="${nota.id}" /></td>
						<td><c:out value="${nota.assunto}" /></td>
						<td><c:out value="${nota.dtNota}" /></td>
						<td><c:out value="${nota.texto}" /></td>
						<td><a class="btn btn-sm btn-info"
							href="diario?action=verNota&id=${nota.id}"> <i
								class="fas fa-search"></i>
						</a> | <a class="btn btn-sm btn-primary"
							href="diario?action=editNota&id=${nota.id}"> <i
								class="fas fa-edit"></i>
						</a> | <a onclick="deletePessoa(${nota.id});"
							class="btn btn-sm btn-danger"
							href="diario?action=delNota&id=${nota.id}"> <i
								class="fas fa-trash"></i>
						</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</main>
</div>

<!--  Scripts -->
<jsp:include page="inc/scripts.jsp"></jsp:include>

</body>
</html>