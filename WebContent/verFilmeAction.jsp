<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="inc/header.jsp"></jsp:include>

<main>
	<div class="card" style="width:18em">
		<div class="card-body">
    	<h5 class="card-title"><c:out value="${objFilme.titulo}" /></h5>
			<ul style="list-style: none;">
				<li>ID: <b><c:out value="${objFilme.id}" /></b>
				</li>
				<li>Titulo: <b><c:out value="${objFilme.titulo}" /></b>
				</li>
				<li>Classificacao: <b><c:out value="${objFilme.classificacao}" /></b>
				</li>
				<li>genero: <b><c:out value="${objFilme.genero}" /></b></li>
			</ul>
		</div>
	</div>
</main>
<button onclick="window.history.back();">Voltar</button>
</div>


<!--  Scripts -->
<jsp:include page="inc/scripts.jsp"></jsp:include>

</body>
</html>