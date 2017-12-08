<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="<c:url value="/assets/libs/bootstrap-3.3.7/css/bootstrap.css" />">
<link rel="stylesheet"
	href="<c:url value="/assets/libs/bootstrap-3.3.7/css/bootstrap-theme.css" />">
<script type="text/javascript"
	src="<c:url value="/assets/libs/jquery-3.2.1.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/assets/libs/bootstrap-3.3.7/js/bootstrap.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/assets/libs/js/script.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/assets/libs/scrollreveal.min.js" />"></script>

<link rel="stylesheet"
	href="<c:url value="/assets/libs/css/heroic-features.css" />">
<link rel="stylesheet"
	href="<c:url value="/assets/libs/css/font-awesome.min.css" />">
<title>Liste des voyages</title>
</head>
<body id="vert">
	<nav class="navbar navbar-inverse navbar-fixed-top"
		style="padding-bottom: 10px;">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand"
					href="${pageContext.request.contextPath}/accueil"><img
					src="<c:url value="/assets/images/logo_poney.png" />" height="45px" /></a>
			</div>
			<div style="padding-top: 10px;">
				<c:if test="${sessionScope.logged}">
					<ul class="nav navbar-nav">
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">Voyages<span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a
									href="${pageContext.request.contextPath}/voyage/afficheAjout">Ajout</a></li>
								<li><a
									href="${pageContext.request.contextPath}/voyage/modifVoyage">Modification</a></li>
								<li><a
									href="${pageContext.request.contextPath}/voyage/afficheSuppr">Suppression</a></li>
								<li><a
									href="${pageContext.request.contextPath}/voyage/rechercheVoyage">Recherche</a></li>
								<li><a
									href="${pageContext.request.contextPath}/voyage/promotion">Promotion</a></li>
							</ul></li>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">Voyageurs<span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a
									href="${pageContext.request.contextPath}/voyageur/listeVoyageurs">Liste</a></li>
								<li><a
									href="${pageContext.request.contextPath}/voyageur/afficheAjout">Ajout</a></li>
								<li><a
									href="${pageContext.request.contextPath}/voyageur/afficheModif">Modification</a></li>
								<li><a
									href="${pageContext.request.contextPath}/voyageur/afficheSuppr">Suppression</a></li>
								<li><a
									href="${pageContext.request.contextPath}/voyageur/afficheRecherche">Recherche</a></li>
							</ul></li>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">Dossiers<span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a
									href="${pageContext.request.contextPath}/dossier/listeDossiers">Liste</a></li>
								<li><a
									href="${pageContext.request.contextPath}/dossier/afficheAjout">Ajout</a></li>
								<li><a
									href="${pageContext.request.contextPath}/dossier/afficheModif">Modification</a></li>
								<li><a
									href="${pageContext.request.contextPath}/dossier/afficheModifStatut">Modification
										statut</a></li>
								<li><a
									href="${pageContext.request.contextPath}/dossier/afficheSuppr">Suppression</a></li>
								<li><a
									href="${pageContext.request.contextPath}/dossier/afficheRecherche">Recherche</a></li>
							</ul></li>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">Agences<span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a
									href="${pageContext.request.contextPath}/agence/listeAgences">Liste</a></li>
								<li><a
									href="${pageContext.request.contextPath}/agence/afficheAjout">Ajout</a></li>
							</ul></li>
					</ul>
				</c:if>
				<c:if test="${not sessionScope.logged}">
					<ul class="nav navbar-nav">
						<li class="active"><a
							href="${pageContext.request.contextPath}/accueil">Nos Offres</a></li>
						<li class="active"><a
							href="${pageContext.request.contextPath}/agence/listeAgences">Nos
								Agences</a></li>
					</ul>
				</c:if>
				<ul class="nav navbar-nav navbar-right">
					<c:if test="${sessionScope.logged}">
						<li><a href="#">${sessionScope.username}</a></li>
						<li class="disabled"><a href="#"><img
								src="<c:url value="/assets/images/iconeconnecte.svg" />"
								height="30px" /></a></li>
						<li><a href="${pageContext.request.contextPath}/logout"><span
								class="glyphicon glyphicon-log-out"></span> Logout</a></li>
					</c:if>
					<c:if test="${not sessionScope.logged}">
						<li><a href="${pageContext.request.contextPath}/login"><span
								class="glyphicon glyphicon-log-in"></span> Login</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</nav>

	<div style="margin-top: 100px"></div>
	<br />

	<!-- Page Content -->
	<div class="container">

		<!-- Jumbotron Header -->
		<c:if test="${continent=='Afrique'}">

			<header class="jumbotron hero-spacer cadre-continent"
				style="background-image: url('http://www.ivtci.com/tourisme/cote_ivoire/data1/images/masquewobc3a9ouestdelacc3b4tedivoire.jpg')">
				<h1 style="color: white">AFRIQUE</h1>
				<br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br />
				<br />
			</header>

			<style>
