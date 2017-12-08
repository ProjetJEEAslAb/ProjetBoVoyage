<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<title>Ajout d'un h�tel</title>
</head>
<body background="<c:url value="/assets/images/hotel.jpg" />">
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
	<h2>Ajout d'un h�tel</h2>
	
	<form:form method="POST" action="ajouteAutreHotel" class="form-horizontal"
		modelAttribute="hotelAjoute">
		
		<div class="form-group">
			<form:label for="adresse" class="col-sm-2 control-label" path="adresse">Adresse</form:label>
			<div class="col-sm-8">
				<form:input class="form-control" id="adresse" placeholder="Adresse"
					path="adresse" />
				<form:errors path="adresse" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label class="col-sm-2 control-label" path="chambre">Chambre</form:label>
			<div class="col-sm-8">
				<form:select class="form-control" 
					 path="chambre">
					<option>Simple</option>
					<option>Double</option>
				</form:select>
			</div>
		</div>
		
		<div class="form-group">
			<form:label for="dateTemp" class="col-sm-2 control-label"
				path="dateTemp">Date d'arriv�e</form:label>
			<div class="col-sm-8">
				<form:input type="date" class="form-control" id="dateTemp"
					placeholder="Date d'arriv�e" path="dateTemp" />
				<form:errors path="dateTemp" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label for="duree" class="col-sm-2 control-label" path="duree">Dur�e</form:label>
			<div class="col-sm-8">
				<form:input class="form-control" id="duree" placeholder="Dur�e"
					path="duree" />
				<form:errors path="duree" />
			</div>
		</div>
		
		
		
		<div class="col-sm-offset-2 col-sm-8">
			<input type="submit" value="Ajouter un hotel" class="btn btn-success" />
		</div>
		
	</form:form>
	<br/>
	<br/>
	<br/>
	<form:form method="POST" action="ajouteDernierHotel" class="form-horizontal"
		modelAttribute="hotelAjoute">
	
	<div class="col-sm-offset-2 col-sm-8">
			<input type="submit" value="Valider" class="btn btn-success" />
		</div>
	
	</form:form>

</body>
</html>