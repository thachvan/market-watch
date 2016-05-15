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

<!-- Table -->
<link href="/market-watch/resources/css/jquery.dataTables.min.css"
	rel="stylesheet">

<script src="/market-watch/resources/js/jquery-1.12.0.min.js"></script>
<script src="/market-watch/resources/js/jquery.dataTables.min.js"></script>

</head>

<body>
	<div class="container">
		<h1>Portfolio</h1>
		<table id="example" class="display" cellspacing="0" width="100%">
			<thead>
				<tr>
					<th>Name</th>
					<th>Ask</th>
					<th>Bid</th>
					<th>Open</th>
					<th>Close</th>
					<th>High</th>
					<th>Low</th>
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
				"ajax" : "../server_side/scripts/server_processing.php"
			});
		});
	</script>
</body>

</html>