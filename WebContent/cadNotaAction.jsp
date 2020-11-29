<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="inc/header.jsp"></jsp:include>
<header>
	<h1>Cadastrar Nota</h1>
	<hr>
</header>
<main>
	<form action="diario" method="post">
		<div class="form-group">
			<label for="assunto">Assunto</label> <input name="assunto"
				type="text" class="form-control" id="inputAssunto"> <span
				id="validateAssunto"></span>
		</div>
		<div class="form-group">
			<label for="dtNota">Data anotação</label> <input name="dtNota"
				type="date" class="form-control" id="dtNota"> <span
				id="dtNota"></span>
		</div>
		<div class="form-group">
			<label for="texto">Texto</label>
			<textarea class="form-control" id="texto" rows="3" name="texto"></textarea>
			<span id="texto"></span>
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
</main>
<jsp:include page="inc/scripts.jsp"></jsp:include>
</body>
</html>