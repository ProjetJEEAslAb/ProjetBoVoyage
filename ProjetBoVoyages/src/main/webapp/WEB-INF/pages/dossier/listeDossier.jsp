<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet"
	href="<c:url value="/assets/libs/bootstrap-3.3.7/css/bootstrap.css" />">
<link rel="stylesheet"
	href="<c:url value="/assets/libs/bootstrap-3.3.7/css/bootstrap-theme.css" />">
<script type="text/javascript"
	src="<c:url value="/assets/libs/jquery-3.2.1.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/assets/libs/bootstrap-3.3.7/js/bootstrap.js" />"></script>

<title>Liste des dossiers</title>
</head>
<body background="<c:url value="/assets/images/dossier.jpg" />">
	<nav class="navbar navbar-inverse navbar-fixed-top" style="padding-bottom: 10px;">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#"><img src="<c:url value="/assets/images/logo_poney.png" />" height="45px" /></a>
			</div>
			<div style="padding-top: 10px;">
				<c:if test="${sessionScope.logged}">
					<ul class="nav navbar-nav">
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">Voyages<span class="caret"></span></a>
							<ul class="dropdown-menu">
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
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">Agences<span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="${pageContext.request.contextPath}/agence/listeAgences">Liste</a></li>
								<li><a href="${pageContext.request.contextPath}/agence/afficheAjout">Ajout</a></li>
							</ul>
						</li>
					</ul>
				</c:if>
				<c:if test="${not sessionScope.logged}">
					<ul class="nav navbar-nav">
						<li class="active"><a href="${pageContext.request.contextPath}/accueil">Nos Offres</a></li>
						<li class="active"><a href="${pageContext.request.contextPath}/agence/listeAgences">Nos Agences</a></li>
					</ul>
				</c:if>
			<ul class="nav navbar-nav navbar-right">
				<c:if test="${sessionScope.logged}">
					<li><a href="#">${sessionScope.username}</a></li>
					<li class="disabled"><a href="#"><img src="<c:url value="/assets/images/iconeconnecte.svg" />" height="30px" /></a></li>
					<li><a href="${pageContext.request.contextPath}/logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
				</c:if>
				<c:if test="${not sessionScope.logged}">
					<li><a href="${pageContext.request.contextPath}/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
				</c:if>
			</ul>
			</div>
		</div>
	</nav>
	
	<div style="margin-top: 100px"></div>

<h2>Liste des Dossiers</h2>
	<div align="center">
		<table class="table table-bordered">
			<tr>
				<th>ID</th>
				<th>Statut</th>
				<th>Assurance</th>
				<th>Code CB</th>
				<th>operations</th>
			</tr>

			<c:forEach var="dossier" items="${listeDossiers}">
				<tr>
					<td>${dossier.id}</td>
					<td>${dossier.statut}</td>
					<td>${dossier.assurance}</td>
					<td>${dossier.codeCB}</td>
					
					<td><a
						href="${pageContext.request.contextPath}/voyageur/SupprimeViaLien?pId=${etudiant.id}">supprimer</a>|<a
						href="${pageContext.request.contextPath}/etudiant/ModifViaLien${etudiant.id}">modifier</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>