body {
	background-color: #f2e6d9;
}
</style>
		</c:if>

		<c:if test="${continent=='Asie'}">
			<header class="jumbotron hero-spacer cadre-continent"
				style="background-image: url('http://shaktatravels.com/pic/flexslider/Ganga-Valley-Varanasi-Tour/l-6.jpg')">
				<h1 style="color: white">ASIE</h1>
				<br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br />
				<br />
			</header>

			<style>
body {
	background-color: #ffebe6;
}
</style>
		</c:if>

		<c:if test="${continent=='Oceanie'}">
			<header class="jumbotron hero-spacer cadre-continent"
				style="background-image: url('https://www.esplweb.fr/eta209/images/sydney-campus-01.jpg')">
				<h1 style="color: white">OCEANIE</h1>
				<br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br />
				<br />
			</header>
			<style>
body {
	background-color: #ecf8f2;
}
</style>

		</c:if>

		<c:if test="${continent=='AmNord'}">

			<header class="jumbotron hero-spacer cadre-continent"
				style="background-image: url('https://d1qq9lwf5ow8iz.cloudfront.net/live-images-1/ImageDetail_71a2019f-89e1-4e48-b5b3-3ac01b70b183_ThreeByOne?v=636202685923833133')">
				<h1 style="color: white">AMERIQUE DU NORD</h1>
				<br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br />
				<br />
			</header>
			<style>
body {
	background-color: #f8ecf2;
}
</style>
		</c:if>
		<c:if test="${continent=='AmSud'}">
			<header class="jumbotron hero-spacer cadre-continent"
				style="background-image: url('http://www.intern-brazil.com/wp-content/uploads/2016/12/Banner_Corcovado.jpg')">
				<h1 style="color: white">AMERIQUE DU SUD</h1>
				<br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br />
				<br />
			</header>
			<style>
body {
	background-color: #e6f2ff;
}
</style>
		</c:if>
		<c:if test="${continent=='Europe'}">
			<header class="jumbotron hero-spacer cadre-continent"
				style="background-image: url('http://www.voyages18.fr/wp-content/uploads/2017/08/blue.jpg')">
				<h1 style="color: white">EUROPE</h1>
				<br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br />
				<br />
			</header>
			<style>
