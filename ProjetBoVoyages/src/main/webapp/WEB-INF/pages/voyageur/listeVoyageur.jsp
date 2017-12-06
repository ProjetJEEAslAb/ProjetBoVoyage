<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet"
	href="assets/libs/bootstrap-3.3.7/css/bootstrap.css">
<link rel="stylesheet"
	href="https://bootswatch.com/3/superhero/bootstrap.min.css">
<script type="text/javascript" src="assets/libs/jquery-3.2.1.js"></script>
<script type="text/javascript"
	src="assets/libs/bootstrap-3.3.7/js/bootstrap.js"></script>


<title>Ajout d'un voyageur</title>
<body>

	<h1 style="color: blue; text-align: center">Liste des Voyageurs</h1>
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