<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
		<title>Market Watch - Simulator</title>
		
		<!-- Bootstrap core CSS -->
		<link href="/market-watch/resources/css/bootstrap.min.css" rel="stylesheet">
		
		<!-- JQuery -->
		<script src="/market-watch/resources/js/jquery-1.12.0.min.js"></script>
		
		<!-- Simulator -->
		<script src="/market-watch/resources/js/simulator.js"></script>
	</head>
	
	<body>
		<div class = "container">
			<br>
			<input type="button" id="startstop" value="Start" onclick="startstop()"></input>
			<br><br>
			<textarea rows="20" column="100" id="result">Hello</textarea>
		</div>
	</body>

</html>