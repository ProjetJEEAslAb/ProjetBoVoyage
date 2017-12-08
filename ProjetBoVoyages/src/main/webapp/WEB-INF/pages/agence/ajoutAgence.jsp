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
	<title>Ajout d'une Agence</title>
</head>
<body>
	
	<form:form class="form-horizontal" method="post" action="ajoutAgence" modelAttribute="ajoutAgence">
		<div class="form-group">
			<form:label for="adresse" class="col-sm-2 control-label" path="adresse">Adresse :</form:label>
			<div class="col-sm-8">
				<form:input type="text" class="form-control" id="adresse"
					placeholder="Adresse" path="adresse" required="required" />
				<form:errors path="adresse" />
			</div>
		</div>
		<div class="form-group">
			<form:label for="descriptionId" class="col-sm-2 control-label" path="description">Description :</form:label>
			<div class="col-sm-8">
				<form:input type="text" class="form-control" id="descriptionId"
					placeholder="Description" path="description" required="required" />
				<form:errors path="description" />
			</div>
		</div>
		<div class="col-sm-offset-2 col-sm-8">
			<input type="submit" value="Ajouter agence" class="btn btn-success" />
		</div>
	</form:form>
</body>
</html>
