<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="<c:url value="/assets/libs/bootstrap-3.3.7/css/bootstrap.css" />">
<link rel="stylesheet"
	href="<c:url value="/assets/libs/bootstrap-3.3.7/css/bootstrap-theme.css" />">
<script type="text/javascript"
	src="<c:url value="/assets/libs/jquery-3.2.1.js" />"></script>
<script type="text/javascript" src="<c:url value="/assets/js/promotionPDF.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/assets/libs/bootstrap-3.3.7/js/bootstrap.js" />"></script>

<title>Recherche voyage</title>
</head>
<body>

	<h1>Recherche d'un voyage</h1>
	<form:form method="POST" action="rechercheVoyage"
		class="form-horizontal" modelAttribute="voyageRecherche">

		<div class="form-group">
			<form:label for="pays" class="col-sm-2 control-label" path="pays">Pays</form:label>
			<div class="col-sm-8">
				<form:input class="form-control" id="pays" placeholder="Pays"
					path="pays" />
				<form:errors path="pays" />
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
			<form:label for="prix" class="col-sm-2 control-label" path="prix">Budget maximal</form:label>
			<div class="col-sm-8">
				<form:input class="form-control" id="prix" placeholder="Prix"
					path="prix" />
				<form:errors path="prix" />
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
 
		<div class="form-group">
			<form:label for="dateDepart" class="col-sm-2 control-label"
				path="dateString">Date de départ</form:label>
			<div class="col-sm-8">
				<form:input type="date" class="form-control" id="dateDepart"
					placeholder="Date de départ" path="dateString" />
				<form:errors path="dateString" />
			</div>
		</div>


		<div class="col-sm-offset-2 col-sm-8">
			<input type="submit" value="Rechercher voyage" class="btn btn-info" />
		</div>

	</form:form>
	
	
	
	
	
</body>
</html>