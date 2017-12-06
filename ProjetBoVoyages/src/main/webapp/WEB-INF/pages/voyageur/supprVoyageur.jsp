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
	<title>Supprimer un voyageur</title>
<body>


	<h2 style="text-align: center; color: royalblue">Formulaire de
		suppression</h2>

	<form:form class="form-horizontal" method='POST' action="supprVoyageur" modelAttribute="voyageurSuppr">

		<div class="form-group">
			<form:label for="id" class="col-sm-2 control-label" path="id">Id voyageur
				* :</form:label>
			<div class="col-sm-4">
				<form:input type="number" class="form-control" id="id"
					placeholder="Id" path="id" required="required" />
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<!-- offset permet de saute les deux premieres colonnes -->
				<input type="submit" class="btn btn-primary"
					value="Supprimer un
					voyageur" />

			</div>
		</div>
	</form:form>
</body>
</html>