body {
	background-color: #cce0ff;
}
</style>

		</c:if>
		<hr>
		<!-- Barre de recherche -->
		<form:form method="GET" action="filtrer"
			modelAttribute="voyageDesirer">

			<input type="hidden" name="continent" value="${continent}">

			<div>
				<table>
					<tr>
						<td style="text-align: center">Pays</td>
						<td style="text-align: center">Durée</td>
						<td style="text-align: center">Prix Maximal</td>
						<td style="text-align: center">Nombre de voyageurs</td>
						<td style="text-align: center">Détails</td>
					</tr>
					<tr>
						<td><form:input path="pays" placeholder="Pays" /></td>
						<td><form:input path="duree" placeholder="Durée du voyage" /></td>
						<td><form:input path="prix" placeholder="Prix" /></td>
						<td><form:input path="placesDisponibles"
								placeholder="Nombre de voyageurs" /></td>
						<td><form:input path="descriptionVoyage" /></td>

					</tr>
					<button class="btn btn-success btn-md pull-right" type="submit">Rechercher</button>

				</table>
			</div>





		</form:form>

		<!-- Message d'erreur si on veut reserver trop de places -->
		<br> <br> <br>
		<h2 style="text-align: center">${message}</h2>

		<!-- Title -->

		<div class="row">
			<div class="col-lg-12">
				<h3 style="color: #267326">Promotions</h3>
			</div>
		</div>
		<hr>

		<!-- /.row -->
		<div class="tout" style="text-align: center;">
			<br>

			<!-- Page Features -->
			<c:forEach var="promotion" items="${listePromotion}">
				<c:if test="${promotion.continent==continent}">

					<div class="col-md-3 col-sm-6 hero-feature">
						<div>
							<div class="thumbnail">

								<div class="ribbon">
									<span>PROMOTIONS</span>

								</div>
								<br> <img
									src="<c:url value="/images/${promotion.pays}/0.jpg" />"
									alt="image de ${promotion.pays}" height="10%" width="300px">


								<div class="caption">
									<h3>${promotion.pays}</h3>
									<p>Lorem ipsum dolor sit amet, consectetur adipisicing
										elit.</p>
									<p>
										<button class="btn btn-success btn-lg" data-toggle="modal"
											data-target="#popupPromotion_${promotion.id}">Infos</button>
									</p>
									<div style="margin-bottom: 10px; margin-top: 50px">
										<p style="float: left">${promotion.prix}euros</p>
										<p style="float: right">${promotion.placesDisponibles}
											places</p>
									</div>
									<div style="clear: left; clear: right"></div>
								</div>
							</div>
						</div>
					</div>
				</c:if>
			</c:forEach>

		</div>
		<!-- /.row -->

		<!-- Title -->

		<div class="row">
			<div class="col-lg-12">
				<h3 style="color: #267326">Populaires</h3>
			</div>
		</div>
		<!-- /.row -->
		<hr>

		<!-- Page Features -->
		<div class="tout" class="row text-center">
			<c:forEach var="voyage" items="${listeSansPromotion}">
				<c:if test="${voyage.continent==continent}">

					<div class="col-md-3 col-sm-6 hero-feature">
						<div class="thumbnail">


							<img src="<c:url value="/images/${voyage.pays}/0.jpg" />"
								alt="image de ${voyage.pays}" height="10%" width="300px">

							<div class="caption">
								<h3 style="text-align: center;">${voyage.pays}</h3>
								<p style="text-align: center">Lorem ipsum dolor sit amet,
									consectetur adipisicing elit.</p>
								<p>
									<button class="btn btn-success btn-lg" data-toggle="modal"
										data-target="#popupVoyage_${voyage.id}">Infos</button>
								</p>
								<div style="margin-bottom: 10px; margin-top: 50px">
									<p style="float: left">${voyage.prix}euros</p>
									<p style="float: right">${voyage.placesDisponibles}places</p>
								</div>
								<div style="clear: left; clear: right"></div>
							</div>


						</div>
					</div>
				</c:if>
			</c:forEach>
		</div>
	</div>
	<!-- Popup pour les voyages en promotion -->
	<c:forEach var="promotion" items="${listePromotion}">
		<c:if test="${promotion.continent==continent}">

			<div class="container">

				<!-- construction de la popup 
          data-backdrop="false" pour supprimer le voile au-dessus de la popup
          data-keyboard="false" pour supprimer la touche Echap -->
				<div class="modal slide" id="popupPromotion_${promotion.id}"
					tabindex="-1" role="dialog" aria-labelledby="titrePopUp"
					aria-hidden="true" style="text-align: center">

					<div class="modal-dialog">

						<div class="modal-content">

							<!-- le titre de la popup -->
							<div class="modal-header">
								<h4 class="modal-title" id="titrePopUp">
									${promotion.pays}
									<!-- lla croix de fermeture de la popup -->
									<button type="button" class="close" data-dismiss="modal"
										aria-hidden="true">&times;</button>
								</h4>
							</div>

							<!-- le contenu HTML de la popup -->
							<div class="modal-body">
								<p class="lead">
									<img src="assets/libs/img/téléchargement.jpg"
										class="pull-right" /> Détails du voyage
								</p>
								<p>${promotion.descriptionVoyage}</p>
							</div>

							<!-- le pied de page de la popup -->
							<div class="modal-footer">
								<form method="GET" action="reserver">
									<input type="hidden" name="identifiantVoyage"
										value="${promotion.id}"> <label class="control-label">Nombre
										de voyageurs </label><input type="number" name="nbVoyageur"> <input
										type="hidden" value="${continent}" name="continent"><input
										type="submit">
								</form>
							</div>

						</div>

					</div>

				</div>

			</div>
		</c:if>
	</c:forEach>
	<!-- Popup pour les voyages qui ne sont pas en promotions -->
	<c:forEach var="voyage" items="${listeSansPromotion}">
		<c:if test="${voyage.continent==continent}">

			<div class="container">
				<div class="modal slide" id="popupVoyage_${voyage.id}" tabindex="-1"
					role="dialog" aria-labelledby="titrePopUp" aria-hidden="true"
					style="text-align: center">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h4 class="modal-title" id="titrePopUp">${voyage.pays}
									<button type="button" class="close" data-dismiss="modal"
										aria-hidden="true">&times;</button>
								</h4>
							</div>

							<!-- le contenu HTML de la popup -->
							<div class="modal-body">
								<p class="lead">
									<img src="assets/libs/img/téléchargement.jpg"
										class="pull-right" /> Détails du voyage
								</p>
								<p>${voyage.descriptionVoyage}</p>
							</div>
							<!-- le pied de page de la popup -->
							<div class="modal-footer">
								<form method="GET" action="reserver">
									<input type="hidden" name="identifiantVoyage"
										value="${voyage.id}"> <label class="control-label">Nombre
										de voyageurs </label><input type="number" name="nbVoyageur"> <input
										type="hidden" value="${continent}" name="continent"><input
										type="submit">
								</form>

							</div>

						</div>
					</div>
				</div>
			</div>
		</c:if>
	</c:forEach>

	<script type="text/javascript">
		window.sr = ScrollReveal();
		sr.reveal('.cadre-continent', {
			duration : 1000,
			origin : 'right',
			distance : '600px'
		});
	</script>

</body>
</html>