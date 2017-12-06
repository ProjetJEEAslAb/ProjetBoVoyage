<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="assets/libs/bootstrap-3.3.7/css/bootstrap.css">
	<link rel="stylesheet" href="assets/libs/bootstrap-3.3.7/css/bootstrap-theme.css">
	<script type="text/javascript" src="assets/libs/jquery-3.2.1.js"></script>
	<script type="text/javascript" src="assets/libs/bootstrap-3.3.7/js/bootstrap.js"></script>
	<title>Login</title>
</head>
<body>
	<br /><br />
	<h1 align="center">Entrez vos identifiants</h1>
	<br /><br />
	<form class="form-horizontal container" action="j_spring_security_check" method="post">
		<div class="input-group">
			<span class="input-group-addon"><i
				class="glyphicon glyphicon-user"></i></span> <input type="email"
				class="form-control" id="identifiantId" name="j_username"
				placeholder="Identifiant">
		</div>
		<div class="input-group">
			<span class="input-group-addon"><i
				class="glyphicon glyphicon-lock"></i></span> <input type="password"
				class="form-control" id="mdpId" name="j_password"
				placeholder="Mot de Passe">
		</div>
		<br />
		<div align="center">
			<button type="submit" class="btn btn-primary">
				<i class="glyphicon glyphicon-log-in"></i> Login
			</button>
		</div>
	</form>
	
	
	<script type="text/javascript">
		$(window).on('load', function() {
			var erreur = "${erreur}";
			if (erreur) {
				$('#loginFailureModal').modal('show');
			}
		});
	</script>
	
	<div class="modal fade" id="loginFailureModal" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Echec Connexion</h4>
				</div>
				<div class="modal-body">
					<p>L'identifiant ou le mot de passe sont incorects</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Fermer</button>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>