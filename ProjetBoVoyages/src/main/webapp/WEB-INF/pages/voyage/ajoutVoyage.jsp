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
	<title>Ajout d'un voyage</title>
</head>
<body background="<c:url value="/assets/images/ajoutVoyage.jpg" />">
	<nav class="navbar navbar-inverse navbar-fixed-top" style="padding-bottom: 10px;">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#"><img src="<c:url value="/assets/images/logo_poney.png" />" height="45px" /></a>
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

	<h2>Ajout de voyage</h2>

	<form:form method="POST" action="ajouteVoyage" class="form-horizontal"
		enctype="multipart/form-data" modelAttribute="voyageAjoute">
		
		<hr/>
		
		<h4 style="text-align: center">Destination</h4>
		<div class="form-group">
			<form:label for="pays" class="col-sm-2 control-label"
				path="continent">Continent</form:label>
			<div class="col-sm-8">
				<form:select class="form-control" id="continent"
					placeholder="Continent" path="continent">
					<option>Europe</option>
					<option>Asie</option>
					<option>Afrique</option>
					<option value="AmNord">Am�rique du nord</option>
					<option value="AmSud">Am�rique du sud</option>
					<option value="Oceanie">Oc�anie</option>
				</form:select>
			</div>
		</div>
		<div class="form-group">
			<form:label for="pays" class="col-sm-2 control-label" path="pays" required="true">Pays</form:label>
			<div class="col-sm-8">
				<form:input class="form-control" id="pays" placeholder="Pays"
					path="pays" />
				<form:errors path="pays" />
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">Pays</label>
			<div class="col-sm-8">
				<input type="file" name="file" />
			</div>
		</div>
		<div class="form-group">
			<form:label for="descriptionVoyage" class="col-sm-2 control-label" path="descriptionVoyage">Description de voyage</form:label>
			<div class="col-sm-8">
				<form:input type="textarea" class="form-control" id="descriptionVoyage" placeholder="Description de voyage"
					path="descriptionVoyage" />
				<form:errors path="descriptionVoyage" />
			</div>
		</div>
		<hr/>
		
		<h4 style="text-align: center">Consid�rations pratiques</h4>
		<div class="form-group">
			<form:label for="prix" class="col-sm-2 control-label" path="prix">Prix</form:label>
			<div class="col-sm-8">
				<form:input class="form-control" id="prix" placeholder="Prix"
					path="prix" />
				<form:errors path="prix" />
			</div>
		</div>
		<div class="form-group">
			<form:label for="places" class="col-sm-2 control-label"
				path="placesDisponibles">Places disponibles</form:label>
			<div class="col-sm-8">
				<form:input class="form-control" id="places"
					placeholder="Places disponibles" path="placesDisponibles" />
				<form:errors path="placesDisponibles" />
			</div>
		</div>
		<div class="form-group">
			<form:label for="dateDepart" class="col-sm-2 control-label"
				path="dateString">Date de d�part</form:label>
			<div class="col-sm-8">
				<form:input type="date" class="form-control" id="dateDepart"
					placeholder="Date de d�part" path="dateString" />
				<form:errors path="dateString" />
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
		
		<div class="form-group">
			<form:label for="hebergement" class="col-sm-2 control-label"
				path="formule.hebergement">H�bergement</form:label>
			<div class="col-sm-8">
				<form:select class="form-control" id="hebergement"
					placeholder="H�bergement" path="formule.hebergement">
					<option>H�bergement seul</option>
					<option>Petit d�jeuner</option>
					<option>Demi-pension</option>
					<option>Pension compl�te</option>
				</form:select>
			</div>
		</div>

<hr/>
		<h4  style="text-align: center">Avion</h4>
		<div class="form-group">
			<form:label for="compagnie" class="col-sm-2 control-label" path="formule.avion.compagnie">Compagnie a�rienne</form:label>
			<div class="col-sm-8">
				<form:input class="form-control" id="compagnie" placeholder="Compagnie a�rienne"
					path="formule.avion.compagnie" />
				<form:errors path="formule.avion.compagnie" />
			</div>
		</div>
		<div class="form-group">
			<form:label for="heureDepart" class="col-sm-2 control-label"
				path="formule.avion.depart">Horaire de l'avion pour le d�part</form:label>
			<div class="col-sm-8">
				<form:input type="datetime-local" class="form-control" id="heureDepart"
					placeholder="Horaire de l'avion pour le d�part" path="formule.avion.depart" />
				<form:errors path="dateString" />
			</div>
		</div>
		<div class="form-group">
			<form:label for="heureDepart" class="col-sm-2 control-label"
				path="formule.avion.arrivee">Horaire de l'avion pour l'arriv�e</form:label>
			<div class="col-sm-8">
				<form:input type="datetime-local" class="form-control" id="heureArriv�e"
					placeholder="Horaire de l'avion pour l'arriv�e" path="formule.avion.arrivee" />
				<form:errors path="dateString" />
			</div>
		</div>
		
		<hr/>
		
		<h4  style="text-align: center">Voiture</h4>
		<div class="form-group">
			<form:label for="categorie" class="col-sm-2 control-label" path="formule.voiture.categorie">Cat�gorie de voiture</form:label>
			<div class="col-sm-8">
				<form:input class="form-control" id="categorie" placeholder="Cat�gorie"
					path="formule.voiture.categorie" />
				<form:errors path="formule.voiture.categorie" />
			</div>
		</div>
		<div class="form-group">
			<form:label for="loueur" class="col-sm-2 control-label" path="formule.voiture.loueur">Loueur de voiture</form:label>
			<div class="col-sm-8">
				<form:input class="form-control" id="loueur" placeholder="Loueur"
					path="formule.voiture.loueur" />
				<form:errors path="formule.voiture.loueur" />
			</div>
		</div>
		
		
		<div class="col-sm-offset-2 col-sm-8">
			<input type="submit" value="Ajouter voyage" class="btn btn-success" />
		</div>

	</form:form>

</body>
</html>