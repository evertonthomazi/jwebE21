<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="inc/header.jsp"></jsp:include>
<header>
	<h1>Cadastrar Pessoa</h1>
	<hr>
</header>
	<main>
		<form action="pessoa" method="post">
			<div class="form-group">
				<label for="nome">Nome</label> <input name="nome" type="text"
					class="form-control" id="inputNome"> <span
					id="validateNome"></span>
			</div>
			<div class="form-group">
				<label for="dataNascimento">Data nascimento</label> <input
					name="dataNascimento" type="date" class="form-control"
					id="dataNascimento"> <span id="validateDataNascimento"></span>
			</div>
			<div class="form-group">
				<label for="sexo">Sexo</label> <select class="form-control"
					id="sexo" name="sexo">
					<option>Selecione</option>
					<option value="M">Masculino</option>
					<option value="F">Feminino</option>
				</select> <span id="validadeSexo"></span>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</main>
	<jsp:include page="inc/scripts.jsp"></jsp:include>
</body>
</html>