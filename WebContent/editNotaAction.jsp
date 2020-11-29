<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="inc/header.jsp"></jsp:include>
		
	<main>
		<fieldset>
			<legend>Editando Cadastro de <c:out value="${objNota.assunto }" /> </legend>
			<div>
				<form action="diario" method="post">
					<ul style="list-style: none;">
						<li>
							<label>Assunto:</label>
							<input class="form-control col-5" type="text" name="assunto" value="${objNota.assunto }">
							<span id="assunto"></span>
						</li>
						<li>
							<label>Data:</label>
							<input class="form-control col-5" type="date" name="dtNota" value="${objNota.dtNota }">
							<span id="dtNota"></span>
						</li>
						<li>
							<label>Texto</label>
							<textarea class="form-control" id="texto" rows="3" name="texto">${objNota.texto }</textarea>
							<span id="texto"></span>
						</li>
						<li>
							<input type="hidden" name="id" value="${objNota.id }">
							<input class="btn btn-success" type="submit" value="Atualizar">
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