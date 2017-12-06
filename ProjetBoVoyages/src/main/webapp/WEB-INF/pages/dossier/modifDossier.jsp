<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet"
	href="assets/libs/bootstrap-3.3.7/css/bootstrap.css">
<link rel="stylesheet"
	href="assets/libs/bootstrap-3.3.7/css/bootstrap-theme.css">
<script type="text/javascript" src="assets/libs/jquery-3.2.1.js"></script>
<script type="text/javascript"
	src="assets/libs/bootstrap-3.3.7/js/bootstrap.js"></script>

<title>Modification Dossier</title>
</head>
<body>

	<h2 style="text-align: center; color: royalblue">Formulaire
		de modification de dossier</h2>

	<form:form class="form-horizontal" method='post' action="modifDoss"
		modelAttribute="dossierModif">

		<div class="form-group">
			<label for="inputCivilite" class="col-sm-2 control-label">ID
				* :</label>
			<div class="col-sm-4">
				<form:input type="text" class="form-control" id="inputID"
					path="id" placeholder="ID" name="pId"
					required="required" />
				<form:errors path="id" cssStyle="color:red" />
			</div>
		</div>

		<div class="form-group">
			<label for="inputCivilite" class="col-sm-2 control-label">Statut
				* :</label>
			<div class="col-sm-4">
				<form:input type="text" class="form-control" id="inputStatut"
					path="statut" placeholder="Statut" name="pStatut"
					required="required" />
				<form:errors path="statut" cssStyle="color:red" />
			</div>
		</div>

		<div class="form-group">
			<label for="inputSolde" class="col-sm-2 control-label">Code
				CB * :</label>
			<div class="col-sm-4">
				<form:input type="text" class="form-control" id="inputCodeCB"
					path="codeCB" placeholder="Code CB" name="pCodeCB"
					required="required" />
				<form:errors path="codeCB" cssStyle="color:red" />
			</div>
		</div>

		<div class="form-group">
			<label for="inputPrenom" class="col-sm-2 control-label">Assurance
				* :</label>
			<div class="col-sm-4">
				<form:input type="text" class="form-control" id="inputAssurance"
					path="assurance" placeholder="Assurance" name="pAssurance"
					required="required" />
				<form:errors path="assurance" cssStyle="color:red" />
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<!-- offset permet de saute les deux premieres colonnes -->

				<button type="submit" class="btn btn-primary" value="">Modifier
					le dossier</button>
			</div>
		</div>
	</form:form>


</body>
</html>