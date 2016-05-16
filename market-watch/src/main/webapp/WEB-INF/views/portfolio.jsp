<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Market Watch - Portfolio</title>

<!-- Bootstrap core CSS -->
<link href="/market-watch/resources/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Form -->
<link href="/market-watch/resources/css/form.css" rel="stylesheet">

<!-- Table -->
<link href="/market-watch/resources/css/jquery.dataTables.min.css"
	rel="stylesheet">

<script src="/market-watch/resources/js/jquery-1.12.0.min.js"></script>
<script src="/market-watch/resources/js/jquery.dataTables.min.js"></script>

</head>

<body>
	<div class="container">
		<c:url var="logoutUrl" value="/logout" />
		<form action="${logoutUrl}" method="post">
			<label>Welcome ${name} </label> <input type="submit" value="Log out" />
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>

		<h2 class="form-front-heading">Portfolio</h2>

		<form class="form-front" action="/market-watch/portfolio/add"
			method="post">
			<label>Symbol</label> <select name="symbol" class="form-control">
				<c:forEach var="portfolioItem" items="${portfolio}">
					<option value="${portfolioItem.symbol.name}">${portfolioItem.symbol.name}</option>
				</c:forEach>
			</select>
		</form>

		<table id="portfolio" class="display" cellspacing="0" width="100%">
			<thead>
				<tr>
					<th>Name</th>
					<th>Ask</th>
					<th>Bid</th>
					<th>Original Price</th>
					<th>Volume</th>
					<th>Profit</th>
				</tr>
			</thead>
		</table>
	</div>
	<!-- /container -->
	<script>
		$(document).ready(function() {
			$('#example').DataTable({
				"processing" : true,
				"serverSide" : true,
				"ajax" : "/market-watch/"
			});
		});
	</script>
</body>

</html>