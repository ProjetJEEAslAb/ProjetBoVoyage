<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">




<title>Réservation</title>


<!--  
<script type="text/javascript"
	src="<c:url value="/assets/libs/jquery-3.2.1.js" />"></script> -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>

<script type="text/javascript"
	src="<c:url value="/assets/libs/bootstrap-3.3.7/js/reserver.js" />"></script>
<link rel="stylesheet"
	href="<c:url value="/assets/libs/bootstrap-3.3.7/css/bootstrap.css" />">
<link rel="stylesheet"
	href="<c:url value="/assets/libs/bootstrap-3.3.7/css/reserver.css"/>" />

</head>
<body>
	<div>
		<!-- Entête du voyage -->
		<h1 style="text-align: center;">Réservation du voyage</h1>
		<img
			src="https://upload.wikimedia.org/wikipedia/commons/thumb/c/c9/Flag_of_Syldavia.svg/900px-Flag_of_Syldavia.svg.png"
			width="400px">
	</div>



	<div class="container">

		<div class="stepwizard col-md-offset-3">
			<div class="stepwizard-row setup-panel">
				<div class="stepwizard-step">
					<a href="#step-1" type="button" class="btn  btn-primary btn-circle">1</a>
					<p>Etape 1 : Enregistrement du client</p>
				</div>
				<div class="stepwizard-step">
					<a href="#step-2" type="button" class="btn  btn-default btn-circle">2</a>
					<p>Etape 2 : Choix de l'assurance</p>
				</div>
				<div class="stepwizard-step">
					<a href="#step-3" type="button" class="btn btn-default btn-circle"
						disabled="disabled">3</a>
					<p>Etape 3 : Informations pour le paiement</p>
				</div>
				<div class="stepwizard-step">
					<a href="#step-4" type="button" class="btn btn-default btn-circle"
						disabled="disabled">4</a>
					<p>Etape 4 : Résumé de votre commande</p>
				</div>
				<div class="stepwizard-step">
					<a href="#step-5" type="button" class="btn btn-default btn-circle"
						disabled="disabled">5</a>
					<p>Etape 5 : Accompagnants</p>
				</div>
			</div>
		</div>

		<form:form method="POST" action="reservation" class="form-horizontal"
			modelAttribute="client">

			<div class="row setup-content" id="step-1">
				<div class="col-xs-6 col-md-offset-3">
					<div class="col-md-12">
						<h3>Etape 1</h3>
						<div class="form-group">
							<label class="control-label">Civilité</label>
							<form:select class="form-control" id="hebergement"
								placeholder="Hébergement" path="civilite">
								<option>Monsieur</option>
								<option>Madame</option>
							</form:select>
						</div>
						<div class="form-group">
							<label class="control-label">Nom</label>
							<form:input maxlength="100" type="text" required="required"
								class="form-control" path="nom" placeholder="Nom" />
						</div>
						<div class="form-group">
							<label class="control-label">Prenom</label>
							<form:input maxlength="100" type="text" required="required"
								class="form-control" placeholder="Prénom" path="prenom" />
						</div>

						<div class="form-group">
							<label class="control-label">Adresse</label>
							<form:input maxlength="100" type="text" required="required"
								class="form-control" placeholder="Adresse" path="adresse" />
						</div>

						<div class="form-group">
							<label class="control-label">Téléphone</label>
							<form:input maxlength="100" type="text" required="required"
								class="form-control" placeholder="Téléphone" path="telephone" />
						</div>

						<div class="form-group">
							<label class="control-label">Date de naissance</label>
							<form:input maxlength="100" type="date" required="required"
								class="form-control" placeholder="Date de naissance"
								path="dateString" />
						</div>


						<button class="btn btn-success nextBtn btn-lg pull-right"
							type="button">Suivant</button>
					</div>
				</div>
			</div>
			<div class="row setup-content" id="step-2">
				<div class="col-xs-6 col-md-offset-3">
					<div class="col-md-12">
						<h3>Etape 2</h3>

						Notre agence vous propose différentes assurances pour vous assurer
						toute la sérénité et la tranquilité nécessaire pour passer de
						bonnes vacances : <br> Les assurances possibles sont : <br>
						- Assurance annulation : Un imprévu et vous devez décommander. En
						souscrivant à notre assurance annulation nous nous engageons à
						rembourser intégralement les frais avancés.

						<div class="form-group">
							<label class="control-label">Assurance choisie</label> <select
								class="form-control" placeholder="Assurance" name="assurance">
								<option>Aucune</option>
								<option>Assurance annulation</option>

							</select>

							<!--  <input maxlength="200" type="text" required="required"
								class="form-control" placeholder="Numéro de carte Bancaire"
								name="assurance" />-->
						</div>


						<button class="btn btn-success nextBtn btn-lg pull-right"
							type="button">Suivant</button>
					</div>
				</div>
			</div>



			<div class="row setup-content" id="step-3">
				<div class="col-xs-6 col-md-offset-3">
					<div class="col-md-12">
						<h3>Step 2</h3>
						<div class="form-group">
							<label class="control-label">Numéro de carte Bancaire</label> <input
								maxlength="200" type="text" required="required"
								class="form-control" placeholder="Numéro de carte Bancaire"
								name="numCB" />
						</div>
						<div class="form-group">
							<label class="control-label">Code</label> <input maxlength="200"
								type="text" required="required" class="form-control"
								placeholder="Code" name="codeCB" />
						</div>

						<button class="btn btn-success nextBtn btn-lg pull-right"
							type="button">Suivant</button>
					</div>
				</div>
			</div>
			<div class="row setup-content" id="step-4">
				<div class="col-xs-6 col-md-offset-3">
					<div class="col-md-12">
						<h2 style="text-align: center;">Résumé de votre commande</h2>
						<input type="hidden" value="${nbVoyageurs}" name="nbVoyageur">
						<input type="hidden" value="${voyageAReserver.id}"
							name="identifiantReservation"> Id : ${voyageAReserver.id}
						Destination : ${voyageAReserver.pays} <br> Prix Unitaire :
						${voyageAReserver.prix-voyageAReserver.prix*voyageAReserver.reduction/100 }
						euros. Prix total :
						${(voyageAReserver.prix-voyageAReserver.prix*voyageAReserver.reduction/100 )* nbVoyageurs}.
						<button class="btn btn-success btn-lg pull-right" type="submit">Submit</button>
					</div>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>