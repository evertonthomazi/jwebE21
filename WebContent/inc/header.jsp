<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Projeto Java WEB - Entra 21</title>

<!--  Style -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr"
	crossorigin="anonymous">

<style>
* {
	font-family: 'Poppins', sans-serif;
	-webkit-user-select: none;
	-moz-user-select: -moz-none;
	-o-user-select: none;
	user-select: none;
}

img {
	-webkit-user-drag: none;
	-moz-user-drag: none;
	-o-user-drag: none;
	user-drag: none;
}

img {
	pointer-events: none;
}

.movie_card {
	padding: 0 !important;
	width: 15rem;
	margin: 14px;
	border-radius: 10px;
	box-shadow: 0 3px 4px 0 rgba(0, 0, 0, 0.2), 0 4px 15px 0
		rgba(0, 0, 0, 0.19);
	float: left;
}

.movie_card img {
	border-top-left-radius: 10px;
	border-top-right-radius: 10px;
	height: 20rem;
}

.movie_info {
	color: #5e5c5c;
}

.movie_info i {
	font-size: 20px;
}

.card-title {
	width: 80%;
	height: 4rem;
}

.play_button {
	background-color: #ff3d49;
	position: absolute;
	width: 60px;
	height: 60px;
	border-radius: 50%;
	right: 5px;
	bottom: 111px;
	font-size: 27px;
	padding-left: 21px;
	padding-top: 16px;
	color: #FFFFFF;
	cursor: pointer;
	top: 256px;
}

span.movie_info {
	font-size: 12px;
}
</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href="index.jsp">Home</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Pessoas </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="pessoa?action=listPessoas">Listar</a>
						<a class="dropdown-item" href="pessoa?action=cadPessoa">Cadastrar</a>
					</div></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Filmes </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="filmes?action=listFilmes">Listar</a>
						<a class="dropdown-item" href="filmes?action=cadFilme">Cadastrar</a>
					</div></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Series </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="series?action=listSeries">Listar</a>
						<a class="dropdown-item" href="series?action=cadSerie">Cadastrar</a>
					</div></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Diário </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="diario?action=listNotas">Listar</a>
						<a class="dropdown-item" href="diario?action=cadNota">Cadastrar</a>
					</div></li>
			</ul>
		</div>
	</nav>
	<div class="container-fluid">