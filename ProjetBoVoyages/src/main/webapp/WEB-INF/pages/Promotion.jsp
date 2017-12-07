<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<script type="text/javascript"
	src="<c:url value="/assets/js/promotionPDF.js"/>"></script>

<title>Promotion</title>
</head>
<body>

	<h1>Liste des voyages en promotions</h1>

	<table class="table table-bordered">
		<tr>
			<td>Destination</td>
			<td>Prix de base</td>
			<td>Prix avec réduction</td>
			<td>Date de Départ</td>
			<td>Durée du séjour (jours)</td>
			<td>Changer la promotion</td>

		</tr>

		<c:forEach var="voyage" items="${listeVoyage}">
			<tr>
				<td>${voyage.pays}</td>
				<td>${voyage.prix}</td>
				<td>${voyage.prix-voyage.prix*voyage.reduction/100}</td>
				<td>${voyage.dateDepart}</td>
				<td>${voyage.duree}</td>
				<th><form method="GET" action="modifierPromotion">
						<input type="hidden" name="identifiantVoyage" value="${voyage.id}">
						<input type="number" name="reduction"> <input
							type="submit">
					</form>
			</tr>

		</c:forEach>
	</table>



	<div id="promotion">




		<h1>Liste des voyages en promotions</h1>

		<table class="table table-bordered">
			<tr>
				<td>Destination</td>
				<td>Prix de base</td>
				<td>Prix après promotion</td>
				<td>Taux de réduction (en %)</td>
				<td>Date de Départ</td>
				<td>Durée du séjour (jours)</td>
			</tr>

			<c:forEach var="promotion" items="${listePromotion}">
				<tr>
					<td>${promotion.pays}</td>
					<td>${promotion.prix}</td>
					<td>${promotion.prix - promotion.prix*promotion.reduction/100}</td>
					<td>${promotion.reduction}</td>
					<td>${promotion.dateDepart}</td>
					<td>${promotion.duree}</td>

				</tr>

			</c:forEach>
		</table>
	</div>
	<button onclick="ecrirePDF()">PDF</button>
	
	<form method="POST" action="envoyerEmail">
		<div class="form-group">
			<label for="email" class="col-sm-2 control-label" >Email</label>
			<div class="col-sm-8">
				<input type="email" class="form-control" id="email" placeholder="Email" name="email" />				
			</div>
		</div>
		
		<input type="submit" value="Envoyer mail">
	</form>


</body>
</html>