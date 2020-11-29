<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="inc/header.jsp"></jsp:include>

<main>
	<fieldset>
		<legend>Cadastro</legend>
		<div>
			<form action="series" method="post">
				<ul style="list-style: none;">
					<li><label>Titulo:</label> <input class="form-control col-5"
						type="text" name="titulo" placeholder="Informe um titulo...">
						<span id="nomeValidate"></span></li>
					<li><label>Classificacao:</label> <input
						class="form-control col-5" type="text" name="classificacao"
						placeholder="+14, +18"> <span id="classificacao"></span></li>
					<li><label>Gênero:</label> <input class="form-control col-5"
						type="text" name="genero" placeholder="Ação, aventura...">
						<span id="genero"></span></li>
					<li><label>Top series:</label> <input
						class="form-control col-5" type="text" name="topSeries"
						placeholder="Sim, nao"> <span id="topSeries"></span></li>
						<li><label>Capa:</label> <input
						class="form-control col-5" type="text" name="capa" placeholder="url jpg"> <span id="capa"></span></li>
					<li><input class="btn btn-success" type="submit"
						value="Cadastrar"></li>
				</ul>
			</form>
		</div>
	</fieldset>
</main>
</div>

<!--  Scripts -->
<jsp:include page="inc/scripts.jsp"></jsp:include>

</body>
</html>