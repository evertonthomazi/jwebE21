<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="inc/header.jsp"></jsp:include>
<header>
	<h1>Lista de Filmes</h1>
	<hr>
</header>

<main>
	<div class="container mt-5">
		<div class="row justify-content-center"></div>
		<c:forEach var="filme" items="${listaFilmes}">
			<div class="card movie_card">

				<img src="<c:out value="${filme.capa}" />" class="card-img-top"
					alt="...">
				<div class="card-body">
					<a href="filmes?action=verFilme&id=${filme.id}"><i
						class="fas fa-play play_button" data-toggle="tooltip"
						data-placement="bottom" title="Play Trailer"> </i></a>
					<h5 class="card-title">
						<c:out value="${filme.titulo}" />
					</h5>
					<span class="movie_info"><c:out
							value="${filme.classificacao}" /></span> <span
						class="movie_info float-right">
						
						<i class="fas fa-star"></i>
						<c:out value="${filme.genero}" /></span>
				</div>

			</div>
		</c:forEach>
	</div>
	</div>
</main>
<jsp:include page="inc/scripts.jsp"></jsp:include>
</body>
</html>