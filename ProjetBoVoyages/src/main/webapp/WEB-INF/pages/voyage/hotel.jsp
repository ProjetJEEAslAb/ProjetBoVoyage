<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	
	<form:form method="POST" action="ajouteDernierHotel" class="form-horizontal"
		modelAttribute="voyageAjoute">
		
		<div class="form-group">
			<form:label for="chambre" class="col-sm-2 control-label" path="chambre">Chambre</form:label>
			<div class="col-sm-8">
				<form:input class="form-control" id="chambre" placeholder="Chambre"
					path="chambre" />
				<form:errors path="chambre" />
			</div>
		</div>
		
		<div class="col-sm-offset-2 col-sm-8">
			<form:input type="submit" value="Ajouter hotel et valider" class="btn btn-info" />
		</div>
		
	</form:form>

</body>
</html>