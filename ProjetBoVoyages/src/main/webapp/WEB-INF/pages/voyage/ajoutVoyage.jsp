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
<title>Ajout d'un voyage</title>
</head>
<body>
	<h2>Ajout</h2>

	<form:form method="POST" action="ajouteVoyage" class="form-horizontal"
		modelAttribute="voyageAjoute">
		<div class="form-group">
			<form:label for="pays" class="col-sm-2 control-label" path="pays">Pays</form:label>
			<div class="col-sm-8">
				<form:input class="form-control" id="pays" placeholder="Pays"
					path="pays" />
				<form:errors path="pays" />
			</div>
		</div>

		<div class="form-group">
			<form:label for="pays" class="col-sm-2 control-label"
				path="continent">Continent</form:label>
			<div class="col-sm-8">
				<form:select class="form-control" id="continent"
					placeholder="Continent" path="continent">
					<option>Europe</option>
					<option>Asie</option>
					<option>Am�rique du nord</option>
					<option>Am�rique du sud</option>
					<option>Oc�anie</option>
				</form:select>
			</div>
		</div>

		<div class="form-group">
			<form:label for="places" class="col-sm-2 control-label"
				path="placesDisponibles">Places disponibles</form:label>
			<div class="col-sm-8">
				<form:input class="form-control" id="places"
					placeholder="Places disponibles" path="placesDisponibles" />
				<form:errors path="placesDisponibles" />
			</div>
		</div>

		<div class="form-group">
			<form:label for="prix" class="col-sm-2 control-label" path="prix">Prix</form:label>
			<div class="col-sm-8">
				<form:input class="form-control" id="prix" placeholder="Prix"
					path="prix" />
				<form:errors path="prix" />
			</div>
		</div>

		<div class="form-group">
			<form:label for="dateDepart" class="col-sm-2 control-label"
				path="dateString">Date de d�part</form:label>
			<div class="col-sm-8">
				<form:input type="date" class="form-control" id="dateDepart"
					placeholder="Date de d�part" path="dateString" />
				<form:errors path="dateString" />
			</div>
		</div>

		<div class="form-group">
			<form:label for="duree" class="col-sm-2 control-label" path="duree">Dur�e</form:label>
			<div class="col-sm-8">
				<form:input class="form-control" id="duree" placeholder="Dur�e"
					path="duree" />
				<form:errors path="duree" />
			</div>
		</div>

		<div class="form-group">
			<form:label for="hebergement" class="col-sm-2 control-label"
				path="formule.hebergement">H�bergement</form:label>
			<div class="col-sm-8">
				<form:select class="form-control" id="hebergement"
					placeholder="H�bergement" path="formule.hebergement">
					<option>H�bergement seul</option>
					<option>Petit d�jeuner</option>
					<option>Demi-pension</option>
					<option>Pension compl�te</option>
					<option>Oc�anie</option>
				</form:select>
			</div>
		</div>

		<div class="form-group">
			<form:label for="compagnie" class="col-sm-2 control-label" path="formule.avion.compagnie">Compagnie a�rienne</form:label>
			<div class="col-sm-8">
				<form:input class="form-control" id="compagnie" placeholder="Compagnie a�rienne"
					path="formule.avion.compagnie" />
				<form:errors path="formule.avion.compagnie" />
			</div>
		</div>


		<div class="form-group">
			<form:label for="heureDepart" class="col-sm-2 control-label"
				path="formule.avion.depart">Horaire de l'avion pour le d�part</form:label>
			<div class="col-sm-8">
				<form:input type="datetime-local" class="form-control" id="heureDepart"
					placeholder="Horaire de l'avion pour le d�part" path="formule.avion.depart" />
				<form:errors path="dateString" />
			</div>
		</div>

		<div class="form-group">
			<form:label for="heureDepart" class="col-sm-2 control-label"
				path="formule.avion.arrivee">Horaire de l'avion pour l'arriv�e</form:label>
			<div class="col-sm-8">
				<form:input type="datetime-local" class="form-control" id="heureDepart"
					placeholder="Horaire de l'avion pour l'arriv�e" path="formule.avion.arrivee" />
				<form:errors path="dateString" />
			</div>
		</div>

		
		
		<div class="form-group">
			<form:label for="categorie" class="col-sm-2 control-label" path="formule.voiture.categorie">Cat�gorie de voiture</form:label>
			<div class="col-sm-8">
				<form:input class="form-control" id="categorie" placeholder="Cat�gorie"
					path="formule.voiture.categorie" />
				<form:errors path="formule.voiture.categorie" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label for="loueur" class="col-sm-2 control-label" path="formule.voiture.loueur">Loueur de voiture</form:label>
			<div class="col-sm-8">
				<form:input class="form-control" id="loueur" placeholder="Loueur"
					path="formule.voiture.loueur" />
				<form:errors path="formule.voiture.loueur" />
			</div>
		</div>
		
		<div class="col-sm-offset-2 col-sm-8">
			<input type="submit" value="Ajouter voyage" class="btn btn-info" />
		</div>

	</form:form>

</body>
</html>