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


<title>Modifier un voyageur</title>
<body>


	<h2 style="text-align: center; color: royalblue">Formulaire de
		modification de compte</h2>

	<form class="form-horizontal" method='post' action="/modifVoyageur">

		<div class="form-group">
			<label for="inputCivilite" class="col-sm-2 control-label">Civilite
				* :</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="inputCivilite"
					placeholder="Civilite" name="pCivilite" required="required">
			</div>
		</div>

		<div class="form-group">
			<label for="inputSolde" class="col-sm-2 control-label">Nom *
				:</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="inputNom"
					placeholder="Nom" name="pNom" required="required">
			</div>
		</div>

		<div class="form-group">
			<label for="inputPrenom" class="col-sm-2 control-label">Prenom
				* :</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="inputPrenom"
					placeholder="Prenom" name="pPrenom" required="required">
			</div>
		</div>


		<div class="form-group">
			<label for="inputAdresse" class="col-sm-2 control-label">Adresse
				* :</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="inputAdresse"
					placeholder="Adresse" name="pAdresse" required="required">
			</div>
		</div>

		<div class="form-group">
			<label for="inputTelephone" class="col-sm-2 control-label">Telephone
				* :</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="inputAdresse"
					placeholder="Telephone" name="pTelephone" required="required">
			</div>
		</div>

		<div class="form-group">
			<label for="inputDateNaissance" class="col-sm-2 control-label">Date
				de Naissance * :</label>
			<div class="col-sm-4">
				<input type="datetime-local" class="form-control"
					id="inputDateNaissance" placeholder="DateNaissance"
					name="pDateNaissance" required="required">
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<!-- offset permet de saute les deux premieres colonnes -->

				<button type="submit" class="btn btn-primary" >Modifer
					un voyageur</button>
			</div>
		</div>
	</form>
</body>
</html>