<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
		<title>Market Watch - Register</title>
		
		<!-- Bootstrap core CSS -->
		<link href="/market-watch/resources/css/bootstrap.min.css" rel="stylesheet">
		
		<!-- Custom styles for Login and Register -->
    	<link href="/market-watch/resources/css/form.css" rel="stylesheet">
	</head>
	
	<body>
		<div class="container">
			<form:form modelAttribute="user" class="form-front" action="/market-watch/register" method="post">
				<h2 class="form-front-heading">Register</h2>
				<label for="inputName" class="sr-only">Name</label>
				<form:errors path="name" cssClass="error"/>
				<input name="name" type="text" id="inputName" class="form-control" placeholder="Name" autofocus>
				<label for="inputUsername" class="sr-only">Username</label>
				<form:errors path="username" cssClass="error"/>
				<input name="username" type="text" id="inputUsername" class="form-control" placeholder="Username">
				<label for="inputPassword" class="sr-only">Password</label>
				<form:errors path="password" cssClass="error"/>
				<input name="password" type="password" id="inputPassword" class="form-control" placeholder="Password">
				<button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
			</form:form>
		</div> <!-- /container -->
</body>

</html>