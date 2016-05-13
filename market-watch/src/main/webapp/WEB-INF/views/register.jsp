<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
		<title>Market Watch - Register</title>
		
		<!-- Bootstrap core CSS -->
		<link href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" rel="stylesheet">
		
		<!-- Custom styles for Login and Register -->
    	<link href="<%=request.getContextPath()%>/resources/css/form.css" rel="stylesheet">
	</head>
	
	<body>
		<div class="container">
			<form:form class="form-front" action="/market-watch/register" method="post">
				<h2 class="form-front-heading">Register</h2>
				<label for="inputName" class="sr-only">Name</label>
				<input name="name" type="text" id="inputName" class="form-control" placeholder="Name" autofocus>
				<form:errors path="*" cssClass="error"/>
				<label for="inputUsername" class="sr-only">Username</label>
				<input name="username" type="text" id="inputUsername" class="form-control" placeholder="Username">
				<form:errors path="username" cssClass="error"/>
				<label for="inputPassword" class="sr-only">Password</label>
				<input name="password" type="password" id="inputPassword" class="form-control" placeholder="Password">
				<form:errors path="password" cssClass="error"/>
				<button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
			</form:form>
		</div> <!-- /container -->
</body>

</html>