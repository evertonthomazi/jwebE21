<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="inc/header.jsp"></jsp:include>

	<main>
		<fieldset>
			<legend>Cadastro</legend>
			<div>
				<form action="pessoa" method="post">
					<ul style="list-style: none;">
						<li>
							<label>Nome:</label>
							<input class="form-control col-5" type="text" name="nome" placeholder="Informe um nome...">
							<span id="nomeValidate"></span>
						</li>
						<li>
							<label>Nascimento:</label>
							<input class="form-control col-5" type="date" name="dataNascimento" placeholder="01/01/2000">
							<span id="dateNascValidate"></span>
						</li>
						<li>
							<label>CPF:</label>
							<input class="form-control col-5" type="text" name="cpf">
							<span id="CPF"></span>
						</li>
						<li>
							<label>Sexo:</label>
							<input type="radio" name="sexo" value="M"> Masc
							<input type="radio" name="sexo" value="F"> Fem
							<span id="sexoValidate"></span>
						</li>
						<li>
							<input class="btn btn-success" type="submit" value="Cadastrar">
						</li>
					</ul>
				</form>
			</div>
		</fieldset>
	</main>
</div>

<!--  Scripts -->
<jsp:include page="inc/scripts.jsp"></jsp:include>

<!-- Script customizado para cadastro -->

<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.0/jquery.mask.js"></script>
<script>
    $(document).ready(function () { 
        var $seuCampoCpf = $("#CPF");
        $seuCampoCpf.mask('000.000.000-00', {reverse: true});
    });
</script>

</body>
</html>