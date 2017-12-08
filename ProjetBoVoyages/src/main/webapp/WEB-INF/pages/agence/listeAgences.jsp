<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="<c:url value="/assets/libs/bootstrap-3.3.7/css/bootstrap.css" />">
	<link rel="stylesheet" href="<c:url value="/assets/libs/bootstrap-3.3.7/css/bootstrap-theme.css" />">
	<script type="text/javascript" src="<c:url value="/assets/libs/jquery-3.2.1.js" />"></script>
	<script type="text/javascript" src="<c:url value="/assets/libs/bootstrap-3.3.7/js/bootstrap.js" />"></script>
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAlMJacV2bESryY_WL1XjSSy6Bh-NDofNw"></script>
	<script type="text/javascript" src="<c:url value="/assets/libs/axios.js" />"></script>
	<script>
	var map;
	function initialize() {
    	var map = new google.maps.Map(document.getElementById('map-canvas'), {
            zoom: 1,
            center: {lat: 30.0, lng: 0.0}
        });
		var locations = ["22 Main st Boston MA", "Petrovka St-Bld 11, Moscow"];
		for(i=0; i<locations.length; i++) {
	        axios.get("https://maps.googleapis.com/maps/api/geocode/json", {
	            params:{
	                address:locations[i],
	                key:"AIzaSyAlMJacV2bESryY_WL1XjSSy6Bh-NDofNw"
	            }
	        }).then(function(response) {
	            var results = response.data.results;
	            for (i=0; i<results.length;i++) {
	                var position = {lat:response.data.results[i].geometry.location.lat, lng:response.data.results[i].geometry.location.lng};
	                console.log(position);
	                var marker = new google.maps.Marker({
	                    position: position,
	                    map: map
	                });
	            }
	        });
		}
	}
	google.maps.event.addDomListener(window, 'load', initialize);
	</script>
	<title>Liste des Agences</title>
</head>
<body>
	
	<h1 align="center">Nos agences :</h1>
	<br/>
	<br/>
	<br/>
	<div align="center">
		<div id="map-canvas" style="height:300px; width:500px; margin-bottom:50px;"></div>
	</div>
	
</body>
</html>
