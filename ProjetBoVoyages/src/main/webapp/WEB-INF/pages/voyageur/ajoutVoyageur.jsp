<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
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


	<h2 style="text-align: center; color: royalblue">Formulaire
		d'ajout de compte</h2>

	<form:form class="form-horizontal" method='POST' action="ajout"
		modelAttribute="voyageurAjout">

		<div class="form-group">
			<form:label for="civilite" class="col-sm-2 control-label"
				path="civilite">Civilite
				* :</form:label>
			<div class="col-sm-4">
				<form:input type="text" class="form-control" id="civilite"
					placeholder="Civilite" path="civilite" required="required" />
			</div>
		</div>

		<div class="form-group">
			<form:label for="nom" class="col-sm-2 control-label" path="nom">Nom *
				:</form:label>
			<div class="col-sm-4">
				<form:input type="text" class="form-control" id="nom"
					placeholder="Nom" path="nom" required="required" />
			</div>
		</div>

		<div class="form-group">
			<form:label for="prenom" class="col-sm-2 control-label" path="prenom">Prenom
				* :</form:label>
			<div class="col-sm-4">
				<form:input type="text" class="form-control" id="prenom"
					placeholder="Prenom" path="prenom" required="required" />
			</div>
		</div>


		<div class="form-group">
			<form:label for="adresse" class="col-sm-2 control-label"
				path="adresse">Adresse * :</form:label>
			<div class="col-sm-4">
				<form:input type="text" class="form-control" id="adresse"
					placeholder="Adresse" path="adresse" required="required" />
			</div>
		</div>

		<div class="form-group">
			<form:label for="telephone" class="col-sm-2 control-label"
				path="telephone">Telephone
				* :</form:label>
			<div class="col-sm-4">
				<form:input type="text" class="form-control" id="telephone"
					placeholder="Telephone" path="telephone" required="required" />
			</div>
		</div>

		<div class="form-group">
			<form:label for="dateNaissance" class="col-sm-2 control-label"
				path="dateString">Date 
				de Naissance * :</form:label>
			<div class="col-sm-4">
				<form:input type="date" class="form-control"
					id="dateNaissance" placeholder="DateNaissance" path="dateString"
					required="required" />
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<!-- offset permet de saute les deux premieres colonnes -->

				<input type="submit" class="btn btn-primary"
					value="Ajouter
					un voyageur" />
			</div>
		</div>
	</form:form>
</body>
</html>