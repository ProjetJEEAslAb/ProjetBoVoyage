<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<script type="text/javascript"
	src="<c:url value="/assets/libs/bootstrap-3.3.7/js/bootstrap.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/assets/js/promotionPDF.js"/>"></script>

<title>Promotion</title>
</head>
<body>

	<h1>Liste des promotions</h1>

	<table class="">
		<tr>
			<td>Destination</td>
			<td>Prix</td>
			<td>Date de Départ</td>
			<td>Durée du séjour</td>
		</tr>

		<c:forEach var="promotion" items="${listePromotion}">
			<tr>
				<td>${promotion.pays}</td>
				<td>${promotion.prix}</td>
				<td>${promotion.duree}</td>
				<td>${promotion.dateDepart}</td>
			</tr>

		</c:forEach>
	</table>
	
		<button onclick="ecrirePDF()">PDF</button>
	

</body>
</html>