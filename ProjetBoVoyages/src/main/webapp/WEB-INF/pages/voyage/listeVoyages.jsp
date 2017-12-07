<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

<title>Affichage des voyages Agent</title>
</head>
<body>
	<h1>${continent}</h1>
	<h1 style="color: blue; text-align: center">Liste des Voyages
		disponibles</h1>
	<div align="center">
		<table class="table table-bordered">
			<tr>
				<th>ID</th>
				<th>Places disponibles</th>
				<th>Prix</th>
				<th>Date de départ</th>
				<th>Durée du séjour</th>
				<th>Pays</th>
				<th>Continent</th>
				<th>Hébergement</th>
				<th>Compagnie aérienne</th>
				<th>Horaire de départ du vol</th>
				<th>Horaire d'arrivée du vol</th>
				<th>Loueur de véhicule</th>
				<th>Catégorie de véhicule</th>
				<th>operations</th>
			</tr>

			<c:forEach var="voyage" items="${listeVoyages}">
			<c:if test="${voyage.continent==continent}">
				<tr>
					<td>${voyage.id}</td>
					<td>${voyage.placesDisponibles}</td>
					<td>${voyage.prix}</td>
					<td>${voyage.dateDepart}</td>
					<td>${voyage.duree}</td>
					<td>${voyage.pays}</td>
					<td>${voyage.continent}</td>
					<td>${voyage.formule.hebergement}</td>
					<td>${voyage.formule.avion.compagnie}</td>
					<td>${voyage.formule.avion.horaireDepart}</td>
					<td>${voyage.formule.avion.horaireArrivee}</td>
					<td>${voyage.formule.voiture.loueur}</td>
					<td>${voyage.formule.voiture.categorie}</td>

					<td><a
						href="${pageContext.request.contextPath}/voyageur/SupprimeViaLien?pId=${etudiant.id}">supprimer</a>|<a
						href="${pageContext.request.contextPath}/etudiant/ModifViaLien${etudiant.id}">modifier</a></td>
				</tr>
				</c:if>
			</c:forEach>
		</table>
	</div>

</body>
</html>