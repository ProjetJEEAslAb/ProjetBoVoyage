<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet"
	href="<c:url value="/assets/libs/bootstrap-3.3.7/css/bootstrap.css" />">
<link rel="stylesheet"
	href="<c:url value="/assets/libs/bootstrap-3.3.7/css/bootstrap-theme.css" />">
<script type="text/javascript"
	src="<c:url value="/assets/libs/jquery-3.2.1.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/assets/libs/bootstrap-3.3.7/js/bootstrap.js" />"></script>


<title>Recherche d'un dossier</title>
</head>
<body>

	<h2 style="text-align: center; color: royalblue">Formulaire de
		recherche d'un dossier</h2>

	<form:form class="form-horizontal" method='post' action="rechercheDoss"
		modelAttribute="dossierRecherche">

		<div class="form-group">
			<label for="inputCivilite" class="col-sm-2 control-label">ID
				* :</label>
			<div class="col-sm-4">
				<form:input type="text" class="form-control" id="inputID" path="id"
					placeholder="ID" name="pId" required="required" />
				<form:errors path="id" cssStyle="color:red" />
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<!-- offset permet de saute les deux premieres colonnes -->

				<button type="submit" class="btn btn-primary" value="">Rechercher
					le dossier</button>
			</div>
		</div>
	</form:form>

	<br />
	<h1 style="color: blue; text-align: center">Dossier trouvé</h1>
	<div align="center">
		<table class="table table-bordered">
			<tr>
				<th>ID</th>
				<th>Statut</th>
				<th>Assurance</th>
				<th>Code CB</th>
				<th>operation</th>
			</tr>

			<tr>
				<td>${dossier.id}</td>
				<td>${dossier.statut}</td>
				<td>${dossier.assurance}</td>
				<td>${dossier.codeCB}</td>
				<td><a
					href="${pageContext.request.contextPath}/voyageur/SupprimeViaLien?pId=${etudiant.id}">supprimer</a>|<a
					href="${pageContext.request.contextPath}/etudiant/ModifViaLien${etudiant.id}">modifier</a></td>
			</tr>

		</table>
	</div>

</body>
</html>