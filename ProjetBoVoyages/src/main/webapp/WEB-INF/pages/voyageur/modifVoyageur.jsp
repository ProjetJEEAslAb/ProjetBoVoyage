<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html >
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="<c:url value="/assets/libs/bootstrap-3.3.7/css/bootstrap.css" />">
	<link rel="stylesheet" href="<c:url value="/assets/libs/bootstrap-3.3.7/css/bootstrap-theme.css" />">
	<script type="text/javascript" src="<c:url value="/assets/libs/jquery-3.2.1.js" />"></script>
	<script type="text/javascript" src="<c:url value="/assets/libs/bootstrap-3.3.7/js/bootstrap.js" />"></script>
	<title>Modifier un voyageur</title>
<body background="<c:url value="/assets/images/voyageur.jpg" />">
	<nav class="navbar navbar-inverse navbar-fixed-top" style="padding-bottom: 10px;">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="${pageContext.request.contextPath}/accueil"><img src="<c:url value="/assets/images/logo_poney.png" />" height="45px" /></a>
			</div>
			<div style="padding-top: 10px;">
				<c:if test="${sessionScope.logged}">
					<ul class="nav navbar-nav">
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">Voyages<span class="caret"></span></a>
							<ul class="dropdown-menu">
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
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">Agences<span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="${pageContext.request.contextPath}/agence/listeAgences">Liste</a></li>
								<li><a href="${pageContext.request.contextPath}/agence/afficheAjout">Ajout</a></li>
							</ul>
						</li>
					</ul>
				</c:if>
				<c:if test="${not sessionScope.logged}">
					<ul class="nav navbar-nav">
						<li class="active"><a href="${pageContext.request.contextPath}/accueil">Nos Offres</a></li>
						<li class="active"><a href="${pageContext.request.contextPath}/agence/listeAgences">Nos Agences</a></li>
					</ul>
				</c:if>
			<ul class="nav navbar-nav navbar-right">
				<c:if test="${sessionScope.logged}">
					<li><a href="#">${sessionScope.username}</a></li>
					<li class="disabled"><a href="#"><img src="<c:url value="/assets/images/iconeconnecte.svg" />" height="30px" /></a></li>
					<li><a href="${pageContext.request.contextPath}/logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
				</c:if>
				<c:if test="${not sessionScope.logged}">
					<li><a href="${pageContext.request.contextPath}/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
				</c:if>
			</ul>
			</div>
		</div>
	</nav>
	
	<div style="margin-top: 100px"></div>


	<h2>Modification de compte client</h2>



	<form:form class="form-horizontal" method='POST' action="modif"
		modelAttribute="voyageurModif">

		<div class="form-group">
			<form:label for="id" class="col-sm-2 control-label"
				path="id">Id voyageur
				* :</form:label>
			<div class="col-sm-4">
				<form:input type="number" class="form-control" id="id"
					placeholder="Id" path="id" required="required" />
			</div>
		</div>

		<div class="form-group">
			<form:label for="civilite" class="col-sm-2 control-label"
				path="civilite">Civilite
				* :</form:label>
			<div class="col-sm-4">
				<form:select class="form-control" id="civilite"
				model="type" path="civilite" required="required">
				<option value="Mr">Mr.</option>
				<option selected="selected" value="Mme">Mme.</option>
			</form:select>
			</div>
		</div>

		<div class="form-group">
			<form:label for="nom" class="col-sm-2 control-label" path="nom">Nom *
				:</form:label>
			<div class="col-sm-4">
				<form:input type="text" class="form-control" id="nom"
					placeholder="Nom" path="nom" required="required" />
			</div>
		</div>

		<div class="form-group">
			<form:label for="prenom" class="col-sm-2 control-label" path="prenom">Prenom
				* :</form:label>
			<div class="col-sm-4">
				<form:input type="text" class="form-control" id="prenom"
					placeholder="Prenom" path="prenom" required="required" />
			</div>
		</div>


		<div class="form-group">
			<form:label for="adresse" class="col-sm-2 control-label"
				path="adresse">Adresse * :</form:label>
			<div class="col-sm-4">
				<form:input type="text" class="form-control" id="adresse"
					placeholder="Adresse" path="adresse" required="required" />
			</div>
		</div>

		<div class="form-group">
			<form:label for="telephone" class="col-sm-2 control-label"
				path="telephone">Telephone
				* :</form:label>
			<div class="col-sm-4">
				<form:input type="text" class="form-control" id="telephone"
					placeholder="Telephone" path="telephone" required="required" />
			</div>
		</div>

		<!-- 		<div class="form-group"> -->
		<%-- 			<form:label for="dateNaissance" class="col-sm-2 control-label" --%>
		<%-- 				path="dateNaissance">Date --%>
		<%-- 				de Naissance * :</form:label> --%>
		<!-- 			<div class="col-sm-4"> -->
		<%-- 				<form:input type="date-local" class="form-control" --%>
		<%-- 					id="dateNaissance" placeholder="DateNaissance" path="dateNaissance" --%>
		<%-- 					required="required" /> --%>
		<!-- 			</div> -->
		<!-- 		</div> -->

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<!-- offset permet de saute les deux premieres colonnes -->

				<input type="submit" class="btn btn-success" value="Modifer un
				voyageur"/>
			</div>
		</div>
	</form:form>
</body>
</html>