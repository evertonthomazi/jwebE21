<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="inc/header.jsp"></jsp:include>

<main>
	<div class="card">
		<div class="card-body">
			<h5 class="card-title">
				<c:out value="${objNota.assunto}" />
			</h5>
			<ul style="list-style: none;">
				<li>ID: <b><c:out value="${objNota.id}" /></b>
				</li>
				<li>Assunto: <b><c:out value="${objNota.assunto}" /></b>
				</li>
				<li>Data: <b><c:out value="${objNota.dtNota}" /></b>
				</li>
				<li>Texto: <b><c:out value="${objNota.texto}" /></b></li>
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