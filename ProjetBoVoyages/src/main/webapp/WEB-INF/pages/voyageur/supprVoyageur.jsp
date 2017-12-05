<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet"
	href="assets/libs/bootstrap-3.3.7/css/bootstrap.css">
<link rel="stylesheet"
	href="https://bootswatch.com/3/superhero/bootstrap.min.css">
<script type="text/javascript" src="assets/libs/jquery-3.2.1.js"></script>
<script type="text/javascript"
	src="assets/libs/bootstrap-3.3.7/js/bootstrap.js"></script>


<title>Supprimer un voyageur</title>
<body>

	
	<h2 style="text-align: center; color: royalblue">Formulaire
		de suppression</h2>

	<form class="form-horizontal" method='post' action="/supprVoyageur">

		<div class="form-group">
			<label for="inputNumero" class="col-sm-2 control-label">Id *
				:</label>
			<div class="col-sm-4">
				<input type="number" class="form-control" id="inputId"
					placeholder="Id" name="pId" required="required">
			</div>
		</div>
			
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<!-- offset permet de saute les deux premieres colonnes -->

				<button type="submit" class="btn btn-primary" >Supprimer un
					voyageur</button>
			</div>
		</div>
	</form>
</body>
</html>