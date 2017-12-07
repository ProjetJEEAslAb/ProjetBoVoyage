<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="<c:url value="/assets/libs/bootstrap-3.3.7/css/bootstrap.css" />">
	<link rel="stylesheet" href="<c:url value="/assets/libs/bootstrap-3.3.7/css/bootstrap-theme.css" />">
	<script type="text/javascript" src="<c:url value="/assets/libs/jquery-3.2.1.js" />"></script>
	<script type="text/javascript" src="<c:url value="/assets/libs/bootstrap-3.3.7/js/bootstrap.js" />"></script>
	<title>Liste des voyageurs</title>
<body background="<c:url value="/assets/images/voyageur.jpg" />">
<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">BoVoyage</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Voyages<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="${pageContext.request.contextPath}/voyage/afficheListeVoyage">Liste</a></li>
						<li><a href="${pageContext.request.contextPath}/voyage/afficheAjout">Ajout</a></li>
						<li><a href="${pageContext.request.contextPath}/voyage/modifVoyage">Modification</a></li>
						<li><a href="${pageContext.request.contextPath}/voyage/afficheSuppr">Suppression</a></li>
						<li><a href="${pageContext.request.contextPath}/voyage/rechercheVoyage">Recherche</a></li>
						<li><a href="${pageContext.request.contextPath}/voyage/promotion">Promotion</a></li>
					</ul>
				</li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Voyageurs<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="${pageContext.request.contextPath}/voyageur/listeVoyageurs">Liste</a></li>
						<li><a href="${pageContext.request.contextPath}/voyageur/afficheAjout">Ajout</a></li>
						<li><a href="${pageContext.request.contextPath}/voyageur/afficheModif">Modification</a></li>
						<li><a href="${pageContext.request.contextPath}/voyageur/afficheSuppr">Suppression</a></li>
						<li><a href="${pageContext.request.contextPath}/voyageur/afficheRecherche">Recherche</a></li>
					</ul>
				</li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Dossiers<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="${pageContext.request.contextPath}/dossier/listeDossiers">Liste</a></li>
						<li><a href="${pageContext.request.contextPath}/dossier/afficheAjout">Ajout</a></li>
						<li><a href="${pageContext.request.contextPath}/dossier/afficheModif">Modification</a></li>
						<li><a href="${pageContext.request.contextPath}/dossier/afficheModifStatut">Modification statut</a></li>
						<li><a href="${pageContext.request.contextPath}/dossier/afficheSuppr">Suppression</a></li>
						<li><a href="${pageContext.request.contextPath}/dossier/afficheRecherche">Recherche</a></li>
					</ul>
				</li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<c:if test="${sessionScope.logged}">
					<li><a href="#">${sessionScope.username}</a></li>
					<li class="disabled"><a href="#"><img src="http://crdp-pupitre.ac-clermont.fr/upload/_237_587_2015-01-05_09-46-46_.gif" height="30px" /></a></li>
					<li><a href="${pageContext.request.contextPath}/logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
				</c:if>
				<c:if test="${not sessionScope.logged}">
					<li><a href="${pageContext.request.contextPath}/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
				</c:if>
			</ul>
		</div>
	</nav>



	<h2>Liste des voyageurs</h2>
	<div align="center">
		<table class="table table-bordered">
			<tr>
				<th>ID</th>
				<th>civilite</th>
				<th>nom</th>
				<th>prenom</th>
				<th>adresse</th>
				<th>telephone</th>
				<th>dateNaissance</th>
				<th>client</th>
				<th>operation</th>

			</tr>

			<c:forEach var="voyageur" items="${listeVoyageurs}">
				<tr>
					<td>${voyageur.id}</td>
					<td>${voyageur.civilite}</td>
					<td>${voyageur.nom}</td>
					<td>${voyageur.prenom}</td>
					<td>${voyageur.adresse}</td>
					<td>${voyageur.telephone}</td>
					<td>${voyageur.dateNaissance}</td>
					<td>${voyageur.client}</td>
					<td><a
						href="${pageContext.request.contextPath}/voyageur/SupprimeViaLien?pId=${etudiant.id}">supprimer</a>|<a
						href="${pageContext.request.contextPath}/etudiant/ModifViaLien${etudiant.id}">modifier</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>