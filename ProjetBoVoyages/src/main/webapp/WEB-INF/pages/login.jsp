<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="assets/libs/bootstrap-3.3.7/css/bootstrap.css">
	<link rel="stylesheet" href="https://bootswatch.com/3/superhero/bootstrap.min.css">
	<script type="text/javascript" src="assets/libs/jquery-3.2.1.js"></script>
	<script type="text/javascript" src="assets/libs/bootstrap-3.3.7/js/bootstrap.js"></script>
	<title>Login</title>
</head>
<body>
	<h1 align="center">Login :</h1>
	<form action="j_spring_security_check" method="post">
		Identifiant : <input type="text" name="j_username" /><br/>
		Password : <input type="password" name="j_password" /><br/>
		<input type="submit" value="Se connecter" />
	</form>
	<c:if test="${not empty erreur}">
		<h1>Login incorrect</h1>
	</c:if>
</body>
</html>