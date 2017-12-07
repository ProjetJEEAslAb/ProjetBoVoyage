<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

<title>Liste des dossiers</title>
</head>
<body>

<h1 style="color: blue; text-align: center">Liste des Dossiers</h1>
	<div align="center">
		<table class="table table-bordered">
			<tr>
				<th>ID</th>
				<th>Statut</th>
				<th>Assurance</th>
				<th>Code CB</th>
				<th>operations</th>
			</tr>

			<c:forEach var="dossier" items="${listeDossiers}">
				<tr>
					<td>${dossier.id}</td>
					<td>${dossier.statut}</td>
					<td>${dossier.assurance}</td>
					<td>${dossier.codeCB}</td>
					
					<td><a
						href="${pageContext.request.contextPath}/voyageur/SupprimeViaLien?pId=${etudiant.id}">supprimer</a>|<a
						href="${pageContext.request.contextPath}/etudiant/ModifViaLien${etudiant.id}">modifier</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>