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


<title>Modifier Statut Dossier</title>
</head>
<body background="<c:url value="/assets/images/dossier.jpg" />">
<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">BoVoyage</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Voyages<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="${pageContext.request.contextPath}/voyage/afficheListeVoyage">Liste</a></li>
						<li><a href="${pageContext.request.contextPath}/voyage/afficheAjout">Ajout</a></li>
						<li><a href="${pageContext.request.contextPath}/voyage/modifVoyage">Modification</a></li>
						<li><a href="${pageContext.request.contextPath}/voyage/afficheSuppr">Suppression</a></li>
						<li><a href="${pageContext.request.contextPath}/voyage/rechercheVoyage">Recherche</a></li>
						<li><a href="${pageContext.request.contextPath}/voyage/promotion">Promotion</a></li>
					</ul>
				</li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Voyageurs<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="${pageContext.request.contextPath}/voyageur/listeVoyageurs">Liste</a></li>
						<li><a href="${pageContext.request.contextPath}/voyageur/afficheAjout">Ajout</a></li>
						<li><a href="${pageContext.request.contextPath}/voyageur/afficheModif">Modification</a></li>
						<li><a href="${pageContext.request.contextPath}/voyageur/afficheSuppr">Suppression</a></li>
						<li><a href="${pageContext.request.contextPath}/voyageur/afficheRecherche">Recherche</a></li>
					</ul>
				</li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Dossiers<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="${pageContext.request.contextPath}/dossier/listeDossiers">Liste</a></li>
						<li><a href="${pageContext.request.contextPath}/dossier/afficheAjout">Ajout</a></li>
						<li><a href="${pageContext.request.contextPath}/dossier/afficheModif">Modification</a></li>
						<li><a href="${pageContext.request.contextPath}/dossier/afficheModifStatut">Modification statut</a></li>
						<li><a href="${pageContext.request.contextPath}/dossier/afficheSuppr">Suppression</a></li>
						<li><a href="${pageContext.request.contextPath}/dossier/afficheRecherche">Recherche</a></li>
					</ul>
				</li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<c:if test="${sessionScope.logged}">
					<li><a href="#">${sessionScope.username}</a></li>
					<li class="disabled"><a href="#"><img src="http://crdp-pupitre.ac-clermont.fr/upload/_237_587_2015-01-05_09-46-46_.gif" height="30px" /></a></li>
					<li><a href="${pageContext.request.contextPath}/logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
				</c:if>
				<c:if test="${not sessionScope.logged}">
					<li><a href="${pageContext.request.contextPath}/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
				</c:if>
			</ul>
		</div>
	</nav>

	<h2>Formulaire
		de modification de dossier</h2>

	<form:form class="form-horizontal" method='post' action="modifierStatut"
		modelAttribute="statutModif">

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
			<label for="inputCivilite" class="col-sm-2 control-label"> Nouveau statut
				* :</label>
			<div class="col-sm-4">
				<form:input type="text" class="form-control" id="inputStatut"
					path="statut" placeholder="Nouveau statut" name="pStatut"
					required="required" />
				<form:errors path="statut" cssStyle="color:red" />
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<!-- offset permet de saute les deux premieres colonnes -->

				<button type="submit" class="btn btn-success" value="">Modifier
					le statut du dossier</button>
			</div>
		</div>
	</form:form>

<h1 style="color: red; text-align: center">${message}</h1>

</body>
</html>