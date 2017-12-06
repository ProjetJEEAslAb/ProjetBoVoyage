<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="assets/libs/bootstrap-3.3.7/css/bootstrap.css">
	<link rel="stylesheet" href="https://bootswatch.com/3/superhero/bootstrap.min.css">
	<script type="text/javascript" src="assets/libs/jquery-3.2.1.js"></script>
	<script type="text/javascript" src="assets/libs/bootstrap-3.3.7/js/bootstrap.js"></script>
<title>Ajout d'un voyage</title>
</head>
<body>
	<h2>Ajout</h2>

	<form:form method="POST" action="ajouteVoyage" class="form-horizontal"
		modelAttribute="voyageAjoute">
		<div class="form-group">
			<form:label for="pays" class="col-sm-2 control-label" path="pays">Pays</form:label>
			<div class="col-sm-8">
				<form:input class="form-control" id="pays"
 					placeholder="Pays" path="pays"/> 
 				<form:errors path="pays" /> 
			</div>
		</div>
		
		<div class="form-group">
			<form:label for="pays" class="col-sm-2 control-label" path="continent">Continent</form:label>
			<div class="col-sm-8">
				<form:select  class="form-control" id="continent"
					placeholder="Continent" path="continent">
					<option>Europe</option>
					<option>Asie</option>
					<option>Amérique du nord</option>
					<option>Amérique du sud</option>
					<option>Océanie</option>
				</form:select>
			</div>
		</div>
		
		<div class="form-group">
			<form:label for="places" class="col-sm-2 control-label" path="placesDisponibles">Places disponibles</form:label>
			<div class="col-sm-8">
				<form:input  class="form-control" id="places"
					placeholder="Places disponibles" path="placesDisponibles"/>
				<form:errors path="placesDisponibles" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label for="prix" class="col-sm-2 control-label" path="prix">Prix</form:label>
			<div class="col-sm-8">
				<form:input  class="form-control" id="prix"
					placeholder="Prix" path="prix"/>
				<form:errors path="prix" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label for="dateDepart" class="col-sm-2 control-label" path="dateString">Date de départ</form:label>
			<div class="col-sm-8">
				<form:input type="date" class="form-control" id="dateDepart"
					placeholder="Date de départ" path="dateString"/> 
				<form:errors path="dateString" /> 
			</div>
		</div>
		
		<div class="form-group">
			<form:label for="duree" class="col-sm-2 control-label" path="duree">Durée</form:label>
			<div class="col-sm-8">
				<form:input  class="form-control" id="duree"
 					placeholder="Durée" path="duree"/> 
 				<form:errors path="duree" /> 
			</div>
		</div>
		
		<div class="form-group">
			<form:label for="hebergement" class="col-sm-2 control-label" path="formule.hebergement">Hébergement</form:label>
			<div class="col-sm-8">
				<form:select  class="form-control" id="hebergement"
 					placeholder="Hébergement" path="formule.hebergement"> 
					<option>Hébergement seul</option>
					<option>Petit déjeuner</option>
					<option>Demi-pension</option>
					<option>Pension complète</option>
					<option>Océanie</option>
 				</form:select> 
			</div>
		</div>
	
		
		<div class="col-sm-offset-2 col-sm-8">
			<input type="submit" value="Ajouter voyage" class="btn btn-info" />
		</div>
		
	</form:form>

</body>
</html>