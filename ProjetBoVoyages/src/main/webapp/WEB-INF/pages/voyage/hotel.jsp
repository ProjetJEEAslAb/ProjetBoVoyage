<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<title>Ajout d'un hôtel</title>
</head>
<body>
	<h2>Ajout d'un hôtel</h2>
	
	<form:form method="POST" action="ajouteAutreHotel" class="form-horizontal"
		modelAttribute="hotelAjoute">
		
		<div class="form-group">
			<form:label for="adresse" class="col-sm-2 control-label" path="adresse">Adresse</form:label>
			<div class="col-sm-8">
				<form:input class="form-control" id="adresse" placeholder="Adresse"
					path="adresse" />
				<form:errors path="adresse" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label for="chambre" class="col-sm-2 control-label" path="chambre">Chambre</form:label>
			<div class="col-sm-8">
				<form:select class="form-control" id="hebergement"
					placeholder="Hébergement" path="formule.hebergement">
					<option>Simple</option>
					<option>Double</option>
				</form:select>
			</div>
		</div>
		
		<div class="form-group">
			<form:label for="dateTemp" class="col-sm-2 control-label"
				path="dateTemp">Date d'arrivée</form:label>
			<div class="col-sm-8">
				<form:input type="date" class="form-control" id="dateTemp"
					placeholder="Date d'arrivée" path="dateTemp" />
				<form:errors path="dateTemp" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label for="duree" class="col-sm-2 control-label" path="duree">Durée</form:label>
			<div class="col-sm-8">
				<form:input class="form-control" id="duree" placeholder="Durée"
					path="duree" />
				<form:errors path="duree" />
			</div>
		</div>
		
		
		
		<div class="col-sm-offset-2 col-sm-8">
			<input type="submit" value="Ajouter un autre hotel" class="btn btn-info" />
		</div>
		
	</form:form>
	
	<form:form method="POST" action="ajouteDernierHotel" class="form-horizontal"
		modelAttribute="hotelAjoute">
	
	<div class="col-sm-offset-2 col-sm-8">
			<input type="submit" value="Valider" class="btn btn-info" />
		</div>
	
	</form:form>

</body>
</html>