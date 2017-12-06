<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="assets/libs/bootstrap-3.3.7/css/bootstrap.css">
	<link rel="stylesheet" href="assets/libs/bootstrap-3.3.7/css/bootstrap-theme.css">
	<script type="text/javascript" src="assets/libs/jquery-3.2.1.js"></script>
	<script type="text/javascript" src="assets/libs/bootstrap-3.3.7/js/bootstrap.js"></script>
	<title>Accès refusé</title>
</head>
<body>
	<div align="center">
		<br/>
		<br/>
		<br/>
		<h1 style="color:red;">Vous n'êtes pas autorisé à acceder à cette page</h1>
		<br/>
		<br/>
		<h2><a href="${pageContext.request.contextPath}/accueil">Accueil</a></h2>
	</div>
</body>
</html>