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

<title>Suppression d'un voyage</title>
</head>
<body>

<form:form method="POST" action="supprimerVoyage" class="form-horizontal"
		modelAttribute="voyageSuppr">
		
		<div class="form-group">
			<form:label for="id" class="col-sm-2 control-label" path="id">ID *:</form:label>
			<div class="col-sm-8">
				<form:input class="form-control" id="id" placeholder="ID"
					path="id" />
				<form:errors path="id" />
			</div>
		</div>
		
		<div class="col-sm-offset-2 col-sm-8">
			<input type="submit" value="Supprimer voyage" class="btn btn-info" />
		</div>

	</form:form>
		


</body>
</html>