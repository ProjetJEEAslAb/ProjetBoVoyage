<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet"
	href="<c:url value="/assets/libs/bootstrap-3.3.7/css/bootstrap.css" />">

<link rel="stylesheet"
	href="<c:url value="/assets/libs/css/heroic-features.css" />">
<link rel="stylesheet"
	href="<c:url value="/assets/libs/css/font-awesome.min.css" />">

<script type="text/javascript"
	src="<c:url value="/assets/libs/jquery-3.2.1.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/assets/libs/bootstrap-3.3.7/js/bootstrap.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/assets/libs/js/script.js" />"></script>

<title>Insert title here</title>
</head>
<body id="vert">
	<br />

	<!-- Page Content -->
	<div class="container">

		<!-- Jumbotron Header -->
		<c:if test="${continent=='Afrique'}">

			<header class="jumbotron hero-spacer"
				style="background-image: url('http://www.ivtci.com/tourisme/cote_ivoire/data1/images/masquewobc3a9ouestdelacc3b4tedivoire.jpg')">
				<h1 style="color: white">AFRIQUE</h1>
				<br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br />
				<br />
			</header>

			<style>
				body {
					background-color:  #f2e6d9
					;
					}
			</style>
		</c:if>

		<c:if test="${continent=='Asie'}">
			<header class="jumbotron hero-spacer"
				style="background-image: url('http://shaktatravels.com/pic/flexslider/Ganga-Valley-Varanasi-Tour/l-6.jpg')">
				<h1 style="color: white">ASIE</h1>
				<br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br />
				<br />
			</header>

			<style>
				body {
					background-color:  #ffebe6;
					}
			</style>
		</c:if>

		<c:if test="${continent=='Oceanie'}">
			<header class="jumbotron hero-spacer"
				style="background-image: url('https://www.esplweb.fr/eta209/images/sydney-campus-01.jpg')">
				<h1 style="color: white">OCEANIE</h1>
				<br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br />
				<br />
			</header>
			 <style>
				body {
					background-color:  #ecf8f2;
					}
			</style>
			
		</c:if>

		<c:if test="${continent=='AmNord'}">

			<header class="jumbotron hero-spacer"
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
			<header class="jumbotron hero-spacer"
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
			<header class="jumbotron hero-spacer"
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

		<!-- Title -->
		<div class="row">
			<div class="col-lg-12">
				<h3 style="color: #267326">Promotions</h3>
			</div>
		</div>
		<!-- /.row -->
		<div class="tout" style="text-align: center;">
			<!-- Page Features -->
			<c:forEach var="promotion" items="${listePromotion}">
				<c:if test="${promotion.continent==continent}">

					<div class="col-md-3 col-sm-6 hero-feature">
						<div>
							<div class="thumbnail">


								<div class="ribbon">
									<span >PROMOTIONS</span>
								</div>

								<img
									src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRfMtC4vtpnT4i4xlZfQ0ptJAvXHBpdZWzyVcrLRLTySpto43udpw"
									alt="" height="10%" width="300px">


								<div class="caption">
									<h3>${promotion.pays}</h3>
									<p>Lorem ipsum dolor sit amet, consectetur adipisicing
										elit.</p>
									<p>
										<button class="btn btn-success btn-lg" data-toggle="modal"
											data-target="#popupPromotion">Infos</button>
									</p>
								</div>
							</div>
						</div>
					</div>
				</c:if>
			</c:forEach>

		</div>
		<!-- /.row -->

		<hr>
		<!-- Title -->
		<div class="row">
			<div class="col-lg-12">
				<h3 style="color: #267326">Populaires</h3>
			</div>
		</div>
		<!-- /.row -->

		<!-- Page Features -->
		<div class="tout" class="row text-center">
			<c:forEach var="voyage" items="${listeSansPromotion}">
				<c:if test="${voyage.continent==continent}">

					<div class="col-md-3 col-sm-6 hero-feature">
						<div class="thumbnail">
							<img src="http://placehold.it/800x500" alt="">

							<div class="caption">
								<h3>${voyage.pays}</h3>
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
								<p>

									<button class="btn btn-success btn-lg" data-toggle="modal"
										data-target="#popupVoyage">Infos</button>
								</p>
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
				<div class="modal slide" id="popupPromotion" tabindex="-1"
					role="dialog" aria-labelledby="titrePopUp" aria-hidden="true"
					style="text-align: center">

					<div class="modal-dialog">

						<div class="modal-content">

							<!-- le titre de la popup -->
							<div class="modal-header">
								<h4 class="modal-title" id="titrePopUp">
									Johanesburg, Afrique du Sud
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
										value="${promotion.id}"> Nombre de voyageurs<input
										type="number" name="nbVoyageur"> <input type="submit">
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
				<div class="modal slide" id="popupVoyage" tabindex="-1"
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
								<p>${promotion.descriptionVoyage}</p>
							</div>
							<!-- le pied de page de la popup -->
							<div class="modal-footer">
								<a href="" class="btn btn-success pull-left">Reserver</a>
							</div>

						</div>
					</div>
				</div>
			</div>
		</c:if>
	</c:forEach>
</body>
</html>