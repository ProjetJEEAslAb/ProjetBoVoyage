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
		<header class="jumbotron hero-spacer" id="imageAfrique">
			<h1>AFRIQUE</h1>
			<br /> <br /> <br /> <br /> <br />
		</header>

		<hr>

		<!-- Title -->
		<div class="row">
			<div class="col-lg-12">
				<h3>Promotions</h3>
			</div>
		</div>
		<!-- /.row -->
		<div class="tout" style="text-align: center;">
			<!-- Page Features -->
			<div></div>
			<div class="row text-center">
				<div class="col-md-3 col-sm-6 hero-feature">
					<div>
						<div class="thumbnail">
							<div class="ribbon">
								<span>PROMOTIONS</span>
							</div>

							<img
								src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRfMtC4vtpnT4i4xlZfQ0ptJAvXHBpdZWzyVcrLRLTySpto43udpw"
								alt="">

							<div class="caption">
								<h3>Afrique du Sud</h3>
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
								<p>
									<button class="btn btn-primary btn-lg" data-toggle="modal"
										data-target="#id-popup">Infos</button>
								</p>

							</div>
						</div>
					</div>
				</div>
				<div class="col-md-3 col-sm-6 hero-feature">
					<div class="thumbnail">
						<div class="ribbon">
							<span>PROMOTIONS</span>
						</div>
						<img src="http://placehold.it/800x500" alt="">
						<div class="caption">
							<h3>Kenya</h3>
							<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
							<p>
								<a href="#" class="btn btn-primary">Reservé</a> <a href="#"
									class="btn btn-default">More Info</a>
							</p>
						</div>
					</div>
				</div>

				<div class="col-md-3 col-sm-6 hero-feature">
					<div class="thumbnail">
						<div class="ribbon">
							<span>PROMOTIONS</span>
						</div>
						<img src="http://placehold.it/800x500" alt="">
						<div class="caption">
							<h3>Algérie</h3>
							<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
							<p>
								<a href="#" class="btn btn-primary">Reservé</a> <a href="#"
									class="btn btn-default">More Info</a>
							</p>
						</div>
					</div>
				</div>

				<div class="col-md-3 col-sm-6 hero-feature">
					<div class="thumbnail">
						<div class="ribbon">
							<span>PROMOTIONS</span>
						</div>
						<img src="http://placehold.it/800x500" alt="">
						<div class="caption">
							<h3>Madagascar</h3>
							<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
							<p>
								<a href="#" class="btn btn-primary">Reservé</a> <a href="#"
									class="btn btn-default">More Info</a>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- /.row -->

		<hr>
		<!-- Title -->
		<div class="row">
			<div class="col-lg-12">
				<h3>Populaires</h3>
			</div>
		</div>
		<!-- /.row -->

		<!-- Page Features -->
		<div class="row text-center">
			<div class="col-md-3 col-sm-6 hero-feature">
				<div class="thumbnail">
					<img src="http://placehold.it/800x500" alt="">
					<div class="caption">
						<h3>Afrique du Sud</h3>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
						<p>
							<a href="#" class="btn btn-primary">Reservé</a> <a href="#"
								class="btn btn-default">More Info</a>
						</p>
					</div>
				</div>
			</div>

			<div class="col-md-3 col-sm-6 hero-feature">
				<div class="thumbnail">
					<img src="http://placehold.it/800x500" alt="">
					<div class="caption">
						<h3>Kenya</h3>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
						<p>
							<a href="#" class="btn btn-primary">Reservé</a> <a href="#"
								class="btn btn-default">More Info</a>
						</p>
					</div>
				</div>
			</div>

			<div class="col-md-3 col-sm-6 hero-feature">
				<div class="thumbnail">
					<img src="http://placehold.it/800x500" alt="">
					<div class="caption">
						<h3>Algérie</h3>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
						<p>
							<a href="#" class="btn btn-primary">Reservé</a> <a href="#"
								class="btn btn-default">More Info</a>
						</p>
					</div>
				</div>
			</div>

			<div class="col-md-3 col-sm-6 hero-feature">
				<div class="thumbnail">
					<img src="http://placehold.it/800x500" alt="">
					<div class="caption">
						<h3>Madagascar</h3>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
						<p>
							<a href="#" class="btn btn-primary">Reservé</a> <a href="#"
								class="btn btn-default">More Info</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>


	<div class="container">

		<!-- construction de la popup 
          data-backdrop="false" pour supprimer le voile au-dessus de la popup
          data-keyboard="false" pour supprimer la touche Echap -->
		<div class="modal slide" id="id-popup" tabindex="-1" role="dialog"
			aria-labelledby="titrePopUp" aria-hidden="true" style="text-align: center">

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
							<img src="assets/libs/img/téléchargement.jpg" class="pull-right" />
							Mettre details du voyage
						</p>
						<p>Mettre details du voyage</p>
					</div>

					<!-- le pied de page de la popup -->
					<div class="modal-footer">
						<a href="" class="btn btn-primary pull-left">Reserver</a>
					</div>

				</div>

			</div>

		</div>

	</div>


</body>
</html>