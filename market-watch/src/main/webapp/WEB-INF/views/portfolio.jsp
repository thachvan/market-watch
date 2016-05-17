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

<!-- JQuery -->
<script src="/market-watch/resources/js/jquery-1.12.0.min.js"></script>

<!-- Bootstrap table -->
<link href="/market-watch/resources/css/bootstrap-table.css" rel="stylesheet">
<script src="/market-watch/resources/js/bootstrap-table.js"></script>
<script src="/market-watch/resources/js/bootstrap-table-en-US.js"></script>

<!-- DataTables -->
<link href="/market-watch/resources/css/jquery.dataTables.min.css"
	rel="stylesheet">
<script src="/market-watch/resources/js/jquery.dataTables.min.js"></script>

</head>

<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12"></div>
				<div class="pull-right">
					<c:url var="logoutUrl" value="/logout" />
					<form action="${logoutUrl}" method="post">
						<label>Welcome ${name} </label> <input type="submit" value="Log out" />
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</form>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div style="text-align: center">
					<h2 class="form-standard-heading">Portfolio</h2>
				</div>
			</div>
		</div>
		<div class="row"><br></div>
		<div class="row">
			<form class="form-inline" action="/market-watch/portfolio/add"
				method="post">
				<div class="form-group">
					<label for="name">Symbol</label>
					<select name="name" class="form-control">
						<c:forEach var="symbol" items="${symbols}">
							<option value="${symbol.name}">${symbol.name}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group">
					<label for="volume">Volume</label>
					<input name="volume" type="number" step="0.01" class="form-control" />
				</div>
				<div class="form-group">
					<label for="originalPrice">Original price</label>
					<input name="originalPrice" type="number" step="0.01" class="form-control" />
				</div>
				<div class="form-group">
					<label for="type">Type</label>
					<select name="type" class="form-control">
						<option value="BUY">Buy</option>
						<option value="SELL">Sell</option>
					</select>
				</div>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				<div class="form-group">
					<button class="btn btn-primary" type="submit">Add</button>
				</div>
			</form>
		</div>
		<div class="row"><br><br></div>
		<div class="row">
			<table data-toggle="table" data-url="/market-watch/portfolio/getjson">
				<thead>
					<tr>
						<th data-field="symbolName">Symbol</th>
						<th data-field="volume">Volume</th>
						<th data-field="originalPrice">Original price</th>
						<th data-field="type">Trading type</th>
						<th data-field="ask">Ask</th>
						<th data-field="bid">Bid</th>
						<th data-field="profit">Profit</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
	<!-- /container -->
</body>

</html>