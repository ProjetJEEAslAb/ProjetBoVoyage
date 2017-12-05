<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="assets/libs/bootstrap-3.3.7/css/bootstrap.css">
	<link rel="stylesheet" href="https://bootswatch.com/3/superhero/bootstrap.min.css">
	<script type="text/javascript" src="assets/libs/jquery-3.2.1.js"></script>
	<script type="text/javascript" src="assets/libs/bootstrap-3.3.7/js/bootstrap.js"></script>
	<title>Accueil</title>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">BoVoyage</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Voyages<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Liste</a></li>
						<li><a href="${pageContext.request.contextPath}/voyage/afficheAjout">Ajout</a></li>
						<li><a href="#">Modification</a></li>
						<li><a href="#">Suppression</a></li>
						<li><a href="#">Recherche</a></li>
					</ul>
				</li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Voyageurs<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Liste</a></li>
						<li><a href="#">Ajout</a></li>
						<li><a href="#">Modification</a></li>
						<li><a href="#">Suppression</a></li>
						<li><a href="#">Recherche</a></li>
					</ul>
				</li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Dossiers<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Liste</a></li>
						<li><a href="#">Ajout</a></li>
						<li><a href="#">Modification</a></li>
						<li><a href="#">Suppression</a></li>
						<li><a href="#">Recherche</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</nav>

	<h1>Accueil</h1>
</body>
</html>