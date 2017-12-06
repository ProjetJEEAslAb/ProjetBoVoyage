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
			</div>
		</div>
		
		<div class="form-group">
			<form:label for="pays" class="col-sm-2 control-label" path="continent">Continent</form:label>
			<div class="col-sm-8">
				<form:input  class="form-control" id="continent"
					placeholder="Continent" path="continent"/>
			</div>
		</div>
		
		<div class="form-group">
			<form:label for="places" class="col-sm-2 control-label" path="placesDisponibles">Places disponibles</form:label>
			<div class="col-sm-8">
				<form:input  class="form-control" id="places"
					placeholder="Places disponibles" path="placesDisponibles"/>
			</div>
		</div>
		
	
		
		<div class="col-sm-offset-2 col-sm-8">
			<input type="submit" value="Ajouter voyage" class="btn btn-info" />
		</div>
		
	</form:form>

</body>
</html>