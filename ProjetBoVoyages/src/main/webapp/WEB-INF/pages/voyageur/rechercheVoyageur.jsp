<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
	<title>Rechercher un voyageur</title>
<body>


	<h2 style="text-align: center; color: royalblue">Formulaire de
		recherche</h2>

	<form:form class="form-horizontal" method='POST' action="rechercheVoyageur" modelAttribute="voyageurRecherche">

		<div class="form-group">
			<form:label for="id" class="col-sm-2 control-label" path="id">Id voyageur
				* :</form:label>
			<div class="col-sm-4">
				<form:input type="number" class="form-control" id="id"
					placeholder="Id" path="id" required="required" />
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<!-- offset permet de saute les deux premieres colonnes -->
				<input type="submit" class="btn btn-primary"
					value="Rechercher un
					voyageur" />

			</div>
		</div>
	</form:form>

	<br />
	<h1 style="color: blue; text-align: center">Voyageur trouvé</h1>
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

			<tr>
				<td>${voyageur.id}</td>
				<td>${voyageur.civilite}</td>
				<td>${voyageur.nom}</td>
				<td>${voyageur.prenom}</td>
				<td>${voyageur.adresse}</td>
				<td>${voyageur.telephone}</td>
				<td>${voyageur.dateNaissance}</td>
				<td>${voyageur.client}</td>
			</tr>

		</table>
	</div>
</body>
</html>