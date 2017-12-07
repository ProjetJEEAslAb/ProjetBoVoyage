<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
<body>


	<div class="container">

		<div class="stepwizard col-md-offset-3">
			<div class="stepwizard-row setup-panel">
				<div class="stepwizard-step">
					<a href="#step-1" type="button" class="btn btn-primary btn-circle">1</a>
					<p>Etape 1 : Enregistrement du client</p>
				</div>
				<div class="stepwizard-step">
					<a href="#step-2" type="button" class="btn btn-primary btn-circle">2</a>
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
		<form:form method="POST" action="ajoutAccompagnant" class="form-horizontal"
			modelAttribute="accompagnant">

			<div class="row setup-content" id="step-5">
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
							<label class="control-label">Date de naissance</label> <form:input
								maxlength="100" type="date" required="required"
								class="form-control" placeholder="Date de naissance" path="dateString"/>
						</div>


						<button class="btn btn-primary nextBtn btn-lg pull-right"
							type="submit">Ajouter la personne au voyage</button>
					</div>
				</div>
			</div>
	



	
		</form:form>

</body>
</html>