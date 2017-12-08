<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet"
	href="<c:url value="/assets/libs/bootstrap-3.3.7/css/bootstrap.css" />">
<link rel="stylesheet"
	href="<c:url value="/assets/libs/bootstrap-3.3.7/css/bootstrap-theme.css" />">
<link rel="stylesheet"
	href="<c:url value="/assets/libs/css/pub.css" />">


<script type="text/javascript"
	src="<c:url value="/assets/libs/jquery-3.2.1.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/assets/libs/bootstrap-3.3.7/js/bootstrap.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/assets/libs/scrollreveal.min.js" />"></script>

<title>Merry Christmas!</title>

</head>

<body>






	<section class="xmas">
		<div class="xmas-message"></div>

		<!-- Let it snow! -->
		<canvas id="xmas"></canvas>
	</section>

	<div class="demos" style="text-align: center">
		<h1>
			Promotions de Noel,<br>venez vite!!!
		</h1>
		<form method="GET" action="pubPromo">
			<input type="button" class="btn btn-success" data-dismiss="modal"
				aria-hidden="true" value="Profiter!">
		</form>
	</div>
	<a href="">boVoyage.com</a>



	
</body>
</html>